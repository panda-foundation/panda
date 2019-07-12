package compiler

import (
	"fmt"
	"path/filepath"
	"unicode/utf8"
)

const bom = 0xFEFF // byte order mark, only permitted as very first character

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
}

// NewScanner return an initialized scanner
func NewScanner(file *File, src []byte, err ErrorHandler, scanDocument bool, flags []string) *Scanner {
	scanner := &Scanner{}

	if file.size != len(src) {
		panic(fmt.Sprintf("file size (%d) does not match src len (%d)", file.size, len(src)))
	}
	scanner.file = file
	scanner.src = src
	scanner.err = err
	scanner.scanDocument = scanDocument
	scanner.dir = filepath.Split(file.name)

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
			s.file.AddLine(s.offset)
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
		if s.ch == '\n' {
			s.file.AddLine(s.offset)
		}
		s.ch = -1 // eof
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
		s.err(s.file.Position(s.file.Pos(offset)), msg)
	}
	s.ErrorCount++
}

//func (s *Scanner) scanComment() string {
// skip then update line info
// scanDocument
// updateLineInfo

func (s *Scanner) scanIdentifier() rune {
	// the zero'th rune is OK; start scanning at the next one
	char := s.next()
	for i := 1; s.isIdentifierRune(char, i); i++ {
		char = s.next()
	}
	return char
}

func (s *Scanner) scanDigits(char rune, base int) rune {
	if base <= 10 {
		max := rune('0' + base)
		for isDecimal(char) {
			if char >= max {
				s.error(fmt.Sprintf("invalid digit %q ", char))
			}
			char = s.next()
		}
	} else {
		for isHex(char) {
			char = s.next()
		}
	}
	return char
}

func (s *Scanner) scanNumber(char rune, seenDot bool) (rune, Token) {
	base := 10        // number base
	prefix := rune(0) // one of 0 (decimal), '0' (0-octal), 'x', or 'b'

	// integer part
	var numberType Token
	if !seenDot {
		numberType = TokenInt
		if char == '0' {
			char = s.next()
			switch lower(char) {
			case 'x':
				char = s.next()
				base, prefix = 16, 'x'
			case 'b':
				char = s.next()
				base, prefix = 2, 'b'
			default:
				base, prefix = 8, '0'
			}
		}
		char = s.scanDigits(char, base)
		if char == '.' {
			char = s.next()
			seenDot = true
		}
	}

	// fractional part
	if seenDot {
		numberType = TokenFloat
		if prefix == 'b' || prefix == 'x' {
			s.error("invalid radix point")
		}
		char = s.scanDigits(char, base)
	}

	s.tokenEnd = s.srcPos - s.lastCharLen
	return char, numberType
}

func (s *Scanner) digitVal(char rune) int {
	switch {
	case '0' <= char && char <= '9':
		return int(char - '0')
	case 'a' <= lower(char) && lower(char) <= 'f':
		return int(lower(char) - 'a' + 10)
	}
	s.error("invalid digit char")
	return 16 // larger than any legal digit val
}

func (s *Scanner) scanNDigits(char rune, base, n int) rune {
	for n > 0 && s.digitVal(char) < base {
		char = s.next()
		n--
	}
	if n > 0 {
		s.error("invalid char escape")
	}
	return char
}

func (s *Scanner) scanEscape(quote rune) rune {
	char := s.next() // read character after '/'
	switch char {
	case 'a', 'b', 'f', 'n', 'r', 't', 'v', '\\', quote:
		// nothing to do
		char = s.next()
	case '0', '1', '2', '3', '4', '5', '6', '7':
		char = s.scanNDigits(char, 8, 3)
	case 'x':
		char = s.scanNDigits(s.next(), 16, 2)
	case 'u':
		char = s.scanNDigits(s.next(), 16, 4)
	case 'U':
		char = s.scanNDigits(s.next(), 16, 8)
	default:
		s.error("invalid char escape")
	}
	return char
}

func (s *Scanner) scanString(quote rune) (rune, int) {
	char := s.next() // read character after quote
	n := 0
	for char != quote {
		if char == '\n' || char < 0 { // new line or EOF
			s.error("string not terminated")
			return char, n
		}
		if char == '\\' {
			char = s.scanEscape(quote)
		} else {
			char = s.next()
		}
		n++
	}
	return char, n
}

func (s *Scanner) scanRawString() rune {
	char, _ := s.scanUntil('"') // read character after '@("'
	terminated := false
	char, terminated = s.ensureChar(')')
	for terminated != true {
		char, _ = s.scanUntil('"')
		char, terminated = s.ensureChar(')')
	}
	return char
}

func (s *Scanner) scanChar() rune {
	char, n := s.scanString('\'')
	if n != 1 {
		s.error("invalid char literal")
	}
	return char
}

func (s *Scanner) scanOperators(char rune) (rune, Token) {
	// TO-DO optimization later with tree, and opt info stored in scanner
	for HasToken(s.currentToken() + string(char)) {
		char = s.next()
	}
	return char, KeyToToken(s.currentToken())
}

func (s *Scanner) scanLineComment() rune {
	// '/'
	char, _ := s.scanUntil('\n') // read character after "//"
	return char
}

func (s *Scanner) scanBlockComment() rune {
	// '*'
	char, _ := s.scanUntil('*')
	terminated := false
	char, terminated = s.ensureChar('/')
	for terminated != true {
		char, _ = s.scanUntil('*')
		char, terminated = s.ensureChar('/')
	}
	return char
}

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
}

func (s *Scanner) scanUntil(quote rune) (rune, int) {
	char := s.next() // read character after quote
	n := 0
	for char != quote {
		if char < 0 { // EOF
			s.error("not terminated")
			return char, n
		}
		char = s.next()
		n++
	}
	return char, n
}

func (s *Scanner) ensureChar(char rune) (rune, bool) {
	result := s.next()
	return result, char == result
}

//TO-DO add: ensureIdentifier

func (s *Scanner) isIdentifierRune(char rune, i int) bool {
	return char == '_' || s.isLetter(char) || (s.isDigit(char) && i > 0)
}

func (s *Scanner) isLetter(char rune) bool {
	return ('a' <= char && char <= 'z') || ('A' <= char && char <= 'Z')
}

func (s *Scanner) isDigit(char rune) bool {
	return '0' <= char && char <= '9'
}

func (s *Scanner) resetToken() {
	s.tokenBuf.Reset()
	s.tokenPos = s.srcPos - s.lastCharLen
}

// returns lower-case char if char is ASCII letter
// use 0b00100000 instead 'a' - 'A' later in panda own compiler
func lower(char rune) rune {
	return ('a' - 'A') | char
}

func isDecimal(char rune) bool {
	return '0' <= char && char <= '9'
}

func isHex(char rune) bool {
	return '0' <= char && char <= '9' || 'a' <= lower(char) && lower(char) <= 'f'
}

// Scan next token
func (s *Scanner) Scan() Token {
	// reset token text position
	s.tokenPos = InvalidPos
	s.Line = 0

	char := s.peek()
	// whitespace
	for char == ' ' || char == '\t' || char == '\r' || char == '\n' {
		char = s.next()
	}

	// reset token
	s.resetToken()
	s.Offset = s.srcBufOffset + s.tokenPos

	if s.column > 0 {
		// common case: last character was not a '\n'
		s.Line = s.line
		s.Column = s.column
	} else {
		// last character was a '\n'
		// (we cannot be at the beginning of the source
		// since we have called next() at least once)
		s.Line = s.line - 1
		s.Column = s.lastLineLen
	}

	// todo NewLine
	// determine token value
	token := TokenInvalid
	switch {
	case s.isIdentifierRune(char, 0):
		token = TokenIdentifier
		char = s.scanIdentifier()
		text := s.currentToken()
		if HasToken(text) {
			token = KeyToToken(text)
		}
	case isDecimal(char):
		char, token = s.scanNumber(char, false)
	default:
		switch char {
		case EOFChar:
			token = TokenEOF
			if s.conditionStarted {
				s.error("#if not terminated, expecting #end")
			}
			break
		case '"':
			s.scanString('"')
			char = s.next()
			token = TokenString
		case '\'':
			s.scanChar()
			char = s.next()
			token = TokenChar
		case '.': //start with . can maybe operator
			char = s.next()
			if isDecimal(char) {
				char, token = s.scanNumber(char, true)
			} else {
				char, token = s.scanOperators(char)
			}
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
				char, token = s.scanOperators(char)
			}
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
			}

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
			s.error("unexpected: " + string(char))
		default:
			if IsOperator(char) {
				char = s.next()
				char, token = s.scanOperators(char)
			} else {
				// invalid
				s.error("invalid token")
				char = s.next()
			}
		}
	}

	// end of token text
	s.tokenEnd = s.srcPos - s.lastCharLen

	s.char = char
	return token
}

// Pos return position info of scanner
func (s *Scanner) Pos() (pos Position) {
	pos.Filename = s.Filename
	pos.Offset = s.srcBufOffset + s.srcPos - s.lastCharLen
	switch {
	case s.column > InvalidColumn:
		// common case: last character was not a '\n'
		pos.Line = s.line
		pos.Column = s.column
	case s.lastLineLen > 0:
		// last character was a '\n'
		pos.Line = s.line - 1
		pos.Column = s.lastLineLen
	default:
		// at the beginning of the source
		pos.Line = 1
		pos.Column = 1
	}
	return
}

// Token returns the string corresponding to the most recently scanned token.
// Valid after calling Scan and in calls of Scanner.Error.
func (s *Scanner) Token() string {
	if s.tokenPos < 0 {
		// no token text
		return ""
	}
	if s.tokenEnd < s.tokenPos {
		// if EOF was reached, s.tokenEnd is set to -1 (s.srcPos == 0)
		s.tokenEnd = s.tokenPos
	}
	// s.tokenEnd >= s.tokenPos
	if s.tokenBuf.Len() == 0 {
		// common case: the entire token text is still in srcBuf
		return string(s.srcBuf[s.tokenPos:s.tokenEnd])
	}
	// part of the token text was saved in tokenBuf: save the rest in
	// tokenBuf as well and return its content
	s.tokenBuf.Write(s.srcBuf[s.tokenPos:s.tokenEnd])
	s.tokenPos = s.tokenEnd // ensure idempotency of Token() call
	return s.tokenBuf.String()
}

func (s *Scanner) currentToken() string {
	end := s.tokenEnd
	s.tokenEnd = s.srcPos - s.lastCharLen
	token := s.Token()
	s.tokenEnd = end
	return token
}
