package main

import (
	"strings"

	"github.com/alecthomas/participle"
	"github.com/alecthomas/participle/lexer"
	"github.com/alecthomas/repr"
	"github.com/panda-foundation/panda/compiler"
)

type cli struct {
	Files []string `required existingfile arg help:"Protobuf files."`
}

/*
	public function main()
	{
		print()
	}
*/

func main() {

	input := `
package main
import "iostream"
public static map<int, string, bytes> main(int status, int code)
`

	parser := participle.MustBuild(&compiler.Program{}, participle.UseLookahead(2))
	program := &compiler.Program{}
	if err := parser.Parse(strings.NewReader(input), program); err != nil {
		panic(err)
	}
	repr.Println(program, repr.Hide(&lexer.Position{}))
}
