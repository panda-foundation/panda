package main

import (
	"fmt"
	"strings"

	"github.com/panda-foundation/panda/compiler"
)

/*
	@("raw string")
	"windows"
	// this is line comment.
	string str = @("raw string here")
	if a > 10 {}
*/

func main() {
	const src = `//#if windows
	print("windows")
	//#end
	`

	var s compiler.Scanner
	s.Init(strings.NewReader(src), false, []string{})
	for token := s.Scan(); token != compiler.TypeEOF && s.ErrorCount == 0; token = s.Scan() {
		newLine := "\n"
		if token == compiler.TypeNewLine {
			newLine = ""
		}
		fmt.Printf("type %s %s: %s%s", compiler.TokenToString(token), s.Position, s.TokenText(), newLine)
	}
}
