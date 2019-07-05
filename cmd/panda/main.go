package main

import (
	"fmt"
	"strings"

	"github.com/panda-foundation/panda/compiler"
)

func main() {
	const src = `
	// this is line comment.
	/* here are 
	block comment */
	string str = @("raw string here")
	if a > 10 { }
	`

	var s compiler.Scanner
	s.Init(strings.NewReader(src), false)
	for token := s.Scan(); token != compiler.TypeEOF; token = s.Scan() {
		newLine := "\n"
		if token == compiler.TypeNewLine {
			newLine = ""
		}
		fmt.Printf("type %s %s: %s%s", compiler.TokenToString(token), s.Position, s.TokenText(), newLine)
	}
}
