package compiler

type AccessType int

const (
	AccessPrivate AccessType = iota
	AccessProtected
	AccessPublic
)

type Node interface {
	Pos() Position // position of first character belonging to the node
	End() Position // position of first character immediately after the node
}

type Expression interface {
	Node
	isExpr() bool
}

type Statement interface {
	Node
	isStatement() bool
}

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

type Type struct {
	Scalar      Token
	QualifiedId string
	//TO-DO generic
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
