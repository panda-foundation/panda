package compiler

import "fmt"

type TokenData struct {
	Type Token
	Text string
}

type Type struct {
	Scalar      Token
	QualifiedId string
	//TO-DO generic
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
	parser.parseDeclarations()
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

func (parser *Parser) parseComments() {
	if parser.Scanner.skipComment {
		return
	}
	parser.clearComments()
	for parser.peek() == TokenComment {
		parser.Comments = append(parser.Comments, parser.Scanner.Token())
		parser.consume()
	}
}

func (parser *Parser) skipComments() {
	if parser.Scanner.skipComment {
		return
	}
	for parser.peek() == TokenComment {
		parser.consume()
	}
}

func (parser *Parser) clearComments() {
	if parser.Scanner.skipComment {
		return
	}
	parser.Comments = parser.Comments[:0]
}

func (parser *Parser) getComments() []string {
	var comments []string
	if parser.Scanner.skipComment {
		return comments
	}
	for _, v := range parser.Comments {
		comments = append(comments, v)
	}
	parser.clearComments()
	return comments
}

func (parser *Parser) parseNamespace() {
	parser.parseComments()
	if parser.peek() == Namespace {
		parser.consume()
		if parser.peek() != Semi {
			parser.Program.Namespace = parser.parseQualifiedId(false)
		}
		parser.ensure(Semi)
		parser.Program.Comments = parser.getComments()
		fmt.Println("namespace:", parser.Program.Namespace)
	} else {
		parser.Scanner.error(fmt.Sprintf("unexpected: %s, expect namespace", TokenToKey(parser.peek())))
	}
}

func (parser *Parser) parseIncludes() {
	for {
		parser.parseComments()
		if parser.peek() == Include {
			parser.consume()
			text := parser.parseQualifiedId(true)
			parser.Program.Includes = append(parser.Program.Includes, text)
			fmt.Println("include:", text)
			parser.ensure(Semi)
			parser.clearComments()
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

func (parser *Parser) parseType() *Type {
	dataType := &Type{}
	dataType.Scalar = TokenInvalid

}

func (parser *Parser) parseDeclarations() {
	parser.parseModifiers()
	//parser meta data

	switch parser.peek() {
	case Class:
	case Enum:
	case TokenIdentifier:
	default:
		if IsScala(parser.peek()) {

		} else {

		}
	}
}

func (parser *Parser) parseClassMember() {

}

func (parser *Parser) parseDelaration() {

}

func (parser *Parser) parseFunction() {

}
