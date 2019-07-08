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
	#if windows
	print("windows")
	#end
*/

func main() {
	const src = `"hello world (你好！)"`
	s := compiler.NewScanner(strings.NewReader(src), false, []string{"windows"})
	for token := s.Scan(); token != compiler.TypeEOF; token = s.Scan() {
		if s.ErrorCount > 0 {
			break
		}
		newLine := "\n"
		if token == compiler.TypeNewLine {
			newLine = ""
		}
		fmt.Printf("type %s %s: %s%s", compiler.TokenType(token), s.Position, s.Token(), newLine)
	}
}
