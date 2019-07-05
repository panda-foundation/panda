package main

import (
	"fmt"
	"strings"

	"github.com/panda-foundation/panda/compiler"
)

/*
	// this is line comment.
	string str = @("raw string here")
	if a > 10 {}
*/

func main() {
	const src = ` *
	#== * +	@("raw string")
	a = 1
	if a > 10 {}
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
