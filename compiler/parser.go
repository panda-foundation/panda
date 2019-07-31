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
			if _, ok := e.(bailout); !ok {
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

// A bailout panic is raised to indicate early termination.
type bailout struct{}

// The parser structure holds the parser's internal state.
type parser struct {
	file    *File
	errors  ErrorList
	scanner Scanner

	scanComments bool // if scan comments
	indent       int  // indentation used for tracing output

	// Comments
	leadComment *Comment // last lead comment

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

	// Ordinary identifier scopes
	pkgScope   *Scope        // namespaceScope.Outer == nil
	topScope   *Scope        // top-most scope; may be pkgScope
	unresolved []*Ident      // unresolved identifiers
	imports    []*ImportSpec // list of imports

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
func (p *parser) tryResolve(x Expr, collectUnresolved bool) {
	// nothing to do if x is not an identifier or the blank identifier
	ident, _ := x.(*Ident)
	if ident == nil {
		return
	}
	assert(ident.Obj == nil, "identifier already declared or resolved")
	if ident.Name == "_" {
		return
	}
	// try to resolve the identifier
	for s := p.topScope; s != nil; s = s.Outer {
		if obj := s.Find(ident.Name); obj != nil {
			ident.Obj = obj
			return
		}
	}
	// all local scopes are known, so any unresolved identifier
	// must be found either in the file scope, package scope
	// (perhaps in another file), or universe scope --- collect
	// them so that they can be resolved later
	if collectUnresolved {
		ident.Obj = unresolved
		p.unresolved = append(p.unresolved, ident)
	}
}

func (p *parser) resolve(x Expr) {
	p.tryResolve(x, true)
}

// ----------------------------------------------------------------------------
// Parsing support

// Consume comments, keep the last one
func (p *parser) consumeComment() *Comment {
	pos, tok, lit := p.pos, p.tok, p.lit
	for p.tok == COMMENT {
		p.pos, p.tok, p.lit = p.scanner.Scan()
		if p.tok == COMMENT {
			pos, tok, lit = p.pos, p.tok, p.lit
		}
	}

	if tok == COMMENT {
		return &Comment{Slash: pos, Text: lit}
	}
	return nil
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
	p.leadComment = nil
	prev := p.pos
	p.pos, p.tok, p.lit = p.scanner.Scan()
	for p.tok == COMMENT {
		// if the comment is on same line as the previous token; it cannot be a lead comment
		if p.file.Line(p.pos) != p.file.Line(prev) {
			p.leadComment = p.consumeComment()
		}
		p.next()
	}
}

func (p *parser) error(pos Pos, msg string) {
	/* TO-DO
	epos := p.file.Position(pos)

	// If AllErrors is not set, discard errors reported on the same line
	// as the last recorded error and stop parsing if there are more than
	// 10 errors.
	if p.mode&AllErrors == 0 {
		n := len(p.errors)
		if n > 0 && p.errors[n-1].Pos.Line == epos.Line {
			return // discard - likely a spurious error
		}
		if n > 10 {
			panic(bailout{})
		}
	}*/

	//p.errors.Add(epos, msg)

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

// expectClosing is like expect but provides a better error message
// for the common case of a missing comma before a newline.
//
func (p *parser) expectClosing(tok Token, context string) Pos {
	if p.tok != tok && p.tok == Semi && p.lit == "\n" {
		p.error(p.pos, "missing ',' before newline in "+context)
		p.next()
	}
	return p.expect(tok)
}

func (p *parser) atComma(context string, follow Token) bool {
	if p.tok == Comma {
		return true
	}
	if p.tok != follow {
		msg := "missing ','"
		if p.tok == Semi && p.lit == "\n" {
			msg += " before newline"
		}
		p.error(p.pos, msg+" in "+context)
		return true // "insert" comma and continue
	}
	return false
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
	Break: true,
	Catch: true,
	//Const:    true,
	Continue: true,
	For:      true,
	If:       true,
	Return:   true,
	Switch:   true,
	Try:      true,
	//Var:      true,
}

var declStart = map[Token]bool{
	Const:  true,
	Class:  true,
	Enum:   true,
	Public: true,
	Static: true,
	Var:    true,
}

var exprEnd = map[Token]bool{
	Comma:        true,
	Colon:        true,
	Semi:         true,
	RightParen:   true,
	RightBrace:   true,
	RightBracket: true,
}

// safePos returns a valid file position for a given position: If pos
// is valid to begin with, safePos returns pos. If pos is out-of-range,
// safePos returns the EOF position.
//
// This is hack to work around "artificial" end positions in the AST which
// are computed by adding 1 to (presumably valid) token positions. If the
// token positions are invalid due to parse errors, the resulting end position
// may be past the file's EOF position, which would lead to panics if used
// later on.
//
func (p *parser) safePos(pos Pos) (res Pos) {
	defer func() {
		if recover() != nil {
			res = Pos(p.file.Base() + p.file.Size()) // EOF position
		}
	}()
	_ = p.file.Offset(pos) // trigger a panic if position is out-of-range
	return pos
}

// ----------------------------------------------------------------------------
// Identifiers

func (p *parser) parseIdent() *Ident {
	pos := p.pos
	name := "_"
	if p.tok == IDENT {
		name = p.lit
		p.next()
	} else {
		p.expect(IDENT) // use expect() error handling
	}
	return &Ident{NamePos: pos, Name: name}
}

func (p *parser) parseIdentList() (list []*Ident) {
	list = append(list, p.parseIdent())
	for p.tok == Comma {
		p.next()
		list = append(list, p.parseIdent())
	}
	return
}

func (p *parser) parseQualifiedIdent() *Ident {
	pos := p.pos
	name := "_"
	if p.tok == IDENT {
		name = p.lit
		p.next()
		for p.tok == Dot {
			p.next()
			if p.tok == IDENT {
				name += "." + p.lit
				p.next()
			} else {
				p.expect(IDENT)
				break
			}
		}
	} else {
		p.expect(IDENT) // use expect() error handling
	}
	return &Ident{NamePos: pos, Name: name}

}

func (p *parser) parseModifier() *Modifier {
	m := &Modifier{}
	m.Public = false
	m.Static = false
	if p.tok == Public {
		m.Public = true
		p.next()
	}
	if p.tok == Static {
		m.Static = true
		p.next()
	}
	return m
}

// ----------------------------------------------------------------------------
// Common productions

// If lhs is set, result list elements which are identifiers are not resolved.
func (p *parser) parseExprList(lhs bool) (list []Expr) {
	list = append(list, p.checkExpr(p.parseExpr(lhs)))
	for p.tok == Comma {
		p.next()
		list = append(list, p.checkExpr(p.parseExpr(lhs)))
	}

	return
}

func (p *parser) parseLhsList() []Expr {
	old := p.inRhs
	p.inRhs = false
	list := p.parseExprList(true)
	for _, x := range list {
		p.resolve(x)
	}
	p.inRhs = old
	return list
}

func (p *parser) parseRhsList() []Expr {
	old := p.inRhs
	p.inRhs = true
	list := p.parseExprList(false)
	p.inRhs = old
	return list
}

// ----------------------------------------------------------------------------
// Types

func (p *parser) parseType() Expr {
	typ := p.tryType()

	if typ == nil {
		pos := p.pos
		p.errorExpected(pos, "type")
		p.advance(exprEnd)
		return &BadExpr{From: pos, To: p.pos}
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
		p.resolve(ident)
		sel := p.parseIdent()
		return &SelectorExpr{X: ident, Sel: sel}
	}

	//TO-DO generic eg: <int, int>

	return ident
}

func (p *parser) makeIdentList(list []Expr) []*Ident {
	idents := make([]*Ident, len(list))
	for i, x := range list {
		ident, isIdent := x.(*Ident)
		if !isIdent {
			if _, isBad := x.(*BadExpr); !isBad {
				// only report error if it's a new one
				p.errorExpected(x.Pos(), "identifier")
			}
			ident = &Ident{NamePos: x.Pos(), Name: "_"}
		}
		idents[i] = ident
	}
	return idents
}

func (p *parser) parseFieldDecl(scope *Scope) *Field {
	doc := p.leadComment

	// 1st FieldDecl
	// A type name used as an anonymous field looks like a field identifier.
	var list []Expr
	for {
		list = append(list, p.parseVarType(false))
		if p.tok != Comma {
			break
		}
		p.next()
	}

	typ := p.tryVarType(false)

	// analyze case
	var idents []*Ident
	if typ != nil {
		// IdentifierList Type
		idents = p.makeIdentList(list)
	} else {
		// ["*"] TypeName (AnonymousField)
		typ = list[0] // we always have at least one element
		if n := len(list); n > 1 {
			p.errorExpected(p.pos, "type")
			typ = &BadExpr{From: p.pos, To: p.pos}
		} else if !isTypeName(typ) {
			p.errorExpected(typ.Pos(), "anonymous field")
			typ = &BadExpr{From: typ.Pos(), To: p.safePos(typ.End())}
		}
	}

	// Tag
	var tag *BasicLit
	if p.tok == STRING {
		tag = &BasicLit{ValuePos: p.pos, Kind: p.tok, Value: p.lit}
		p.next()
	}

	p.expect(Semi) // call before accessing p.linecomment

	field := &Field{Doc: doc, Names: idents, Type: typ, Tag: tag}
	p.declare(field, scope, VarObj, idents...)
	p.resolve(typ)

	return field
}

/*
func (p *parser) parseStructType() *StructType {
	pos := p.expect(STRUCT)
	lbrace := p.expect(LeftBrace)
	scope := NewScope(nil) // struct scope
	var list []*Field
	for p.tok == IDENT || p.tok == MUL || p.tok == LeftParen {
		// a field declaration cannot start with a '(' but we accept
		// it here for more robust parsing and better error messages
		// (parseFieldDecl will check and complain if necessary)
		list = append(list, p.parseFieldDecl(scope))
	}
	rbrace := p.expect(RightBrace)

	return &StructType{
		Struct: pos,
		Fields: &FieldList{
			Opening: lbrace,
			List:    list,
			Closing: rbrace,
		},
	}
}*/

// If the result is an identifier, it is not resolved.
func (p *parser) tryVarType(isParam bool) Expr {
	if isParam && p.tok == Ellipsis {
		pos := p.pos
		p.next()
		typ := p.tryIdentOrType() // don't use parseType so we can provide better error message
		if typ != nil {
			p.resolve(typ)
		} else {
			p.error(pos, "'...' parameter is missing type")
			typ = &BadExpr{From: pos, To: p.pos}
		}
		return &EllipsisLit{Ellipsis: pos, Elt: typ}
	}
	return p.tryIdentOrType()
}

// If the result is an identifier, it is not resolved.
func (p *parser) parseVarType(isParam bool) Expr {
	typ := p.tryVarType(isParam)
	if typ == nil {
		pos := p.pos
		p.errorExpected(pos, "type")
		p.next() // make progress
		typ = &BadExpr{From: pos, To: p.pos}
	}
	return typ
}

func (p *parser) parseParameterList(scope *Scope, ellipsisOk bool) (params []*Field) {
	// 1st ParameterDecl
	// A list of identifiers looks like a list of type names.
	var list []Expr
	for {
		list = append(list, p.parseVarType(ellipsisOk))
		if p.tok != Comma {
			break
		}
		p.next()
		if p.tok == RightParen {
			break
		}
	}

	// analyze case
	if typ := p.tryVarType(ellipsisOk); typ != nil {
		// IdentifierList Type
		idents := p.makeIdentList(list)
		field := &Field{Names: idents, Type: typ}
		params = append(params, field)
		// Go spec: The scope of an identifier denoting a function
		// parameter or result variable is the function body.
		p.declare(field, scope, VarObj, idents...)
		p.resolve(typ)
		if !p.atComma("parameter list", RightParen) {
			return
		}
		p.next()
		for p.tok != RightParen && p.tok != EOF {
			idents := p.parseIdentList()
			typ := p.parseVarType(ellipsisOk)
			field := &Field{Names: idents, Type: typ}
			params = append(params, field)
			// Go spec: The scope of an identifier denoting a function
			// parameter or result variable is the function body.
			p.declare(field, scope, VarObj, idents...)
			p.resolve(typ)
			if !p.atComma("parameter list", RightParen) {
				break
			}
			p.next()
		}
		return
	}

	// Type { "," Type } (anonymous parameters)
	params = make([]*Field, len(list))
	for i, typ := range list {
		p.resolve(typ)
		params[i] = &Field{Type: typ}
	}
	return
}

func (p *parser) parseParameters(scope *Scope, ellipsisOk bool) *FieldList {
	var params []*Field
	lparen := p.expect(LeftParen)
	if p.tok != RightParen {
		params = p.parseParameterList(scope, ellipsisOk)
	}
	rparen := p.expect(RightParen)

	return &FieldList{Opening: lparen, List: params, Closing: rparen}
}

func (p *parser) parseResult(scope *Scope) *Field {
	typ := p.tryType()
	if typ != nil {
		return &Field{Type: typ}
	}
	return nil
}

func (p *parser) parseSignature(scope *Scope) (params *FieldList, result *Field) {
	params = p.parseParameters(scope, true)
	result = p.parseResult(scope)

	return
}

func (p *parser) parseFuncType() (*FuncType, *Scope) {
	pos := p.expect(Function)
	scope := NewScope(p.topScope) // function scope
	params, result := p.parseSignature(scope)

	return &FuncType{Func: pos, Params: params, Result: result}, scope
}

func (p *parser) parseMethodSpec(scope *Scope) *Field {
	doc := p.leadComment
	var idents []*Ident
	var typ Expr
	x := p.parseTypeName()
	if ident, isIdent := x.(*Ident); isIdent && p.tok == LeftParen {
		// method
		idents = []*Ident{ident}
		scope := NewScope(nil) // method scope
		params, result := p.parseSignature(scope)
		typ = &FuncType{Func: NoPos, Params: params, Result: result}
	} else {
		// embedded interface
		typ = x
		p.resolve(typ)
	}
	p.expect(Semi) // call before accessing p.linecomment

	spec := &Field{Doc: doc, Names: idents, Type: typ}
	p.declare(spec, scope, FunctionObj, idents...)

	return spec
}

func (p *parser) parseInterfaceType() *InterfaceType {
	pos := p.expect(Interface)
	lbrace := p.expect(LeftBrace)
	scope := NewScope(nil) // interface scope
	var list []*Field
	for p.tok == IDENT {
		list = append(list, p.parseMethodSpec(scope))
	}
	rbrace := p.expect(RightBrace)

	return &InterfaceType{
		Interface: pos,
		Methods: &FieldList{
			Opening: lbrace,
			List:    list,
			Closing: rbrace,
		},
	}
}

// If the result is an identifier, it is not resolved.
func (p *parser) tryIdentOrType() Expr {
	if p.tok.IsScalar() {
		scalar := &Scalar{
			From:  p.pos,
			Token: p.tok,
		}
		p.next()
		scalar.To = p.pos
		return scalar

	} else if p.tok == IDENT {
		return p.parseTypeName()
	}
	// no type found
	return nil
}

func (p *parser) tryType() Expr {
	typ := p.tryIdentOrType()
	if typ != nil {
		p.resolve(typ)
	}
	return typ
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
	lbrace := p.expect(LeftBrace)
	p.topScope = scope // open function scope
	list := p.parseStmtList()
	p.closeScope()
	rbrace := p.expect(RightBrace)

	return &BlockStmt{Lbrace: lbrace, List: list, Rbrace: rbrace}
}

func (p *parser) parseBlockStmt() *BlockStmt {
	lbrace := p.expect(LeftBrace)
	p.openScope()
	list := p.parseStmtList()
	p.closeScope()
	rbrace := p.expect(RightBrace)

	return &BlockStmt{Lbrace: lbrace, List: list, Rbrace: rbrace}
}

// ----------------------------------------------------------------------------
// Expressions

func (p *parser) parseFuncTypeOrLit() Expr {
	typ, scope := p.parseFuncType()
	if p.tok != LeftBrace {
		// function type only
		return typ
	}

	p.exprLev++
	body := p.parseBody(scope)
	p.exprLev--

	return &FuncLit{Type: typ, Body: body}
}

// parseOperand may return an expression or a raw type (incl. array
// types of the form [...]T. Callers must verify the result.
// If lhs is set and the result is an identifier, it is not resolved.
//
func (p *parser) parseOperand(lhs bool) Expr {
	switch p.tok {
	case IDENT:
		x := p.parseIdent()
		if !lhs {
			p.resolve(x)
		}
		return x

	case INT, FLOAT, CHAR, STRING, True, False, Void, Null:
		x := &BasicLit{ValuePos: p.pos, Kind: p.tok, Value: p.lit}
		p.next()
		return x

	case LeftParen:
		lparen := p.pos
		p.next()
		p.exprLev++
		x := p.parseRhsOrType() // types may be parenthesized: (some type)
		p.exprLev--
		rparen := p.expect(RightParen)
		return &ParenExpr{Lparen: lparen, X: x, Rparen: rparen}

	case Function:
		return p.parseFuncTypeOrLit()
	}

	if typ := p.tryIdentOrType(); typ != nil {
		// could be type for composite literal or conversion
		_, isIdent := typ.(*Ident)
		assert(!isIdent, "type cannot be identifier")
		return typ
	}

	// we have an error
	pos := p.pos
	p.errorExpected(pos, "operand")
	p.advance(stmtStart)
	return &BadExpr{From: pos, To: p.pos}
}

func (p *parser) parseSelector(x Expr) Expr {

	sel := p.parseIdent()

	return &SelectorExpr{X: x, Sel: sel}
}

func (p *parser) parseIndex(x Expr) Expr {
	lbrack := p.expect(LeftBracket)
	p.exprLev++
	var index Expr
	index = p.parseRhs()
	p.exprLev--
	rbrack := p.expect(RightBracket)

	return &IndexExpr{X: x, Lbrack: lbrack, Index: index, Rbrack: rbrack}
}

func (p *parser) parseCallOrConversion(fun Expr) *CallExpr {
	lparen := p.expect(LeftParen)
	p.exprLev++
	var list []Expr
	var ellipsis Pos
	for p.tok != RightParen && p.tok != EOF && !ellipsis.IsValid() {
		list = append(list, p.parseRhsOrType()) // builtins may expect a type: make(some type, ...)
		if p.tok == Ellipsis {
			ellipsis = p.pos
			p.next()
		}
		if !p.atComma("argument list", RightParen) {
			break
		}
		p.next()
	}
	p.exprLev--
	rparen := p.expectClosing(RightParen, "argument list")

	return &CallExpr{Fun: fun, Lparen: lparen, Args: list, Ellipsis: ellipsis, Rparen: rparen}
}

func (p *parser) parseValue(keyOk bool) Expr {
	if p.tok == LeftBrace {
		return p.parseLiteralValue(nil)
	}

	// Because the parser doesn't know the composite literal type, it cannot
	// know if a key that's an identifier is a struct field name or a name
	// denoting a value. The former is not resolved by the parser or the
	// resolver.
	//
	// Instead, _try_ to resolve such a key if possible. If it resolves,
	// it a) has correctly resolved, or b) incorrectly resolved because
	// the key is a struct field with a name matching another identifier.
	// In the former case we are done, and in the latter case we don't
	// care because the type checker will do a separate field lookup.
	//
	// If the key does not resolve, it a) must be defined at the top
	// level in another file of the same package, the universe scope, or be
	// undeclared; or b) it is a struct field. In the former case, the type
	// checker can do a top-level lookup, and in the latter case it will do
	// a separate field lookup.
	x := p.checkExpr(p.parseExpr(keyOk))
	if keyOk {
		if p.tok == Colon {
			// Try to resolve the key but don't collect it
			// as unresolved identifier if it fails so that
			// we don't get (possibly false) errors about
			// undeclared names.
			p.tryResolve(x, false)
		} else {
			// not a key
			p.resolve(x)
		}
	}

	return x
}

func (p *parser) parseElement() Expr {
	x := p.parseValue(true)
	if p.tok == Colon {
		colon := p.pos
		p.next()
		x = &KeyValueExpr{Key: x, Colon: colon, Value: p.parseValue(false)}
	}

	return x
}

func (p *parser) parseElementList() (list []Expr) {
	for p.tok != RightBrace && p.tok != EOF {
		list = append(list, p.parseElement())
		if !p.atComma("composite literal", RightBrace) {
			break
		}
		p.next()
	}

	return
}

func (p *parser) parseLiteralValue(typ Expr) Expr {
	lbrace := p.expect(LeftBrace)
	var elts []Expr
	p.exprLev++
	if p.tok != RightBrace {
		elts = p.parseElementList()
	}
	p.exprLev--
	rbrace := p.expectClosing(RightBrace, "composite literal")
	return &CompositeLit{Type: typ, Lbrace: lbrace, Elts: elts, Rbrace: rbrace}
}

// checkExpr checks that x is an expression (and not a type).
func (p *parser) checkExpr(x Expr) Expr {
	switch unparen(x).(type) {
	case *BadExpr:
	case *Ident:
	case *BasicLit:
	case *FuncLit:
	case *CompositeLit:
	case *ParenExpr:
		panic("unreachable")
	case *SelectorExpr:
	case *IndexExpr:
	case *CallExpr:
	case *UnaryExpr:
	case *BinaryExpr:
	default:
		// all other nodes are not proper expressions
		p.errorExpected(x.Pos(), "expression")
		x = &BadExpr{From: x.Pos(), To: p.safePos(x.End())}
	}
	return x
}

// isTypeName reports whether x is a (qualified) TypeName.
func isTypeName(x Expr) bool {
	switch t := x.(type) {
	case *BadExpr:
	case *Ident:
	case *SelectorExpr:
		_, isIdent := t.X.(*Ident)
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
		_, isIdent := t.X.(*Ident)
		return isIdent
	case *StructType:
	default:
		return false // all other nodes are not legal composite literal types
	}
	return true
}

// If x is of the form *T, deref returns T, otherwise it returns x.
/*
func deref(x Expr) Expr {
	if p, isPtr := x.(*StarExpr); isPtr {
		x = p.X
	}
	return x
}*/

// If x is of the form (T), unparen returns unparen(T), otherwise it returns x.
func unparen(x Expr) Expr {
	if p, isParen := x.(*ParenExpr); isParen {
		x = unparen(p.X)
	}
	return x
}

// checkExprOrType checks that x is an expression or a type
// (and not a raw type such as [...]T).
//
func (p *parser) checkExprOrType(x Expr) Expr {
	switch unparen(x).(type) {
	case *ParenExpr:
		panic("unreachable")
	}
	// all other nodes are expressions or types
	return x
}

// If lhs is set and the result is an identifier, it is not resolved.
func (p *parser) parsePrimaryExpr(lhs bool) Expr {
	x := p.parseOperand(lhs)
	for {
		switch p.tok {
		case Dot:
			p.next()
			if lhs {
				p.resolve(x)
			}
			switch p.tok {
			case IDENT:
				x = p.parseSelector(p.checkExprOrType(x))
			default:
				pos := p.pos
				p.errorExpected(pos, "selector or type assertion")
				p.next() // make progress
				sel := &Ident{NamePos: pos, Name: "_"}
				x = &SelectorExpr{X: x, Sel: sel}
			}
		case LeftBracket:
			if lhs {
				p.resolve(x)
			}
			x = p.parseIndex(p.checkExpr(x))
		case LeftParen:
			if lhs {
				p.resolve(x)
			}
			x = p.parseCallOrConversion(p.checkExprOrType(x))
		case LeftBrace:
			if isLiteralType(x) && (p.exprLev >= 0 || !isTypeName(x)) {
				if lhs {
					p.resolve(x)
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
		return &UnaryExpr{OpPos: pos, Op: op, X: p.checkExpr(x)}
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
		pos := p.expect(op)
		if lhs {
			p.resolve(x)
			lhs = false
		}
		y := p.parseBinaryExpr(false, oprec+1)
		x = &BinaryExpr{X: p.checkExpr(x), OpPos: pos, Op: op, Y: p.checkExpr(y)}
	}
}

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
	x := p.checkExpr(p.parseExpr(false))
	p.inRhs = old
	return x
}

func (p *parser) parseRhsOrType() Expr {
	old := p.inRhs
	p.inRhs = true
	x := p.checkExprOrType(p.parseExpr(false))
	p.inRhs = old
	return x
}

// ----------------------------------------------------------------------------
// Statements

// Parsing modes for parseSimpleStmt.
const (
	basic = iota
	labelOk
	rangeOk
)

// parseSimpleStmt returns true as 2nd result if it parsed the assignment
// of a range clause (with mode == rangeOk). The returned statement is an
// assignment with a right-hand side that is a single unary expression of
// the form "range x". No guarantees are given for the left-hand side.
func (p *parser) parseSimpleStmt(mode int) Stmt {
	x := p.parseLhsList()

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

type parseSpecFunction func(doc *Comment, keyword Token, iota int) Spec

func (p *parser) parsePackageSpec(doc *Comment) *PackageSpec {
	// The namespace clause is not a declaration;
	// the package name does not appear in any scope.
	ident := p.parseQualifiedIdent()
	p.expect(Semi)

	if p.errors.Len() != 0 {
		return nil
	}

	spec := &PackageSpec{
		Doc:  doc,
		Path: &BasicLit{ValuePos: ident.Pos(), Kind: STRING, Value: ident.Name},
	}
	return spec
}

func (p *parser) parseImportSpec(doc *Comment) *ImportSpec {
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
	return &ImportSpec{
		Doc:  doc,
		Name: ident,
		Path: path,
	}
}

func (p *parser) parseValueSpec(doc *Comment, m *Modifier) *ValueSpec {
	keyword := p.tok
	p.next()
	spec := &ValueSpec{
		Doc:   doc,
		Names: p.parseIdentList(),
		Type:  p.tryType(),
	}

	pos := p.pos
	// always permit optional initialization for more tolerant parsing
	if p.tok == Assign {
		p.next()
		spec.Values = p.parseRhsList()
	}
	p.expect(Semi) // call before accessing p.linecomment

	if spec.Values == nil && spec.Type == nil {
		p.error(pos, "missing type or initialization")
	}

	kind := ConstObj
	if keyword == Var {
		kind = VarObj
	}
	p.declare(spec, p.topScope, kind, spec.Names...)

	return spec
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

func (p *parser) parseFuncDecl(doc *Comment, m *Modifier) *FuncDecl {
	pos := p.expect(Function)
	scope := NewScope(p.topScope) // function scope

	//TO-DO parse <> generic
	ident := p.parseIdent()

	params, result := p.parseSignature(scope)

	var body *BlockStmt
	if p.tok == LeftBrace {
		body = p.parseBody(scope)
	}
	p.expect(Semi)

	decl := &FuncDecl{
		Doc:  doc,
		Name: ident,
		Type: &FuncType{
			Func:   pos,
			Params: params,
			Result: result,
		},
		Body: body,
	}

	p.declare(decl, p.pkgScope, FunctionObj, ident)

	return decl
}

func (p *parser) parseDecl(sync map[Token]bool) Decl {
	m := p.parseModifier()
	switch p.tok {
	case Const, Var:
		//pack to general decl
		tok := p.tok
		return &GenDecl{
			Doc:    p.leadComment,
			TokPos: p.pos,
			Tok:    tok,
			Spec:   p.parseValueSpec(p.leadComment, m),
		}
	/*TO-DO class enum interface
	case Type:
		f = p.parseTypeSpec
	*/
	case Function:
		return p.parseFuncDecl(p.leadComment, m)

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
	program.Package = p.parsePackageSpec(p.leadComment)

	if p.errors.Len() != 0 {
		return nil
	}
	p.openScope()
	p.pkgScope = p.topScope

	// import
	for p.tok == Import {
		p.next()
		program.Imports = append(program.Imports, p.parseImportSpec(p.leadComment))
	}

	// rest of namespace body
	for p.tok != EOF {
		program.Decls = append(program.Decls, p.parseDecl(declStart))
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
