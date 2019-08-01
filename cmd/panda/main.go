package main

import (
	"bytes"
	"fmt"

	"github.com/panda-foundation/panda/compiler"
)

func main() {
	fileset := &compiler.FileSet{}
	pf, err := compiler.ParseFile(fileset, "./../../everything.pd", true, []string{})
	if err == nil {
		var b bytes.Buffer
		pf.Print(&b, 0)
		fmt.Println(b.String())
	}
}
