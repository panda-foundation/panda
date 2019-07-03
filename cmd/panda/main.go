package main

import (
	"github.com/panda-foundation/panda/compiler"
)

type cli struct {
	Files []string `required existingfile arg help:"Protobuf files."`
}

func main() {
	compiler.Parse()
	/*
		ioutil.WriteFile("./sample.cpp", bytes, 0666)

		cmd := exec.Command("gcc", "sample.cpp", "-lstdc++", "-o", "sample.exe")
		if err := cmd.Run(); err != nil {
			fmt.Println("compile error:", err.Error())
		}*/
}
