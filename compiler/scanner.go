package compiler

import (
	"bytes"
	"fmt"
	"io"
	"os"
	"unicode/utf8"
)

//TO-DO implement conditional compiler //trade it as comment

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

const (
	EOFChar     = -1
	InvalidChar = -2
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

func TokenToString(token Type) string {
	return tokenString[token]
}

const bufLen = 1024 // at least utf8.UTFMax

// A Scanner implements reading of Unicode characters and tokens from an io.Reader.
type Scanner struct {
	// Input
	src io.Reader

	srcBuf [bufLen + 1]byte // +1 for sentinel for common case of s.next()
	srcPos int              // reading position (srcBuf index)
	srcEnd int              // source end (srcBuf index)

	srcBufOffset int // byte offset of srcBuf[0] in source
	line         int // line count
	column       int // character count
	lastLineLen  int // length of last line in characters (for correct column reporting)
	lastCharLen  int // length of last character in bytes

	tokenBuf bytes.Buffer // token text head that is not in srcBuf anymore
	tokenPos int          // token text tail position (srcBuf index); valid if >= 0
	tokenEnd int          // token text tail end (srcBuf index)

	char rune // character before current srcPos

	skipComment         bool
	flags               map[string]bool
	startedPreprocessor int

	Error      func(s *Scanner, msg string)
	ErrorCount int

	Position
}

func (s *Scanner) Init(src io.Reader, skipComment bool, flags []string) *Scanner {
	s.skipComment = skipComment
	s.flags = make(map[string]bool)
	for _, v := range flags {
		s.flags[v] = true
	}

	s.src = src
	s.srcBuf[0] = utf8.RuneSelf // sentinel
	s.srcPos = 0
	s.srcEnd = 0

	// initialize source position
	s.srcBufOffset = 0
	s.line = 1
	s.column = 0
	s.lastLineLen = 0
	s.lastCharLen = 0

	s.tokenPos = -1

	// initialize one character look-ahead
	s.char = InvalidChar // no char read yet, not EOF

	// initialize public fields
	s.Error = nil
	s.ErrorCount = 0
	s.Line = 0 // invalidate token position

	return s
}

func (s *Scanner) next() rune {
	char, width := rune(s.srcBuf[s.srcPos]), 1
	// scan utf8 char // TO-DO, check it later
	if char >= utf8.RuneSelf {
		for s.srcPos+utf8.UTFMax > s.srcEnd && !utf8.FullRune(s.srcBuf[s.srcPos:s.srcEnd]) {
			if s.tokenPos >= 0 {
				s.tokenBuf.Write(s.srcBuf[s.tokenPos:s.srcPos])
				s.tokenPos = 0
				// s.tokenEnd is set by Scan()
			}
			// move unread bytes to beginning of buffer
			copy(s.srcBuf[0:], s.srcBuf[s.srcPos:s.srcEnd])
			s.srcBufOffset += s.srcPos
			i := s.srcEnd - s.srcPos
			n, err := s.src.Read(s.srcBuf[i:bufLen])
			s.srcPos = 0
			s.srcEnd = i + n
			s.srcBuf[s.srcEnd] = utf8.RuneSelf // sentinel
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
				break
			}
		}
		// at least one byte
		char = rune(s.srcBuf[s.srcPos])
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
	}

	// advance
	s.srcPos += width
	s.lastCharLen = width
	s.column++

	// special situations
	switch char {
	case 0:
		// for compatibility with other tools
		s.error("invalid character NUL")
	case '\n':
		s.line++
		s.lastLineLen = s.column
		s.column = 0
	}

	return char
}

func (s *Scanner) Next() rune {
	s.tokenPos = -1 // don't collect token text
	s.Line = 0      // invalidate token position
	char := s.Peek()
	if char != EOFChar {
		s.char = s.next()
	}
	return char
}

func (s *Scanner) Peek() rune {
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

func (s *Scanner) errorf(format string, args ...interface{}) {
	s.error(fmt.Sprintf(format, args...))
}

func (s *Scanner) isIdentifierRune(char rune, i int) bool {
	return char == '_' || s.isLetter(char) || (s.isDigit(char) && i > 0)
}

func (s *Scanner) isLetter(char rune) bool {
	return ('a' <= char && char <= 'z') || ('A' <= char && char <= 'Z')
}

func (s *Scanner) isDigit(char rune) bool {
	return '0' <= char && char <= '9'
}

func (s *Scanner) scanIdentifier() rune {
	// we know the zero'th rune is OK; start scanning at the next one
	char := s.next()
	for i := 1; s.isIdentifierRune(char, i); i++ {
		char = s.next()
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
	if !s.isIdentifierRune(char, 0) {
		s.error("unexpected " + string(char))
	}
	for i := 1; s.isIdentifierRune(char, i); i++ {
		char = s.next()
	}
	if char != '\n' {
		s.error("unexpected " + string(char))
	}
	result := false
	s.tokenEnd = s.srcPos - s.lastCharLen
	if _, ok := s.flags[s.TokenText()]; ok {
		result = true
	}
	if notOp {
		result = !result
	}
	return char, result
}

func (s *Scanner) skipPreprossesor() {
	startedPreprossesor := s.startedPreprocessor
	for s.startedPreprocessor >= startedPreprossesor {
		s.scanString('#')
		char := s.next()
		if s.isIdentifierRune(char, 0) {
			char = s.scanIdentifier()
			s.tokenEnd = s.srcPos - s.lastCharLen
			text := s.TokenText()
			if text == "#if" {
				s.startedPreprocessor++
			} else if text == "#end" {
				s.startedPreprocessor--
			} else if text != "#elif" {
				s.error("unexpected: " + text)
			}
		} else {
			s.error("unexpected: " + string(char))
		}
	}
}

func (s *Scanner) digits(char0 rune, base int, invalid *rune) rune {
	char := char0
	if base <= 10 {
		max := rune('0' + base)
		for isDecimal(char) {
			if char >= max && *invalid == 0 {
				*invalid = char
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

func (s *Scanner) scanNumber(char rune, seenDot bool) (Type, rune) {
	base := 10         // number base
	prefix := rune(0)  // one of 0 (decimal), '0' (0-octal), 'x', 'o', or 'b'
	invalid := rune(0) // invalid digit in literal, or 0

	// integer part
	var token Type
	if !seenDot {
		token = TypeInt
		if char == '0' {
			char = s.next()
			switch lower(char) {
			case 'x':
				char = s.next()
				base, prefix = 16, 'x'
			case 'o':
				char = s.next()
				base, prefix = 8, 'o'
			case 'b':
				char = s.next()
				base, prefix = 2, 'b'
			default:
				base, prefix = 8, '0'
			}
		}
		char = s.digits(char, base, &invalid)
		if char == '.' {
			char = s.next()
			seenDot = true
		}
	}

	// fractional part
	if seenDot {
		token = TypeFloat
		if prefix == 'o' || prefix == 'b' {
			s.error("invalid radix point in " + literalNumberName(prefix))
		}
		char = s.digits(char, base, &invalid)
	}

	// exponent
	if e := lower(char); e == 'e' {
		if prefix != 0 && prefix != '0' {
			s.errorf("%q exponent requires decimal mantissa", char)
		}
		char = s.next()
		token = TypeFloat
		if char == '+' || char == '-' {
			char = s.next()
		}
		char = s.digits(char, 10, nil)
	} else if prefix == 'x' && token == TypeFloat {
		s.error("hexadecimal mantissa requires a 'p' exponent")
	}

	if token == TypeInt && invalid != 0 {
		s.errorf("invalid digit %q in %s", invalid, literalNumberName(prefix))
	}

	s.tokenEnd = s.srcPos - s.lastCharLen
	return token, char
}

func literalNumberName(prefix rune) string {
	switch prefix {
	default:
		return "decimal literal"
	case 'x':
		return "hexadecimal literal"
	case 'o', '0':
		return "octal literal"
	case 'b':
		return "binary literal"
	}
}

func digitVal(char rune) int {
	switch {
	case '0' <= char && char <= '9':
		return int(char - '0')
	case 'a' <= lower(char) && lower(char) <= 'f':
		return int(lower(char) - 'a' + 10)
	}
	return 16 // larger than any legal digit val
}

func (s *Scanner) scanDigits(char rune, base, n int) rune {
	for n > 0 && digitVal(char) < base {
		char = s.next()
		n--
	}
	if n > 0 {
		s.error("invalid char escape")
	}
	return char
}

func (s *Scanner) scanEscape(quote rune) rune {
	//TO-DO check out it later
	char := s.next() // read character after '/'
	switch char {
	case 'a', 'b', 'f', 'n', 'r', 't', 'v', '\\', quote:
		// nothing to do
		char = s.next()
	case '0', '1', '2', '3', '4', '5', '6', '7':
		char = s.scanDigits(char, 8, 3)
	case 'x':
		char = s.scanDigits(s.next(), 16, 2)
	case 'u':
		char = s.scanDigits(s.next(), 16, 4)
	case 'U':
		char = s.scanDigits(s.next(), 16, 8)
	default:
		s.error("invalid char escape")
	}
	return char
}

func (s *Scanner) scanString(quote rune) (n int) {
	char := s.next() // read character after quote
	for char != quote {
		if char == '\n' || char < 0 {
			s.error("string not terminated")
			return
		}
		if char == '\\' {
			char = s.scanEscape(quote)
		} else {
			char = s.next()
		}
		n++
	}
	return
}

func (s *Scanner) scanRawString() rune {
	char := s.next() // read character after '@("'
	for {
		if char < 0 {
			s.error("raw string not terminated")
			break
		}
		char0 := char
		char = s.next()
		if char0 == '"' && char == ')' {
			char = s.next()
			break
		}
	}
	return char
}

func (s *Scanner) scanChar() {
	if s.scanString('\'') != 1 {
		s.error("invalid char literal")
	}
}

func (s *Scanner) scanOperators() rune {
	char := s.Peek()
	str := string(char)
	for HasToken(str) {
		char = s.next()
		str += string(char)
	}
	return char
}

//TO-DO scan operators

func (s *Scanner) scanComment(char rune) rune {
	// char == '/' || char == '*'
	if char == '/' {
		// line comment
		char = s.next() // read character after "//"
		for char != '\n' && char >= 0 {
			char = s.next()
		}
		return char
	}

	// general comment
	char = s.next() // read character after "/*"
	for {
		if char < 0 {
			s.error("comment not terminated")
			break
		}
		char0 := char
		char = s.next()
		if char0 == '*' && char == '/' {
			char = s.next()
			break
		}
	}
	return char
}

func (s *Scanner) Scan() Type {
	char := s.Peek()

	// reset token text position
	s.tokenPos = -1
	s.Line = 0

redo:
	for char == ' ' || char == '\t' || char == '\r' {
		char = s.next()
	}
	s.tokenBuf.Reset()
	s.tokenPos = s.srcPos - s.lastCharLen
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

		s.tokenEnd = s.srcPos - s.lastCharLen
		if HasToken(s.TokenText()) {
			token = TypeToken
		}
	case isDecimal(char):
		token, char = s.scanNumber(char, false)
	default:
		switch char {
		case EOFChar:
			token = TypeEOF
			if s.startedPreprocessor != 0 {
				s.error("preprocessor not terminated")
			}
			break
		case '"':
			s.scanString('"')
			char = s.next()
			token = TypeString
		case '\'':
			s.scanChar()
			token = TypeChar
		case '.': //start with .
			char = s.next()
			if isDecimal(char) {
				token, char = s.scanNumber(char, true)
			} else {
				token = TypeToken
				char = s.scanOperators()
			}
		case '/':
			char = s.next()
			if char == '/' || char == '*' {
				if s.skipComment {
					s.tokenPos = -1 // don't collect token text
					char = s.scanComment(char)
					goto redo
				}
				char = s.scanComment(char)
				token = TypeComment
			}
		case '@':
			char = s.next()
			if char == '(' {
				char = s.next()
				if char == '"' {
					char = s.scanRawString()
					token = TypeRawString
				}
			} else if s.isIdentifierRune(char, 0) {
				token = TypeMetaIdentifier
				char = s.scanIdentifier()
			}
		case '#': //#if #elif #else #end
			char = s.next()
			if s.isIdentifierRune(char, 0) {
				char = s.scanIdentifier()
				s.tokenEnd = s.srcPos - s.lastCharLen
				text := s.TokenText()
				if text == "#if" {
					s.startedPreprocessor++
				} else if text == "#end" {
					s.startedPreprocessor--
				} else if text != "#elif" {
					s.error("unexpected: " + text)
				}

				if text == "#if" || text == "#elif" {
					result := false
					char, result = s.scanPreprossesor()
					if !result {
						s.skipPreprossesor()
						char = s.next()
					}
				}
				s.tokenPos = -1
				goto redo
			} else {
				s.error("unexpected: " + string(char))
			}
		case '\n':
			char = s.next()
			token = TypeNewLine
		default:
			if IsOperator(char) {
				token = TypeToken
				char = s.scanOperators()
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
	case s.column > 0:
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

// TokenText returns the string corresponding to the most recently scanned token.
// Valid after calling Scan and in calls of Scanner.Error.
func (s *Scanner) TokenText() string {
	if s.tokenPos < 0 {
		// no token text
		return ""
	}

	if s.tokenEnd < s.tokenPos {
		// if EOF was reached, s.tokEnd is set to -1 (s.srcPos == 0)
		s.tokenEnd = s.tokenPos
	}
	// s.tokEnd >= s.tokPos

	if s.tokenBuf.Len() == 0 {
		// common case: the entire token text is still in srcBuf
		return string(s.srcBuf[s.tokenPos:s.tokenEnd])
	}

	// part of the token text was saved in tokBuf: save the rest in
	// tokBuf as well and return its content
	s.tokenBuf.Write(s.srcBuf[s.tokenPos:s.tokenEnd])
	s.tokenPos = s.tokenEnd // ensure idempotency of TokenText() call
	return s.tokenBuf.String()
}

func lower(char rune) rune     { return ('a' - 'A') | char } // returns lower-case ch iff ch is ASCII letter
func isDecimal(char rune) bool { return '0' <= char && char <= '9' }
func isHex(char rune) bool {
	return '0' <= char && char <= '9' || 'a' <= lower(char) && lower(char) <= 'f'
}
