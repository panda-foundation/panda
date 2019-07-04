// Code generated from PandaParser.g4 by ANTLR 4.7.1. DO NOT EDIT.

package compiler // PandaParser
import "github.com/antlr/antlr4/runtime/Go/antlr"

type BasePandaParserVisitor struct {
	*antlr.BaseParseTreeVisitor
}

func (v *BasePandaParserVisitor) VisitTranslation_unit(ctx *Translation_unitContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitPrimary_expression(ctx *Primary_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitId_expression(ctx *Id_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitUnqualified_id(ctx *Unqualified_idContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitQualified_id(ctx *Qualified_idContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitNested_name_specifier(ctx *Nested_name_specifierContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitPost_fix_expression(ctx *Post_fix_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitExpression_list(ctx *Expression_listContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitUnary_expression(ctx *Unary_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitUnary_operator(ctx *Unary_operatorContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitNew_expression(ctx *New_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitNew_initializer(ctx *New_initializerContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitMultiplicative_expression(ctx *Multiplicative_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitAdditive_expression(ctx *Additive_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitShift_expression(ctx *Shift_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitShiftoperator(ctx *ShiftoperatorContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitRelational_expression(ctx *Relational_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitEquality_expression(ctx *Equality_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitAnd_expression(ctx *And_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitExclusiveor_expression(ctx *Exclusiveor_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitInclusiveor_expression(ctx *Inclusiveor_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitLogical_and_expression(ctx *Logical_and_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitLogical_or_expression(ctx *Logical_or_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitConditional_expression(ctx *Conditional_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitAssignment_expression(ctx *Assignment_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitAssignment_operator(ctx *Assignment_operatorContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitExpression(ctx *ExpressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitConstant_expression(ctx *Constant_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitStatement(ctx *StatementContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitLabeled_statement(ctx *Labeled_statementContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitExpression_statement(ctx *Expression_statementContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitCompound_statement(ctx *Compound_statementContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitStatement_sequence(ctx *Statement_sequenceContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitSelection_statement(ctx *Selection_statementContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitCondition(ctx *ConditionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitIteration_statement(ctx *Iteration_statementContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitFor_init_statement(ctx *For_init_statementContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitFor_range_declaration(ctx *For_range_declarationContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitFor_range_initializer(ctx *For_range_initializerContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitJump_statement(ctx *Jump_statementContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitDeclaration_statement(ctx *Declaration_statementContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitDeclaration_sequence(ctx *Declaration_sequenceContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitDeclaration(ctx *DeclarationContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitBlock_declaration(ctx *Block_declarationContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitEmpty_declaration(ctx *Empty_declarationContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitDecl_specifier(ctx *Decl_specifierContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitDecl_specifier_sequence(ctx *Decl_specifier_sequenceContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitType_specifier_sequence(ctx *Type_specifier_sequenceContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitType_specifier(ctx *Type_specifierContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitType_name(ctx *Type_nameContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitEnum_name(ctx *Enum_nameContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitEnum_specifier(ctx *Enum_specifierContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitEnum_head(ctx *Enum_headContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitEnum_key(ctx *Enum_keyContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitEnum_base(ctx *Enum_baseContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitEnumerator_list(ctx *Enumerator_listContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitEnumerator_definition(ctx *Enumerator_definitionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitEnumerator(ctx *EnumeratorContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitNamespace_name(ctx *Namespace_nameContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitNamespace_definition(ctx *Namespace_definitionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitInclude_definition(ctx *Include_definitionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitInclude_definition_sequence(ctx *Include_definition_sequenceContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitInit_declarator_list(ctx *Init_declarator_listContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitInit_declarator(ctx *Init_declaratorContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitDeclarator(ctx *DeclaratorContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitPtr_declarator(ctx *Ptr_declaratorContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitNoptr_declarator(ctx *Noptr_declaratorContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitParameters_and_qualifiers(ctx *Parameters_and_qualifiersContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitRef_operator(ctx *Ref_operatorContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitDeclarator_id(ctx *Declarator_idContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitType_id(ctx *Type_idContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitParameter_declaration_clause(ctx *Parameter_declaration_clauseContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitParameter_declaration_list(ctx *Parameter_declaration_listContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitParameter_declaration(ctx *Parameter_declarationContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitFunction_definition(ctx *Function_definitionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitInitializer(ctx *InitializerContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitBrace_or_equal_initializer(ctx *Brace_or_equal_initializerContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitInitializer_clause(ctx *Initializer_clauseContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitInitializer_list(ctx *Initializer_listContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitBraced_init_list(ctx *Braced_init_listContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitClass_specifier(ctx *Class_specifierContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitClass_name(ctx *Class_nameContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitMember_specification(ctx *Member_specificationContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitMember_declaration(ctx *Member_declarationContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitMember_declarator_list(ctx *Member_declarator_listContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitMember_declarator(ctx *Member_declaratorContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitAccess_specifier(ctx *Access_specifierContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitBase_clause(ctx *Base_clauseContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitBase_specifier_list(ctx *Base_specifier_listContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitBase_specifier(ctx *Base_specifierContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitOperator_function_id(ctx *Operator_function_idContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitTemplate_id(ctx *Template_idContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitTemplate_definition(ctx *Template_definitionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitTemplate_argument_list(ctx *Template_argument_listContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitTemplate_argument(ctx *Template_argumentContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitType_name_specifier(ctx *Type_name_specifierContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitType_id_list(ctx *Type_id_listContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitTry_block(ctx *Try_blockContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitHandler_sequence(ctx *Handler_sequenceContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitHandler(ctx *HandlerContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitException_declaration(ctx *Exception_declarationContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitThrow_expression(ctx *Throw_expressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitOperators(ctx *OperatorsContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasePandaParserVisitor) VisitLiteral(ctx *LiteralContext) interface{} {
	return v.VisitChildren(ctx)
}
