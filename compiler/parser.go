package compiler

import "fmt"

type TokenData struct {
	Type Token
	Text string
}

type Parser struct {
	Scanner *Scanner
	Program *ProgramUnit

	Token     Token
	Modifiers []Token

	InClass    bool
	InFunction bool
	InEnum     bool

	Comments []string
}

func NewParser() *Parser {
	return &Parser{}
}

func (parser *Parser) Parse(scanner *Scanner) {
	parser.Scanner = scanner
	parser.Program = &ProgramUnit{}

	parser.parseNamespace()
	parser.parseIncludes()
	parser.parseDefinitions()
}

// return the first cached token
func (parser *Parser) peek() Token {
	if parser.Token == TokenInvalid {
		parser.Token = parser.Scanner.Scan()
	}
	return parser.Token
}

func (parser *Parser) consume() {
	parser.Token = TokenInvalid
}

func (parser *Parser) ensure(token Token) {
	if parser.peek() != token {
		err := fmt.Sprintf("unexpected %s: %s, expecte: %s \n", parser.Scanner.Position, parser.Scanner.Token(), TokenToKey(token))
		parser.Scanner.error(err)
	}
	parser.consume()
}

func (parser *Parser) isModifier(token Token) bool {
	return token == Private || token == Protected || token == Public ||
		token == Static || token == Const
}

func (parser *Parser) isAccessModifier(token Token) bool {
	return token == Private || token == Protected || token == Public
}

func (parser *Parser) scanComments(store bool) {
	if parser.Scanner.skipComment {
		return
	}
	parser.Comments = parser.Comments[:0]
	for parser.peek() == TokenComment {
		if store {
			parser.Comments = append(parser.Comments, parser.Scanner.Token())
		}
		parser.consume()
	}
}

func (parser *Parser) parseNamespace() {
	parser.scanComments(false)
	if parser.peek() == Namespace {
		parser.consume()
		if parser.peek() != Semi {
			parser.Program.Namespace = parser.parseQualifiedId(false)
		}
		parser.ensure(Semi)
		fmt.Println("namespace:", parser.Program.Namespace)
	}
}

func (parser *Parser) parseIncludes() {
	for {
		parser.scanComments(false)
		if parser.peek() == Include {
			parser.consume()
			text := parser.parseQualifiedId(true)
			parser.Program.Includes = append(parser.Program.Includes, text)
			fmt.Println("include:", text)
			parser.ensure(Semi)
		} else {
			break
		}
	}
}

func (parser *Parser) parseModifiers() {
	parser.Modifiers = parser.Modifiers[:0]
	for {
		if parser.isModifier(parser.peek()) {
			if parser.peek() == Static {
				if !parser.InClass {
					parser.Scanner.error("unexpected static")
				}
			}
			for _, v := range parser.Modifiers {
				if v == parser.peek() {
					parser.Scanner.error("dupilicate modifier: " + TokenToKey(parser.peek()))
				}
				if parser.isAccessModifier(parser.peek()) && parser.isAccessModifier(v) {
					parser.Scanner.error("dupilicate access modifier: " + TokenToKey(parser.peek()))
				}
			}
			parser.Modifiers = append(parser.Modifiers, parser.peek())
			parser.consume()
		} else {
			break
		}
	}
	fmt.Println("modifiers:", parser.Modifiers)
}

func (parser *Parser) parseQualifiedId(allowStar bool) string {
	id := ""
	for {
		if parser.peek() == TokenIdentifier {
			id += parser.Scanner.Token()
			parser.consume()
			if parser.peek() == Dot {
				id += parser.Scanner.Token()
				parser.consume()
				if allowStar && parser.peek() == Star {
					id += parser.Scanner.Token()
					parser.consume()
					break
				}
			} else {
				break
			}
		} else {
			parser.Scanner.error("invalid qualified id, unexpected: " + parser.Scanner.Token())
			break
		}
	}
	return id
}

func (parser *Parser) parseDefinitions() {
	parser.parseModifiers()

	switch parser.peek() {
	case Class:
	case Enum:
	case TokenIdentifier:
	}

}

func (parser *Parser) parseClassMember() {

}

func (parser *Parser) parseDelaration() {

}

func (parser *Parser) parseFunction() {

}
