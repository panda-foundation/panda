package compiler

import (
	"fmt"
)

const (
	globalPackage = "global"
)

var (
	programs = make(map[string][]*Program)
)

func AddProgram(program *Program) error {
	foundPackageName := false
	packageName := globalPackage
	for _, entry := range program.Entries {
		if entry.Package != nil {
			if foundPackageName {
				return fmt.Errorf("duplicated package define, file: %s, line: %s", entry.Pos.Filename, entry.Pos.Line)
			}
			if *entry.Package == globalPackage {
				return fmt.Errorf("cannot use \"global\" as package name, file: %s, line: %s", entry.Pos.Filename, entry.Pos.Line)
			} else if *entry.Package != "" {
				packageName = *entry.Package
			}
			foundPackageName = true
		}
	}
	programs[packageName] = append(programs[packageName], program)
	return nil
}
