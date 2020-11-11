package compiler

import "testing"

func TestAllTypes(t *testing.T) {
	src := `
@doc "namespace_doc"
namespace main;

@doc "import_doc"
import sys = system;
@doc "import_doc"
import compiler.test.sub;

@doc "const_doc"
public const b bool = true;
@doc "const_doc"
const c char = 'a'; // alias u32 //TO-DO

var sbyte_v sbyte = 1; // alias i8
var short_v short = 0; // alias i16
var int_v int; // alias i32
var long_v long; // alias i64
var int8_v i8;
var int16_v i16;
var int32_v i32;
var int64_v i64;

var byte_v byte; // alias u8
var ushort_v ushort; // alias u16
var uint_v uint; // alias u32
var ulong_v ulong; // alias u64
var uint8_v u8;
var uint16_v u16;
var uint32_v u32;
var uint64_v u64;

var float_v float; // alias f32
var double_v double; // alias f64
var f32_v f32;
var f64_v f64;

var string_v string = "hello world\n";
/*
@doc "add_function"
function add(a, b int) int
{
    return a + b;
}*/`

	p, err := ParseString(src, true, nil)
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
