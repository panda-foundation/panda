package compiler

/*
type Parser struct {
	Scanner *Scanner
	Program *ProgramUnit

	Token    Token
	Modifier Modifier

	InClass    bool
	InFunction bool
	InEnum     bool

	Documents []string
}

func NewParser() *Parser {
	return &Parser{}
}

func (parser *Parser) Parse(scanner *Scanner) {
	parser.Scanner = scanner
	parser.Program = &ProgramUnit{}

	parser.parseNamespace()
	parser.parseIncludes()
	parser.parseDeclarations()
}

// return the first cached token
func (parser *Parser) peek() Token {
	if parser.Token == TokenInvalid {
		parser.Token = parser.Scan()
	}
	return parser.Token
}

func (parser *Parser) consume() {
	parser.Token = TokenInvalid
}

func (parser *Parser) ensure(token Token) {
	if parser.peek() != token {
		err := fmt.Sprintf("unexpected %s: %s, expecte: %s \n", parser.Position, parser.Token(), TokenToKey(token))
		parser.error(err)
	}
	parser.consume()
}

func (parser *Parser) parseDocument() {
	if parser.skipDocument {
		return
	}

		//parser.clearDocument()
		//for parser.peek() == TokenComment {
			//parser.Documents = append(parser.Documents, parser.Token())
			//parser.consume()
		//}
}

func (parser *Parser) skipDocument() {
	if parser.skipDocument {
		return
	}
		//for parser.peek() == TokenComment {
			//parser.consume()
		//}
}

func (parser *Parser) clearDocument() {
	if parser.skipDocument {
		return
	}
	parser.Documents = parser.Documents[:0]
}

func (parser *Parser) getDocument() []string {
	var documents []string
	if parser.skipDocument {
		return documents
	}
	for _, v := range parser.Documents {
		documents = append(documents, v)
	}
	parser.clearDocument()
	return documents
}

func (parser *Parser) parseNamespace() {
	parser.parseDocument()
	if parser.peek() == Namespace {
		parser.consume()
		if parser.peek() != Semi {
			parser.Program.Namespace = parser.parseQualifiedId(false)
		}
		parser.ensure(Semi)
		parser.Program.Document = parser.getDocument()
		fmt.Println("namespace:", parser.Program.Namespace)
	} else {
		parser.error(fmt.Sprintf("unexpected: %s, expect namespace", TokenToKey(parser.peek())))
	}
}

func (parser *Parser) parseIncludes() {
	for {
		parser.parseDocument()
		if parser.peek() == Include {
			parser.consume()
			text := parser.parseQualifiedId(true)
			parser.Program.Includes = append(parser.Program.Includes, text)
			fmt.Println("include:", text)
			parser.ensure(Semi)
			parser.clearDocument()
		} else {
			break
		}
	}
}

func (parser *Parser) parseModifier() {
	parser.Modifier.Public = false
	parser.Modifier.Static = false

	if parser.peek() == Public {
		parser.Modifier.Public = true
		parser.consume()
	}
	if parser.peek() == Static {
		parser.Modifier.Static = true
		parser.consume()
		if !parser.InClass {
			parser.error("unexpected static")
		}
	}

	fmt.Println("modifiers:", parser.Modifier)
}

func (parser *Parser) parseQualifiedId(allowStar bool) string {
	id := ""
	for {
		if parser.peek() == TokenIdentifier {
			id += parser.Token()
			parser.consume()
			if parser.peek() == Dot {
				id += parser.Token()
				parser.consume()
				if allowStar && parser.peek() == Star {
					id += parser.Token()
					parser.consume()
					break
				}
			} else {
				break
			}
		} else {
			parser.error("invalid qualified id, unexpected: " + parser.Token())
			break
		}
	}
	return id
}

func (parser *Parser) parseType() *Type {
	dataType := &Type{}
	dataType.Scalar = TokenInvalid
	return nil
}

func (parser *Parser) parseDeclarations() {
	parser.parseModifier()
	//parser meta data

	switch parser.peek() {
	case Class:
	case Enum:
	case Interface:
	case Var:
	case Const:
	default:
		parser.error("unexpected: " + parser.Token())
	}
}

func (parser *Parser) parseClass() {

}

func (parser *Parser) parseDelaration(isConstant bool) {

}

func (parser *Parser) parseFunction() {

}*/

// Copyright 2009 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

// This file contains the exported entry points for invoking the parser.

import (
	"fmt"
	"io/ioutil"
)

// A Mode value is a set of flags (or 0).
// They control the amount of source code parsed and other optional
// parser functionality.
//
type Mode uint

const (
	PackageClauseOnly Mode             = 1 << iota // stop parsing after package clause
	ImportsOnly                                    // stop parsing after import declarations
	ParseComments                                  // parse comments and add them to AST
	Trace                                          // print a trace of parsed productions
	DeclarationErrors                              // report declaration errors
	SpuriousErrors                                 // same as AllErrors, for backward-compatibility
	AllErrors         = SpuriousErrors             // report all errors (not just the first 10 on different lines)
)

func ParseString() {

}

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
				Name:  new(Ident),
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
	comments    []*Comment
	leadComment *Comment // last lead comment
	lineComment *Comment // last line comment

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
	//pkgScope   *Scope        // pkgScope.Outer == nil
	//topScope   *Scope        // top-most scope; may be pkgScope
	unresolved []*Ident      // unresolved identifiers
	imports    []*ImportSpec // list of imports

	// Label scopes
	// (maintained by open/close LabelScope)
	//labelScope  *Scope     // label scope for current function
	targetStack [][]*Ident // stack of unresolved labels
}

func (p *parser) init(fset *FileSet, filename string, src []byte, scanComments bool, flags []string) {
	p.file = fset.AddFile(filename, -1, len(src))
	eh := func(pos Position, msg string) { p.errors.Add(pos, msg) }
	p.scanner.Init(p.file, src, eh, scanComments, flags)
	p.next()
}

/*
// ----------------------------------------------------------------------------
// Scoping support

func (p *parser) openScope() {
	p.topScope = NewScope(p.topScope)
}

func (p *parser) closeScope() {
	p.topScope = p.topScope.Outer
}

func (p *parser) openLabelScope() {
	p.labelScope = NewScope(p.labelScope)
	p.targetStack = append(p.targetStack, nil)
}

func (p *parser) closeLabelScope() {
	// resolve labels
	n := len(p.targetStack) - 1
	scope := p.labelScope
	for _, ident := range p.targetStack[n] {
		ident.Obj = scope.Lookup(ident.Name)
		if ident.Obj == nil && p.mode&DeclarationErrors != 0 {
			p.error(ident.Pos(), fmt.Sprintf("label %s undefined", ident.Name))
		}
	}
	// pop label scope
	p.targetStack = p.targetStack[0:n]
	p.labelScope = p.labelScope.Outer
}

func (p *parser) declare(decl, data interface{}, scope *Scope, kind ObjKind, idents ...*Ident) {
	for _, ident := range idents {
		assert(ident.Obj == nil, "identifier already declared or resolved")
		obj := NewObj(kind, ident.Name)
		// remember the corresponding declaration for redeclaration
		// errors and global variable resolution/typechecking phase
		obj.Decl = decl
		obj.Data = data
		ident.Obj = obj
		if ident.Name != "_" {
			if alt := scope.Insert(obj); alt != nil && p.mode&DeclarationErrors != 0 {
				prevDecl := ""
				if pos := alt.Pos(); pos.IsValid() {
					prevDecl = fmt.Sprintf("\n\tprevious declaration at %s", p.file.Position(pos))
				}
				p.error(ident.Pos(), fmt.Sprintf("%s redeclared in this block%s", ident.Name, prevDecl))
			}
		}
	}
}

func (p *parser) shortVarDecl(decl *AssignStmt, list []Expr) {
	// Go spec: A short variable declaration may redeclare variables
	// provided they were originally declared in the same block with
	// the same type, and at least one of the non-blank variables is new.
	n := 0 // number of new variables
	for _, x := range list {
		if ident, isIdent := x.(*Ident); isIdent {
			assert(ident.Obj == nil, "identifier already declared or resolved")
			obj := NewObj(Var, ident.Name)
			// remember corresponding assignment for other tools
			obj.Decl = decl
			ident.Obj = obj
			if ident.Name != "_" {
				if alt := p.topScope.Insert(obj); alt != nil {
					ident.Obj = alt // redeclaration
				} else {
					n++ // new declaration
				}
			}
		} else {
			p.errorExpected(x.Pos(), "identifier on left side of :=")
		}
	}
	if n == 0 && p.mode&DeclarationErrors != 0 {
		p.error(list[0].Pos(), "no new variables on left side of :=")
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
		if obj := s.Lookup(ident.Name); obj != nil {
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
*/
// ----------------------------------------------------------------------------
// Parsing support

// Consume a comment and return it and the line on which it ends.
/* TO-DO
func (p *parser) consumeComment() (comment *Comment, endline int) {
	// /*-style comments may end on a different line than where they start.
	// Scan the comment for '\n' chars and adjust endline accordingly.
	endline = p.file.Line(p.pos)
	if p.lit[1] == '*' {
		// don't use range here - no need to decode Unicode code points
		for i := 0; i < len(p.lit); i++ {
			if p.lit[i] == '\n' {
				endline++
			}
		}
	}

	comment = &Comment{Slash: p.pos, Text: p.lit}
	p.pos, p.tok, p.lit = p.scanner.Scan()

	return
}

// Consume a group of adjacent comments, add it to the parser's
// comments list, and return it together with the line at which
// the last comment in the group ends. A non-comment token or n
// empty lines terminate a comment group.
//  TO-DO
func (p *parser) consumeCommentGroup(n int) (comments *CommentGroup, endline int) {
	var list []*Comment
	endline = p.file.Line(p.pos)
	for p.tok == COMMENT && p.file.Line(p.pos) <= endline+n {
		var comment *Comment
		comment, endline = p.consumeComment()
		list = append(list, comment)
	}

	// add comment group to the comments list
	comments = &CommentGroup{List: list}
	p.comments = append(p.comments, comments)

	return
}
*/

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
//
// Lead and line comments may be considered documentation that is
// stored in the
//
func (p *parser) next() {
	p.leadComment = nil
	p.lineComment = nil

	p.pos, p.tok, p.lit = p.scanner.Scan()
	//TO-DO scan comment for doc later
	/*
		if p.tok == COMMENT {
			prev := p.pos
			var comment *Comment
			var endline int

			if p.file.Line(p.pos) == p.file.Line(prev) {
				// The comment is on same line as the previous token; it
				// cannot be a lead comment but may be a line comment.
				comment, endline = p.consumeCommentGroup(0)
				if p.file.Line(p.pos) != endline || p.tok == EOF {
					// The next token is on a different line, thus
					// the last comment group is a line comment.
					p.lineComment = comment
				}
			}

			// consume successor comments, if any
			endline = -1
			for p.tok == COMMENT {
				comment, endline = p.consumeCommentGroup(1)
			}

			if endline+1 == p.file.Line(p.pos) {
				// The next token is following on the line immediately after the
				// comment group, thus the last comment group is a lead comment.
				p.leadComment = comment
			}
		}*/
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

func (p *parser) expectSemi() {
	// semicolon is optional before a closing ')' or '}'
	if p.tok != RightParen && p.tok != RightBrace {
		switch p.tok {
		case Comma:
			// permit a ',' instead of a ';' but complain
			p.errorExpected(p.pos, "';'")
			fallthrough
		case Semi:
			p.next()
		default:
			p.errorExpected(p.pos, "';'")
			p.advance(stmtStart)
		}
	}
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
/*
func (p *parser) safePos(pos Pos) (res Pos) {
	defer func() {
		if recover() != nil {
			res = Pos(p.file.Base() + p.file.Size()) // EOF position
		}
	}()
	_ = p.file.Offset(pos) // trigger a panic if position is out-of-range
	return pos
}*/

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

// ----------------------------------------------------------------------------
// Namespace
// If the result is an identifier, it is not resolved.
func (p *parser) parseNamespace() Expr {
	if p.trace {
		defer un(trace(p, "TypeName"))
	}

	ident := p.parseIdent()
	// don't resolve ident yet - it may be a parameter or field name

	if p.tok == PERIOD {
		// ident is a package name
		p.next()
		p.resolve(ident)
		sel := p.parseIdent()
		return &SelectorExpr{X: ident, Sel: sel}
	}

	return ident
}

/*
// ----------------------------------------------------------------------------
// Common productions

// If lhs is set, result list elements which are identifiers are not resolved.
func (p *parser) parseExprList(lhs bool) (list []Expr) {
	if p.trace {
		defer un(trace(p, "ExpressionList"))
	}

	list = append(list, p.checkExpr(p.parseExpr(lhs)))
	for p.tok == COMMA {
		p.next()
		list = append(list, p.checkExpr(p.parseExpr(lhs)))
	}

	return
}

func (p *parser) parseLhsList() []Expr {
	old := p.inRhs
	p.inRhs = false
	list := p.parseExprList(true)
	switch p.tok {
	case DEFINE:
		// lhs of a short variable declaration
		// but doesn't enter scope until later:
		// caller must call p.shortVarDecl(p.makeIdentList(list))
		// at appropriate time.
	case COLON:
		// lhs of a label declaration or a communication clause of a select
		// statement (parseLhsList is not called when parsing the case clause
		// of a switch statement):
		// - labels are declared by the caller of parseLhsList
		// - for communication clauses, if there is a stand-alone identifier
		//   followed by a colon, we have a syntax error; there is no need
		//   to resolve the identifier in that case
	default:
		// identifiers must be declared elsewhere
		for _, x := range list {
			p.resolve(x)
		}
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
	if p.trace {
		defer un(trace(p, "Type"))
	}

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
	if p.trace {
		defer un(trace(p, "TypeName"))
	}

	ident := p.parseIdent()
	// don't resolve ident yet - it may be a parameter or field name

	if p.tok == PERIOD {
		// ident is a package name
		p.next()
		p.resolve(ident)
		sel := p.parseIdent()
		return &SelectorExpr{X: ident, Sel: sel}
	}

	return ident
}

func (p *parser) parseArrayType() Expr {
	if p.trace {
		defer un(trace(p, "ArrayType"))
	}

	lbrack := p.expect(LBRACK)
	p.exprLev++
	var len Expr
	// always permit ellipsis for more fault-tolerant parsing
	if p.tok == ELLIPSIS {
		len = &Ellipsis{Ellipsis: p.pos}
		p.next()
	} else if p.tok != RBRACK {
		len = p.parseRhs()
	}
	p.exprLev--
	p.expect(RBRACK)
	elt := p.parseType()

	return &ArrayType{Lbrack: lbrack, Len: len, Elt: elt}
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
	if p.trace {
		defer un(trace(p, "FieldDecl"))
	}

	doc := p.leadComment

	// 1st FieldDecl
	// A type name used as an anonymous field looks like a field identifier.
	var list []Expr
	for {
		list = append(list, p.parseVarType(false))
		if p.tok != COMMA {
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
		} else if !isTypeName(deref(typ)) {
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

	p.expectSemi() // call before accessing p.linecomment

	field := &Field{Doc: doc, Names: idents, Type: typ, Tag: tag, Comment: p.lineComment}
	p.declare(field, nil, scope, Var, idents...)
	p.resolve(typ)

	return field
}

func (p *parser) parseStructType() *StructType {
	if p.trace {
		defer un(trace(p, "StructType"))
	}

	pos := p.expect(STRUCT)
	lbrace := p.expect(LBRACE)
	scope := NewScope(nil) // struct scope
	var list []*Field
	for p.tok == IDENT || p.tok == MUL || p.tok == LPAREN {
		// a field declaration cannot start with a '(' but we accept
		// it here for more robust parsing and better error messages
		// (parseFieldDecl will check and complain if necessary)
		list = append(list, p.parseFieldDecl(scope))
	}
	rbrace := p.expect(RBRACE)

	return &StructType{
		Struct: pos,
		Fields: &FieldList{
			Opening: lbrace,
			List:    list,
			Closing: rbrace,
		},
	}
}

func (p *parser) parsePointerType() *StarExpr {
	if p.trace {
		defer un(trace(p, "PointerType"))
	}

	star := p.expect(MUL)
	base := p.parseType()

	return &StarExpr{Star: star, X: base}
}

// If the result is an identifier, it is not resolved.
func (p *parser) tryVarType(isParam bool) Expr {
	if isParam && p.tok == ELLIPSIS {
		pos := p.pos
		p.next()
		typ := p.tryIdentOrType() // don't use parseType so we can provide better error message
		if typ != nil {
			p.resolve(typ)
		} else {
			p.error(pos, "'...' parameter is missing type")
			typ = &BadExpr{From: pos, To: p.pos}
		}
		return &Ellipsis{Ellipsis: pos, Elt: typ}
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
	if p.trace {
		defer un(trace(p, "ParameterList"))
	}

	// 1st ParameterDecl
	// A list of identifiers looks like a list of type names.
	var list []Expr
	for {
		list = append(list, p.parseVarType(ellipsisOk))
		if p.tok != COMMA {
			break
		}
		p.next()
		if p.tok == RPAREN {
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
		p.declare(field, nil, scope, Var, idents...)
		p.resolve(typ)
		if !p.atComma("parameter list", RPAREN) {
			return
		}
		p.next()
		for p.tok != RPAREN && p.tok != EOF {
			idents := p.parseIdentList()
			typ := p.parseVarType(ellipsisOk)
			field := &Field{Names: idents, Type: typ}
			params = append(params, field)
			// Go spec: The scope of an identifier denoting a function
			// parameter or result variable is the function body.
			p.declare(field, nil, scope, Var, idents...)
			p.resolve(typ)
			if !p.atComma("parameter list", RPAREN) {
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
	if p.trace {
		defer un(trace(p, "Parameters"))
	}

	var params []*Field
	lparen := p.expect(LPAREN)
	if p.tok != RPAREN {
		params = p.parseParameterList(scope, ellipsisOk)
	}
	rparen := p.expect(RPAREN)

	return &FieldList{Opening: lparen, List: params, Closing: rparen}
}

func (p *parser) parseResult(scope *Scope) *FieldList {
	if p.trace {
		defer un(trace(p, "Result"))
	}

	if p.tok == LPAREN {
		return p.parseParameters(scope, false)
	}

	typ := p.tryType()
	if typ != nil {
		list := make([]*Field, 1)
		list[0] = &Field{Type: typ}
		return &FieldList{List: list}
	}

	return nil
}

func (p *parser) parseSignature(scope *Scope) (params, results *FieldList) {
	if p.trace {
		defer un(trace(p, "Signature"))
	}

	params = p.parseParameters(scope, true)
	results = p.parseResult(scope)

	return
}

func (p *parser) parseFuncType() (*FuncType, *Scope) {
	if p.trace {
		defer un(trace(p, "FuncType"))
	}

	pos := p.expect(FUNC)
	scope := NewScope(p.topScope) // function scope
	params, results := p.parseSignature(scope)

	return &FuncType{Func: pos, Params: params, Results: results}, scope
}

func (p *parser) parseMethodSpec(scope *Scope) *Field {
	if p.trace {
		defer un(trace(p, "MethodSpec"))
	}

	doc := p.leadComment
	var idents []*Ident
	var typ Expr
	x := p.parseTypeName()
	if ident, isIdent := x.(*Ident); isIdent && p.tok == LPAREN {
		// method
		idents = []*Ident{ident}
		scope := NewScope(nil) // method scope
		params, results := p.parseSignature(scope)
		typ = &FuncType{Func: NoPos, Params: params, Results: results}
	} else {
		// embedded interface
		typ = x
		p.resolve(typ)
	}
	p.expectSemi() // call before accessing p.linecomment

	spec := &Field{Doc: doc, Names: idents, Type: typ, Comment: p.lineComment}
	p.declare(spec, nil, scope, Fun, idents...)

	return spec
}

func (p *parser) parseInterfaceType() *InterfaceType {
	if p.trace {
		defer un(trace(p, "InterfaceType"))
	}

	pos := p.expect(INTERFACE)
	lbrace := p.expect(LBRACE)
	scope := NewScope(nil) // interface scope
	var list []*Field
	for p.tok == IDENT {
		list = append(list, p.parseMethodSpec(scope))
	}
	rbrace := p.expect(RBRACE)

	return &InterfaceType{
		Interface: pos,
		Methods: &FieldList{
			Opening: lbrace,
			List:    list,
			Closing: rbrace,
		},
	}
}

func (p *parser) parseMapType() *MapType {
	if p.trace {
		defer un(trace(p, "MapType"))
	}

	pos := p.expect(MAP)
	p.expect(LBRACK)
	key := p.parseType()
	p.expect(RBRACK)
	value := p.parseType()

	return &MapType{Map: pos, Key: key, Value: value}
}

func (p *parser) parseChanType() *ChanType {
	if p.trace {
		defer un(trace(p, "ChanType"))
	}

	pos := p.pos
	dir := SEND | RECV
	var arrow Pos
	if p.tok == CHAN {
		p.next()
		if p.tok == ARROW {
			arrow = p.pos
			p.next()
			dir = SEND
		}
	} else {
		arrow = p.expect(ARROW)
		p.expect(CHAN)
		dir = RECV
	}
	value := p.parseType()

	return &ChanType{Begin: pos, Arrow: arrow, Dir: dir, Value: value}
}

// If the result is an identifier, it is not resolved.
func (p *parser) tryIdentOrType() Expr {
	switch p.tok {
	case IDENT:
		return p.parseTypeName()
	case LBRACK:
		return p.parseArrayType()
	case STRUCT:
		return p.parseStructType()
	case MUL:
		return p.parsePointerType()
	case FUNC:
		typ, _ := p.parseFuncType()
		return typ
	case INTERFACE:
		return p.parseInterfaceType()
	case MAP:
		return p.parseMapType()
	case CHAN, ARROW:
		return p.parseChanType()
	case LPAREN:
		lparen := p.pos
		p.next()
		typ := p.parseType()
		rparen := p.expect(RPAREN)
		return &ParenExpr{Lparen: lparen, X: typ, Rparen: rparen}
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
	if p.trace {
		defer un(trace(p, "StatementList"))
	}

	for p.tok != CASE && p.tok != DEFAULT && p.tok != RBRACE && p.tok != EOF {
		list = append(list, p.parseStmt())
	}

	return
}

func (p *parser) parseBody(scope *Scope) *BlockStmt {
	if p.trace {
		defer un(trace(p, "Body"))
	}

	lbrace := p.expect(LBRACE)
	p.topScope = scope // open function scope
	p.openLabelScope()
	list := p.parseStmtList()
	p.closeLabelScope()
	p.closeScope()
	rbrace := p.expect(RBRACE)

	return &BlockStmt{Lbrace: lbrace, List: list, Rbrace: rbrace}
}

func (p *parser) parseBlockStmt() *BlockStmt {
	if p.trace {
		defer un(trace(p, "BlockStmt"))
	}

	lbrace := p.expect(LBRACE)
	p.openScope()
	list := p.parseStmtList()
	p.closeScope()
	rbrace := p.expect(RBRACE)

	return &BlockStmt{Lbrace: lbrace, List: list, Rbrace: rbrace}
}

// ----------------------------------------------------------------------------
// Expressions

func (p *parser) parseFuncTypeOrLit() Expr {
	if p.trace {
		defer un(trace(p, "FuncTypeOrLit"))
	}

	typ, scope := p.parseFuncType()
	if p.tok != LBRACE {
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
	if p.trace {
		defer un(trace(p, "Operand"))
	}

	switch p.tok {
	case IDENT:
		x := p.parseIdent()
		if !lhs {
			p.resolve(x)
		}
		return x

	case INT, FLOAT, IMAG, CHAR, STRING:
		x := &BasicLit{ValuePos: p.pos, Kind: p.tok, Value: p.lit}
		p.next()
		return x

	case LPAREN:
		lparen := p.pos
		p.next()
		p.exprLev++
		x := p.parseRhsOrType() // types may be parenthesized: (some type)
		p.exprLev--
		rparen := p.expect(RPAREN)
		return &ParenExpr{Lparen: lparen, X: x, Rparen: rparen}

	case FUNC:
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
	if p.trace {
		defer un(trace(p, "Selector"))
	}

	sel := p.parseIdent()

	return &SelectorExpr{X: x, Sel: sel}
}

func (p *parser) parseIndexOrSlice(x Expr) Expr {
	if p.trace {
		defer un(trace(p, "IndexOrSlice"))
	}

	const N = 3 // change the 3 to 2 to disable 3-index slices
	lbrack := p.expect(LBRACK)
	p.exprLev++
	var index [N]Expr
	var colons [N - 1]Pos
	if p.tok != COLON {
		index[0] = p.parseRhs()
	}
	ncolons := 0
	for p.tok == COLON && ncolons < len(colons) {
		colons[ncolons] = p.pos
		ncolons++
		p.next()
		if p.tok != COLON && p.tok != RBRACK && p.tok != EOF {
			index[ncolons] = p.parseRhs()
		}
	}
	p.exprLev--
	rbrack := p.expect(RBRACK)

	if ncolons > 0 {
		// slice expression
		slice3 := false
		if ncolons == 2 {
			slice3 = true
			// Check presence of 2nd and 3rd index here rather than during type-checking
			// to prevent erroneous programs from passing through gofmt (was issue 7305).
			if index[1] == nil {
				p.error(colons[0], "2nd index required in 3-index slice")
				index[1] = &BadExpr{From: colons[0] + 1, To: colons[1]}
			}
			if index[2] == nil {
				p.error(colons[1], "3rd index required in 3-index slice")
				index[2] = &BadExpr{From: colons[1] + 1, To: rbrack}
			}
		}
		return &SliceExpr{X: x, Lbrack: lbrack, Low: index[0], High: index[1], Max: index[2], Slice3: slice3, Rbrack: rbrack}
	}

	return &IndexExpr{X: x, Lbrack: lbrack, Index: index[0], Rbrack: rbrack}
}

func (p *parser) parseCallOrConversion(fun Expr) *CallExpr {
	if p.trace {
		defer un(trace(p, "CallOrConversion"))
	}

	lparen := p.expect(LPAREN)
	p.exprLev++
	var list []Expr
	var ellipsis Pos
	for p.tok != RPAREN && p.tok != EOF && !ellipsis.IsValid() {
		list = append(list, p.parseRhsOrType()) // builtins may expect a type: make(some type, ...)
		if p.tok == ELLIPSIS {
			ellipsis = p.pos
			p.next()
		}
		if !p.atComma("argument list", RPAREN) {
			break
		}
		p.next()
	}
	p.exprLev--
	rparen := p.expectClosing(RPAREN, "argument list")

	return &CallExpr{Fun: fun, Lparen: lparen, Args: list, Ellipsis: ellipsis, Rparen: rparen}
}

func (p *parser) parseValue(keyOk bool) Expr {
	if p.trace {
		defer un(trace(p, "Element"))
	}

	if p.tok == LBRACE {
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
		if p.tok == COLON {
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
	if p.trace {
		defer un(trace(p, "Element"))
	}

	x := p.parseValue(true)
	if p.tok == COLON {
		colon := p.pos
		p.next()
		x = &KeyValueExpr{Key: x, Colon: colon, Value: p.parseValue(false)}
	}

	return x
}

func (p *parser) parseElementList() (list []Expr) {
	if p.trace {
		defer un(trace(p, "ElementList"))
	}

	for p.tok != RBRACE && p.tok != EOF {
		list = append(list, p.parseElement())
		if !p.atComma("composite literal", RBRACE) {
			break
		}
		p.next()
	}

	return
}

func (p *parser) parseLiteralValue(typ Expr) Expr {
	if p.trace {
		defer un(trace(p, "LiteralValue"))
	}

	lbrace := p.expect(LBRACE)
	var elts []Expr
	p.exprLev++
	if p.tok != RBRACE {
		elts = p.parseElementList()
	}
	p.exprLev--
	rbrace := p.expectClosing(RBRACE, "composite literal")
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
	case *SliceExpr:
	case *TypeAssertExpr:
		// If t.Type == nil we have a type assertion of the form
		// y.(type), which is only allowed in type switch expressions.
		// It's hard to exclude those but for the case where we are in
		// a type switch. Instead be lenient and test this in the type
		// checker.
	case *CallExpr:
	case *StarExpr:
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
	case *ArrayType:
	case *StructType:
	case *MapType:
	default:
		return false // all other nodes are not legal composite literal types
	}
	return true
}

// If x is of the form *T, deref returns T, otherwise it returns x.
func deref(x Expr) Expr {
	if p, isPtr := x.(*StarExpr); isPtr {
		x = p.X
	}
	return x
}

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
	switch t := unparen(x).(type) {
	case *ParenExpr:
		panic("unreachable")
	case *UnaryExpr:
	case *ArrayType:
		if len, isEllipsis := t.Len.(*Ellipsis); isEllipsis {
			p.error(len.Pos(), "expected array length, found '...'")
			x = &BadExpr{From: x.Pos(), To: p.safePos(x.End())}
		}
	}

	// all other nodes are expressions or types
	return x
}

// If lhs is set and the result is an identifier, it is not resolved.
func (p *parser) parsePrimaryExpr(lhs bool) Expr {
	if p.trace {
		defer un(trace(p, "PrimaryExpr"))
	}

	x := p.parseOperand(lhs)
L:
	for {
		switch p.tok {
		case PERIOD:
			p.next()
			if lhs {
				p.resolve(x)
			}
			switch p.tok {
			case IDENT:
				x = p.parseSelector(p.checkExprOrType(x))
			case LPAREN:
				x = p.parseTypeAssertion(p.checkExpr(x))
			default:
				pos := p.pos
				p.errorExpected(pos, "selector or type assertion")
				p.next() // make progress
				sel := &Ident{NamePos: pos, Name: "_"}
				x = &SelectorExpr{X: x, Sel: sel}
			}
		case LBRACK:
			if lhs {
				p.resolve(x)
			}
			x = p.parseIndexOrSlice(p.checkExpr(x))
		case LPAREN:
			if lhs {
				p.resolve(x)
			}
			x = p.parseCallOrConversion(p.checkExprOrType(x))
		case LBRACE:
			if isLiteralType(x) && (p.exprLev >= 0 || !isTypeName(x)) {
				if lhs {
					p.resolve(x)
				}
				x = p.parseLiteralValue(x)
			} else {
				break L
			}
		default:
			break L
		}
		lhs = false // no need to try to resolve again
	}

	return x
}

// If lhs is set and the result is an identifier, it is not resolved.
func (p *parser) parseUnaryExpr(lhs bool) Expr {
	if p.trace {
		defer un(trace(p, "UnaryExpr"))
	}

	switch p.tok {
	case ADD, SUB, NOT, XOR, AND:
		pos, op := p.pos, p.tok
		p.next()
		x := p.parseUnaryExpr(false)
		return &UnaryExpr{OpPos: pos, Op: op, X: p.checkExpr(x)}

	case ARROW:
		// channel type or receive expression
		arrow := p.pos
		p.next()

		// If the next token is CHAN we still don't know if it
		// is a channel type or a receive operation - we only know
		// once we have found the end of the unary expression. There
		// are two cases:
		//
		//   <- type  => (<-type) must be channel type
		//   <- expr  => <-(expr) is a receive from an expression
		//
		// In the first case, the arrow must be re-associated with
		// the channel type parsed already:
		//
		//   <- (chan type)    =>  (<-chan type)
		//   <- (chan<- type)  =>  (<-chan (<-type))

		x := p.parseUnaryExpr(false)

		// determine which case we have
		if typ, ok := x.(*ChanType); ok {
			// (<-type)

			// re-associate position info and <-
			dir := SEND
			for ok && dir == SEND {
				if typ.Dir == RECV {
					// error: (<-type) is (<-(<-chan T))
					p.errorExpected(typ.Arrow, "'chan'")
				}
				arrow, typ.Begin, typ.Arrow = typ.Arrow, arrow, arrow
				dir, typ.Dir = typ.Dir, RECV
				typ, ok = typ.Value.(*ChanType)
			}
			if dir == SEND {
				p.errorExpected(arrow, "channel type")
			}

			return x
		}

		// <-(expr)
		return &UnaryExpr{OpPos: arrow, Op: ARROW, X: p.checkExpr(x)}

	case MUL:
		// pointer type or unary "*" expression
		pos := p.pos
		p.next()
		x := p.parseUnaryExpr(false)
		return &StarExpr{Star: pos, X: p.checkExprOrType(x)}
	}

	return p.parsePrimaryExpr(lhs)
}

func (p *parser) tokPrec() (Token, int) {
	tok := p.tok
	if p.inRhs && tok == ASSIGN {
		tok = EQL
	}
	return tok, tok.Precedence()
}

// If lhs is set and the result is an identifier, it is not resolved.
func (p *parser) parseBinaryExpr(lhs bool, prec1 int) Expr {
	if p.trace {
		defer un(trace(p, "BinaryExpr"))
	}

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
	if p.trace {
		defer un(trace(p, "Expression"))
	}

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
func (p *parser) parseSimpleStmt(mode int) (Stmt, bool) {
	if p.trace {
		defer un(trace(p, "SimpleStmt"))
	}

	x := p.parseLhsList()

	switch p.tok {
	case
		DEFINE, ASSIGN, ADD_ASSIGN,
		SUB_ASSIGN, MUL_ASSIGN, QUO_ASSIGN,
		REM_ASSIGN, AND_ASSIGN, OR_ASSIGN,
		XOR_ASSIGN, SHL_ASSIGN, SHR_ASSIGN, AND_NOT_ASSIGN:
		// assignment statement, possibly part of a range clause
		pos, tok := p.pos, p.tok
		p.next()
		var y []Expr
		isRange := false
		if mode == rangeOk && p.tok == RANGE && (tok == DEFINE || tok == ASSIGN) {
			pos := p.pos
			p.next()
			y = []Expr{&UnaryExpr{OpPos: pos, Op: RANGE, X: p.parseRhs()}}
			isRange = true
		} else {
			y = p.parseRhsList()
		}
		as := &AssignStmt{Lhs: x, TokPos: pos, Tok: tok, Rhs: y}
		if tok == DEFINE {
			p.shortVarDecl(as, x)
		}
		return as, isRange
	}

	if len(x) > 1 {
		p.errorExpected(x[0].Pos(), "1 expression")
		// continue with first expression
	}

	switch p.tok {
	case COLON:
		// labeled statement
		colon := p.pos
		p.next()
		if label, isIdent := x[0].(*Ident); mode == labelOk && isIdent {
			// Go spec: The scope of a label is the body of the function
			// in which it is declared and excludes the body of any nested
			// function.
			stmt := &LabeledStmt{Label: label, Colon: colon, Stmt: p.parseStmt()}
			p.declare(stmt, nil, p.labelScope, Lbl, label)
			return stmt, false
		}
		// The label declaration typically starts at x[0].Pos(), but the label
		// declaration may be erroneous due to a token after that position (and
		// before the ':'). If SpuriousErrors is not set, the (only) error
		// reported for the line is the illegal label error instead of the token
		// before the ':' that caused the problem. Thus, use the (latest) colon
		// position for error reporting.
		p.error(colon, "illegal label declaration")
		return &BadStmt{From: x[0].Pos(), To: colon + 1}, false

	case ARROW:
		// send statement
		arrow := p.pos
		p.next()
		y := p.parseRhs()
		return &SendStmt{Chan: x[0], Arrow: arrow, Value: y}, false

	case INC, DEC:
		// increment or decrement
		s := &IncDecStmt{X: x[0], TokPos: p.pos, Tok: p.tok}
		p.next()
		return s, false
	}

	// expression
	return &ExprStmt{X: x[0]}, false
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

func (p *parser) parseGoStmt() Stmt {
	if p.trace {
		defer un(trace(p, "GoStmt"))
	}

	pos := p.expect(GO)
	call := p.parseCallExpr("go")
	p.expectSemi()
	if call == nil {
		return &BadStmt{From: pos, To: pos + 2} // len("go")
	}

	return &GoStmt{Go: pos, Call: call}
}

func (p *parser) parseDeferStmt() Stmt {
	if p.trace {
		defer un(trace(p, "DeferStmt"))
	}

	pos := p.expect(DEFER)
	call := p.parseCallExpr("defer")
	p.expectSemi()
	if call == nil {
		return &BadStmt{From: pos, To: pos + 5} // len("defer")
	}

	return &DeferStmt{Defer: pos, Call: call}
}

func (p *parser) parseReturnStmt() *ReturnStmt {
	if p.trace {
		defer un(trace(p, "ReturnStmt"))
	}

	pos := p.pos
	p.expect(RETURN)
	var x []Expr
	if p.tok != SEMICOLON && p.tok != RBRACE {
		x = p.parseRhsList()
	}
	p.expectSemi()

	return &ReturnStmt{Return: pos, Results: x}
}

func (p *parser) parseBranchStmt(tok Token) *BranchStmt {
	if p.trace {
		defer un(trace(p, "BranchStmt"))
	}

	pos := p.expect(tok)
	var label *Ident
	if tok != FALLTHROUGH && p.tok == IDENT {
		label = p.parseIdent()
		// add to list of unresolved targets
		n := len(p.targetStack) - 1
		p.targetStack[n] = append(p.targetStack[n], label)
	}
	p.expectSemi()

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
	if p.tok == LBRACE {
		p.error(p.pos, "missing condition in if statement")
		cond = &BadExpr{From: p.pos, To: p.pos}
		return
	}
	// p.tok != LBRACE

	outer := p.exprLev
	p.exprLev = -1

	if p.tok != SEMICOLON {
		// accept potential variable declaration but complain
		if p.tok == VAR {
			p.next()
			p.error(p.pos, fmt.Sprintf("var declaration not allowed in 'IF' initializer"))
		}
		init, _ = p.parseSimpleStmt(basic)
	}

	var condStmt Stmt
	var semi struct {
		pos Pos
		lit string // ";" or "\n"; valid if pos.IsValid()
	}
	if p.tok != LBRACE {
		if p.tok == SEMICOLON {
			semi.pos = p.pos
			semi.lit = p.lit
			p.next()
		} else {
			p.expect(SEMICOLON)
		}
		if p.tok != LBRACE {
			condStmt, _ = p.parseSimpleStmt(basic)
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
	if p.trace {
		defer un(trace(p, "IfStmt"))
	}

	pos := p.expect(IF)
	p.openScope()
	defer p.closeScope()

	init, cond := p.parseIfHeader()
	body := p.parseBlockStmt()

	var else_ Stmt
	if p.tok == ELSE {
		p.next()
		switch p.tok {
		case IF:
			else_ = p.parseIfStmt()
		case LBRACE:
			else_ = p.parseBlockStmt()
			p.expectSemi()
		default:
			p.errorExpected(p.pos, "if statement or block")
			else_ = &BadStmt{From: p.pos, To: p.pos}
		}
	} else {
		p.expectSemi()
	}

	return &IfStmt{If: pos, Init: init, Cond: cond, Body: body, Else: else_}
}

func (p *parser) parseTypeList() (list []Expr) {
	if p.trace {
		defer un(trace(p, "TypeList"))
	}

	list = append(list, p.parseType())
	for p.tok == COMMA {
		p.next()
		list = append(list, p.parseType())
	}

	return
}

func (p *parser) parseCaseClause(typeSwitch bool) *CaseClause {
	if p.trace {
		defer un(trace(p, "CaseClause"))
	}

	pos := p.pos
	var list []Expr
	if p.tok == CASE {
		p.next()
		if typeSwitch {
			list = p.parseTypeList()
		} else {
			list = p.parseRhsList()
		}
	} else {
		p.expect(DEFAULT)
	}

	colon := p.expect(COLON)
	p.openScope()
	body := p.parseStmtList()
	p.closeScope()

	return &CaseClause{Case: pos, List: list, Colon: colon, Body: body}
}

func isTypeSwitchAssert(x Expr) bool {
	a, ok := x.(*TypeAssertExpr)
	return ok && a.Type == nil
}

func (p *parser) isTypeSwitchGuard(s Stmt) bool {
	switch t := s.(type) {
	case *ExprStmt:
		// x.(type)
		return isTypeSwitchAssert(t.X)
	case *AssignStmt:
		// v := x.(type)
		if len(t.Lhs) == 1 && len(t.Rhs) == 1 && isTypeSwitchAssert(t.Rhs[0]) {
			switch t.Tok {
			case ASSIGN:
				// permit v = x.(type) but complain
				p.error(t.TokPos, "expected ':=', found '='")
				fallthrough
			case DEFINE:
				return true
			}
		}
	}
	return false
}

func (p *parser) parseSwitchStmt() Stmt {
	if p.trace {
		defer un(trace(p, "SwitchStmt"))
	}

	pos := p.expect(SWITCH)
	p.openScope()
	defer p.closeScope()

	var s1, s2 Stmt
	if p.tok != LBRACE {
		prevLev := p.exprLev
		p.exprLev = -1
		if p.tok != SEMICOLON {
			s2, _ = p.parseSimpleStmt(basic)
		}
		if p.tok == SEMICOLON {
			p.next()
			s1 = s2
			s2 = nil
			if p.tok != LBRACE {
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
				s2, _ = p.parseSimpleStmt(basic)
			}
		}
		p.exprLev = prevLev
	}

	typeSwitch := p.isTypeSwitchGuard(s2)
	lbrace := p.expect(LBRACE)
	var list []Stmt
	for p.tok == CASE || p.tok == DEFAULT {
		list = append(list, p.parseCaseClause(typeSwitch))
	}
	rbrace := p.expect(RBRACE)
	p.expectSemi()
	body := &BlockStmt{Lbrace: lbrace, List: list, Rbrace: rbrace}

	if typeSwitch {
		return &TypeSwitchStmt{Switch: pos, Init: s1, Assign: s2, Body: body}
	}

	return &SwitchStmt{Switch: pos, Init: s1, Tag: p.makeExpr(s2, "switch expression"), Body: body}
}

func (p *parser) parseCommClause() *CommClause {
	if p.trace {
		defer un(trace(p, "CommClause"))
	}

	p.openScope()
	pos := p.pos
	var comm Stmt
	if p.tok == CASE {
		p.next()
		lhs := p.parseLhsList()
		if p.tok == ARROW {
			// SendStmt
			if len(lhs) > 1 {
				p.errorExpected(lhs[0].Pos(), "1 expression")
				// continue with first expression
			}
			arrow := p.pos
			p.next()
			rhs := p.parseRhs()
			comm = &SendStmt{Chan: lhs[0], Arrow: arrow, Value: rhs}
		} else {
			// RecvStmt
			if tok := p.tok; tok == ASSIGN || tok == DEFINE {
				// RecvStmt with assignment
				if len(lhs) > 2 {
					p.errorExpected(lhs[0].Pos(), "1 or 2 expressions")
					// continue with first two expressions
					lhs = lhs[0:2]
				}
				pos := p.pos
				p.next()
				rhs := p.parseRhs()
				as := &AssignStmt{Lhs: lhs, TokPos: pos, Tok: tok, Rhs: []Expr{rhs}}
				if tok == DEFINE {
					p.shortVarDecl(as, lhs)
				}
				comm = as
			} else {
				// lhs must be single receive operation
				if len(lhs) > 1 {
					p.errorExpected(lhs[0].Pos(), "1 expression")
					// continue with first expression
				}
				comm = &ExprStmt{X: lhs[0]}
			}
		}
	} else {
		p.expect(DEFAULT)
	}

	colon := p.expect(COLON)
	body := p.parseStmtList()
	p.closeScope()

	return &CommClause{Case: pos, Comm: comm, Colon: colon, Body: body}
}

func (p *parser) parseSelectStmt() *SelectStmt {
	if p.trace {
		defer un(trace(p, "SelectStmt"))
	}

	pos := p.expect(SELECT)
	lbrace := p.expect(LBRACE)
	var list []Stmt
	for p.tok == CASE || p.tok == DEFAULT {
		list = append(list, p.parseCommClause())
	}
	rbrace := p.expect(RBRACE)
	p.expectSemi()
	body := &BlockStmt{Lbrace: lbrace, List: list, Rbrace: rbrace}

	return &SelectStmt{Select: pos, Body: body}
}

func (p *parser) parseForStmt() Stmt {
	if p.trace {
		defer un(trace(p, "ForStmt"))
	}

	pos := p.expect(FOR)
	p.openScope()
	defer p.closeScope()

	var s1, s2, s3 Stmt
	var isRange bool
	if p.tok != LBRACE {
		prevLev := p.exprLev
		p.exprLev = -1
		if p.tok != SEMICOLON {
			if p.tok == RANGE {
				// "for range x" (nil lhs in assignment)
				pos := p.pos
				p.next()
				y := []Expr{&UnaryExpr{OpPos: pos, Op: RANGE, X: p.parseRhs()}}
				s2 = &AssignStmt{Rhs: y}
				isRange = true
			} else {
				s2, isRange = p.parseSimpleStmt(rangeOk)
			}
		}
		if !isRange && p.tok == SEMICOLON {
			p.next()
			s1 = s2
			s2 = nil
			if p.tok != SEMICOLON {
				s2, _ = p.parseSimpleStmt(basic)
			}
			p.expectSemi()
			if p.tok != LBRACE {
				s3, _ = p.parseSimpleStmt(basic)
			}
		}
		p.exprLev = prevLev
	}

	body := p.parseBlockStmt()
	p.expectSemi()

	if isRange {
		as := s2.(*AssignStmt)
		// check lhs
		var key, value Expr
		switch len(as.Lhs) {
		case 0:
			// nothing to do
		case 1:
			key = as.Lhs[0]
		case 2:
			key, value = as.Lhs[0], as.Lhs[1]
		default:
			p.errorExpected(as.Lhs[len(as.Lhs)-1].Pos(), "at most 2 expressions")
			return &BadStmt{From: pos, To: p.safePos(body.End())}
		}
		// parseSimpleStmt returned a right-hand side that
		// is a single unary expression of the form "range x"
		x := as.Rhs[0].(*UnaryExpr).X
		return &RangeStmt{
			For:    pos,
			Key:    key,
			Value:  value,
			TokPos: as.TokPos,
			Tok:    as.Tok,
			X:      x,
			Body:   body,
		}
	}

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
	if p.trace {
		defer un(trace(p, "Statement"))
	}

	switch p.tok {
	case CONST, TYPE, VAR:
		s = &DeclStmt{Decl: p.parseDecl(stmtStart)}
	case
		// tokens that may start an expression
		IDENT, INT, FLOAT, IMAG, CHAR, STRING, FUNC, LPAREN, // operands
		LBRACK, STRUCT, MAP, CHAN, INTERFACE, // composite types
		ADD, SUB, MUL, AND, XOR, ARROW, NOT: // unary operators
		s, _ = p.parseSimpleStmt(labelOk)
		// because of the required look-ahead, labeled statements are
		// parsed by parseSimpleStmt - don't expect a semicolon after
		// them
		if _, isLabeledStmt := s.(*LabeledStmt); !isLabeledStmt {
			p.expectSemi()
		}
	case GO:
		s = p.parseGoStmt()
	case DEFER:
		s = p.parseDeferStmt()
	case RETURN:
		s = p.parseReturnStmt()
	case BREAK, CONTINUE, GOTO, FALLTHROUGH:
		s = p.parseBranchStmt(p.tok)
	case LBRACE:
		s = p.parseBlockStmt()
		p.expectSemi()
	case IF:
		s = p.parseIfStmt()
	case SWITCH:
		s = p.parseSwitchStmt()
	case SELECT:
		s = p.parseSelectStmt()
	case FOR:
		s = p.parseForStmt()
	case SEMICOLON:
		// Is it ever possible to have an implicit semicolon
		// producing an empty statement in a valid program?
		// (handle correctly anyway)
		s = &EmptyStmt{Semicolon: p.pos, Implicit: p.lit == "\n"}
		p.next()
	case RBRACE:
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

type parseSpecFunction func(doc *CommentGroup, keyword Token, iota int) Spec

func isValidImport(lit string) bool {
	const illegalChars = `!"#$%&'()*,:;<=>?[\]^{|}` + "`\uFFFD"
	s, _ := strconv.Unquote(lit) // go/scanner returns a legal string literal
	for _, r := range s {
		if !unicode.IsGraphic(r) || unicode.IsSpace(r) || strings.ContainsRune(illegalChars, r) {
			return false
		}
	}
	return s != ""
}

func (p *parser) parseImportSpec(doc *CommentGroup, _ Token, _ int) Spec {
	if p.trace {
		defer un(trace(p, "ImportSpec"))
	}

	var ident *Ident
	switch p.tok {
	case PERIOD:
		ident = &Ident{NamePos: p.pos, Name: "."}
		p.next()
	case IDENT:
		ident = p.parseIdent()
	}

	pos := p.pos
	var path string
	if p.tok == STRING {
		path = p.lit
		if !isValidImport(path) {
			p.error(pos, "invalid import path: "+path)
		}
		p.next()
	} else {
		p.expect(STRING) // use expect() error handling
	}
	p.expectSemi() // call before accessing p.linecomment

	// collect imports
	spec := &ImportSpec{
		Doc:     doc,
		Name:    ident,
		Path:    &BasicLit{ValuePos: pos, Kind: STRING, Value: path},
		Comment: p.lineComment,
	}
	p.imports = append(p.imports, spec)

	return spec
}

func (p *parser) parseValueSpec(doc *CommentGroup, keyword Token, iota int) Spec {
	if p.trace {
		defer un(trace(p, keyword.String()+"Spec"))
	}

	pos := p.pos
	idents := p.parseIdentList()
	typ := p.tryType()
	var values []Expr
	// always permit optional initialization for more tolerant parsing
	if p.tok == ASSIGN {
		p.next()
		values = p.parseRhsList()
	}
	p.expectSemi() // call before accessing p.linecomment

	switch keyword {
	case VAR:
		if typ == nil && values == nil {
			p.error(pos, "missing variable type or initialization")
		}
	case CONST:
		if values == nil && (iota == 0 || typ != nil) {
			p.error(pos, "missing constant value")
		}
	}

	// Go spec: The scope of a constant or variable identifier declared inside
	// a function begins at the end of the ConstSpec or VarSpec and ends at
	// the end of the innermost containing block.
	// (Global identifiers are resolved in a separate phase after parsing.)
	spec := &ValueSpec{
		Doc:     doc,
		Names:   idents,
		Type:    typ,
		Values:  values,
		Comment: p.lineComment,
	}
	kind := Con
	if keyword == VAR {
		kind = Var
	}
	p.declare(spec, iota, p.topScope, kind, idents...)

	return spec
}

func (p *parser) parseTypeSpec(doc *CommentGroup, _ Token, _ int) Spec {
	if p.trace {
		defer un(trace(p, "TypeSpec"))
	}

	ident := p.parseIdent()

	// Go spec: The scope of a type identifier declared inside a function begins
	// at the identifier in the TypeSpec and ends at the end of the innermost
	// containing block.
	// (Global identifiers are resolved in a separate phase after parsing.)
	spec := &TypeSpec{Doc: doc, Name: ident}
	p.declare(spec, nil, p.topScope, Typ, ident)
	if p.tok == ASSIGN {
		spec.Assign = p.pos
		p.next()
	}
	spec.Type = p.parseType()
	p.expectSemi() // call before accessing p.linecomment
	spec.Comment = p.lineComment

	return spec
}

func (p *parser) parseGenDecl(keyword Token, f parseSpecFunction) *GenDecl {
	if p.trace {
		defer un(trace(p, "GenDecl("+keyword.String()+")"))
	}

	doc := p.leadComment
	pos := p.expect(keyword)
	var lparen, rparen Pos
	var list []Spec
	if p.tok == LPAREN {
		lparen = p.pos
		p.next()
		for iota := 0; p.tok != RPAREN && p.tok != EOF; iota++ {
			list = append(list, f(p.leadComment, keyword, iota))
		}
		rparen = p.expect(RPAREN)
		p.expectSemi()
	} else {
		list = append(list, f(nil, keyword, 0))
	}

	return &GenDecl{
		Doc:    doc,
		TokPos: pos,
		Tok:    keyword,
		Lparen: lparen,
		Specs:  list,
		Rparen: rparen,
	}
}

func (p *parser) parseFuncDecl() *FuncDecl {
	if p.trace {
		defer un(trace(p, "FunctionDecl"))
	}

	doc := p.leadComment
	pos := p.expect(FUNC)
	scope := NewScope(p.topScope) // function scope

	var recv *FieldList
	if p.tok == LPAREN {
		recv = p.parseParameters(scope, false)
	}

	ident := p.parseIdent()

	params, results := p.parseSignature(scope)

	var body *BlockStmt
	if p.tok == LBRACE {
		body = p.parseBody(scope)
	}
	p.expectSemi()

	decl := &FuncDecl{
		Doc:  doc,
		Recv: recv,
		Name: ident,
		Type: &FuncType{
			Func:    pos,
			Params:  params,
			Results: results,
		},
		Body: body,
	}
	if recv == nil {
		// Go spec: The scope of an identifier denoting a constant, type,
		// variable, or function (but not method) declared at top level
		// (outside any function) is the package block.
		//
		// init() functions cannot be referred to and there may
		// be more than one - don't put them in the pkgScope
		if ident.Name != "init" {
			p.declare(decl, nil, p.pkgScope, Fun, ident)
		}
	}

	return decl
}

func (p *parser) parseDecl(sync map[Token]bool) Decl {
	if p.trace {
		defer un(trace(p, "Declaration"))
	}

	var f parseSpecFunction
	switch p.tok {
	case CONST, VAR:
		f = p.parseValueSpec

	case TYPE:
		f = p.parseTypeSpec

	case FUNC:
		return p.parseFuncDecl()

	default:
		pos := p.pos
		p.errorExpected(pos, "declaration")
		p.advance(sync)
		return &BadDecl{From: pos, To: p.pos}
	}

	return p.parseGenDecl(p.tok, f)
}
*/
// ----------------------------------------------------------------------------
// Source files

func (p *parser) parseFile() *ProgramFile {
	// Don't bother parsing the rest if we had errors scanning the first
	// Likely not a Go source file at all.
	if p.errors.Len() != 0 {
		return nil
	}

	// package
	doc := p.leadComment
	pos := p.expect(Namespace)
	// The namespace clause is not a declaration;
	// the package name does not appear in any scope.
	ident := p.parseIdent()
	p.expectSemi()

	if p.errors.Len() != 0 {
		return nil
	}

	/*
		p.openScope()
		p.pkgScope = p.topScope
		var decls []Decl
		if p.mode&PackageClauseOnly == 0 {
			// import decls
			for p.tok == IMPORT {
				decls = append(decls, p.parseGenDecl(IMPORT, p.parseImportSpec))
			}

			if p.mode&ImportsOnly == 0 {
				// rest of package body
				for p.tok != EOF {
					decls = append(decls, p.parseDecl(declStart))
				}
			}
		}
		p.closeScope()
		assert(p.topScope == nil, "unbalanced scopes")
		assert(p.labelScope == nil, "unbalanced label scopes")

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

	return &ProgramFile{
		Doc:       doc,
		Namespace: pos,
		Name:      ident,
		//Decls:      decls,
		//Scope:      p.pkgScope,
		//Imports:    p.imports,
		//Unresolved: p.unresolved[0:i],
	}
}
