package main

import (
	"fmt"

	"github.com/panda-foundation/panda/compiler"
)

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
	1/2*3+4
	a.b.c/d
	"string"
	@meta
	#if windows
	run_windows()
	#end
	//comment
	/* block 
	comment */`

	bytes := []byte(src)
	s := compiler.NewScanner(nil, bytes, nil, true, []string{"windows"})
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
