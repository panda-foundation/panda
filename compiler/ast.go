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
	Modifier *Modifier
}

type ClassDefinition struct {
	Modifier *Modifier

	Parents      []string
	Templates    []string
	Declarations []*Declaration
	Functions    []*Function
}

type Function struct {
	Modifier *Modifier

	Templates []string
}

type Declaration struct {
	Modifier *Modifier
}

type Expression struct {
}
