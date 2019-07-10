package compiler

type AccessType int

const (
	AccessPrivate AccessType = iota
	AccessProtected
	AccessPublic
)

type Modifier struct {
	Access AccessType
	Static bool
	Const  bool
}

type ProgramUnit struct {
	Namespace string
	Includes  []string

	Declarations []*Declaration
	Functions    []*Function
	Enums        []*EnumDefinition
	Classes      []*ClassDefinition
}

type EnumDefinition struct {
	Comment  string
	Modifier *Modifier
}

type ClassDefinition struct {
	Comment  string
	Modifier *Modifier

	Parents      []string
	Templates    []string
	Declarations []*Declaration
	Functions    []*Function
}

type Function struct {
	Comment  string
	Modifier *Modifier

	Templates []string
}

type Declaration struct {
	Comment  string
	Modifier *Modifier
}

type Expression struct {
}
