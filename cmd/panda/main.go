package main

import (
	"fmt"
	"strings"

	"github.com/panda-foundation/panda/compiler"
)

func main() {
	const src = `
	// This is scanned code.
	if a > 10 {
		someParsable = text
	}`

	var s compiler.Scanner
	s.Init(strings.NewReader(src), false)
	s.Filename = "example"
	for tok := s.Scan(); tok != compiler.EOF; tok = s.Scan() {
		fmt.Printf("type %s %s: %s\n", compiler.TokenToString(tok), s.Position, s.TokenText())
	}
}
