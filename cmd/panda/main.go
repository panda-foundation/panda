package main

import (
	"../../compiler"
)

func main() {
	fileset := &compiler.FileSet{}
	compiler.ParseFile(fileset, "./../../sample.pd", true, []string{})
}
