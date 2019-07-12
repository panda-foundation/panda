package compiler

import "fmt"

type Parser struct {
	Scanner *Scanner
	Program *ProgramUnit

	Token    Token
	Modifier Modifier

	InClass    bool
	InFunction bool
	InEnum     bool

	Documents []string
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

func (parser *Parser) parseDocument() {
	if parser.Scanner.skipDocument {
		return
	}
	/*
		parser.clearDocument()
		for parser.peek() == TokenComment {
			parser.Documents = append(parser.Documents, parser.Scanner.Token())
			parser.consume()
		}*/
}

func (parser *Parser) skipDocument() {
	if parser.Scanner.skipDocument {
		return
	}
	/*
		for parser.peek() == TokenComment {
			parser.consume()
		}*/
}

func (parser *Parser) clearDocument() {
	if parser.Scanner.skipDocument {
		return
	}
	parser.Documents = parser.Documents[:0]
}

func (parser *Parser) getDocument() []string {
	var documents []string
	if parser.Scanner.skipDocument {
		return documents
	}
	for _, v := range parser.Documents {
		documents = append(documents, v)
	}
	parser.clearDocument()
	return documents
}

func (parser *Parser) parseNamespace() {
	parser.parseDocument()
	if parser.peek() == Namespace {
		parser.consume()
		if parser.peek() != Semi {
			parser.Program.Namespace = parser.parseQualifiedId(false)
		}
		parser.ensure(Semi)
		parser.Program.Document = parser.getDocument()
		fmt.Println("namespace:", parser.Program.Namespace)
	} else {
		parser.Scanner.error(fmt.Sprintf("unexpected: %s, expect namespace", TokenToKey(parser.peek())))
	}
}

func (parser *Parser) parseIncludes() {
	for {
		parser.parseDocument()
		if parser.peek() == Include {
			parser.consume()
			text := parser.parseQualifiedId(true)
			parser.Program.Includes = append(parser.Program.Includes, text)
			fmt.Println("include:", text)
			parser.ensure(Semi)
			parser.clearDocument()
		} else {
			break
		}
	}
}

func (parser *Parser) parseModifier() {
	parser.Modifier.Public = false
	parser.Modifier.Static = false

	if parser.peek() == Public {
		parser.Modifier.Public = true
		parser.consume()
	}
	if parser.peek() == Static {
		parser.Modifier.Static = true
		parser.consume()
		if !parser.InClass {
			parser.Scanner.error("unexpected static")
		}
	}

	fmt.Println("modifiers:", parser.Modifier)
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
	return nil
}

func (parser *Parser) parseDeclarations() {
	parser.parseModifier()
	//parser meta data

	switch parser.peek() {
	case Class:
	case Enum:
	case Interface:
	case Var:
	case Const:
	default:
		parser.Scanner.error("unexpected: " + parser.Scanner.Token())
	}
}

func (parser *Parser) parseClass() {

}

func (parser *Parser) parseDelaration(isConstant bool) {

}

func (parser *Parser) parseFunction() {

}
