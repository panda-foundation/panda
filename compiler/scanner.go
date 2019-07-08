package compiler

import (
	"bytes"
	"fmt"
	"io"
	"os"
	"unicode/utf8"
)

type Position struct {
	Filename string // filename, if any
	Offset   int    // byte offset, starting at 0
	Line     int    // line number, starting at 1
	Column   int    // column number, starting at 1 (character count per line)
}

func (pos *Position) IsValid() bool { return pos.Line > 0 }

func (pos Position) String() string {
	s := pos.Filename
	if s == "" {
		s = "<input>"
	}
	if pos.IsValid() {
		s += fmt.Sprintf(":%d:%d", pos.Line, pos.Column)
	}
	return s
}

// Type for scanner
type Type rune

// Token types
const (
	TypeInvalid Type = iota
	TypeEOF
	TypeIdentifier
	TypeToken
	TypeInt
	TypeFloat
	TypeChar
	TypeString
	TypeRawString
	TypeNewLine
	TypeComment
	TypeMetaIdentifier
	TypeIgnored
)

// Const for scanner
const (
	EOFChar       rune = -1
	InvalidChar   rune = -2
	InvalidPos    int  = -1
	InvalidLine   int  = 0
	InvalidColumn int  = 0
)

var tokenString = map[Type]string{
	TypeInvalid:        "Invalid",
	TypeEOF:            "EOF",
	TypeIdentifier:     "Identifier",
	TypeToken:          "Token",
	TypeInt:            "Int",
	TypeFloat:          "Float",
	TypeChar:           "Char",
	TypeString:         "String",
	TypeRawString:      "RawString",
	TypeNewLine:        "NewLine",
	TypeComment:        "Comment",
	TypeMetaIdentifier: "MetaIdentifier",
	TypeIgnored:        "Ignored", // by conditional compile
}

// TokenType return token type
func TokenType(token Type) string {
	return tokenString[token]
}

const bufLen = 4 // 1024 // at least utf8.UTFMax // default 1024, 4 for testing

// A Scanner implements reading of Unicode characters and tokens from an io.Reader.
type Scanner struct {
	src io.Reader // Input

	srcBuf       [bufLen]byte // for input reader
	srcPos       int          // reading position (srcBuf index)
	srcEnd       int          // source end (srcBuf index)
	srcBufOffset int          // byte offset of srcBuf[0] in source

	line        int // line count
	column      int // character count
	lastLineLen int // length of last line in characters (for correct column reporting)
	lastCharLen int // length of last character in bytes

	tokenBuf bytes.Buffer // token text head that is not in srcBuf anymore, store unfinished token
	tokenPos int          // token text tail position (srcBuf index); valid if >= 0
	tokenEnd int          // token text tail end (srcBuf index)

	char rune // character before current srcPos

	skipComment      bool            // if skip to store comment info
	flags            map[string]bool // flags for condition compiler
	conditionStarted bool            // if #if is true

	Error      func(s *Scanner, msg string) // hook error function
	ErrorCount int                          // total errors

	Position
}

// NewScanner return an initialized scanner
func NewScanner(src io.Reader, skipComment bool, flags []string) *Scanner {
	s := &Scanner{}

	s.src = src
	s.srcPos = 0
	s.srcEnd = 0
	s.srcBufOffset = 0

	s.skipComment = skipComment
	s.flags = make(map[string]bool)
	for _, v := range flags {
		s.flags[v] = true
	}

	s.line = 1
	s.column = InvalidColumn
	s.lastLineLen = 0
	s.lastCharLen = 0

	s.tokenPos = InvalidPos

	s.char = InvalidChar // no char read yet, not EOF

	s.Error = nil
	s.ErrorCount = 0
	s.Line = InvalidLine // invalidate token position

	return s
}

func (s *Scanner) next() rune {
	// check if need to load some buf first
	shouldRead := s.srcPos >= s.srcEnd
	if !shouldRead {
		char := rune(s.srcBuf[s.srcPos])
		if char >= utf8.RuneSelf && s.srcPos+utf8.UTFMax > s.srcEnd && !utf8.FullRune(s.srcBuf[s.srcPos:s.srcEnd]) {
			shouldRead = true
		}
	}
	if shouldRead {
		if s.tokenPos >= 0 {
			s.tokenBuf.Write(s.srcBuf[s.tokenPos:s.srcPos])
			s.tokenPos = 0
		}
		copy(s.srcBuf[0:], s.srcBuf[s.srcPos:s.srcEnd]) // move to start
		s.srcBufOffset += s.srcPos
		length := s.srcEnd - s.srcPos // length in buf
		n, err := s.src.Read(s.srcBuf[length:bufLen])
		s.srcPos = 0
		s.srcEnd = length + n
		if err != nil {
			if err != io.EOF {
				s.error(err.Error())
			}
			if s.srcEnd == 0 {
				if s.lastCharLen > 0 {
					// previous character was not EOF
					s.column++
				}
				s.lastCharLen = 0
				return EOFChar
			}
		}
	}

	// at least one byte
	char, width := rune(s.srcBuf[s.srcPos]), 1
	if char >= utf8.RuneSelf {
		// uncommon case: not ASCII
		char, width = utf8.DecodeRune(s.srcBuf[s.srcPos:s.srcEnd])
		if char == utf8.RuneError && width == 1 {
			// advance for correct error position
			s.srcPos += width
			s.lastCharLen = width
			s.column++
			s.error("invalid UTF-8 encoding")
			return char
		}
	}

	// advance
	s.srcPos += width
	s.lastCharLen = width
	s.column++

	// special situations
	switch char {
	case 0:
		// for compatibility
		s.error("invalid character NUL")
	case '\n':
		s.line++
		s.lastLineLen = s.column
		s.column = InvalidColumn
	}

	return char
}

func (s *Scanner) peek() rune {
	if s.char == InvalidChar {
		s.char = s.next()
		if s.char == '\uFEFF' {
			s.char = s.next()
		}
	}
	return s.char
}

func (s *Scanner) error(msg string) {
	s.tokenEnd = s.srcPos - s.lastCharLen // make sure token text is terminated
	s.ErrorCount++
	if s.Error != nil {
		s.Error(s, msg)
		return
	}
	pos := s.Position
	if !pos.IsValid() {
		pos = s.Pos()
	}
	fmt.Fprintf(os.Stderr, "%s: %s\n", pos, msg)
}

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

func (s *Scanner) scanNumber(char rune, seenDot bool) (rune, Type) {
	base := 10        // number base
	prefix := rune(0) // one of 0 (decimal), '0' (0-octal), 'x', or 'b'

	// integer part
	var numberType Type
	if !seenDot {
		numberType = TypeInt
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
		numberType = TypeFloat
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

func (s *Scanner) scanOperators(char rune) rune {
	// TO-DO optimization later with tree, and opt info stored in scanner
	for HasToken(s.currentToken() + string(char)) {
		char = s.next()
	}
	return char
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
	s.scanUntil('#')
	char := s.next()
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
func (s *Scanner) Scan() Type {
	// reset token text position
	s.tokenPos = InvalidPos
	s.Line = 0

	char := s.peek()
	// whitespace
	for char == ' ' || char == '\t' || char == '\r' {
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
	token := TypeInvalid
	switch {
	case s.isIdentifierRune(char, 0):
		token = TypeIdentifier
		char = s.scanIdentifier()
		if HasToken(s.currentToken()) {
			token = TypeToken
		}
	case isDecimal(char):
		char, token = s.scanNumber(char, false)
	default:
		switch char {
		case EOFChar:
			token = TypeEOF
			if s.conditionStarted {
				s.error("#if not terminated, expecting #end")
			}
			break
		case '"':
			s.scanString('"')
			char = s.next()
			token = TypeString
		case '\'':
			s.scanChar()
			char = s.next()
			token = TypeChar
		case '.': //start with . can maybe operator
			char = s.next()
			if isDecimal(char) {
				char, token = s.scanNumber(char, true)
			} else {
				token = TypeToken
				char = s.scanOperators(char)
			}
		case '/': // alse maybe operator /
			char = s.next()
			if char == '/' || char == '*' {
				if char == '/' {
					char = s.scanLineComment()
				} else {
					char = s.scanBlockComment()
				}
				char = s.next()
				if s.skipComment {
					s.char = char
					return s.Scan()
				}
				token = TypeComment
			} else {
				token = TypeToken
				char = s.scanOperators(char)
			}
		case '@':
			char = s.next()
			if char == '(' {
				isRawString := false
				char, isRawString = s.ensureChar('"')
				if isRawString {
					s.scanRawString()
					token = TypeRawString
					char = s.next()
				} else {
					s.error(fmt.Sprintf("unexpected: %s", string(char)))
				}
			} else if s.isIdentifierRune(char, 0) {
				token = TypeMetaIdentifier
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
		case '\n':
			char = s.next()
			token = TypeNewLine
		default:
			if IsOperator(char) {
				token = TypeToken
				char = s.next()
				char = s.scanOperators(char)
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
