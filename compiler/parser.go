package compiler

import "fmt"

type TokenData struct {
	Type Type
	Text string
}

type Parser struct {
	Scanner *Scanner
	Cache   []*TokenData

	Program *ProgramUnit
}

func NewParser() *Parser {
	return &Parser{}
}

/*
	for token := s.Scan(); token != compiler.TypeEOF; token = s.Scan() {
		if s.ErrorCount > 0 {
			break
		}
		fmt.Printf("type %s %s: %s \n", compiler.TokenType(token), s.Position, s.Token())
	}
*/

//TO-DO return error
func (parser *Parser) Parse(scanner *Scanner) {
	parser.Scanner = scanner
	parser.Program = &ProgramUnit{}

	parser.parseNamespace()
}

// return the first cached token
func (parser *Parser) peek() *TokenData {
	if len(parser.Cache) == 0 {
		token := parser.next()
		if token != nil {
			parser.Cache = append(parser.Cache, token)
		} else {
			return nil
		}
	}
	return parser.Cache[0]
}

func (parser *Parser) next() *TokenData {
	tokenType := parser.Scanner.Scan()
	if parser.Scanner.ErrorCount > 0 {
		//TO-DO will stop parse
		fmt.Printf("type %s %s: %s \n", TokenType(tokenType), parser.Scanner.Position, parser.Scanner.Token())
		return nil
	}
	token := &TokenData{
		Type: tokenType,
	}
	if tokenType != TypeEOF {
		token.Text = parser.Scanner.Token()
	}
	return token

}

func (parser *Parser) consume() {
	parser.Cache = parser.Cache[1:]
}

func (parser *Parser) parseNamespace() {
	fmt.Println("parse namespace")
	token := parser.peek()
	if token.Type == TypeToken && token.Text == TokenToKey(Namespace) {
		parser.Program.Namespace = "to be parsed"
		parser.consume()
		//TO-DO parse namespace content
		fmt.Println("to parse namespace")
	}
}
