package compiler

import "testing"

func TestAllTypes(t *testing.T) {
	src := `
@doc "package_doc"
package main;

@doc "import_doc"
import sys "system";
@doc "import_doc"
import "collection";

@doc "const_doc"
public const b bool = true;
@doc "const_doc"
const c char = 'a'; // alias u32 //TO-DO`

	p, err := ParseString(src, true, nil)
	if err != nil {
		t.Error(err)
	}

	if p.Package.Name.Name != "main" || p.Package.Doc.Text != "package_doc" {
		t.Error("parse [package main] failed")
	}

	if p.Imports[0].Name.Name != "sys" || p.Imports[0].Path.Value != "system" {
		t.Error("parse [import system] failed")
	}

	if p.Imports[1].Path.Value != "collection" || p.Imports[1].Doc.Text != "import_doc" {
		t.Error("parse [import collection] failed")
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
