package compiler

import (
	"io"

	"github.com/alecthomas/participle"
	"github.com/alecthomas/participle/lexer"
)

// Scalar : basic data type
type Scalar int

// Basic data types
const (
	Bool    Scalar = iota
	Int8           = 1
	Int16          = 2
	Int32          = 3
	Int64          = 4
	Uint8          = 5
	Uint16         = 6
	Uint32         = 7
	Uint64         = 8
	Float32        = 9
	Float64        = 10
	String         = 11

	Int    = Int32
	Uint   = Uint32
	Float  = Float32
	Double = Float64
	Byte   = Uint8
)

var scalarToString = map[Scalar]string{
	Bool: "bool",
	Int8: "i8", Int16: "i16", Int32: "i32", Int64: "i64",
	Uint8: "u8", Uint16: "u16", Uint32: "u32", Uint64: "u64",
	Float32: "f32", Float64: "f64",
	String: "string",
}

var stringToScalar = map[string]Scalar{
	"bool": Bool,
	"i8":   Int8, "i16": Int16, "i32": Int32, "i64": Int64,
	"u8": Uint8, "u16": Uint16, "u32": Uint32, "u64": Uint64,
	"f32": Float32, "f64": Float64,
	"string": String,
	"int":    Int, "uint": Uint, "float": Float, "double": Double, "byte": Byte,
}

func (s Scalar) String() string { return scalarToString[s] }

func (s *Scalar) Parse(lex lexer.PeekingLexer) error {
	token, err := lex.Peek(0)
	if err != nil {
		return err
	}
	v, ok := stringToScalar[token.Value]
	if !ok {
		return participle.NextMatch
	}
	_, err = lex.Next()
	if err != nil {
		return err
	}
	*s = v
	return nil
}

var (
	pandParser = participle.MustBuild(&Program{})
)

// Parse a BASIC program.
func Parse(r io.Reader) (*Program, error) {
	program := &Program{}
	err := pandParser.Parse(r, program)
	if err != nil {
		return nil, err
	}
	return program, nil
}

// Program data for 1 panda source code *.pd (*.pbc panda byte code)
type Program struct {
	Pos lexer.Position

	Entries []*Entry `( @@ )*`
}

type Entry struct {
	Pos lexer.Position

	Package *string `  "package" @( Ident ( "." Ident )* )?`
	Import  *string `| "import" @String`
	Method  *Method `| @@`

	//Enum      *Enum     `| @@`
	//Class     *Class    `| @@`

	// for testing
	Operation *Operation `| @@`
}

type Method struct {
	Pos lexer.Position

	Modifier  []string      `@( "static" | "const" | "public" | "protected" | "private" | "weak" )*`
	Return    *Type         `@@`
	Name      *string       `@Ident "("`
	Arguments []*Argument   `( @@ ( "," @@ )* )? ")"`
	Body      []*Expression `"{" ( @@ )* "}"`
	//TO-DO add generic for method
}

type Type struct {
	Pos lexer.Position

	Scalar    Scalar       `  @@`
	Generic   *GenericType `| @@`
	Reference *string      `| @( Ident ( "." Ident )* )`
	Null      bool         `| @"null"`
	Void      bool         `| @"void"`
}

type Argument struct {
	Pos lexer.Position

	Type *Type   `@@`
	Name *string `@Ident`
	//TO-DO add default value (expr)
}

type GenericType struct {
	Pos lexer.Position

	Reference *string `@( Ident ( "." Ident )* ) "<"`
	Generics  []*Type `@@ ( "," @@ )* ">"`
}

type Expression struct {
	Pos lexer.Position

	Block       []*Expression `  "{" ( @@ )* "}"`
	Call        *Call         `| @@`
	Declaration *Declaration  `| @@`
	Const       *Const        `| @@`
}

type Call struct {
	Pos lexer.Position

	Callee    *string       `@( Ident ( "." Ident )* ) "("`
	Arguments []*Expression `( @@ ( "," @@ )* )? ")" ";"`
}

type Declaration struct {
	Pos lexer.Position

	Type *Type       `@@`
	Name *string     `@Ident`
	Expr *Expression `( "=" @@ )? ";"`
}

type Const struct {
	Pos lexer.Position

	Int64   *int64   `  @Int`
	Float64 *float64 `| @Float`
	String  *string  `| @String`
}

type Operation struct {
	Pos lexer.Position

	Op *string `@( "+" | "*" | "/" | "-" | "=" | "!" | ">" | "<" | "&" | "|" | "^" | "%" | "~" )+`
}

/*
type Binop struct {
	Operation string
	Expr1        *Expression
	Expr2        *Expression
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

ENew(cl:String, params:Array<Expr>);

EThrow(e:Expr);
ETry(e:Expr, v:String, ecatch:Expr);
*/

// TO-DO if has return value
// Expression
// TO-DO corroutine (channel, pipe), thread support

//metadata   @author @generate(generate code block) @custom
