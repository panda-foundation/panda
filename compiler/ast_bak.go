package compiler

/*
// Flow control type
const (
	Break    = 0
	Continue = 1
	Return   = 2
)

// Data types for Panda lang
const (
	Bool    = 0
	Int8    = 1
	Int16   = 2
	Int32   = 3
	Int64   = 4
	Uint8   = 5
	Uint16  = 6
	Uint32  = 7
	Uint64  = 8
	Float32 = 9
	Float64 = 10
	String  = 11
	Int     = Int32
	Uint    = Uint32
	Float   = Float32
	Double  = Float64
	Byte    = Uint8
)

// Error define
const (
	ErrorInvalidChar         = 0
	ErrorUnexpected          = 1
	ErrorExpected            = 3
	ErrorInvalidAssignment   = 4
	ErrorUnterminatedString  = 5
	ErrorUnterminatedComment = 6
	ErrorUnknownVariable     = 7
	ErrorInvalidIterator     = 8
	ErrorInvalidOp           = 9
	ErrorInvalidAccess       = 10
	ErrorUpperCasePackage    = 11
	ErrorLowerCaseClass      = 12
	ErrorClassRedefined      = 13
	ErrorVarRedefined        = 14
	ErrorInvalidParam        = 15
	ErrorInvalid             = 16
	ErrorScriptThrow         = 17
	ErrorStop                = 18
	ErrorInvalidImport       = 19
)

// Expr base expr
type Expr interface {
	Type() int
	String() string
}

// ExprPackage for package define
type ExprPackage struct {
	Expr
	Value string
}

// ExprImport for import info
type ExprImport struct {
	Expr
	Value string
}

// ExprClass for class define
type ExprClass struct {
	Package         *ExprPackage
	Name            string
	Parent          *ExprClass
	Vars            []Expr
	StaticVars      []Expr
	Functions       []Expr
	StaticFunctions []Expr
}

// ExprFunction for function define
type ExprFunction struct {
	Name string
	Args []string
	Body Expr
}

// ExprReturn for return define
type ExprReturn struct {
	Value Expr
}

// ExprCall info to call a function
type ExprCall struct {
	Callee Expr
	Params []Expr
}

// ExprConst const info
type ExprConst struct {
	ValueType int
	Value     Expr
}

// ExprVar var info
type ExprVar struct {
	Name  string
	Value Expr
}

// ExprIdent ident ifo
type ExprIdent struct {
	Name string
}

// ExprClassIdent class ident
type ExprClassIdent struct {
	Name string
}

// ExprPair key value pair
type ExprPair struct {
	Name  string
	Value Expr
}

// ExprObject for object data
type ExprObject struct {
	Members []ExprPair
}

// ExprParent parent info
type ExprParent struct {
	Value Expr
}

// ExprField field info
type ExprField struct {
	Object Expr
	Field  string
}

// ExprBlock expr block define
type ExprBlock struct {
	Values []Expr
}

// ExprBinop binary operation
type ExprBinop struct {
	Operation string
	E1        Expr
	E2        Expr
}

// ExprUnop unary operation
type ExprUnop struct {
	Operation string
	E         Expr
}

// ExprIf if define
type ExprIf struct {
	Condition Expr
	E1        Expr
	E2        Expr
}

// ExprTernary ternary operation
type ExprTernary struct {
	Condition Expr
	E1        Expr
	E2        Expr
}

type ExprWhile struct {
	Condition Expr
	E         Expr
}

type ExprFor struct {
	IteratorName string
	Iterator     Expr
	E            Expr
}

type ExprBreak struct{}

type ExprContinue struct{}
*/
// TO-DO map and array and list native support
// type ExprArray
// type ExprArrayDecl

// TO-DO corroutine (channel, pipe), thread support
/*

	EBreak;
	EContinue;

	EArray(e:Expr, index:Expr); //array access
	EArrayDecl(e:Array<Expr>); //array declare

	ENew(cl:String, params:Array<Expr>);

	EThrow(e:Expr);
	ETry(e:Expr, v:String, ecatch:Expr);

	ELine(l:Int);*/

/*
type Expr struct {
	EPackage(v:String);
	EImport(v:String);
	EClass(name:String, file:String, parent:String,
		   vars:Array<Expr>, sVars:Array<Expr>,
		   funs:Array<Expr>, sFuns:Array<Expr>);

	EFunction(name:String, args:Array<String>, e:Expr);
	EReturn(?e:Expr);
	ECall(e:Expr, params:Array<Expr>);

	EConst(c:Const);
	EVar(n:String, ?e:Expr);
	EIdent(v:String);
	EClassIdent(v:String);
	EObject(fl:Array<{name:String, e:Expr}>);

	EParent(e:Expr);
	EField(e:Expr, f:String);
	EBlock(e:Array<Expr>);

	EBinop(op:String, e1:Expr, e2:Expr);
	EUnop(op:String, prefix:Bool, e:Expr);

	EIf(cond:Expr, e1:Expr, ?e2:Expr);
	ETernary(cond:Expr, e1:Expr, e2:Expr);
	EWhile(cond:Expr, e:Expr);
	EFor(v:String, it:Expr, e:Expr);
	EBreak;
	EContinue;

	EArray(e:Expr, index:Expr); //array access
	EArrayDecl(e:Array<Expr>); //array declare

	ENew(cl:String, params:Array<Expr>);

	EThrow(e:Expr);
	ETry(e:Expr, v:String, ecatch:Expr);

	ELine(l:Int);
}
*/

// Error data for emitting
/*
type Error struct {
	Type  int
	Reson string
}*/
