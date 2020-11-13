package compiler

import (
	"bytes"
	"fmt"
	"io/ioutil"
	"os/exec"
	"testing"
)

func TestAllTypes(t *testing.T) {
	b, _ := ioutil.ReadFile("./test/all_types.pd")
	p, err := ParseString(string(b), true, nil)
	if err != nil {
		t.Error(err)
	}

	if p.Namespace.Name.Name != "main" || p.Namespace.Doc.Text != "namespace_doc" {
		t.Error("parse [package main] failed")
	}

	if p.Imports[0].Name.Name != "sys" {
		t.Error("parse [import system] failed")
	}

	if p.Imports[0].Doc.Text != "import_doc" {
		t.Error("parse [import system] failed")
	}

	if p.Imports[0].Path.(*Ident).Name != "system" {
		t.Error("parse [import system] failed")
	}

	if p.Imports[1].Name != nil {
		t.Error("parse [import collection.test.sub] failed")
	}

	if p.Imports[1].Path.(*SelectorExpr).Selector.Name != "sub" {
		t.Error("parse [import collection.test.sub] failed")
	}

	if p.Imports[1].Path.(*SelectorExpr).Expr.(*SelectorExpr).Selector.Name != "test" {
		t.Error("parse [import collection.test.sub] failed")
	}

	if p.Values[0].Name.Name != "b" || !p.Values[0].Modifier.Public {
		t.Error("parse [public const b bool = true] failed")
	}

	if v, ok := p.Values[0].Value.(*BasicLit); !ok || v.Value != "true" {
		t.Error("parse [public const b bool = true] failed")
	}

	if p.Values[0].Doc.Text != "const_doc" {
		t.Error("parse doc for [public const b bool = true] failed")
	}

	if p.Values[1].Doc.Text != "const_doc" {
		t.Error("parse doc for [const c char = 'a'] failed")
	}
}

func TestGenerate(t *testing.T) {
	b, _ := ioutil.ReadFile("./test/all_types.pd")
	p, err := ParseString(string(b), true, nil)
	if err != nil {
		t.Error(err)
	}

	buff := bytes.NewBuffer(nil)
	p.Print(buff)

	ioutil.WriteFile("./test/all_types.cpp", buff.Bytes(), 0644)

	cmd := exec.Command("g++", "-o", "test/all_types", "test/all_types.cpp")
	err = cmd.Run()
	if err != nil {
		fmt.Println(err)
	}
}
