package main

import (
	"fmt"
	"strings"

	"github.com/panda-foundation/panda/compiler"
)

/*
	#if windows
	print("windows")
	#end
*/

func main() {
	const src = `// test program
/* panda language */
.5 5 0xabcdef 01 0b01010101
keyword 'a'
1/2*3+4
a.b.c/d
if (a > 10) {}
if else try catch
"hello world (你好！)"
@("我是 raw string")
@meta(json(id, omit_empty))
#if windows
windows
#end
#if linux
linux
#end`
	s := compiler.NewScanner(strings.NewReader(src), true, []string{"windows"})
	for token := s.Scan(); token != compiler.TypeEOF; token = s.Scan() {
		if s.ErrorCount > 0 {
			break
		}
		fmt.Printf("type %s %s: %s \n", compiler.TokenType(token), s.Position, s.Token())
	}
}
