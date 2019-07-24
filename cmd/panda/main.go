package main

import (
	"fmt"

	"github.com/panda-foundation/panda/compiler"
)

const src = `// test program
.5 1.5 0xabcdef 01 0b01010101
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

func test() {
	const src = `
	+
	++
	>>=
	0.5
	.5
	0xabcdef 
	12345
	0b01010101
	keyword 
	'a'
	'\n'
	"string"
	@meta
	//comment
	/* block 
	comment */`

	bytes := []byte(src)
	s := compiler.NewScanner(nil, bytes, nil, true, []string{})
	for _, token, literal := s.Scan(); token != compiler.EOF; _, token, literal = s.Scan() {
		fmt.Printf("%s %s \n", token.String(), literal)
	}
}

func main() {
	test()
	//file, _ := os.Open("./../../sample.pd")
	//s := compiler.NewScanner(file, true, []string{})
	//p := compiler.NewParser()
	//p.Parse(s)
}
