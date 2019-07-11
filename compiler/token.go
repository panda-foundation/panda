package compiler

// Token is keywords and operators
type Token rune

// Tokens defined here
const (
	// identifier and values
	TokenInvalid Token = iota
	TokenEOF
	TokenIdentifier
	TokenInt
	TokenFloat
	TokenChar
	TokenString
	TokenRawString
	TokenMetaIdentifier
	TokenDocument //TO-DO

	// keywords
	Base
	Break
	Case
	Cast
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
	Include
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

	// scalar
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

	// operators
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
	scalars    map[Token]bool
)

func init() {
	keyToToken = make(map[string]Token)
	tokenToKey = make(map[Token]string)

	tokenToKey[Base] = "base"
	tokenToKey[Break] = "break"
	tokenToKey[Case] = "case"
	tokenToKey[Cast] = "cast"
	tokenToKey[Catch] = "catch"
	tokenToKey[Class] = "class"
	tokenToKey[Const] = "const"
	tokenToKey[Continue] = "continue"
	tokenToKey[Default] = "default"
	tokenToKey[Else] = "else"
	tokenToKey[Enum] = "enum"
	tokenToKey[False] = "false"
	tokenToKey[For] = "for"
	tokenToKey[Function] = "function"
	tokenToKey[Include] = "include"
	tokenToKey[If] = "if"
	tokenToKey[Namespace] = "namespace"
	tokenToKey[New] = "new"
	tokenToKey[Null] = "null"
	tokenToKey[Operator] = "operator"
	tokenToKey[Public] = "public"
	tokenToKey[Return] = "return"
	tokenToKey[Static] = "static"
	tokenToKey[Switch] = "switch"
	tokenToKey[This] = "this"
	tokenToKey[Throw] = "throw"
	tokenToKey[True] = "true"
	tokenToKey[Try] = "try"
	tokenToKey[Var] = "var"

	tokenToKey[Bool] = "bool"
	tokenToKey[Char] = "char"
	tokenToKey[Int] = "int"
	tokenToKey[Int8] = "i8"
	tokenToKey[Int16] = "i16"
	tokenToKey[Int32] = "i32"
	tokenToKey[Int64] = "i64"
	tokenToKey[Uint] = "uint"
	tokenToKey[Uint8] = "u8"
	tokenToKey[Uint16] = "u16"
	tokenToKey[Uint32] = "u32"
	tokenToKey[Uint64] = "u64"
	tokenToKey[Short] = "short"
	tokenToKey[Long] = "long"
	tokenToKey[Ushort] = "ushort"
	tokenToKey[Ulong] = "ulong"
	tokenToKey[Double] = "double"
	tokenToKey[Float] = "float"
	tokenToKey[Float32] = "f32"
	tokenToKey[Float64] = "f64"
	tokenToKey[String] = "string"
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

	// no fixed text value (read from scanner.Token())
	tokenToKey[TokenInvalid] = "invalid_token"
	tokenToKey[TokenEOF] = "EOF"
	tokenToKey[TokenIdentifier] = "identifier"
	tokenToKey[TokenInt] = "int_value"
	tokenToKey[TokenFloat] = "float_value"
	tokenToKey[TokenChar] = "char_value"
	tokenToKey[TokenString] = "string_value"
	tokenToKey[TokenRawString] = "raw_string"
	tokenToKey[TokenDocument] = "document"
	tokenToKey[TokenMetaIdentifier] = "meta_identifier"

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

	// scalars
	scalars = make(map[Token]bool)

	scalars[Bool] = true

	scalars[Char] = true

	scalars[Int] = true
	scalars[Int8] = true
	scalars[Int16] = true
	scalars[Int32] = true
	scalars[Int64] = true
	scalars[Uint] = true
	scalars[Uint8] = true
	scalars[Uint16] = true
	scalars[Uint32] = true
	scalars[Uint64] = true
	scalars[Short] = true
	scalars[Long] = true
	scalars[Ushort] = true
	scalars[Ulong] = true

	scalars[Double] = true
	scalars[Float] = true
	scalars[Float32] = true
	scalars[Float64] = true

	scalars[String] = true

	scalars[Void] = true
}

// KeyToToken convert key to token
func KeyToToken(key string) Token {
	return keyToToken[key]
}

// TokenToKey convert token to key
func TokenToKey(token Token) string {
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

func IsScala(token Token) bool {
	return scalars[token]
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
