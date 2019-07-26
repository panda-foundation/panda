package compiler

type Token int

const (
	// special tokens
	ILLEGAL Token = iota
	EOF
	COMMENT
	DOCUMENT

	// literals
	literal_begin
	IDENT
	INT
	FLOAT
	CHAR
	STRING
	META
	literal_end

	// keywords
	keyword_begin
	Base
	Break
	Case
	Catch
	Class
	Const
	Continue
	Default
	Else
	Enum
	False
	For
	Function
	Import
	Interface
	If
	Namespace
	New
	Null
	Operator
	Public
	Return
	Static
	Switch
	This
	Throw
	True
	Try
	Var
	keyword_end

	// scalars
	scalar_begin
	Bool
	Char
	Int
	Int8
	Int16
	Int32
	Int64
	Uint
	Uint8
	Uint16
	Uint32
	Uint64
	Short
	Long
	Ushort
	Ulong
	Double
	Float
	Float32
	Float64
	String
	Void
	scalar_end

	// operators
	operator_begin
	LeftParen
	RightParen
	LeftBracket
	RightBracket
	LeftBrace
	RightBrace

	Plus
	Minus
	Star
	Div
	Mod
	Caret
	And
	Or
	Tilde
	Not
	Assign
	Less
	Greater

	PlusAssign
	MinusAssign
	DivAssign
	ModAssign
	XorAssign
	AndAssign
	OrAssign
	LeftShift
	RightShift
	LeftShiftAssign
	RightShiftAssign

	Equal
	NotEqual
	LessEqual
	GreaterEqual
	AndAnd
	OrOr
	PlusPlus
	MinusMinus

	Comma
	Question
	Colon
	Semi
	Dot
	Ellipsis
	operator_end
)

var (
	tokens = [...]string{

		Base:      "base",
		Break:     "break",
		Case:      "case",
		Catch:     "catch",
		Class:     "class",
		Const:     "const",
		Continue:  "continue",
		Default:   "default",
		Else:      "else",
		Enum:      "enum",
		False:     "false",
		For:       "for",
		Function:  "function",
		Import:    "import",
		Interface: "interface",
		If:        "if",
		Namespace: "namespace",
		New:       "new",
		Null:      "null",
		Operator:  "operator",
		Public:    "public",
		Return:    "return",
		Static:    "static",
		Switch:    "switch",
		This:      "this",
		Throw:     "throw",
		True:      "true",
		Try:       "try",
		Var:       "var",

		Bool:    "bool",
		Char:    "char",
		Int:     "int",
		Int8:    "i8",
		Int16:   "i16",
		Int32:   "i32",
		Int64:   "i64",
		Uint:    "uint",
		Uint8:   "u8",
		Uint16:  "u16",
		Uint32:  "u32",
		Uint64:  "u64",
		Short:   "short",
		Long:    "long",
		Ushort:  "ushort",
		Ulong:   "ulong",
		Double:  "double",
		Float:   "float",
		Float32: "f32",
		Float64: "f64",
		String:  "string",
		Void:    "void",

		LeftParen:        "(",
		RightParen:       ")",
		LeftBracket:      "[",
		RightBracket:     "]",
		LeftBrace:        "{",
		RightBrace:       "}",
		Plus:             "+",
		Minus:            "-",
		Star:             "*",
		Div:              "/",
		Mod:              "%",
		Caret:            "^",
		And:              "&",
		Or:               "|",
		Tilde:            "~",
		Not:              "!",
		Assign:           "=",
		Less:             "<",
		Greater:          ">",
		PlusAssign:       "+=",
		MinusAssign:      "-=",
		DivAssign:        "/=",
		ModAssign:        "%=",
		XorAssign:        "^=",
		AndAssign:        "&=",
		OrAssign:         "|=",
		LeftShift:        "<<",
		RightShift:       ">>",
		LeftShiftAssign:  "<<=",
		RightShiftAssign: ">>=",
		Equal:            "==",
		NotEqual:         "!=",
		LessEqual:        "<=",
		GreaterEqual:     ">=",
		AndAnd:           "&&",
		OrOr:             "||",
		PlusPlus:         "++",
		MinusMinus:       "--",
		Comma:            ",",
		Question:         "?",
		Colon:            ":",
		Semi:             ";",
		Dot:              ".",
		Ellipsis:         "...",

		ILLEGAL:  "ILLEGAL",
		EOF:      "EOF",
		COMMENT:  "COMMENT",
		DOCUMENT: "DOCUMENT",

		IDENT:  "IDENT",
		INT:    "INT",
		FLOAT:  "FLOAT",
		CHAR:   "CHAR",
		STRING: "STRING",
		META:   "META",
	}

	keywords     map[string]Token
	scalars      map[string]Token
	operators    map[string]Token
	allTokens    map[string]Token
	operatorRoot *OperatorNode
)

func init() {
	allTokens = make(map[string]Token)

	keywords = make(map[string]Token)
	for i := keyword_begin + 1; i < keyword_end; i++ {
		keywords[tokens[i]] = i
		allTokens[tokens[i]] = i
	}

	scalars = make(map[string]Token)
	for i := scalar_begin + 1; i < scalar_end; i++ {
		scalars[tokens[i]] = i
		allTokens[tokens[i]] = i
	}

	operators = make(map[string]Token)
	operatorRoot = NewOperatorNode()
	for i := operator_begin + 1; i < operator_end; i++ {
		operators[tokens[i]] = i
		allTokens[tokens[i]] = i
		operatorRoot.Insert(tokens[i])
	}
}

func (token Token) String() string {
	if 0 <= token && token < Token(len(tokens)) {
		return tokens[token]
	}
	return ""
}
func (token Token) IsLiteral() bool {
	return literal_begin < token && token < literal_end
}

func (token Token) IsOperator() bool {
	return operator_begin < token && token < operator_end
}

func (token Token) IsKeyword() bool {
	return keyword_begin < token && token < keyword_end
}

func (token Token) IsScalar() bool {
	return scalar_begin < token && token < scalar_end
}

func GetToken(identifier string) Token {
	if token, ok := allTokens[identifier]; ok {
		return token
	}
	return IDENT
}

func ReadOperator(bytes []byte) (Token, int) {
	return operatorRoot.Find(bytes)
}

type OperatorNode struct {
	children map[byte]*OperatorNode
	token    Token
}

func NewOperatorNode() *OperatorNode {
	return &OperatorNode{
		children: make(map[byte]*OperatorNode),
		token:    ILLEGAL,
	}
}

func (node *OperatorNode) Insert(operator string) {
	node.insertOperator(operator, 0)
}

func (node *OperatorNode) Find(bytes []byte) (Token, int) {
	return node.findOperator(bytes, 0)
}

func (node *OperatorNode) findOperator(bytes []byte, offset int) (Token, int) {
	if child, ok := node.children[bytes[offset]]; ok {
		offset++
		if offset < len(bytes) {
			return child.findOperator(bytes, offset)
		} else {
			return node.token, offset
		}
	} else if offset > 0 {
		return GetToken(string(bytes[:offset])), offset
	}
	return ILLEGAL, 1
}

func (node *OperatorNode) insertOperator(operator string, position int) {
	if position < len(operator) {
		char := operator[position]
		if _, ok := node.children[char]; !ok {
			node.children[char] = NewOperatorNode()
		}
		position++
		node.children[char].insertOperator(operator, position)
	} else {
		node.token = GetToken(operator)
	}
}

/*

// A set of constants for precedence-based expression parsing.
// Non-operators have lowest precedence, followed by operators
// starting with precedence 1 up to unary operators. The highest
// precedence serves as "catch-all" precedence for selector,
// indexing, and other operator and delimiter tokens.
//
const (
	LowestPrec  = 0 // non-operators
	UnaryPrec   = 6
	HighestPrec = 7
)

// Precedence returns the operator precedence of the binary
// operator op. If op is not a binary operator, the result
// is LowestPrecedence.
//
func (op Token) Precedence() int {
	switch op {
	case LOR:
		return 1
	case LAND:
		return 2
	case EQL, NEQ, LSS, LEQ, GTR, GEQ:
		return 3
	case ADD, SUB, OR, XOR:
		return 4
	case MUL, QUO, REM, SHL, SHR, AND, AND_NOT:
		return 5
	}
	return LowestPrec
}*/
