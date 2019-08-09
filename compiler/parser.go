package compiler

// Copyright 2009 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

// This file contains the exported entry points for invoking the parser.

import (
	"fmt"
	"io/ioutil"
)

/*
func ParseString() {

}*/

//Init(file *File, src []byte, err ErrorHandler, scanComment bool, flags []string) *Scanner {
func ParseFile(fset *FileSet, filename string, scanComments bool, flags []string) (f *ProgramFile, err error) {
	if fset == nil {
		panic("parser.ParseFile: no FileSet provided (fset == nil)")
	}

	// get source
	text, err := ioutil.ReadFile(filename)
	if err != nil {
		return nil, err
	}

	var p parser
	defer func() {
		if e := recover(); e != nil {
			// resume same panic if it's not a bailout
			if _, ok := e.(tooManyErrors); !ok {
				panic(e)
			}
		}

		// set result values
		if f == nil {
			// source is not a valid Go source file - satisfy
			// ParseFile API and return a valid (but) empty
			// *File
			f = &ProgramFile{
				Scope: NewScope(nil),
			}
		}

		p.errors.Sort()
		err = p.errors.Err()
	}()

	// parse source
	p.init(fset, filename, text, scanComments, flags)
	f = p.parseFile()

	return
}

/*
func ParseDir(fset *FileSet, path string, filter func(os.FileInfo) bool, mode Mode) (pkgs map[string]*Package, first error) {
	fd, err := os.Open(path)
	if err != nil {
		return nil, err
	}
	defer fd.Close()

	list, err := fd.Readdir(-1)
	if err != nil {
		return nil, err
	}

	pkgs = make(map[string]*Package)
	for _, d := range list {
		if strings.HasSuffix(d.Name(), ".go") && (filter == nil || filter(d)) {
			filename := filepath.Join(path, d.Name())
			if src, err := ParseFile(fset, filename, nil, mode); err == nil {
				name := src.Name.Name
				pkg, found := pkgs[name]
				if !found {
					pkg = &Package{
						Name:  name,
						Files: make(map[string]*File),
					}
					pkgs[name] = pkg
				}
				pkg.Files[filename] = src
			} else if first == nil {
				first = err
			}
		}
	}

	return
}*/

type tooManyErrors struct{}

// The parser structure holds the parser's internal state.
type parser struct {
	file    *File
	errors  ErrorList
	scanner Scanner

	allowMeta bool
	allowEmit bool
	document  *Metadata // last lead comment
	meta      *Metadata
	emits     []*Metadata

	// Next token
	pos Pos    // token position
	tok Token  // one token look-ahead
	lit string // token literal

	// Error recovery
	// (used to limit the number of calls to parser.advance
	// w/o making scanning progress - avoids potential endless
	// loops across multiple parser functions during error recovery)
	syncPos Pos // last synchronization position
	syncCnt int // number of parser.advance calls without progress

	// Non-syntactic parser control
	exprLev int  // < 0: in control clause, >= 0: in expression
	inRhs   bool // if set, the parser is parsing a rhs expression
	class   *ClassDecl

	// Ordinary identifier scopes
	pkgScope    *Scope   // namespaceScope.Outer == nil
	topScope    *Scope   // top-most scope; may be pkgScope
	unresolved  []*Ident // unresolved identifiers
	badDecl     []*BadDecl
	targetStack [][]*Ident // stack of unresolved labels
}

func (p *parser) init(fset *FileSet, filename string, src []byte, scanComments bool, flags []string) {
	p.file = fset.AddFile(filename, -1, len(src))
	eh := func(pos Position, msg string) { p.errors.Add(pos, msg) }
	p.scanner.Init(p.file, src, eh, scanComments, flags)
	p.next()
}

// ----------------------------------------------------------------------------
// Scoping support

func (p *parser) openScope() {
	p.topScope = NewScope(p.topScope)
}

func (p *parser) closeScope() {
	p.topScope = p.topScope.Outer
}

func (p *parser) declare(decl interface{}, scope *Scope, kind ObjKind, idents ...*Ident) {
	for _, ident := range idents {
		assert(ident.Obj == nil, "identifier already declared or resolved")
		obj := NewObj(kind, ident.Name)
		// remember the corresponding declaration for redeclaration
		// errors and global variable resolution/typechecking phase
		obj.Decl = decl
		ident.Obj = obj
		if ident.Name != "_" {
			if alt := scope.Insert(obj); alt != nil {
				prevDecl := ""
				if pos := alt.Pos(); pos.IsValid() {
					prevDecl = fmt.Sprintf("\n\tprevious declaration at %s", p.file.Position(pos))
				}
				p.error(ident.Pos(), fmt.Sprintf("%s redeclared in this block%s", ident.Name, prevDecl))
			}
		}
	}
}

// The unresolved object is a sentinel to mark identifiers that have been added
// to the list of unresolved identifiers. The sentinel is only used for verifying
// internal consistency.
var unresolved = new(Object)

// If x is an identifier, tryResolve attempts to resolve x by looking up
// the object it denotes. If no object is found and collectUnresolved is
// set, x is marked as unresolved and collected in the list of unresolved
// identifiers.
//
func (p *parser) resolve(x Expr, collectUnresolved bool) {
	// nothing to do if x is not an identifier or the blank identifier
	ident, _ := x.(*Ident)
	if ident == nil {
		return
	}
	assert(ident.Obj == nil, "identifier already declared or resolved")
	// try to resolve the identifier
	for s := p.topScope; s != nil; s = s.Outer {
		if obj := s.Find(ident.Name); obj != nil {
			ident.Obj = obj
			return
		}
	}
	// all local scopes are known, so any unresolved identifier
	// must be found either in the file scope, package scope,
	// collect them so that they can be resolved later
	if collectUnresolved {
		ident.Obj = unresolved
		p.unresolved = append(p.unresolved, ident)
	}
}

// Advance to the next non-comment  In the process, collect
// any comment groups encountered, and remember the last lead and
// line comments.
//
// A lead comment is a comment group that starts and ends in a
// line without any other tokens and that is followed by a non-comment
// token on the line immediately after the comment group.
//
// A line comment is a comment group that follows a non-comment
// token on the same line, and that has no tokens after it on the line
// where it ends.
func (p *parser) next() {
	p.document = nil
	p.meta = nil
	p.emits = p.emits[:0]
	prev := p.pos
	p.pos, p.tok, p.lit = p.scanner.Scan()
	for p.tok == META {
		// invalid: if the meta is on same line as the previous token
		if p.file.Line(p.pos) == p.file.Line(prev) {
			p.error(p.pos, "meta data must start from newline.")
			p.parseMetadata() // skip meta
		} else {
			metaData := p.parseMetadata()
			for _, v := range metaData {
				if v.Name == MetaDoc {
					if p.allowMeta == false {
						p.error(p.pos, "document is not allowed here.")
					}
					if p.document != nil {
						p.error(p.pos, "duplicate document here.")
					}
					p.document = v
				} else if v.Name == "" {
					if p.allowEmit == false {
						p.error(p.pos, "emit code is not allowed here.")
					}
					p.emits = append(p.emits, v)
				} else {
					if p.allowMeta == false {
						p.error(p.pos, "metadata is not allowed here.")
					}
					if p.meta != nil {
						p.error(p.pos, "duplicate metadata here.")
					}
					p.meta = v
				}
			}
		}
	}
}

func (p *parser) error(pos Pos, msg string) {
	errPos := p.file.Position(pos)
	// If AllErrors is not set, discard errors reported on the same line
	// as the last recorded error and stop parsing if there are more than
	// 10 errors.
	n := len(p.errors)
	if n > 0 && p.errors[n-1].Pos.Line == errPos.Line {
		return // discard - likely a spurious error
	}
	if n > 10 {
		panic(tooManyErrors{})
	}
	p.errors.Add(errPos, msg)
	fmt.Println("error: ", msg)
}

func (p *parser) errorExpected(pos Pos, msg string) {
	msg = "expected " + msg
	if pos == p.pos {
		// the error happened at the current position;
		// make the error message more specific
		switch {
		case p.tok == Semi && p.lit == "\n":
			msg += ", found newline"
		case p.tok.IsLiteral():
			msg += ", found " + p.lit
		default:
			msg += ", found '" + p.tok.String() + "'"
		}
	}
	p.error(pos, msg)
}

func (p *parser) expect(tok Token) Pos {
	pos := p.pos
	if p.tok != tok {
		p.errorExpected(pos, "'"+tok.String()+"'")
	}
	p.next() // make progress
	return pos
}

func assert(cond bool, msg string) {
	if !cond {
		panic("go/parser internal error: " + msg)
	}
}

// advance consumes tokens until the current token p.tok
// is in the 'to' set, or EOF. For error recovery.
func (p *parser) advance(to map[Token]bool) {
	for ; p.tok != EOF; p.next() {
		if to[p.tok] {
			// Return only if parser made some progress since last
			// sync or if it has not reached 10 advance calls without
			// progress. Otherwise consume at least one token to
			// avoid an endless parser loop (it is possible that
			// both parseOperand and parseStmt call advance and
			// correctly do not advance, thus the need for the
			// invocation limit p.syncCnt).
			if p.pos == p.syncPos && p.syncCnt < 10 {
				p.syncCnt++
				return
			}
			if p.pos > p.syncPos {
				p.syncPos = p.pos
				p.syncCnt = 0
				return
			}
			// Reaching here indicates a parser bug, likely an
			// incorrect token list in this function, but it only
			// leads to skipping of possibly correct code if a
			// previous error is present, and thus is preferred
			// over a non-terminating parse.
		}
	}
}

var stmtStart = map[Token]bool{
	Break:    true,
	Catch:    true,
	Const:    true,
	Continue: true,
	For:      true,
	If:       true,
	Return:   true,
	Switch:   true,
	Try:      true,
	Var:      true,
}

var declStart = map[Token]bool{
	Const:     true,
	Class:     true,
	Enum:      true,
	Import:    true,
	Interface: true,
	Public:    true,
	Static:    true,
	Var:       true,
}

var exprEnd = map[Token]bool{
	Comma:        true,
	Colon:        true,
	Semi:         true,
	RightParen:   true,
	RightBrace:   true,
	RightBracket: true,
}

// ----------------------------------------------------------------------------
// Identifiers

func (p *parser) parseIdent() *Ident {
	pos := p.pos
	name := ""
	if p.tok == IDENT {
		name = p.lit
		p.next()
	} else {
		p.expect(IDENT) // use expect() error handling
	}
	return &Ident{Start: pos, Name: name}
}

func (p *parser) parseModifier() *Modifier {
	m := &Modifier{}
	if p.tok == Public {
		m.Public = true
		p.next()
	}
	if p.tok == Static {
		m.Static = true
		p.next()
	}
	if p.tok == Weak {
		m.Weak = true
		p.next()
	}
	return m
}

func (p *parser) parseGeneric(resolve bool) *GenericLit {
	if p.tok == Less {
		g := &GenericLit{
			Start: p.pos,
		}
		p.next()
		g.Types = append(g.Types, p.tryType(resolve))

		for p.tok == Comma {
			p.next()
			g.Types = append(g.Types, p.tryType(resolve))
		}
		p.expect(Greater)
		return g

	}
	return nil
}

func (p *parser) parseMetadata() []*Metadata {
	if p.tok != META {
		return nil
	}
	var meta []*Metadata
	for p.tok == META {
		p.next()
		// emit
		if p.tok == STRING {
			m := &Metadata{Start: p.pos}
			m.Text = p.lit
			p.next()
			continue
		}

		if p.tok != IDENT {
			p.expect(IDENT)
		}
		m := &Metadata{Start: p.pos}
		m.Name = p.lit
		p.next()

		if p.tok == STRING {
			m.Text = p.lit
			p.next()
		} else if p.tok == LeftParen {
			m.Values = make(map[string]*BasicLit)
			p.next()
			for {
				if p.tok == IDENT {
					name := p.lit
					p.next()
					if p.tok == Equal {
						p.next()
						switch p.tok {
						case INT, FLOAT, CHAR, STRING:
							//TO-DO check if duplicated
							m.Values[name] = &BasicLit{
								Start: p.pos,
								Kind:  p.tok,
								Value: p.lit,
							}
						default:
							p.errorExpected(p.pos, "basic literal (char, int, float, string)")
						}
						p.next()
					}
					if p.tok == RightParen {
						break
					}
					p.expect(Comma)
				} else {
					p.expect(IDENT)
				}
			}
			p.next()
		}
		meta = append(meta, m)
	}
	return meta
}

// ----------------------------------------------------------------------------
// Types

func (p *parser) parseType() Expr {
	typ := p.tryType(true)

	if typ == nil {
		pos := p.pos
		p.errorExpected(pos, "type")
		p.advance(exprEnd)
		return &BadExpr{Start: pos}
	}

	return typ
}

// If the result is an identifier, it is not resolved.
func (p *parser) parseTypeName() Expr {
	ident := p.parseIdent()
	// don't resolve ident yet - it may be a parameter or field name
	if p.tok == Dot {
		// ident is a package name
		p.next()
		p.resolve(ident, true)
		sel := p.parseIdent()
		return &SelectorExpr{Expr: ident, Selector: sel}
	}
	return ident
}

// If the result is an identifier, it is not resolved.
func (p *parser) tryVarType(isParam bool) Expr {
	if isParam && p.tok == Ellipsis {
		pos := p.pos
		p.next()
		typ := p.tryType(false) // don't use parseType so we can provide better error message
		if typ != nil {
			p.resolve(typ, true)
		} else {
			p.error(pos, "'...' parameter is missing type")
			typ = &BadExpr{Start: pos}
		}
		return &EllipsisLit{Start: pos, Expr: typ}
	}
	return p.tryType(false)
}

// If the result is an identifier, it is not resolved.
func (p *parser) parseVarType(isParam bool) Expr {
	typ := p.tryVarType(isParam)
	if typ == nil {
		pos := p.pos
		p.errorExpected(pos, "type")
		p.next() // make progress
		typ = &BadExpr{Start: pos}
	}
	return typ
}

func (p *parser) parseParameterList(scope *Scope) (params []*Field) {
	for p.tok != RightParen {
		field := &Field{}
		typ := p.parseVarType(true)
		if p.tok == Comma {
			field.Name = nil
			field.Type = typ
			p.expect(Comma)
			params = append(params, field)
			continue
		}
		ok := false
		field.Name, ok = typ.(*Ident)
		if !ok {
			p.expect(IDENT)
		}
		field.Type = p.parseVarType(true)
		if p.tok == Equal {
			p.next()
			field.Default = p.parseExpr(false)
		}
		params = append(params, field)
		p.declare(field, scope, VarObj, field.Name)
		p.resolve(field.Type, true)
		p.expect(Comma)
	}

	var list []Expr
	for {
		list = append(list, p.parseVarType(true))
		if p.tok != Comma {
			break
		}
		p.next()
		if p.tok == RightParen {
			break
		}
	}
	return
}

func (p *parser) parseParameters(scope *Scope) *FieldList {
	var params []*Field
	start := p.expect(LeftParen)
	if p.tok != RightParen {
		params = p.parseParameterList(scope)
	}
	p.expect(RightParen)

	return &FieldList{Start: start, Fields: params}
}

func (p *parser) parseResult(scope *Scope) *Field {
	typ := p.tryType(true)
	if typ != nil {
		return &Field{Type: typ}
	}
	return &Field{Type: &Scalar{Token: Void}}
}

// If the result is an identifier, it is not resolved.
func (p *parser) tryType(resolve bool) Expr {
	if p.tok.IsScalar() {
		scalar := &Scalar{
			Start: p.pos,
			Token: p.tok,
		}
		p.next()
		return scalar

	} else if p.tok == IDENT {
		typ := p.parseTypeName()
		if resolve {
			p.resolve(typ, true)
		}
		return typ
	}
	return nil
}

// ----------------------------------------------------------------------------
// Blocks

func (p *parser) parseStmtList() (list []Stmt) {
	for p.tok != Case && p.tok != Default && p.tok != RightBrace && p.tok != EOF {
		list = append(list, p.parseStmt())
	}
	return
}

func (p *parser) parseBody(scope *Scope) *BlockStmt {
	start := p.expect(LeftBrace)
	p.topScope = scope // open function scope
	list := p.parseStmtList()
	p.closeScope()
	p.expect(RightBrace)

	return &BlockStmt{Start: start, Stmts: list}
}

func (p *parser) parseBlockStmt() *BlockStmt {
	start := p.expect(LeftBrace)
	p.openScope()
	list := p.parseStmtList()
	p.closeScope()

	return &BlockStmt{Start: start, Stmts: list}
}

// ----------------------------------------------------------------------------
// Expressions

// parseOperand may return an expression or a raw type.
// Callers must verify the result.
// If lhs is set and the result is an identifier, it is not resolved.
//
func (p *parser) parseOperand(lhs bool) Expr {
	switch p.tok {
	case IDENT:
		x := p.parseIdent()
		if !lhs {
			p.resolve(x, true)
		}
		return x

	case INT, FLOAT, CHAR, STRING, True, False, Void, Null:
		x := &BasicLit{Start: p.pos, Kind: p.tok, Value: p.lit}
		p.next()
		return x

	case LeftParen:
		start := p.pos
		p.next()
		p.exprLev++
		x := p.parseRhs() // types may be parenthesized: (some type)
		p.exprLev--
		p.expect(RightParen)
		return &ParenExpr{Start: start, Expr: x}
	}

	if typ := p.tryType(false); typ != nil {
		// could be type for composite literal or conversion
		_, isIdent := typ.(*Ident)
		assert(!isIdent, "type cannot be identifier")
		return typ
	}

	// we have an error
	pos := p.pos
	p.errorExpected(pos, "operand")
	p.advance(stmtStart)
	return &BadExpr{Start: pos}
}

func (p *parser) parseSelector(x Expr) Expr {
	return &SelectorExpr{Expr: x, Selector: p.parseIdent()}
}

func (p *parser) parseIndex(x Expr) Expr {
	p.expect(LeftBracket)
	p.exprLev++
	var index Expr
	index = p.parseRhs()
	p.exprLev--
	p.expect(RightBracket)

	return &IndexExpr{Expr: x, Index: index}
}

func (p *parser) parseCall(fun Expr) *CallExpr {
	p.expect(LeftParen)
	p.exprLev++
	var list []Expr
	var ellipsis = -1
	for p.tok != RightParen && p.tok != EOF {
		list = append(list, p.parseRhs()) // builtins may expect a type: make(some type, ...)
		if p.tok == Ellipsis {
			if ellipsis != -1 {
				p.errorExpected(p.pos, "only one ... can be used in a function call.")
			}
			ellipsis = len(list) - 1
			p.next()
		}
		p.next()
	}
	p.exprLev--
	p.expect(RightParen)

	return &CallExpr{Func: fun, Args: list, Ellipsis: ellipsis}
}

func (p *parser) parseValue(lhs bool) Expr {
	if p.tok == LeftBrace {
		return p.parseLiteralValue(nil)
	}
	x := p.parseExpr(lhs)
	if lhs {
		if p.tok == Colon {
			p.resolve(x, false)
		} else {
			// not a key
			p.resolve(x, true)
		}
	}
	return x
}

func (p *parser) parseElement() Expr {
	x := p.parseValue(true)
	if p.tok == Colon {
		p.next()
		x = &KeyValueExpr{Key: x, Value: p.parseValue(false)}
	}
	return x
}

func (p *parser) parseElementList() (list []Expr) {
	for p.tok != RightBrace && p.tok != EOF {
		list = append(list, p.parseElement())
		p.next()
	}
	return
}

func (p *parser) parseLiteralValue(typ Expr) Expr {
	start := p.expect(LeftBrace)
	var elts []Expr
	p.exprLev++
	if p.tok != RightBrace {
		elts = p.parseElementList()
	}
	p.exprLev--
	p.expect(RightBrace)
	return &CompositeLit{Type: typ, Start: start, Values: elts}
}

// isTypeName reports whether x is a (qualified) TypeName.
func isTypeName(x Expr) bool {
	switch t := x.(type) {
	case *BadExpr:
	case *Ident:
	case *SelectorExpr:
		_, isIdent := t.Expr.(*Ident)
		return isIdent
	default:
		return false // all other nodes are not type names
	}
	return true
}

// isLiteralType reports whether x is a legal composite literal type.
func isLiteralType(x Expr) bool {
	switch t := x.(type) {
	case *BadExpr:
	case *Ident:
	case *SelectorExpr:
		_, isIdent := t.Expr.(*Ident)
		return isIdent
	default:
		return false // all other nodes are not legal composite literal types
	}
	return true
}

// If lhs is set and the result is an identifier, it is not resolved.
func (p *parser) parsePrimaryExpr(lhs bool) Expr {
	x := p.parseOperand(lhs)
	for {
		switch p.tok {
		case Dot:
			p.next()
			if lhs {
				p.resolve(x, true)
			}
			switch p.tok {
			case IDENT:
				x = p.parseSelector(x)
			default:
				pos := p.pos
				p.errorExpected(pos, "selector")
				p.next() // make progress
				sel := &Ident{Start: pos}
				x = &SelectorExpr{Expr: x, Selector: sel}
			}
		case LeftBracket:
			if lhs {
				p.resolve(x, true)
			}
			x = p.parseIndex(x)
		case LeftParen:
			if lhs {
				p.resolve(x, true)
			}
			x = p.parseCall(x)
		case LeftBrace:
			if isLiteralType(x) && (p.exprLev >= 0 || !isTypeName(x)) {
				if lhs {
					p.resolve(x, true)
				}
				x = p.parseLiteralValue(x)
			} else {
				return x
			}
		default:
			return x
		}
		lhs = false // no need to try to resolve again
	}

	return x
}

// If lhs is set and the result is an identifier, it is not resolved.
func (p *parser) parseUnaryExpr(lhs bool) Expr {
	switch p.tok {
	case Plus, Minus, Not, Caret, And:
		pos, op := p.pos, p.tok
		p.next()
		x := p.parseUnaryExpr(false)
		return &UnaryExpr{Start: pos, Op: op, Expr: x}
	}
	return p.parsePrimaryExpr(lhs)
}

func (p *parser) tokPrec() (Token, int) {
	tok := p.tok
	if p.inRhs && tok == Assign {
		tok = Equal
	}
	return tok, tok.Precedence()
}

// If lhs is set and the result is an identifier, it is not resolved.
func (p *parser) parseBinaryExpr(lhs bool, prec1 int) Expr {
	x := p.parseUnaryExpr(lhs)
	for {
		op, oprec := p.tokPrec()
		if oprec < prec1 {
			return x
		}
		p.expect(op)
		if lhs {
			p.resolve(x, true)
			lhs = false
		}
		y := p.parseBinaryExpr(false, oprec+1)
		if op == Question {
			// TernaryExpr
			p.expect(Colon)
			z := p.parseBinaryExpr(false, oprec+1)
			x = &TernaryExpr{Condition: x, First: y, Second: z}
		} else {
			x = &BinaryExpr{Left: x, Op: op, Right: y}
		}
	}
}

// Continue
// If lhs is set and the result is an identifier, it is not resolved.
// The result may be a type or even a raw type ([...]int). Callers must
// check the result (using checkExpr or checkExprOrType), depending on
// context.
func (p *parser) parseExpr(lhs bool) Expr {
	return p.parseBinaryExpr(lhs, LowestPrec+1)
}

func (p *parser) parseRhs() Expr {
	old := p.inRhs
	p.inRhs = true
	x := p.parseExpr(false)
	p.inRhs = old
	return x
}

// ----------------------------------------------------------------------------
// Statements

// parseSimpleStmt returns true as 2nd result if it parsed the assignment
// of a range clause (with mode == rangeOk). The returned statement is an
// assignment with a right-hand side that is a single unary expression of
// the form "range x". No guarantees are given for the left-hand side.
func (p *parser) parseSimpleStmt() Stmt {
	x := p.parseExpr(true)

	switch p.tok {
	case
		Assign, PlusAssign,
		MinusAssign, MulAssign, DivAssign,
		ModAssign, AndAssign, OrAssign,
		XorAssign, LeftShiftAssign, RightShiftAssign:
		// assignment statement, possibly part of a range clause
		pos, tok := p.pos, p.tok
		p.next()
		var y []Expr
		y = p.parseRhsList()
		as := &AssignStmt{Lhs: x, TokPos: pos, Tok: tok, Rhs: y}
		return as
	}

	if len(x) > 1 {
		p.errorExpected(x[0].Pos(), "1 expression")
		// continue with first expression
	}

	switch p.tok {
	case PlusPlus, MinusMinus:
		// increment or decrement
		s := &IncDecStmt{X: x[0], TokPos: p.pos, Tok: p.tok}
		p.next()
		return s
	}

	// expression
	return &ExprStmt{X: x[0]}
}

func (p *parser) parseCallExpr(callType string) *CallExpr {
	x := p.parseRhsOrType() // could be a conversion: (some type)(x)
	if call, isCall := x.(*CallExpr); isCall {
		return call
	}
	if _, isBad := x.(*BadExpr); !isBad {
		// only report error if it's a new one
		p.error(p.safePos(x.End()), fmt.Sprintf("function must be invoked in %s statement", callType))
	}
	return nil
}

func (p *parser) parseReturnStmt() *ReturnStmt {
	pos := p.pos
	p.expect(Return)
	var result Expr
	if p.tok != Semi {
		result = p.checkExpr(p.parseExpr(false))
	}
	p.expect(Semi)
	//TO-DO parse one Rhs instead list
	return &ReturnStmt{Return: pos, Result: result}
}

func (p *parser) parseBranchStmt(tok Token) *BranchStmt {
	pos := p.expect(tok)
	var label *Ident
	if p.tok == IDENT {
		label = p.parseIdent()
		// add to list of unresolved targets
		n := len(p.targetStack) - 1
		p.targetStack[n] = append(p.targetStack[n], label)
	}
	p.expect(Semi)

	return &BranchStmt{TokPos: pos, Tok: tok, Label: label}
}

func (p *parser) makeExpr(s Stmt, want string) Expr {
	if s == nil {
		return nil
	}
	if es, isExpr := s.(*ExprStmt); isExpr {
		return p.checkExpr(es.X)
	}
	found := "simple statement"
	if _, isAss := s.(*AssignStmt); isAss {
		found = "assignment"
	}
	p.error(s.Pos(), fmt.Sprintf("expected %s, found %s (missing parentheses around composite literal?)", want, found))
	return &BadExpr{From: s.Pos(), To: p.safePos(s.End())}
}

// parseIfHeader is an adjusted version of parser.header
// in cmd/compile/internal/syntax/parser.go, which has
// been tuned for better error handling.
func (p *parser) parseIfHeader() (init Stmt, cond Expr) {
	if p.tok == LeftBrace {
		p.error(p.pos, "missing condition in if statement")
		cond = &BadExpr{From: p.pos, To: p.pos}
		return
	}
	// p.tok != LeftBrace

	outer := p.exprLev
	p.exprLev = -1

	if p.tok != Semi {
		// accept potential variable declaration but complain
		if p.tok == Var {
			p.next()
			p.error(p.pos, fmt.Sprintf("var declaration not allowed in 'If' initializer"))
		}
		init = p.parseSimpleStmt(basic)
	}

	var condStmt Stmt
	var semi struct {
		pos Pos
		lit string // ";" or "\n"; valid if pos.IsValid()
	}
	if p.tok != LeftBrace {
		if p.tok == Semi {
			semi.pos = p.pos
			semi.lit = p.lit
			p.next()
		} else {
			p.expect(Semi)
		}
		if p.tok != LeftBrace {
			condStmt = p.parseSimpleStmt(basic)
		}
	} else {
		condStmt = init
		init = nil
	}

	if condStmt != nil {
		cond = p.makeExpr(condStmt, "boolean expression")
	} else if semi.pos.IsValid() {
		if semi.lit == "\n" {
			p.error(semi.pos, "unexpected newline, expecting { after if clause")
		} else {
			p.error(semi.pos, "missing condition in if statement")
		}
	}

	// make sure we have a valid AST
	if cond == nil {
		cond = &BadExpr{From: p.pos, To: p.pos}
	}

	p.exprLev = outer
	return
}

func (p *parser) parseIfStmt() *IfStmt {
	pos := p.expect(If)
	p.openScope()
	defer p.closeScope()

	init, cond := p.parseIfHeader()
	body := p.parseBlockStmt()

	var else_ Stmt
	if p.tok == Else {
		p.next()
		switch p.tok {
		case If:
			else_ = p.parseIfStmt()
		case LeftBrace:
			else_ = p.parseBlockStmt()
			p.expect(Semi)
		default:
			p.errorExpected(p.pos, "if statement or block")
			else_ = &BadStmt{From: p.pos, To: p.pos}
		}
	} else {
		p.expect(Semi)
	}

	return &IfStmt{If: pos, Init: init, Cond: cond, Body: body, Else: else_}
}

func (p *parser) parseTypeList() (list []Expr) {
	list = append(list, p.parseType())
	for p.tok == Comma {
		p.next()
		list = append(list, p.parseType())
	}

	return
}

func (p *parser) parseCaseClause() *CaseClause {
	pos := p.pos
	var list []Expr
	if p.tok == Case {
		p.next()
		list = p.parseRhsList()
	} else {
		p.expect(Default)
	}

	colon := p.expect(Colon)
	p.openScope()
	body := p.parseStmtList()
	p.closeScope()

	return &CaseClause{Case: pos, List: list, Colon: colon, Body: body}
}

func (p *parser) parseSwitchStmt() Stmt {
	pos := p.expect(Switch)
	p.openScope()
	defer p.closeScope()

	var s1, s2 Stmt
	if p.tok != LeftBrace {
		prevLev := p.exprLev
		p.exprLev = -1
		if p.tok != Semi {
			s2 = p.parseSimpleStmt(basic)
		}
		if p.tok == Semi {
			p.next()
			s1 = s2
			s2 = nil
			if p.tok != LeftBrace {
				// A TypeSwitchGuard may declare a variable in addition
				// to the variable declared in the initial SimpleStmt.
				// Introduce extra scope to avoid redeclaration errors:
				//
				//	switch t := 0; t := x.(T) { ... }
				//
				// (this code is not valid Go because the first t
				// cannot be accessed and thus is never used, the extra
				// scope is needed for the correct error message).
				//
				// If we don't have a type switch, s2 must be an expression.
				// Having the extra nested but empty scope won't affect it.
				p.openScope()
				defer p.closeScope()
				s2 = p.parseSimpleStmt(basic)
			}
		}
		p.exprLev = prevLev
	}

	lbrace := p.expect(LeftBrace)
	var list []Stmt
	for p.tok == Case || p.tok == Default {
		list = append(list, p.parseCaseClause())
	}
	rbrace := p.expect(RightBrace)
	p.expect(Semi)
	body := &BlockStmt{Lbrace: lbrace, List: list, Rbrace: rbrace}

	return &SwitchStmt{Switch: pos, Init: s1, Tag: p.makeExpr(s2, "switch expression"), Body: body}
}

func (p *parser) parseForStmt() Stmt {
	pos := p.expect(For)
	p.openScope()
	defer p.closeScope()

	var s1, s2, s3 Stmt
	//var isRange bool
	if p.tok != LeftBrace {
		prevLev := p.exprLev
		p.exprLev = -1
		if p.tok != Semi {
			s2 = p.parseSimpleStmt(rangeOk)
		}
		if p.tok == Semi {
			p.next()
			s1 = s2
			s2 = nil
			if p.tok != Semi {
				s2 = p.parseSimpleStmt(basic)
			}
			p.expect(Semi)
			if p.tok != LeftBrace {
				s3 = p.parseSimpleStmt(basic)
			}
		}
		p.exprLev = prevLev
	}

	body := p.parseBlockStmt()
	p.expect(Semi)

	// regular for statement
	return &ForStmt{
		For:  pos,
		Init: s1,
		Cond: p.makeExpr(s2, "boolean or range expression"),
		Post: s3,
		Body: body,
	}
}

func (p *parser) parseStmt() (s Stmt) {
	if len(p.meta) > 0 {
		// only 1 "@emit" is valid here
		if len(p.meta) > 1 || p.meta[0].Name != MetaEmit {
			p.error(p.meta[0].StartPos, "invalid meta.")
			s = &BadStmt{From: p.meta[0].StartPos, To: p.meta[0].EndPos}
			p.meta = p.meta[:0]
			return
		}
		s = &ExprStmt{X: &EmitExpr{
			Meta: p.meta[0],
		}}
		p.meta = p.meta[:0]
		return
	}
	switch p.tok {
	case Const, Var:
		s = &DeclStmt{Decl: p.parseDecl(stmtStart)}
	case
		// tokens that may start an expression
		IDENT, INT, FLOAT, CHAR, STRING, Function, LeftParen, // operands
		LeftBracket, Class, Enum, Interface, // composite types
		Plus, Minus, Star, And, Caret, Not: // unary operators
		s = p.parseSimpleStmt(labelOk)
	case Return:
		s = p.parseReturnStmt()
	case Break, Continue:
		s = p.parseBranchStmt(p.tok)
	case LeftBrace:
		s = p.parseBlockStmt()
		p.expect(Semi)
	case If:
		s = p.parseIfStmt()
	case Switch:
		s = p.parseSwitchStmt()
	case For:
		s = p.parseForStmt()
	case Semi:
		// Is it ever possible to have an implicit semicolon
		// producing an empty statement in a valid program?
		// (handle correctly anyway)
		s = &EmptyStmt{Semicolon: p.pos, Implicit: p.lit == "\n"}
		p.next()
	case RightBrace:
		// a semicolon may be omitted before a closing "}"
		s = &EmptyStmt{Semicolon: p.pos, Implicit: true}
	default:
		// no statement found
		pos := p.pos
		p.errorExpected(pos, "statement")
		p.advance(stmtStart)
		s = &BadStmt{From: pos, To: p.pos}
	}

	return
}

// ----------------------------------------------------------------------------
// Declarations

func (p *parser) parsePackageDecl(doc *Metadata) *PackageDecl {
	// The namespace clause is not a declaration;
	// the package name does not appear in any scope.
	ident := p.parseQualifiedIdent()
	p.expect(Semi)

	if p.errors.Len() != 0 {
		return nil
	}

	spec := &PackageDecl{
		Doc:  doc,
		Path: &BasicLit{ValuePos: ident.Pos(), Kind: STRING, Value: ident.Name},
	}
	return spec
}

func (p *parser) parseImportDecl(doc *Metadata) *ImportDecl {
	ident := p.parseQualifiedIdent()
	var path *BasicLit

	switch p.tok {
	case Semi:
		path = &BasicLit{ValuePos: ident.NamePos, Kind: STRING, Value: ident.Name}
		ident = nil
		p.next()
	case IDENT:
		qualifiedPath := p.parseQualifiedIdent()
		path = &BasicLit{ValuePos: qualifiedPath.NamePos, Kind: STRING, Value: qualifiedPath.Name}
		p.expect(Semi)
	}

	// collect imports
	return &ImportDecl{
		Doc:  doc,
		Name: ident,
		Path: path,
	}
}

func (p *parser) parseValueDecl(doc *Metadata, m *Modifier) *ValueDecl {
	keyword := p.tok
	p.next()
	decl := &ValueDecl{
		Doc:      doc,
		Modifier: m,
		Names:    p.parseIdentList(),
		Type:     p.tryType(true),
	}

	pos := p.pos
	// always permit optional initialization for more tolerant parsing
	if p.tok == Assign {
		p.next()
		decl.Values = p.parseRhsList()
	}
	p.expect(Semi) // call before accessing p.linecomment

	if decl.Values == nil && decl.Type == nil {
		p.error(pos, "missing type or initialization")
	}

	kind := ConstObj
	if keyword == Var {
		kind = VarObj
	}
	p.declare(decl, p.topScope, kind, decl.Names...)

	return decl
}

/*
func (p *parser) parseTypeSpec(doc *CommentGroup, _ Token, _ int) Spec {
	ident := p.parseIdent()

	// Go spec: The scope of a type identifier declared inside a function begins
	// at the identifier in the TypeSpec and ends at the end of the innermost
	// containing block.
	// (Global identifiers are resolved in a separate phase after parsing.)
	spec := &TypeSpec{Doc: doc, Name: ident}
	p.declare(spec, p.topScope, Typ, ident)
	if p.tok == Assign {
		spec.Assign = p.pos
		p.next()
	}
	spec.Type = p.parseType()
	p.expect(Semi) // call before accessing p.linecomment
	spec.Comment = p.lineComment

	return spec
}
*/

func (p *parser) parseFuncDecl(doc *Metadata, m *Modifier) *FuncDecl {
	pos := p.expect(Function)
	scope := NewScope(p.topScope) // function scope

	ident := p.parseIdent()
	generic := p.parseGeneric(false)
	//TO-DO parse <> generic

	params := p.parseParameters(scope)
	result := p.parseResult(scope)

	var body *BlockStmt
	if p.tok == LeftBrace {
		body = p.parseBody(scope)
	}

	decl := &FuncDecl{
		Doc:  doc,
		Name: ident,
		Type: &FuncType{
			Func:   pos,
			Params: params,
			Result: result,
		},
		Body:    body,
		Generic: generic,
	}

	p.declare(decl, p.pkgScope, FunctionObj, ident)

	return decl
}

func (p *parser) parseDecl(sync map[Token]bool) Decl {
	m := p.parseModifier()
	switch p.tok {
	case Const, Var:
		return p.parseValueDecl(p.document, m)
	/*TO-DO class enum interface
	case Type:
		f = p.parseTypeSpec
	*/
	case Function:
		return p.parseFuncDecl(p.document, m)

	default:
		pos := p.pos
		p.errorExpected(pos, "declaration")
		p.advance(sync)
		return &BadDecl{From: pos, To: p.pos}
	}
}

// ----------------------------------------------------------------------------
// Source files

func (p *parser) parseFile() *ProgramFile {
	program := &ProgramFile{}

	if p.errors.Len() != 0 {
		return nil
	}

	// namespace
	p.expect(Package)
	program.Package = p.parsePackageDecl(p.document)

	if p.errors.Len() != 0 {
		return nil
	}
	p.openScope()
	p.pkgScope = p.topScope

	// import
	for p.tok == Import {
		p.next()
		program.Imports = append(program.Imports, p.parseImportDecl(p.document))
	}

	// rest of namespace body
	for p.tok != EOF {
		decl := p.parseDecl(declStart)
		switch v := decl.(type) {
		case *ValueDecl:
			program.Values = append(program.Values, v)
		case *FuncDecl:
			program.Functions = append(program.Functions, v)
		case *BadDecl:
			p.badDecl = append(p.badDecl, v)

		}
	}

	p.closeScope()
	assert(p.topScope == nil, "unbalanced scopes")
	/*
		// resolve global identifiers within the same file
		i := 0
		for _, ident := range p.unresolved {
			// i <= index for current ident
			assert(ident.Obj == unresolved, "object already resolved")
			ident.Obj = p.pkgScope.Lookup(ident.Name) // also removes unresolved sentinel
			if ident.Obj == nil {
				p.unresolved[i] = ident
				i++
			}
		}*/

	return program
	//Scope:      p.pkgScope,
	//Unresolved: p.unresolved[0:i],
}
