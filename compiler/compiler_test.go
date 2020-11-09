package compiler

import "testing"

func TestPackage(t *testing.T) {
	src := `@doc "all types elements of panda language"
package main;`
	p, err := ParseString(src, true, nil)
	if err != nil {
		t.Error(err)
	}
	if p.Package.Name.Name != "main" {
		t.Error("error package parsed")
	}
}
