package main

import (
	"os"

	"github.com/alecthomas/participle"
	"github.com/alecthomas/participle/lexer"
	"github.com/alecthomas/repr"
	"github.com/panda-foundation/panda/compiler"
)

type cli struct {
	Files []string `required existingfile arg help:"Protobuf files."`
}

func main() {
	file, _ := os.Open("./sample.pd")
	parser := participle.MustBuild(&compiler.Program{}, participle.UseLookahead(2))
	program := &compiler.Program{}
	if err := parser.Parse(file, program); err != nil {
		panic(err)
	}
	repr.Println(program, repr.Hide(&lexer.Position{}))
}
