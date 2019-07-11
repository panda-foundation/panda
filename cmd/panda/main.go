package main

import (
	"os"

	"github.com/panda-foundation/panda/compiler"
)

/*
	const src = `// test program
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

	s := compiler.NewScanner(strings.NewReader(src), false, []string{})
	for token := s.Scan(); token != compiler.TokenEOF; token = s.Scan() {
		if s0.ErrorCount > 0 {
			break
		}
		fmt.Printf("%s: %s \n", s0.Position, s0.Token())
	}
*/

func main() {
	file, _ := os.Open("./../../sample.pd")
	s := compiler.NewScanner(file, false, []string{})
	p := compiler.NewParser()
	p.Parse(s)
}
