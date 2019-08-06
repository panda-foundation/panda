package compiler

import (
	"bytes"
	"fmt"
)

const (
	MetaDoc         = "doc"
	MetaEmit        = "emit"
	MetaSerialilzer = "serializer"
	MetaRef         = "ref"
	MetaCall        = "call"
	MetaReturn      = "return"
	MetaInclude     = "include"
	MetaMacro       = "macro"
	MetaMeta        = "meta"
)

var (
	// max indent
	indents = []byte("                    ")
)

func WriteIndent(buffer *bytes.Buffer, indent int) {
	if indent > len(indents) {
		for i := indent - len(indents); i > -1; i-- {
			indents = append(indents, byte(' '))
		}
	}
	buffer.Write(indents[:indent])
}

// All node types implement the Node interface.
type Node interface {
	Pos() Pos // position of first character belonging to the node
	End() Pos // position of first character immediately after the node
	Print(buffer *bytes.Buffer, indent int)
}

// All expression nodes implement the Expr interface.
type Expr interface {
	Node
	exprNode()
}

// All statement nodes implement the Stmt interface.
type Stmt interface {
	Node
	stmtNode()
}

// All declaration nodes implement the Decl interface.
type Decl interface {
	Node
	declNode()
	PrintDecl(buffer *bytes.Buffer, indent int)
}

// ----------------------------------------------------------------------------
// Meta

// A Metadata node represents a single //-style or /*-style comment.
type Metadata struct {
	StartPos Pos // position of "@" starting the comment
	EndPos   Pos
	Name     string
	Text     string
	Values   map[string]*BasicLit
}

func (meta *Metadata) Pos() Pos { return meta.StartPos }
func (meta *Metadata) End() Pos { return Pos(int(meta.StartPos) + len(meta.Text)) }

// ----------------------------------------------------------------------------
// Modifier

// A Modifier node represents public or static to var, function, class, enum
type Modifier struct {
	From   Pos
	To     Pos
	Public bool
	Static bool
	Weak   bool
}

func (modifier *Modifier) Pos() Pos { return modifier.From }
func (modifier *Modifier) End() Pos { return modifier.To }

// ----------------------------------------------------------------------------
// Expressions and types

// A Field represents a Field declaration list in a struct type
type Field struct {
	Names []*Ident  // field/method/parameter names; or nil
	Type  Expr      // field/method/parameter type
	Tag   *BasicLit // field tag; or nil
}

func (f *Field) Pos() Pos {
	if len(f.Names) > 0 {
		return f.Names[0].Pos()
	}
	return f.Type.Pos()
}

func (f *Field) End() Pos {
	if f.Tag != nil {
		return f.Tag.End()
	}
	return f.Type.End()
}

func (f *Field) Print(buffer *bytes.Buffer, indent int) {
	if f.Names != nil {
		for i, v := range f.Names {
			if i != 0 {
				buffer.WriteString(", ")
			}
			f.Type.Print(buffer, indent)
			buffer.WriteString(" ")
			v.Print(buffer, indent)
		}
	}
}

// A FieldList represents a list of Fields, enclosed by parentheses or braces.
type FieldList struct {
	Opening Pos      // position of opening parenthesis/brace, if any
	List    []*Field // field list; or nil
	Closing Pos      // position of closing parenthesis/brace, if any
}

func (f *FieldList) Pos() Pos {
	if f.Opening.IsValid() {
		return f.Opening
	}
	// the list should not be empty in this case;
	// be conservative and guard against bad ASTs
	if len(f.List) > 0 {
		return f.List[0].Pos()
	}
	return NoPos
}

func (f *FieldList) End() Pos {
	if f.Closing.IsValid() {
		return f.Closing + 1
	}
	// the list should not be empty in this case;
	// be conservative and guard against bad ASTs
	if n := len(f.List); n > 0 {
		return f.List[n-1].End()
	}
	return NoPos
}

func (f *FieldList) Print(buffer *bytes.Buffer, indent int) {
	for i, v := range f.List {
		if i != 0 {
			buffer.WriteString(", ")
		}
		v.Print(buffer, indent)
	}
}

// NumFields returns the number of parameters or struct fields represented by a FieldList.
func (f *FieldList) NumFields() int {
	n := 0
	if f != nil {
		for _, g := range f.List {
			m := len(g.Names)
			if m == 0 {
				m = 1
			}
			n += m
		}
	}
	return n
}

// An expression is represented by a tree consisting of one
// or more of the following concrete expression nodes.
//
type (
	// A BadExpr node is a placeholder for expressions containing
	// syntax errors for which no correct expression nodes can be
	// created.
	//
	BadExpr struct {
		From, To Pos // position range of bad expression
	}

	Scalar struct {
		From, To Pos
		Token    Token
	}

	// An Ident node represents an identifier.
	Ident struct {
		NamePos Pos     // identifier position
		Name    string  // identifier name
		Obj     *Object // denoted object; or nil
	}

	// An EllipsisLit node stands for the "..." type in a
	// parameter list or the "..." length in an array type.
	//
	EllipsisLit struct {
		Ellipsis Pos  // position of "..."
		Elt      Expr // ellipsis element type (parameter lists only); or nil
	}

	// A BasicLit node represents a literal of basic type.
	BasicLit struct {
		ValuePos Pos    // literal position
		Kind     Token  // INT, FLOAT, CHAR, or STRING
		Value    string // literal string; e.g. 42, 0x7f, 3.14, 1e-9, 2.4i, 'a', '\x7f', "foo" or `\m\n\o`
	}

	// A FuncLit node represents a function literal.
	FuncLit struct {
		Type *FuncType  // function type
		Body *BlockStmt // function body
	}

	// A CompositeLit node represents a composite literal.
	CompositeLit struct {
		Type       Expr   // literal type; or nil
		Lbrace     Pos    // position of "{"
		Elts       []Expr // list of composite elements; or nil
		Rbrace     Pos    // position of "}"
		Incomplete bool   // true if (source) expressions are missing in the Elts list
	}

	// A GenericLit node represents a literal of generic define.
	GenericLit struct {
		Less    Pos    // Pos position
		Types   []Expr // <int, int> <T>
		Greater Pos    // > position
	}

	// A ParenExpr node represents a parenthesized expression.
	ParenExpr struct {
		Lparen Pos  // position of "("
		X      Expr // parenthesized expression
		Rparen Pos  // position of ")"
	}

	// A SelectorExpr node represents an expression followed by a selector.
	SelectorExpr struct {
		X   Expr   // expression
		Sel *Ident // field selector
	}

	// An IndexExpr node represents an expression followed by an index.
	IndexExpr struct {
		X      Expr // expression
		Lbrack Pos  // position of "["
		Index  Expr // index expression
		Rbrack Pos  // position of "]"
	}

	// A CallExpr node represents an expression followed by an argument list.
	CallExpr struct {
		Fun      Expr   // function expression
		Lparen   Pos    // position of "("
		Args     []Expr // function arguments; or nil
		Ellipsis Pos    // position of "..." (NoPos if there is no "...")
		Rparen   Pos    // position of ")"
	}

	EmitExpr struct {
		Meta *Metadata
	}

	// A RefExpr node represents an expression of the form "*" Expression.
	// Semantically it could be a unary "*" expression, or a pointer type.
	//
	RefExpr struct {
		Ref Pos  // position of "&"
		X   Expr // operand
	}

	// A UnaryExpr node represents a unary expression.
	// Unary "*" expressions are represented via StarExpr nodes.
	//
	UnaryExpr struct {
		OpPos Pos   // position of Op
		Op    Token // operator
		X     Expr  // operand
	}

	// A BinaryExpr node represents a binary expression.
	BinaryExpr struct {
		X     Expr  // left operand
		OpPos Pos   // position of Op
		Op    Token // operator
		Y     Expr  // right operand
	}

	// A TernaryExpr node represents a ternary expression.
	// TO-DO impl
	TernaryExpr struct {
		X     Expr  // left operand
		OpPos Pos   // position of Op
		Op    Token // operator
		Y     Expr  // right operand
	}

	// A KeyValueExpr node represents (key : value) pairs
	// in composite literals.
	//
	KeyValueExpr struct {
		Key   Expr
		Colon Pos // position of ":"
		Value Expr
	}
)

// A type is represented by a tree consisting of one
// or more of the following type-specific expression
// nodes.
//
type (
	// A StructType node represents a struct type.
	StructType struct {
		Struct     Pos        // position of "struct" keyword
		Fields     *FieldList // list of field declarations
		Incomplete bool       // true if (source) fields are missing in the Fields list
	}

	// Reference types are represented via RefExpr nodes.

	// A FuncType node represents a function type.
	FuncType struct {
		Func   Pos        // position of "func" keyword (NoPos if there is no "func")
		Params *FieldList // (incoming) parameters; non-nil
		Result *Field     // (outgoing) results; or nil
	}

	// An InterfaceType node represents an interface type.
	InterfaceType struct {
		Interface  Pos        // position of "interface" keyword
		Methods    *FieldList // list of methods
		Incomplete bool       // true if (source) methods are missing in the Methods list
	}

	//TO-DO enum type, class type
)

// Pos and End implementations for expression/type nodes.

func (x *BadExpr) Pos() Pos     { return x.From }
func (x *Scalar) Pos() Pos      { return x.From }
func (x *Ident) Pos() Pos       { return x.NamePos }
func (x *EllipsisLit) Pos() Pos { return x.Ellipsis }
func (x *BasicLit) Pos() Pos    { return x.ValuePos }
func (x *FuncLit) Pos() Pos     { return x.Type.Pos() }
func (x *CompositeLit) Pos() Pos {
	if x.Type != nil {
		return x.Type.Pos()
	}
	return x.Lbrace
}
func (x *GenericLit) Pos() Pos   { return x.Less }
func (x *ParenExpr) Pos() Pos    { return x.Lparen }
func (x *SelectorExpr) Pos() Pos { return x.X.Pos() }
func (x *IndexExpr) Pos() Pos    { return x.X.Pos() }
func (x *CallExpr) Pos() Pos     { return x.Fun.Pos() }
func (x *EmitExpr) Pos() Pos     { return x.Meta.StartPos }
func (x *RefExpr) Pos() Pos      { return x.Ref }
func (x *UnaryExpr) Pos() Pos    { return x.OpPos }
func (x *BinaryExpr) Pos() Pos   { return x.X.Pos() }
func (x *KeyValueExpr) Pos() Pos { return x.Key.Pos() }
func (x *StructType) Pos() Pos   { return x.Struct }
func (x *FuncType) Pos() Pos {
	if x.Func.IsValid() || x.Params == nil { // see issue 3870
		return x.Func
	}
	return x.Params.Pos() // interface method declarations have no "func" keyword
}
func (x *InterfaceType) Pos() Pos { return x.Interface }

func (x *BadExpr) End() Pos { return x.To }
func (x *Scalar) End() Pos  { return x.To }
func (x *Ident) End() Pos   { return Pos(int(x.NamePos) + len(x.Name)) }
func (x *EllipsisLit) End() Pos {
	if x.Elt != nil {
		return x.Elt.End()
	}
	return x.Ellipsis + 3 // len("...")
}
func (x *BasicLit) End() Pos     { return Pos(int(x.ValuePos) + len(x.Value)) }
func (x *FuncLit) End() Pos      { return x.Body.End() }
func (x *CompositeLit) End() Pos { return x.Rbrace + 1 }
func (x *GenericLit) End() Pos   { return x.Greater }
func (x *ParenExpr) End() Pos    { return x.Rparen + 1 }
func (x *SelectorExpr) End() Pos { return x.Sel.End() }
func (x *IndexExpr) End() Pos    { return x.Rbrack + 1 }
func (x *CallExpr) End() Pos     { return x.Rparen + 1 }
func (x *EmitExpr) End() Pos     { return x.Meta.StartPos + x.Meta.EndPos }
func (x *RefExpr) End() Pos      { return x.X.End() }
func (x *UnaryExpr) End() Pos    { return x.X.End() }
func (x *BinaryExpr) End() Pos   { return x.Y.End() }
func (x *KeyValueExpr) End() Pos { return x.Value.End() }
func (x *StructType) End() Pos   { return x.Fields.End() }
func (x *FuncType) End() Pos {
	if x.Result != nil {
		return x.Result.End()
	}
	return x.Params.End()
}
func (x *InterfaceType) End() Pos { return x.Methods.End() }

// exprNode() ensures that only expression/type nodes can be
// assigned to an Expr.
//
func (*BadExpr) exprNode()      {}
func (*Scalar) exprNode()       {}
func (*Ident) exprNode()        {}
func (*EllipsisLit) exprNode()  {}
func (*BasicLit) exprNode()     {}
func (*FuncLit) exprNode()      {}
func (*CompositeLit) exprNode() {}
func (*ParenExpr) exprNode()    {}
func (*SelectorExpr) exprNode() {}
func (*IndexExpr) exprNode()    {}
func (*CallExpr) exprNode()     {}
func (*EmitExpr) exprNode()     {}
func (*UnaryExpr) exprNode()    {}
func (*BinaryExpr) exprNode()   {}
func (*KeyValueExpr) exprNode() {}

func (*StructType) exprNode()    {}
func (*FuncType) exprNode()      {}
func (*InterfaceType) exprNode() {}

func (x *BadExpr) Print(buffer *bytes.Buffer, indent int) {
	buffer.WriteString("//Bad expr declared")
}
func (x *Scalar) Print(buffer *bytes.Buffer, indent int) {
	x.Token.Print(buffer)
}
func (x *Ident) Print(buffer *bytes.Buffer, indent int) {
	buffer.WriteString(x.Name)
}

func (x *EllipsisLit) Print(buffer *bytes.Buffer, indent int) {
}

func (x *BasicLit) Print(buffer *bytes.Buffer, indent int) {
	switch x.Kind {
	case INT, FLOAT:
		buffer.WriteString(x.Value)
	case CHAR:
		//TO-DO convert to unicode char
		buffer.WriteString(x.Value)
	case STRING:
		buffer.WriteString(x.Value)
	case True, False, Void, Null:
		x.Kind.Print(buffer)
	default:
		//TO-DO panic to error
	}
}

func (x *FuncLit) Print(buffer *bytes.Buffer, indent int) {
}

func (x *CompositeLit) Print(buffer *bytes.Buffer, indent int) {
}

func (x *ParenExpr) Print(buffer *bytes.Buffer, indent int) {
}

func (x *SelectorExpr) Print(buffer *bytes.Buffer, indent int) {
}

func (x *IndexExpr) Print(buffer *bytes.Buffer, indent int) {
}

func (x *CallExpr) Print(buffer *bytes.Buffer, indent int) {
}

func (x *EmitExpr) Print(buffer *bytes.Buffer, indent int) {
	WriteIndent(buffer, indent)
	buffer.WriteString(x.Meta.Text)
}

func (x *RefExpr) Print(buffer *bytes.Buffer, indent int) {
}

func (x *UnaryExpr) Print(buffer *bytes.Buffer, indent int) {
}

func (x *BinaryExpr) Print(buffer *bytes.Buffer, indent int) {
}

func (x *KeyValueExpr) Print(buffer *bytes.Buffer, indent int) {
}

func (x *StructType) Print(buffer *bytes.Buffer, indent int) {
}

func (x *FuncType) Print(buffer *bytes.Buffer, indent int) {
}

func (x *InterfaceType) Print(buffer *bytes.Buffer, indent int) {
}

// ----------------------------------------------------------------------------
// Statements

// A statement is represented by a tree consisting of one
// or more of the following concrete statement nodes.
//
type (
	// A BadStmt node is a placeholder for statements containing
	// syntax errors for which no correct statement nodes can be
	// created.
	//
	BadStmt struct {
		From, To Pos // position range of bad statement
	}

	// A DeclStmt node represents a declaration in a statement list.
	DeclStmt struct {
		Decl Decl // *GenDecl with CONST, TYPE, or VAR token
	}

	// An EmptyStmt node represents an empty statement.
	// The "position" of the empty statement is the position
	// of the immediately following (explicit or implicit) semicolon.
	//
	EmptyStmt struct {
		Semicolon Pos  // position of following ";"
		Implicit  bool // if set, ";" was omitted in the source
	}

	// An ExprStmt node represents a (stand-alone) expression
	// in a statement list.
	//
	ExprStmt struct {
		X Expr // expression
	}

	// An IncDecStmt node represents an increment or decrement statement.
	IncDecStmt struct {
		X      Expr
		TokPos Pos   // position of Tok
		Tok    Token // INC or DEC
	}

	// An AssignStmt node represents an assignment or
	// a short variable declaration.
	//
	AssignStmt struct {
		Lhs    []Expr
		TokPos Pos   // position of Tok
		Tok    Token // assignment token, DEFINE
		Rhs    []Expr
	}

	// A ReturnStmt node represents a return statement.
	ReturnStmt struct {
		Return Pos  // position of "return" keyword
		Result Expr // result expressions; or nil
	}

	// A BranchStmt node represents a break, continue, goto,
	// or fallthrough statement.
	//
	BranchStmt struct {
		TokPos Pos    // position of Tok
		Tok    Token  // keyword token (BREAK, CONTINUE, GOTO, FALLTHROUGH)
		Label  *Ident // label name; or nil
	}

	// A BlockStmt node represents a braced statement list.
	BlockStmt struct {
		Lbrace Pos // position of "{"
		List   []Stmt
		Rbrace Pos // position of "}"
	}

	// An IfStmt node represents an if statement.
	IfStmt struct {
		If   Pos  // position of "if" keyword
		Init Stmt // initialization statement; or nil
		Cond Expr // condition
		Body *BlockStmt
		Else Stmt // else branch; or nil
	}

	// A CaseClause represents a case of an expression or type switch statement.
	CaseClause struct {
		Case  Pos    // position of "case" or "default" keyword
		List  []Expr // list of expressions or types; nil means default case
		Colon Pos    // position of ":"
		Body  []Stmt // statement list; or nil
	}

	// A SwitchStmt node represents an expression switch statement.
	SwitchStmt struct {
		Switch Pos        // position of "switch" keyword
		Init   Stmt       // initialization statement; or nil
		Tag    Expr       // tag expression; or nil
		Body   *BlockStmt // CaseClauses only
	}

	// A CommClause node represents a case of a select statement.
	CommClause struct {
		Case  Pos    // position of "case" or "default" keyword
		Comm  Stmt   // send or receive statement; nil means default case
		Colon Pos    // position of ":"
		Body  []Stmt // statement list; or nil
	}

	// An SelectStmt node represents a select statement.
	SelectStmt struct {
		Select Pos        // position of "select" keyword
		Body   *BlockStmt // CommClauses only
	}

	// A ForStmt represents a for statement.
	ForStmt struct {
		For  Pos  // position of "for" keyword
		Init Stmt // initialization statement; or nil
		Cond Expr // condition; or nil
		Post Stmt // post iteration statement; or nil
		Body *BlockStmt
	}
)

// Pos and End implementations for statement nodes.

func (s *BadStmt) Pos() Pos    { return s.From }
func (s *DeclStmt) Pos() Pos   { return s.Decl.Pos() }
func (s *EmptyStmt) Pos() Pos  { return s.Semicolon }
func (s *ExprStmt) Pos() Pos   { return s.X.Pos() }
func (s *IncDecStmt) Pos() Pos { return s.X.Pos() }
func (s *AssignStmt) Pos() Pos { return s.Lhs[0].Pos() }
func (s *ReturnStmt) Pos() Pos { return s.Return }
func (s *BranchStmt) Pos() Pos { return s.TokPos }
func (s *BlockStmt) Pos() Pos  { return s.Lbrace }
func (s *IfStmt) Pos() Pos     { return s.If }
func (s *CaseClause) Pos() Pos { return s.Case }
func (s *SwitchStmt) Pos() Pos { return s.Switch }
func (s *CommClause) Pos() Pos { return s.Case }
func (s *SelectStmt) Pos() Pos { return s.Select }
func (s *ForStmt) Pos() Pos    { return s.For }

func (s *BadStmt) End() Pos  { return s.To }
func (s *DeclStmt) End() Pos { return s.Decl.End() }
func (s *EmptyStmt) End() Pos {
	if s.Implicit {
		return s.Semicolon
	}
	return s.Semicolon + 1 /* len(";") */
}
func (s *ExprStmt) End() Pos { return s.X.End() }
func (s *IncDecStmt) End() Pos {
	return s.TokPos + 2 /* len("++") */
}
func (s *AssignStmt) End() Pos { return s.Rhs[len(s.Rhs)-1].End() }
func (s *ReturnStmt) End() Pos {
	if s.Result != nil {
		return s.Result.End()
	}
	return s.Return + 6 // len("return")
}
func (s *BranchStmt) End() Pos {
	if s.Label != nil {
		return s.Label.End()
	}
	return Pos(int(s.TokPos) + len(s.Tok.String()))
}
func (s *BlockStmt) End() Pos { return s.Rbrace + 1 }
func (s *IfStmt) End() Pos {
	if s.Else != nil {
		return s.Else.End()
	}
	return s.Body.End()
}
func (s *CaseClause) End() Pos {
	if n := len(s.Body); n > 0 {
		return s.Body[n-1].End()
	}
	return s.Colon + 1
}
func (s *SwitchStmt) End() Pos { return s.Body.End() }
func (s *CommClause) End() Pos {
	if n := len(s.Body); n > 0 {
		return s.Body[n-1].End()
	}
	return s.Colon + 1
}
func (s *SelectStmt) End() Pos { return s.Body.End() }
func (s *ForStmt) End() Pos    { return s.Body.End() }

// stmtNode() ensures that only statement nodes can be
// assigned to a Stmt.
//
func (*BadStmt) stmtNode()    {}
func (*DeclStmt) stmtNode()   {}
func (*EmptyStmt) stmtNode()  {}
func (*ExprStmt) stmtNode()   {}
func (*IncDecStmt) stmtNode() {}
func (*AssignStmt) stmtNode() {}
func (*ReturnStmt) stmtNode() {}
func (*BranchStmt) stmtNode() {}
func (*BlockStmt) stmtNode()  {}
func (*IfStmt) stmtNode()     {}
func (*CaseClause) stmtNode() {}
func (*SwitchStmt) stmtNode() {}
func (*CommClause) stmtNode() {}
func (*SelectStmt) stmtNode() {}
func (*ForStmt) stmtNode()    {}

func (s *BadStmt) Print(buffer *bytes.Buffer, indent int) {

}
func (s *DeclStmt) Print(buffer *bytes.Buffer, indent int) {

}
func (s *EmptyStmt) Print(buffer *bytes.Buffer, indent int) {

}
func (s *ExprStmt) Print(buffer *bytes.Buffer, indent int) {

}
func (s *IncDecStmt) Print(buffer *bytes.Buffer, indent int) {

}
func (s *AssignStmt) Print(buffer *bytes.Buffer, indent int) {

}
func (s *ReturnStmt) Print(buffer *bytes.Buffer, indent int) {

}
func (s *BranchStmt) Print(buffer *bytes.Buffer, indent int) {

}
func (s *BlockStmt) Print(buffer *bytes.Buffer, indent int) {

}
func (s *IfStmt) Print(buffer *bytes.Buffer, indent int) {

}
func (s *CaseClause) Print(buffer *bytes.Buffer, indent int) {

}
func (s *SwitchStmt) Print(buffer *bytes.Buffer, indent int) {

}
func (s *CommClause) Print(buffer *bytes.Buffer, indent int) {

}
func (s *SelectStmt) Print(buffer *bytes.Buffer, indent int) {

}
func (s *ForStmt) Print(buffer *bytes.Buffer, indent int) {

}

// ----------------------------------------------------------------------------
// Declarations
// A declaration is represented by one of the following declaration nodes.
//
type (
	// A BadDecl node is a placeholder for declarations containing
	// syntax errors for which no correct declaration nodes can be
	// created.
	//
	BadDecl struct {
		From, To Pos // position range of bad declaration
	}

	PackageDecl struct {
		Doc    *Metadata // associated documentation; or nil
		Path   *BasicLit // import path
		EndPos Pos       // end of spec (overrides Path.Pos if nonzero)
	}

	ImportDecl struct {
		Doc    *Metadata // associated documentation; or nil
		Name   *Ident    // local package name (including "."); or nil
		Path   *BasicLit // import path
		EndPos Pos       // end of spec (overrides Path.Pos if nonzero)
	}

	ValueDecl struct {
		Doc      *Metadata // associated documentation; or nil
		Modifier *Modifier
		Names    []*Ident // value names (len(Names) > 0)
		Type     Expr     // value type; or nil //TO-DO Generic *GenericLit
		Values   []Expr   // initial values; or nil
	}

	ClassDecl struct {
		Doc       *Metadata // associated documentation; or nil
		Modifier  *Modifier
		Parents   []*Expr
		Name      *Ident // type name
		Generic   *GenericLit
		Values    []*ValueDecl
		Functions []*FuncDecl
		EndPos    Pos
	}

	EnumDecl struct {
		Doc      *Metadata // associated documentation; or nil
		Modifier *Modifier
		Parent   Expr
		Name     *Ident // type name
		//TO-DO name, value pair
		EndPos Pos
	}

	InterfaceDecl struct {
		Doc       *Metadata // associated documentation; or nil
		Modifier  *Modifier
		Name      *Ident      // type name
		Functions []*FuncDecl // position of '=', if any
		EndPos    Pos
	}

	// A FuncDecl node represents a function declaration.
	FuncDecl struct {
		Doc     *Metadata  // associated documentation; or nil
		Name    *Ident     // function/method name
		Type    *FuncType  // function signature: parameters, results, and position of "func" keyword
		Body    *BlockStmt // function body; or nil for external (non-Go) function
		Generic *GenericLit
	}
)

func (d *BadDecl) Pos() Pos     { return d.From }
func (s *PackageDecl) Pos() Pos { return s.Path.Pos() }
func (s *ImportDecl) Pos() Pos {
	if s.Name != nil {
		return s.Name.Pos()
	}
	return s.Path.Pos()
}
func (s *ValueDecl) Pos() Pos     { return s.Names[0].Pos() }
func (d *FuncDecl) Pos() Pos      { return d.Type.Pos() }
func (c *ClassDecl) Pos() Pos     { return c.Name.Pos() }
func (c *EnumDecl) Pos() Pos      { return c.Name.Pos() }
func (c *InterfaceDecl) Pos() Pos { return c.Name.Pos() }

func (d *BadDecl) End() Pos { return d.To }
func (s *PackageDecl) End() Pos {
	if s.EndPos != 0 {
		return s.EndPos
	}
	return s.Path.End()
}
func (s *ImportDecl) End() Pos {
	if s.EndPos != 0 {
		return s.EndPos
	}
	return s.Path.End()
}
func (s *ValueDecl) End() Pos {
	if n := len(s.Values); n > 0 {
		return s.Values[n-1].End()
	}
	if s.Type != nil {
		return s.Type.End()
	}
	return s.Names[len(s.Names)-1].End()
}
func (d *FuncDecl) End() Pos {
	if d.Body != nil {
		return d.Body.End()
	}
	return d.Type.End()
}
func (c *ClassDecl) End() Pos     { return c.EndPos }
func (c *EnumDecl) End() Pos      { return c.EndPos }
func (c *InterfaceDecl) End() Pos { return c.EndPos }

// declNode() ensures that only declaration nodes can be
// assigned to a Decl.
//
func (*BadDecl) declNode()       {}
func (*ValueDecl) declNode()     {}
func (*FuncDecl) declNode()      {}
func (*ClassDecl) declNode()     {}
func (*EnumDecl) declNode()      {}
func (*InterfaceDecl) declNode() {}

func (*BadDecl) Print(buffer *bytes.Buffer, indent int) {

}
func (v *ValueDecl) Print(buffer *bytes.Buffer, indent int) {
	for i, n := range v.Names {
		v.Type.Print(buffer, indent)
		buffer.WriteString(" ")
		buffer.WriteString(n.Name)
		if len(v.Values) == len(v.Names) {
			buffer.WriteString(" = ")
			v.Values[i].Print(buffer, indent)
		}
		buffer.WriteString(";\n")
	}
}
func (*FuncDecl) Print(buffer *bytes.Buffer, indent int) {

}
func (*ClassDecl) Print(buffer *bytes.Buffer, indent int) {

}
func (*EnumDecl) Print(buffer *bytes.Buffer, indent int) {

}
func (*InterfaceDecl) Print(buffer *bytes.Buffer, indent int) {

}
func (*BadDecl) PrintDecl(buffer *bytes.Buffer, indent int) {

}
func (*ValueDecl) PrintDecl(buffer *bytes.Buffer, indent int) {

}
func (f *FuncDecl) PrintDecl(buffer *bytes.Buffer, indent int) {
	f.Type.Result.Type.Print(buffer, indent)
	buffer.WriteString(" ")
	f.Name.Print(buffer, indent)
	buffer.WriteString("(")
	f.Type.Params.Print(buffer, indent)
	buffer.WriteString(");\n")
}
func (*ClassDecl) PrintDecl(buffer *bytes.Buffer, indent int) {

}
func (*EnumDecl) PrintDecl(buffer *bytes.Buffer, indent int) {

}
func (*InterfaceDecl) PrintDecl(buffer *bytes.Buffer, indent int) {

}

// ----------------------------------------------------------------------------
// Files and packages
type ProgramFile struct {
	Scope      *Scope        // package scope (this file only)
	Package    *PackageDecl  // position of "namespace" keyword
	Imports    []*ImportDecl // imports in this file
	Values     []*ValueDecl
	Functions  []*FuncDecl
	Classes    []*ClassDecl
	Enums      []*EnumDecl
	Interfaces []*InterfaceDecl
	EndPos     Pos
	Unresolved []*Ident // unresolved identifiers in this file
}

func (f *ProgramFile) Pos() Pos { return f.Package.Pos() }
func (f *ProgramFile) End() Pos {
	return f.EndPos
}
func (f *ProgramFile) Print(buffer *bytes.Buffer, indent int) {
	for _, v := range f.Functions {
		v.PrintDecl(buffer, indent)
	}
	buffer.WriteString("\n")

	for _, v := range f.Values {
		v.Print(buffer, indent)
	}
	buffer.WriteString("\n")

	for _, v := range f.Functions {
		v.Print(buffer, indent)
	}
}

// A Package node represents a set of source files
// collectively building a Go package.
//
type ProgramPackage struct {
	Name    string                  // package name
	Scope   *Scope                  // package scope across all files
	Imports map[string]*Object      // map of package id -> package object
	Files   map[string]*ProgramFile // Go source files by filename
}

func (p *ProgramPackage) Pos() Pos { return NoPos }
func (p *ProgramPackage) End() Pos { return NoPos }

// A Scope maintains the set of named language entities declared
// in the scope and a link to the immediately surrounding (outer)
// scope.
//
type Scope struct {
	Outer   *Scope
	Objects map[string]*Object
}

// NewScope creates a new scope nested in the outer scope.
func NewScope(outer *Scope) *Scope {
	const n = 4 // initial scope capacity
	return &Scope{outer, make(map[string]*Object, n)}
}

// Find returns the object with the given name if it is
// found in scope s, otherwise it returns nil. Outer scopes
// are ignored.
//
func (s *Scope) Find(name string) *Object {
	return s.Objects[name]
}

// Insert attempts to insert a named object obj into the scope s.
// If the scope already contains an object alt with the same name,
// Insert leaves the scope unchanged and returns alt. Otherwise
// it inserts obj and returns nil.
//
func (s *Scope) Insert(obj *Object) (alt *Object) {
	if alt = s.Objects[obj.Name]; alt == nil {
		s.Objects[obj.Name] = obj
	}
	return
}

// Debugging support
func (s *Scope) String() string {
	var buf bytes.Buffer
	fmt.Fprintf(&buf, "scope %p {", s)
	if s != nil && len(s.Objects) > 0 {
		fmt.Fprintln(&buf)
		for _, obj := range s.Objects {
			fmt.Fprintf(&buf, "\t%s %s\n", obj.Kind, obj.Name)
		}
	}
	fmt.Fprintf(&buf, "}\n")
	return buf.String()
}

// ----------------------------------------------------------------------------
// Objects

// An Object describes a named language entity such as a package,
// constant, type, variable, function (incl. methods), or label.
//
type Object struct {
	Kind ObjKind
	Name string      // declared name
	Decl interface{} // corresponding Field, XxxSpec, FuncDecl, AssignStmt, Scope; or nil
	Type interface{} // placeholder for type information; may be nil
}

// NewObj creates a new object of a given kind and name.
func NewObj(kind ObjKind, name string) *Object {
	return &Object{Kind: kind, Name: name}
}

// Pos computes the source position of the declaration of an object name.
// The result may be an invalid position if it cannot be computed
// (obj.Decl may be nil or not correct).
func (obj *Object) Pos() Pos {
	name := obj.Name
	switch d := obj.Decl.(type) {
	case *Field:
		for _, n := range d.Names {
			if n.Name == name {
				return n.Pos()
			}
		}
	case *PackageDecl:
		return d.Path.Pos()
	case *ImportDecl:
		if d.Name != nil && d.Name.Name == name {
			return d.Name.Pos()
		}
		return d.Path.Pos()
	case *ValueDecl:
		for _, n := range d.Names {
			if n.Name == name {
				return n.Pos()
			}
		}
	//TO-DO class enum interface
	case *FuncDecl:
		if d.Name.Name == name {
			return d.Name.Pos()
		}
	case *AssignStmt:
		for _, x := range d.Lhs {
			if ident, isIdent := x.(*Ident); isIdent && ident.Name == name {
				return ident.Pos()
			}
		}
	case *Scope:
		// predeclared object - nothing to do for now
	}
	return NoPos
}

// ObjKind describes what an object represents.
type ObjKind int

// The list of possible Object kinds.
const (
	Bad         ObjKind = iota // for error handling
	ConstObj                   // constant
	VarObj                     // variable
	ClassObj                   // class
	EnumObj                    // enum
	FunctionObj                // function or method
)

var objKindStrings = [...]string{
	Bad:         "bad",
	ConstObj:    "const",
	VarObj:      "var",
	ClassObj:    "class",
	EnumObj:     "enum",
	FunctionObj: "function",
}

func (kind ObjKind) String() string { return objKindStrings[kind] }
