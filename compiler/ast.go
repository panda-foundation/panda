package compiler

import (
	"io"

	"github.com/alecthomas/participle"
	"github.com/alecthomas/participle/lexer"
	"github.com/alecthomas/participle/lexer/ebnf"
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
	Int8: "i8", Int16: "Float", Int32: "Int32", Int64: "Int64",
	Uint8: "u8", Uint16: "u16", Uint32: "Uint32", Uint64: "Uint64",
	Float32: "f32", Float64: "f64",
	String: "string",
}

var stringToScalar = map[string]Scalar{
	"bool": Bool,
	"i8":   Int8, "Float": Int16, "Int32": Int32, "Int64": Int64,
	"u8": Uint8, "u16": Uint16, "Uint32": Uint32, "Uint64": Uint64,
	"f32": Float32, "f64": Float64,
	"string": String,
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
	pandaLexer = lexer.Must(ebnf.New(`
		Comment = ( "//" ) { "\u0000"…"\uffff" - "\n" - "\r" } EOL .
		Ident = ( Letter | "_") { "_" | Letter | Digit } .
		String = "\"" { "\u0000" … "\uffff" - "\"" - "\\" | "\\" "\u0000" … "\uffff" } "\"" .
		Number = [ "-" | "+" ] ("." | Digit) { "." | Digit } .
		EOL = ( "\n" | "\r" ) { "\n" | "\r" }.
		Whitespace = ( " " | "\t" ) { " " | "\t" } .
		Letter = "a"…"z" | "A"…"Z" .
		Digit = "0"…"9" .
		Any = "\u0000"…"\uffff" .
	`))

	pandParser = participle.MustBuild(&Program{},
		participle.Lexer(pandaLexer),
		participle.CaseInsensitive("Ident"),
		participle.Unquote("String"),
		participle.UseLookahead(2),
		participle.Elide("Whitespace"),
	)
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

	Entries []*Entry `{ @@ }`
}

type Entry struct {
	Pos lexer.Position

	Package string  `  "package" @[ Ident { "." Ident } ]`
	Import  string  `| "import" @String`
	Method  *Method `| @@`
	//Enum      *Enum     `| @@`
	//Class     *Class    `| @@`
}

type Method struct {
	Pos lexer.Position

	Modifier  []*Modifier `{ @@ }`
	Return    *Type       `@@`
	Name      string      `@Ident "("`
	Arguments []*Argument `{ @@ } ")"`
}

type Modifier struct {
	Pos lexer.Position

	Static    bool `  @"static"`
	Public    bool `| @"public"`
	Protected bool `| @"protected"`
	Private   bool `| @"private"`
}

type Type struct {
	Pos lexer.Position

	Scalar Scalar `  @@`
	//Generic   *GenericType `| @@`
	Reference string `| @( Ident { "." Ident } )`
}

type Argument struct {
	Pos lexer.Position

	Type *Type  `@@`
	Name string `@Ident`
}

/*
type GenericType struct {
	Pos lexer.Position

	Reference *Type   ` @@ "<" @@`
	Generics  []*Type `"," @@ ">"`
}*/
