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
func (parser *Parser) peek() {
	if parser.Token == TokenInvalid {
		parser.Token = parser.Scanner.Scan()
	}
}

func (parser *Parser) consume() {
	parser.Token = TokenInvalid
}

func (parser *Parser) ensure(token Token) {
	parser.peek()
	if parser.Token != token {
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

func (parser *Parser) parseNamespace() {
	parser.peek()
	if parser.Token == Namespace {
		parser.consume()
		parser.peek()
		if parser.Token != Semi {
			parser.Program.Namespace = parser.parseQualifiedId(false)
		}
		parser.ensure(Semi)
		fmt.Println("namespace:", parser.Program.Namespace)
	}
}

func (parser *Parser) parseIncludes() {
	for {
		parser.peek()
		if parser.Token == Include {
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
		parser.peek()
		if parser.isModifier(parser.Token) {
			if parser.Token == Static {
				if !parser.InClass {
					parser.Scanner.error("unexpected static")
				}
			}
			for _, v := range parser.Modifiers {
				if v == parser.Token {
					parser.Scanner.error("dupilicate modifier: " + TokenToKey(parser.Token))
				}
				if parser.isAccessModifier(parser.Token) && parser.isAccessModifier(v) {
					parser.Scanner.error("dupilicate access modifier: " + TokenToKey(parser.Token))
				}
			}
			parser.Modifiers = append(parser.Modifiers, parser.Token)
			parser.consume()
		} else {
			break
		}
	}
	fmt.Println("modifiers:", parser.Modifiers)
}

func (parser *Parser) parseQualifiedId(allowStar bool) string {
	parser.peek()
	id := ""
	for {
		if parser.Token == TokenIdentifier {
			id += parser.Scanner.Token()
			parser.consume()
			parser.peek()
			if parser.Token == Dot {
				id += parser.Scanner.Token()
				parser.consume()
				parser.peek()
				if allowStar && parser.Token == Star {
					id += parser.Scanner.Token()
					parser.consume()
					parser.peek()
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
}

func (parser *Parser) parseClassMember() {

}

func (parser *Parser) parseDelaration() {

}

func (parser *Parser) parseFunction() {

}
