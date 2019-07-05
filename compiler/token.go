package compiler

// Token is keywords and operators
type Token rune

// Tokens defined here
const (
	// keywords
	Auto = iota
	Base
	Bool
	Break
	Case
	Cast
	Catch
	Char
	Class
	Const
	Continue
	Default
	Double
	Else
	Enum
	Float32
	Float64
	False
	Float
	For
	Include
	If
	Int
	Int8
	Int16
	Int32
	Int64
	Long
	Namespace
	New
	Null
	Operator
	Private
	Protected
	Public
	Return
	Static
	Short
	String
	Switch
	This
	Throw
	True
	Try
	Uint
	Uint8
	Uint16
	Uint32
	Uint64
	Ulong
	Ushort
	Void

	/*Operators*/
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
)

var (
	keyToToken map[string]Token
	tokenToKey map[Token]string
	operators  [128]bool
)

func init() {
	keyToToken = make(map[string]Token)
	tokenToKey = make(map[Token]string)

	tokenToKey[Auto] = "auto"
	tokenToKey[Base] = "base"
	tokenToKey[Bool] = "bool"
	tokenToKey[Break] = "break"
	tokenToKey[Case] = "case"
	tokenToKey[Cast] = "cast"
	tokenToKey[Catch] = "catch"
	tokenToKey[Char] = "char"
	tokenToKey[Class] = "class"
	tokenToKey[Const] = "const"
	tokenToKey[Continue] = "continue"
	tokenToKey[Default] = "default"
	tokenToKey[Double] = "double"
	tokenToKey[Else] = "else"
	tokenToKey[Enum] = "enum"
	tokenToKey[Float32] = "f32"
	tokenToKey[Float64] = "f64"
	tokenToKey[False] = "false"
	tokenToKey[Float] = "float"
	tokenToKey[For] = "for"
	tokenToKey[Include] = "include"
	tokenToKey[If] = "if"
	tokenToKey[Int] = "int"
	tokenToKey[Int8] = "i8"
	tokenToKey[Int16] = "i16"
	tokenToKey[Int32] = "i32"
	tokenToKey[Int64] = "i64"
	tokenToKey[Long] = "long"
	tokenToKey[Namespace] = "namespace"
	tokenToKey[New] = "new"
	tokenToKey[Null] = "null"
	tokenToKey[Operator] = "operator"
	tokenToKey[Private] = "private"
	tokenToKey[Protected] = "protected"
	tokenToKey[Public] = "public"
	tokenToKey[Return] = "return"
	tokenToKey[Static] = "static"
	tokenToKey[Short] = "short"
	tokenToKey[String] = "string"
	tokenToKey[Switch] = "switch"
	tokenToKey[This] = "this"
	tokenToKey[Throw] = "throw"
	tokenToKey[True] = "true"
	tokenToKey[Try] = "try"
	tokenToKey[Uint] = "uint"
	tokenToKey[Uint8] = "u8"
	tokenToKey[Uint16] = "u16"
	tokenToKey[Uint32] = "u32"
	tokenToKey[Uint64] = "u64"
	tokenToKey[Ulong] = "ulong"
	tokenToKey[Ushort] = "ushort"
	tokenToKey[Void] = "void"

	tokenToKey[LeftParen] = "("
	tokenToKey[RightParen] = ")"
	tokenToKey[LeftBracket] = "["
	tokenToKey[RightBracket] = "]"
	tokenToKey[LeftBrace] = "{"
	tokenToKey[RightBrace] = "}"
	tokenToKey[Plus] = "+"
	tokenToKey[Minus] = "-"
	tokenToKey[Star] = "*"
	tokenToKey[Div] = "/"
	tokenToKey[Mod] = "%"
	tokenToKey[Caret] = "^"
	tokenToKey[And] = "&"
	tokenToKey[Or] = "|"
	tokenToKey[Tilde] = "~"
	tokenToKey[Not] = "!"
	tokenToKey[Assign] = "="
	tokenToKey[Less] = "<"
	tokenToKey[Greater] = ">"
	tokenToKey[PlusAssign] = "+="
	tokenToKey[MinusAssign] = "-="
	tokenToKey[DivAssign] = "/="
	tokenToKey[ModAssign] = "%="
	tokenToKey[XorAssign] = "^="
	tokenToKey[AndAssign] = "&="
	tokenToKey[OrAssign] = "|="
	tokenToKey[LeftShift] = "<<"
	tokenToKey[RightShift] = ">>"
	tokenToKey[LeftShiftAssign] = "<<="
	tokenToKey[RightShiftAssign] = ">>="
	tokenToKey[Equal] = "=="
	tokenToKey[NotEqual] = "!="
	tokenToKey[LessEqual] = "<="
	tokenToKey[GreaterEqual] = ">="
	tokenToKey[AndAnd] = "&&"
	tokenToKey[OrOr] = "||"
	tokenToKey[PlusPlus] = "++"
	tokenToKey[MinusMinus] = "--"
	tokenToKey[Comma] = ","
	tokenToKey[Question] = "?"
	tokenToKey[Colon] = ":"
	tokenToKey[Semi] = ";"
	tokenToKey[Dot] = "."
	tokenToKey[Ellipsis] = "..."

	for k, v := range tokenToKey {
		keyToToken[v] = k
	}

	operators['('] = true
	operators[')'] = true
	operators['['] = true
	operators[']'] = true
	operators['{'] = true
	operators['}'] = true
	operators['+'] = true
	operators['-'] = true
	operators['*'] = true
	operators['/'] = true
	operators['%'] = true
	operators['^'] = true
	operators['&'] = true
	operators['|'] = true
	operators['~'] = true
	operators['!'] = true
	operators['='] = true
	operators['<'] = true
	operators['>'] = true
	operators[','] = true
	operators[':'] = true
	operators['?'] = true
	operators[';'] = true
	operators['.'] = true
}

// KeyToToken convert key to token
func KeyToToken(key string) Token {
	return keyToToken[key]
}

// TokenToKen convert token to key
func TokenToKen(token Token) string {
	return tokenToKey[token]
}

// HasToken return if it is keyword
func HasToken(key string) bool {
	_, ok := keyToToken[key]
	return ok
}

// IsOperator return if the char is need operator
func IsOperator(char rune) bool {
	if char >= 128 || char < 0 {
		return false
	}
	return operators[char] == true
}

/*
fn (t Token) is_decl() bool {
	// TODO return t in [FUNC ,TIP, CONST,  IMPORT_CONST ,AT ,EOF]
	return t == ENUM || t == INTERFACE || t == FUNC || t == STRUCT || t == TIP ||
	t == CONST || t == IMPORT_CONST || t == PUB || t == EOF
}

const (
	AssignTokens = [
		ASSIGN, PLUS_ASSIGN, MINUS_ASSIGN,
		MULT_ASSIGN, DIV_ASSIGN, XOR_ASSIGN, MOD_ASSIGN,
		OR_ASSIGN, AND_ASSIGN, RIGHT_SHIFT_ASSIGN,
		LEFT_SHIFT_ASSIGN
	]

)

fn (t Token) is_assign() bool {
	return t in AssignTokens
}

fn (t []Token) contains(val Token) bool {
	for tt in t {
		if tt == val {
			return true
		}
	}
	return false
}*/
