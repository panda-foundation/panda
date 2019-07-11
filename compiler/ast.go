package compiler

type AccessType int

const (
	AccessPrivate AccessType = iota
	AccessProtected
	AccessPublic
)

type Modifier struct {
	Public bool
	Static bool
}

type ProgramUnit struct {
	Document  []string
	Namespace string
	Includes  []string

	Declarations []*IdentifierDecl
	Functions    []*FunctionDecl
	Enums        []*EnumDecl
	Classes      []*ClassDecl
}

type EnumDecl struct {
	Document []string
	Modifier *Modifier
}

type ClassDecl struct {
	Document []string
	Modifier *Modifier

	Parents      []string
	Templates    []string
	Declarations []*IdentifierDecl
	Functions    []*FunctionDecl
}

type FunctionDecl struct {
	Document []string
	Modifier *Modifier

	Templates []string
}

type IdentifierDecl struct {
	Document []string
	Modifier *Modifier
	IsVar    bool
}

type Expression struct {
}

type Statement struct {
}
