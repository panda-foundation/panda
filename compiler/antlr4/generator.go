package compiler

import (
	"text/template"
)

var (
	generator *template.Template
)

func init() {
	tpl := `{{range .Entries}}{{template "encode-entry" .}}{{end}}`
	entryTpl := `{{if .Emit}}{{.Emit.Content}}{{end -}}
	{{if .Method}}{{template "encode-method" .Method}}{{end -}}
	`
	methodTpl := `
{{range .Modifier}}{{.}}{{end -}}
{{.Return.Scalar.CppType}} {{.Name}}()
{
	{{range .Body}}{{template "encode-expression" .}}{{end}}
}
	`
	exprTpl := `{{if .Emit}}{{.Emit.Content}}{{end -}}`

	generator = template.New("generator")
	template.Must(generator.Parse(tpl))
	template.Must(generator.New("encode-entry").Parse(entryTpl))
	template.Must(generator.New("encode-method").Parse(methodTpl))
	template.Must(generator.New("encode-expression").Parse(exprTpl))
}

/*
func Generate(program *Program) ([]byte, error) {
	buf := new(bytes.Buffer)
	if err := generator.Execute(buf, program); err != nil {
		return nil, err
	}
	return buf.Bytes(), nil
}*/
