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
	Comments  []string
	Namespace string
	Includes  []string

	Declarations []*Declaration
	Functions    []*Function
	Enums        []*EnumDefinition
	Classes      []*ClassDefinition
}

type EnumDefinition struct {
	Comments []string
	Modifier *Modifier
}

type ClassDefinition struct {
	Comments []string
	Modifier *Modifier

	Parents      []string
	Templates    []string
	Declarations []*Declaration
	Functions    []*Function
}

type Function struct {
	Comments []string
	Modifier *Modifier

	Templates []string
}

type Declaration struct {
	Comments []string
	Modifier *Modifier
}

type Expression struct {
}
