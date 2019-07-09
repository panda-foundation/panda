package main

import (
	"fmt"
	"os"
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
#if !mac_os 
not_mac
#end
#if windows
windows
#end
#if linux
linux
#end`
	s0 := compiler.NewScanner(strings.NewReader(src), false, []string{})
	for token := s0.Scan(); token != compiler.TypeEOF; token = s0.Scan() {
		if s0.ErrorCount > 0 {
			break
		}
		fmt.Printf("type %s %s: %s \n", compiler.TokenType(token), s0.Position, s0.Token())
	}

	file, _ := os.Open("./sample.pd")
	s := compiler.NewScanner(file, true, []string{})
	p := compiler.NewParser()
	p.Parse(s)
}
