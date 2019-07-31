package main

import (
	"github.com/panda-foundation/panda/compiler"
)

func main() {
	fileset := &compiler.FileSet{}
	compiler.ParseFile(fileset, "./../../everything.pd", true, []string{})
}
