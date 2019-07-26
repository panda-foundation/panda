package compiler

import (
	"fmt"
	"io"
	"sort"
	"unicode"
	"unicode/utf8"
)

const (
	bom = 0xFEFF // byte order mark, only permitted as very first character
	eof = -1
)

type ErrorHandler func(position Position, msg string)

type Scanner struct {
	file *File
	dir  string
	src  []byte

	err        ErrorHandler
	ErrorCount int // total errors

	scanComments bool
	flags        map[string]bool // flags for condition compiler
	flagStarted  bool            // if #if is true

	char       rune
	offset     int
	readOffset int
	lineOffset int
}

// Init scanner
func (s *Scanner) Init(file *File, src []byte, err ErrorHandler, scanComment bool, flags []string) *Scanner {
	scanner := &Scanner{}

	//if file.size != len(src) {
	//panic(fmt.Sprintf("file size (%d) does not match src len (%d)", file.size, len(src)))
	//}
	scanner.file = file
	scanner.src = src
	scanner.err = err
	scanner.scanComments = scanComment
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
	fmt.Println("error:", msg)
	if s.err != nil {
		//s.err(s.file.Position(s.file.Pos(offset)), msg)
	}
	s.ErrorCount++
}

func (s *Scanner) scanComment() string {
	// initial '/' already consumed
	offset := s.offset - 1 // position of initial '/'

	if s.char == '/' {
		//-style comment
		s.next()
		for s.char != '\n' && s.char >= 0 {
			s.next()
		}
	} else {
		/*-style comment */
		terminated := false
		s.next()
		for s.char >= 0 {
			char := s.char
			s.next()
			if char == '*' && s.char == '/' {
				s.next()
				terminated = true
				break
			}
		}
		if !terminated {
			s.error(offset, "comment not terminated")
		}
	}
	return string(s.src[offset:s.offset])
}

func (s *Scanner) scanIdentifier() string {
	offset := s.offset
	for s.isLetter(s.char) || s.isDecimal(s.char) {
		s.next()
	}
	return string(s.src[offset:s.offset])
}

func (s *Scanner) scanDigits(base int) {
	for s.digitVal(s.char) < base {
		s.next()
	}
}

func (s *Scanner) scanNumber() (Token, string) {
	offset := s.offset
	token := INT

	if s.char != '.' {
		if s.char == '0' {
			s.next()
			if s.char != '.' {
				base := 10
				switch s.lower(s.char) {
				case 'x':
					base = 16
				case 'b':
					base = 2
				case 'o':
					base = 8
				default:
					s.error(offset, "invalid integer")
					token = ILLEGAL
				}
				if token != ILLEGAL {
					s.next()
					s.scanDigits(base)
					if s.offset-offset <= 2 {
						// only scanned "0x" or "0X"
						token = ILLEGAL
						s.error(offset, "illegal number")
					}
					if s.char == '.' {
						token = ILLEGAL
						s.error(offset, "invalid radix point")
					}
				}
			}
		} else {
			s.scanDigits(10)
		}
	}

	if s.char == '.' {
		offsetFraction := s.offset
		token = FLOAT
		s.next()
		s.scanDigits(10)
		if offsetFraction == s.offset-1 {
			token = ILLEGAL
			s.error(offset, "float has no digits after .")
		}
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
			switch s.char {
			case 'a', 'b', 'f', 'n', 'r', 't', 'v', '\\', '\'':
				s.next()
			default:
				s.error(offset, "illegal char literal")
				valid = false
			}
		}
	}

	if valid && n != 1 {
		s.error(offset, "illegal char literal")
	}

	return string(s.src[offset:s.offset])
}

func (s *Scanner) scanRawString() string {
	// '`' opening already consumed
	offset := s.offset - 1
	for {
		char := s.char
		if char < 0 {
			s.error(offset, "raw string literal not terminated")
			break
		}
		s.next()
		if char == '`' {
			break
		}
	}
	return string(s.src[offset:s.offset])
}

func (s *Scanner) scanOperators() (token Token, literal string) {
	offset := s.offset - 1
	length := 0
	token, length = ReadOperator(s.src[offset:])
	if length > 0 {
		for i := 1; i < length; i++ {
			s.next()
		}
		literal = string(s.src[offset:s.offset])
	}
	return
}

func (s *Scanner) scanPreprossesor() bool {
	// skip whitespace but not newline
	for s.char == ' ' || s.char == '\t' {
		s.next()
	}

	notOp := false
	if s.char == '!' {
		notOp = true
		s.next()
	}

	if s.isLetter(s.char) {
		flag := s.scanIdentifier()

		for s.char == ' ' || s.char == '\t' || s.char == '\r' {
			s.next()
		}
		if s.char != '\n' {
			s.error(s.offset, "unexpected: "+string(s.char))
		}

		result := false
		if _, ok := s.flags[flag]; ok {
			result = true
		}
		if notOp {
			result = !result
		}
		return result
	}

	s.error(s.offset, "#if not terminated")
	return false
}

func (s *Scanner) skipPreprossesor() {
	for s.char != '#' {
		s.next()
	}
	s.next()
	if s.isLetter(s.char) {
		literal := s.scanIdentifier()
		if literal != "end" {
			s.error(s.offset, "unexpected: "+literal)
		}
	} else {
		s.error(s.offset, "unexpected: "+string(s.char))
	}
}

func (s *Scanner) isLetter(char rune) bool {
	return char == '_' || 'a' <= char && char <= 'z' || 'A' <= char && char <= 'Z'
}

func (s *Scanner) isDecimal(char rune) bool {
	return '0' <= char && char <= '9'
}

// returns lower-case char if char is ASCII letter
// use 0b00100000 instead 'a' - 'A' later in panda own compiler
func (s *Scanner) lower(char rune) rune {
	return ('a' - 'A') | char
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
	for s.char == ' ' || s.char == '\t' || s.char == '\n' || s.char == '\r' {
		s.next()
	}

	//pos = s.file.Pos(s.offset)

	token = ILLEGAL
	if s.isLetter(s.char) {
		literal = s.scanIdentifier()
		token = GetToken(literal)
	} else if s.isDecimal(s.char) || (s.char == '.' && s.isDecimal(rune(s.peek()))) {
		token, literal = s.scanNumber()
	} else {
		char := s.char
		s.next()
		switch char {
		case eof:
			token = EOF
			if s.flagStarted {
				s.error(s.offset, "#if not terminated, expecting #end")
			}
		case '"':
			token = STRING
			literal = s.scanString()
		case '`':
			token = STRING
			literal = s.scanRawString()
		case '\'':
			token = CHAR
			literal = s.scanChar()
		case '/': // alse maybe operator /
			if s.char == '/' || s.char == '*' {
				literal = s.scanComment()
				if !s.scanComments {
					return s.Scan()
				}
				token = COMMENT
			} else {
				token, literal = s.scanOperators()
			}
		case '@':
			if s.isLetter(s.char) {
				token = META
				literal = s.scanIdentifier()
			} else {
				s.error(s.offset, "invalid meta name")
			}
		case '#':
			//#if #end, flag can add '!' for not operation
			//nested # is not supported
			//#else is not supported
			if s.char == 'i' || s.char == 'e' {
				literal = s.scanIdentifier()

				if literal == "if" {
					if s.flagStarted {
						s.error(s.offset, "unexpected #if")
					}
					s.flagStarted = true

					result := s.scanPreprossesor()

					if !result {
						s.skipPreprossesor()
						s.flagStarted = false
					}
				} else if literal == "end" {
					if !s.flagStarted {
						s.error(s.offset, "unexpected #end")
					}
					s.flagStarted = false
				} else {
					s.error(s.offset, "unexpected: "+literal)
				}
				return s.Scan()
			} else {
				s.error(s.offset, "unexpected: "+string(s.char))
			}
		default:
			token, literal = s.scanOperators()
			if token == ILLEGAL {
				s.error(s.offset, "invalid token")
				s.next()
			}
		}
	}
	return
}

// In an ErrorList, an error is represented by an *Error.
// The position Pos, if valid, points to the beginning of
// the offending token, and the error condition is described
// by Msg.
//
type Error struct {
	Pos Position
	Msg string
}

// Error implements the error interface.
func (e Error) Error() string {
	if e.Pos.Filename != "" || e.Pos.IsValid() {
		// don't print "<unknown position>"
		// TODO(gri) reconsider the semantics of Position.IsValid
		return e.Pos.String() + ": " + e.Msg
	}
	return e.Msg
}

// ErrorList is a list of *Errors.
// The zero value for an ErrorList is an empty ErrorList ready to use.
//
type ErrorList []*Error

// Add adds an Error with given position and error message to an ErrorList.
func (p *ErrorList) Add(pos Position, msg string) {
	*p = append(*p, &Error{pos, msg})
}

// Reset resets an ErrorList to no errors.
func (p *ErrorList) Reset() { *p = (*p)[0:0] }

// ErrorList implements the sort Interface.
func (p ErrorList) Len() int      { return len(p) }
func (p ErrorList) Swap(i, j int) { p[i], p[j] = p[j], p[i] }

func (p ErrorList) Less(i, j int) bool {
	e := &p[i].Pos
	f := &p[j].Pos
	// Note that it is not sufficient to simply compare file offsets because
	// the offsets do not reflect modified line information (through //line
	// comments).
	if e.Filename != f.Filename {
		return e.Filename < f.Filename
	}
	if e.Line != f.Line {
		return e.Line < f.Line
	}
	if e.Column != f.Column {
		return e.Column < f.Column
	}
	return p[i].Msg < p[j].Msg
}

// Sort sorts an ErrorList. *Error entries are sorted by position,
// other errors are sorted by error message, and before any *Error
// entry.
//
func (p ErrorList) Sort() {
	sort.Sort(p)
}

// RemoveMultiples sorts an ErrorList and removes all but the first error per line.
func (p *ErrorList) RemoveMultiples() {
	sort.Sort(p)
	var last Position // initial last.Line is != any legal error line
	i := 0
	for _, e := range *p {
		if e.Pos.Filename != last.Filename || e.Pos.Line != last.Line {
			last = e.Pos
			(*p)[i] = e
			i++
		}
	}
	(*p) = (*p)[0:i]
}

// An ErrorList implements the error interface.
func (p ErrorList) Error() string {
	switch len(p) {
	case 0:
		return "no errors"
	case 1:
		return p[0].Error()
	}
	return fmt.Sprintf("%s (and %d more errors)", p[0], len(p)-1)
}

// Err returns an error equivalent to this error list.
// If the list is empty, Err returns nil.
func (p ErrorList) Err() error {
	if len(p) == 0 {
		return nil
	}
	return p
}

// PrintError is a utility function that prints a list of errors to w,
// one error per line, if the err parameter is an ErrorList. Otherwise
// it prints the err string.
//
func PrintError(w io.Writer, err error) {
	if list, ok := err.(ErrorList); ok {
		for _, e := range list {
			fmt.Fprintf(w, "%s\n", e)
		}
	} else if err != nil {
		fmt.Fprintf(w, "%s\n", err)
	}
}
