package compiler

import (
	"fmt"

	"github.com/antlr/antlr4/runtime/Go/antlr"
)

type TreeShapeListener struct {
	*BasePandaParserListener
}

func NewTreeShapeListener() *TreeShapeListener {
	return new(TreeShapeListener)
}

func (this *TreeShapeListener) EnterEveryRule(ctx antlr.ParserRuleContext) {
	fmt.Println(ctx.GetText())
}

func Parse() ITranslation_unitContext {
	input, _ := antlr.NewFileStream("./sample.pd")
	lexer := NewPandaLexer(input)
	stream := antlr.NewCommonTokenStream(lexer, 0)
	p := NewPandaParser(stream)
	p.AddErrorListener(antlr.NewDiagnosticErrorListener(true))
	p.BuildParseTrees = true
	tree := p.Translation_unit()
	antlr.ParseTreeWalkerDefault.Walk(NewTreeShapeListener(), tree)

	return tree
}
