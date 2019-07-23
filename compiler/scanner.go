package compiler

import (
	"fmt"
	"unicode"
	"unicode/utf8"
)

const (
	bom = 0xFEFF // byte order mark, only permitted as very first character
	eof = -1
)

type ErrorHandler func(position Position, msg string)

// Const for scanner
/*
const (
	EOFChar       rune = -1
	InvalidChar   rune = -2
	InvalidPos    int  = -1
	InvalidLine   int  = 0
	InvalidColumn int  = 0
)*/

type Scanner struct {
	file *File
	dir  string
	src  []byte

	err        ErrorHandler
	ErrorCount int // total errors

	scanDocument bool
	flags        map[string]bool // flags for condition compiler
	flagStarted  bool            // if #if is true

	char       rune
	offset     int
	readOffset int
	lineOffset int
}

// NewScanner return an initialized scanner
func NewScanner(file *File, src []byte, err ErrorHandler, scanDocument bool, flags []string) *Scanner {
	scanner := &Scanner{}

	//if file.size != len(src) {
	//panic(fmt.Sprintf("file size (%d) does not match src len (%d)", file.size, len(src)))
	//}
	scanner.file = file
	scanner.src = src
	scanner.err = err
	scanner.scanDocument = scanDocument
	//scanner.dir, _ = filepath.Split(file.name)

	scanner.char = ' '
	scanner.offset = 0
	scanner.readOffset = 0
	scanner.ErrorCount = 0

	scanner.next()
	if scanner.char == bom {
		scanner.next()
	}

	scanner.flags = make(map[string]bool)
	for _, flag := range flags {
		scanner.flags[flag] = true
	}

	return scanner
}

func (s *Scanner) next() {
	if s.readOffset < len(s.src) {
		s.offset = s.readOffset
		if s.char == '\n' {
			//s.file.AddLine(s.offset)
		}
		r, w := rune(s.src[s.readOffset]), 1
		switch {
		case r == 0:
			s.error(s.offset, "illegal character NUL")
		case r >= utf8.RuneSelf:
			// not ASCII
			r, w = utf8.DecodeRune(s.src[s.readOffset:])
			if r == utf8.RuneError && w == 1 {
				s.error(s.offset, "illegal UTF-8 encoding")
			} else if r == bom && s.offset > 0 {
				s.error(s.offset, "illegal byte order mark")
			}
		}
		s.readOffset += w
		s.char = r
	} else {
		s.offset = len(s.src)
		if s.char == '\n' {
			//s.file.AddLine(s.offset)
		}
		s.char = eof
	}
}

func (s *Scanner) peek() byte {
	if s.readOffset < len(s.src) {
		return s.src[s.readOffset]
	}
	return 0
}

func (s *Scanner) error(offset int, msg string) {
	if s.err != nil {
		fmt.Println("error:", msg)
		//s.err(s.file.Position(s.file.Pos(offset)), msg)
	}
	s.ErrorCount++
}

//func (s *Scanner) scanComment() string {
// skip then update line info
// scanDocument
// updateLineInfo

func (s *Scanner) scanIdentifier() string {
	offset := s.offset
	for s.isIdentifierLetter(s.char) {
		s.next()
	}
	return string(s.src[offset:s.offset])
}

func (s *Scanner) scanDigits(base int) {
	for s.digitVal(s.char) < base {
		s.next()
	}
}

func (s *Scanner) scanNumber(seenDot bool) (Token, string) {
	offset := s.offset
	token := INT

	if !seenDot {
		if s.char == '0' {
			s.next()
			switch s.lower(s.char) {
			case 'x':
				s.next()
				s.scanDigits(16)
				if s.offset-offset <= 2 {
					// only scanned "0x" or "0X"
					s.error(offset, "illegal hexadecimal number")
				}
				if s.char == '.' {
					s.error(offset, "invalid radix point")
				}
			case 'b':
				s.next()
				s.scanDigits(2)
				if s.offset-offset <= 2 {
					// only scanned "0b" or "0B"
					s.error(offset, "illegal binary number")
				}
				if s.char == '.' {
					s.error(offset, "invalid radix point")
				}
			default:
				s.scanDigits(8)
				if s.char == '8' || s.char == '9' {
					token = FLOAT
					s.scanDigits(10)
					if s.char != '.' {
						s.error(offset, "illegal octal number")
					}
					seenDot = true
				}
			}
		} else {
			s.scanDigits(10)
		}
	}

	// fractional part
	if seenDot {
		token = FLOAT
		s.scanDigits(10)
	}

	return token, string(s.src[offset:s.offset])
}

func (s *Scanner) scanEscape(quote rune) bool {
	offset := s.offset

	var n int
	var base, max uint32
	switch s.char {
	case 'a', 'b', 'f', 'n', 'r', 't', 'v', '\\', quote:
		s.next()
		return true
	case '0', '1', '2', '3', '4', '5', '6', '7':
		n, base, max = 3, 8, 255
	case 'x':
		s.next()
		n, base, max = 2, 16, 255
	case 'u':
		s.next()
		n, base, max = 4, 16, unicode.MaxRune
	case 'U':
		s.next()
		n, base, max = 8, 16, unicode.MaxRune
	default:
		msg := "unknown escape sequence"
		if s.char < 0 {
			msg = "escape sequence not terminated"
		}
		s.error(offset, msg)
		return false
	}

	var x uint32
	for n > 0 {
		d := uint32(s.digitVal(s.char))
		if d >= base {
			msg := fmt.Sprintf("illegal character %#U in escape sequence", s.char)
			if s.char < 0 {
				msg = "escape sequence not terminated"
			}
			s.error(s.offset, msg)
			return false
		}
		x = x*base + d
		s.next()
		n--
	}

	if x > max || 0xD800 <= x && x < 0xE000 {
		s.error(offset, "escape sequence is invalid Unicode code point")
		return false
	}

	return true
}

func (s *Scanner) scanString() string {
	offset := s.offset - 1

	for {
		char := s.char
		if char == '\n' || char < 0 {
			s.error(offset, "string literal not terminated")
			break
		}
		s.next()
		if char == '"' {
			break
		}
		if char == '\\' {
			s.scanEscape('"')
		}
	}

	return string(s.src[offset:s.offset])
}

func (s *Scanner) scanChar() string {
	// '\'' opening already consumed
	offset := s.offset - 1

	valid := true
	n := 0
	for {
		char := s.char
		if char == '\n' || char < 0 {
			// only report error if we don't have one already
			if valid {
				s.error(offset, "rune literal not terminated")
				valid = false
			}
			break
		}
		s.next()
		if char == '\'' {
			break
		}
		n++
		if char == '\\' {
			if !s.scanEscape('\'') {
				valid = false
			}
			// continue to read to closing quote
		}
	}

	if valid && n != 1 {
		s.error(offset, "illegal rune literal")
	}

	return string(s.src[offset:s.offset])
}

/*
func (s *Scanner) scanRawString() rune {
	char, _ := s.scanUntil('"') // read character after '@("'
	terminated := false
	char, terminated = s.ensureChar(')')
	for terminated != true {
		char, _ = s.scanUntil('"')
		char, terminated = s.ensureChar(')')
	}
	return char
}*/

/*
func (s *Scanner) scanOperators(char rune) (rune, Token) {
	// TO-DO optimization later with tree, and opt info stored in scanner
	for HasToken(s.currentToken() + string(char)) {
		char = s.next()
	}
	return char, KeyToToken(s.currentToken())
}*/

/*
func (s *Scanner) scanPreprossesor() (rune, bool) {
	char := s.next()
	notOp := false
	if char == '!' {
		notOp = true
		char = s.next()
	}
	s.resetToken()
	if !s.isIdentifierRune(char, 0) {
		s.error(fmt.Sprintf("unexpected %s \n", string(char)))
	}
	char = s.scanIdentifier()
	for char == ' ' || char == '\t' || char == '\r' {
		char = s.next()
	}
	if char != '\n' {
		s.error("unexpected " + string(char))
	}
	result := false
	text := s.currentToken()
	if _, ok := s.flags[text]; ok {
		result = true
	}
	if notOp {
		result = !result
	}
	return char, result
}

func (s *Scanner) skipPreprossesor() rune {
	char, _ := s.scanUntil('#')
	char = s.next()
	if s.isIdentifierRune(char, 0) {
		s.resetToken()
		char = s.scanIdentifier()
		text := s.currentToken()
		if text != "end" {
			s.error(fmt.Sprintf("unexpected: %s" + text))
		}
	} else {
		s.error("unexpected: " + string(char))
	}
	return char
}*/

//TO-DO add: ensureIdentifier

func (s *Scanner) isIdentifierLetter(char rune) bool {
	return char == '_' || s.isLetter(char) || s.isDigit(char)
}

func (s *Scanner) isLetter(char rune) bool {
	return 'a' <= char && char <= 'z' || 'A' <= char && char <= 'Z'
}

func (s *Scanner) isDigit(char rune) bool {
	return '0' <= char && char <= '9'
}

func (s *Scanner) isDecimal(char rune) bool {
	return '0' <= char && char <= '9'
}

func (s *Scanner) isHex(char rune) bool {
	return '0' <= char && char <= '9' || 'a' <= s.lower(char) && s.lower(char) <= 'f'
}

// returns lower-case char if char is ASCII letter
// use 0b00100000 instead 'a' - 'A' later in panda own compiler
func (s *Scanner) lower(char rune) rune {
	return ('a' - 'A') | char
}

func (s *Scanner) skipWhitespace() {
	for s.char == ' ' || s.char == '\t' || s.char == '\n' || s.char == '\r' {
		s.next()
	}
}

func (s *Scanner) digitVal(char rune) int {
	switch {
	case '0' <= char && char <= '9':
		return int(char - '0')
	case 'a' <= s.lower(char) && s.lower(char) <= 'f':
		return int(s.lower(char) - 'a' + 10)
	}
	return 16 // larger than any legal digit val
}

// Scan next token
func (s *Scanner) Scan() (pos Position, token Token, literal string) {
	s.skipWhitespace()

	//pos = s.file.Pos(s.offset)

	token = ILLEGAL
	if s.isLetter(s.char) || s.char == '_' {
		literal = s.scanIdentifier()
		token = Lookup(literal)
	} else if s.isDecimal(s.char) {
		token, literal = s.scanNumber(false)
	} else {
		char := s.char
		s.next()
		switch char {
		case eof:
			token = EOF
			/*
				if s.conditionStarted {
					s.error("#if not terminated, expecting #end")
				}*/
		case '"':
			token = STRING
			literal = s.scanString()
		case '\'':
			token = CHAR
			literal = s.scanChar()
		case '.': //start with . can maybe operator
			if s.isDecimal(s.char) {
				token, literal = s.scanNumber(true)
			} else {
				//token, literal = s.scanOperators()
			}
			/*
				case '/': // alse maybe operator /
					char = s.next()
					//TO-DO scan document
					if char == '/' || char == '*' {
						if char == '/' {
							char = s.scanLineComment()
						} else {
							char = s.scanBlockComment()
						}
						char = s.next()
						if s.skipDocument {
							s.char = char
							return s.Scan()
						}
						token = TokenDocument
					} else {
						token, literal = s.scanOperators()
					}*/
			/*
				case '@':
					char = s.next()
					if char == '(' {
						isRawString := false
						char, isRawString = s.ensureChar('"')
						if isRawString {
							s.scanRawString()
							token = TokenRawString
							char = s.next()
						} else {
							s.error(fmt.Sprintf("unexpected: %s", string(char)))
						}
					} else if s.isIdentifierRune(char, 0) {
						token = TokenMetaIdentifier
						char = s.scanIdentifier()
					}*/
			/*
				case '#':
					//#if #end, before flag can add '!' for not operation
					//nested # is not supported
					char = s.next()
					if s.isIdentifierRune(char, 0) {
						s.resetToken()
						char = s.scanIdentifier()
						text := s.currentToken()
						if text == "if" {
							if s.conditionStarted {
								s.error("unexpected #if")
							}
							s.conditionStarted = true
						} else if text == "end" {
							if !s.conditionStarted {
								s.error("unexpected #end")
							}
							s.conditionStarted = false
						} else {
							s.error("unexpected: " + text)
						}

						if text == "if" {
							result := false
							char, result = s.scanPreprossesor()
							if !result {
								char = s.skipPreprossesor()
								char = s.next()
								s.conditionStarted = false
							}
						}

						s.char = char
						return s.Scan()
					}
					s.error("unexpected: " + string(char))*/
		default:
			/*
				if IsOperator(char) {
					char = s.next()
					char, token = s.scanOperators(char)
				} else*/{
				// invalid
				s.error(0, "invalid token")
				s.next()
			}
		}
	}
	return
}
