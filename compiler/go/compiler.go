package main

import (
	"bytes"
	"fmt"
)

func main() {
	/*
		fileset := &FileSet{}
		pf, err := ParseFile(fileset, "./../../everything.pd", true, []string{})
		if err == nil {*/
	var b bytes.Buffer
	//pf.Print(&b)
	fmt.Println(b.String())
	//}
}
