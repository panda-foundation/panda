// Code generated from PandaParser.g4 by ANTLR 4.7.1. DO NOT EDIT.

package compiler // PandaParser
import "github.com/antlr/antlr4/runtime/Go/antlr"

// A complete Visitor for a parse tree produced by PandaParser.
type PandaParserVisitor interface {
	antlr.ParseTreeVisitor

	// Visit a parse tree produced by PandaParser#translation_unit.
	VisitTranslation_unit(ctx *Translation_unitContext) interface{}

	// Visit a parse tree produced by PandaParser#primary_expression.
	VisitPrimary_expression(ctx *Primary_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#id_expression.
	VisitId_expression(ctx *Id_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#unqualified_id.
	VisitUnqualified_id(ctx *Unqualified_idContext) interface{}

	// Visit a parse tree produced by PandaParser#qualified_id.
	VisitQualified_id(ctx *Qualified_idContext) interface{}

	// Visit a parse tree produced by PandaParser#nested_name_specifier.
	VisitNested_name_specifier(ctx *Nested_name_specifierContext) interface{}

	// Visit a parse tree produced by PandaParser#lambda_expression.
	VisitLambda_expression(ctx *Lambda_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#lambda_declarator.
	VisitLambda_declarator(ctx *Lambda_declaratorContext) interface{}

	// Visit a parse tree produced by PandaParser#post_fix_expression.
	VisitPost_fix_expression(ctx *Post_fix_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#expression_list.
	VisitExpression_list(ctx *Expression_listContext) interface{}

	// Visit a parse tree produced by PandaParser#unary_expression.
	VisitUnary_expression(ctx *Unary_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#unary_operator.
	VisitUnary_operator(ctx *Unary_operatorContext) interface{}

	// Visit a parse tree produced by PandaParser#new_expression.
	VisitNew_expression(ctx *New_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#new_initializer.
	VisitNew_initializer(ctx *New_initializerContext) interface{}

	// Visit a parse tree produced by PandaParser#multiplicative_expression.
	VisitMultiplicative_expression(ctx *Multiplicative_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#additive_expression.
	VisitAdditive_expression(ctx *Additive_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#shift_expression.
	VisitShift_expression(ctx *Shift_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#shiftoperator.
	VisitShiftoperator(ctx *ShiftoperatorContext) interface{}

	// Visit a parse tree produced by PandaParser#relational_expression.
	VisitRelational_expression(ctx *Relational_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#equality_expression.
	VisitEquality_expression(ctx *Equality_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#and_expression.
	VisitAnd_expression(ctx *And_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#exclusiveor_expression.
	VisitExclusiveor_expression(ctx *Exclusiveor_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#inclusiveor_expression.
	VisitInclusiveor_expression(ctx *Inclusiveor_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#logical_and_expression.
	VisitLogical_and_expression(ctx *Logical_and_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#logical_or_expression.
	VisitLogical_or_expression(ctx *Logical_or_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#conditional_expression.
	VisitConditional_expression(ctx *Conditional_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#assignment_expression.
	VisitAssignment_expression(ctx *Assignment_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#assignment_operator.
	VisitAssignment_operator(ctx *Assignment_operatorContext) interface{}

	// Visit a parse tree produced by PandaParser#expression.
	VisitExpression(ctx *ExpressionContext) interface{}

	// Visit a parse tree produced by PandaParser#constant_expression.
	VisitConstant_expression(ctx *Constant_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#statement.
	VisitStatement(ctx *StatementContext) interface{}

	// Visit a parse tree produced by PandaParser#labeled_statement.
	VisitLabeled_statement(ctx *Labeled_statementContext) interface{}

	// Visit a parse tree produced by PandaParser#expression_statement.
	VisitExpression_statement(ctx *Expression_statementContext) interface{}

	// Visit a parse tree produced by PandaParser#compound_statement.
	VisitCompound_statement(ctx *Compound_statementContext) interface{}

	// Visit a parse tree produced by PandaParser#statement_sequence.
	VisitStatement_sequence(ctx *Statement_sequenceContext) interface{}

	// Visit a parse tree produced by PandaParser#selection_statement.
	VisitSelection_statement(ctx *Selection_statementContext) interface{}

	// Visit a parse tree produced by PandaParser#condition.
	VisitCondition(ctx *ConditionContext) interface{}

	// Visit a parse tree produced by PandaParser#iteration_statement.
	VisitIteration_statement(ctx *Iteration_statementContext) interface{}

	// Visit a parse tree produced by PandaParser#for_init_statement.
	VisitFor_init_statement(ctx *For_init_statementContext) interface{}

	// Visit a parse tree produced by PandaParser#for_range_declaration.
	VisitFor_range_declaration(ctx *For_range_declarationContext) interface{}

	// Visit a parse tree produced by PandaParser#for_range_initializer.
	VisitFor_range_initializer(ctx *For_range_initializerContext) interface{}

	// Visit a parse tree produced by PandaParser#jump_statement.
	VisitJump_statement(ctx *Jump_statementContext) interface{}

	// Visit a parse tree produced by PandaParser#declaration_statement.
	VisitDeclaration_statement(ctx *Declaration_statementContext) interface{}

	// Visit a parse tree produced by PandaParser#declaration_sequence.
	VisitDeclaration_sequence(ctx *Declaration_sequenceContext) interface{}

	// Visit a parse tree produced by PandaParser#declaration.
	VisitDeclaration(ctx *DeclarationContext) interface{}

	// Visit a parse tree produced by PandaParser#block_declaration.
	VisitBlock_declaration(ctx *Block_declarationContext) interface{}

	// Visit a parse tree produced by PandaParser#empty_declaration.
	VisitEmpty_declaration(ctx *Empty_declarationContext) interface{}

	// Visit a parse tree produced by PandaParser#decl_specifier.
	VisitDecl_specifier(ctx *Decl_specifierContext) interface{}

	// Visit a parse tree produced by PandaParser#decl_specifier_sequence.
	VisitDecl_specifier_sequence(ctx *Decl_specifier_sequenceContext) interface{}

	// Visit a parse tree produced by PandaParser#type_specifier.
	VisitType_specifier(ctx *Type_specifierContext) interface{}

	// Visit a parse tree produced by PandaParser#trailing_type_specifier.
	VisitTrailing_type_specifier(ctx *Trailing_type_specifierContext) interface{}

	// Visit a parse tree produced by PandaParser#type_specifier_sequence.
	VisitType_specifier_sequence(ctx *Type_specifier_sequenceContext) interface{}

	// Visit a parse tree produced by PandaParser#trailing_type_specifier_sequence.
	VisitTrailing_type_specifier_sequence(ctx *Trailing_type_specifier_sequenceContext) interface{}

	// Visit a parse tree produced by PandaParser#simple_type_specifier.
	VisitSimple_type_specifier(ctx *Simple_type_specifierContext) interface{}

	// Visit a parse tree produced by PandaParser#type_name.
	VisitType_name(ctx *Type_nameContext) interface{}

	// Visit a parse tree produced by PandaParser#enum_name.
	VisitEnum_name(ctx *Enum_nameContext) interface{}

	// Visit a parse tree produced by PandaParser#enum_specifier.
	VisitEnum_specifier(ctx *Enum_specifierContext) interface{}

	// Visit a parse tree produced by PandaParser#enum_head.
	VisitEnum_head(ctx *Enum_headContext) interface{}

	// Visit a parse tree produced by PandaParser#enum_key.
	VisitEnum_key(ctx *Enum_keyContext) interface{}

	// Visit a parse tree produced by PandaParser#enum_base.
	VisitEnum_base(ctx *Enum_baseContext) interface{}

	// Visit a parse tree produced by PandaParser#enumerator_list.
	VisitEnumerator_list(ctx *Enumerator_listContext) interface{}

	// Visit a parse tree produced by PandaParser#enumerator_definition.
	VisitEnumerator_definition(ctx *Enumerator_definitionContext) interface{}

	// Visit a parse tree produced by PandaParser#enumerator.
	VisitEnumerator(ctx *EnumeratorContext) interface{}

	// Visit a parse tree produced by PandaParser#namespace_name.
	VisitNamespace_name(ctx *Namespace_nameContext) interface{}

	// Visit a parse tree produced by PandaParser#namespace_definition.
	VisitNamespace_definition(ctx *Namespace_definitionContext) interface{}

	// Visit a parse tree produced by PandaParser#qualified_namespace_specifier.
	VisitQualified_namespace_specifier(ctx *Qualified_namespace_specifierContext) interface{}

	// Visit a parse tree produced by PandaParser#init_declarator_list.
	VisitInit_declarator_list(ctx *Init_declarator_listContext) interface{}

	// Visit a parse tree produced by PandaParser#init_declarator.
	VisitInit_declarator(ctx *Init_declaratorContext) interface{}

	// Visit a parse tree produced by PandaParser#declarator.
	VisitDeclarator(ctx *DeclaratorContext) interface{}

	// Visit a parse tree produced by PandaParser#ptr_declarator.
	VisitPtr_declarator(ctx *Ptr_declaratorContext) interface{}

	// Visit a parse tree produced by PandaParser#noptr_declarator.
	VisitNoptr_declarator(ctx *Noptr_declaratorContext) interface{}

	// Visit a parse tree produced by PandaParser#parameters_and_qualifiers.
	VisitParameters_and_qualifiers(ctx *Parameters_and_qualifiersContext) interface{}

	// Visit a parse tree produced by PandaParser#trailing_return_type.
	VisitTrailing_return_type(ctx *Trailing_return_typeContext) interface{}

	// Visit a parse tree produced by PandaParser#ref_operator.
	VisitRef_operator(ctx *Ref_operatorContext) interface{}

	// Visit a parse tree produced by PandaParser#ref_qualifier.
	VisitRef_qualifier(ctx *Ref_qualifierContext) interface{}

	// Visit a parse tree produced by PandaParser#declarator_id.
	VisitDeclarator_id(ctx *Declarator_idContext) interface{}

	// Visit a parse tree produced by PandaParser#type_id.
	VisitType_id(ctx *Type_idContext) interface{}

	// Visit a parse tree produced by PandaParser#parameter_declaration_clause.
	VisitParameter_declaration_clause(ctx *Parameter_declaration_clauseContext) interface{}

	// Visit a parse tree produced by PandaParser#parameter_declaration_list.
	VisitParameter_declaration_list(ctx *Parameter_declaration_listContext) interface{}

	// Visit a parse tree produced by PandaParser#parameter_declaration.
	VisitParameter_declaration(ctx *Parameter_declarationContext) interface{}

	// Visit a parse tree produced by PandaParser#function_definition.
	VisitFunction_definition(ctx *Function_definitionContext) interface{}

	// Visit a parse tree produced by PandaParser#function_body.
	VisitFunction_body(ctx *Function_bodyContext) interface{}

	// Visit a parse tree produced by PandaParser#initializer.
	VisitInitializer(ctx *InitializerContext) interface{}

	// Visit a parse tree produced by PandaParser#brace_or_equal_initializer.
	VisitBrace_or_equal_initializer(ctx *Brace_or_equal_initializerContext) interface{}

	// Visit a parse tree produced by PandaParser#initializer_clause.
	VisitInitializer_clause(ctx *Initializer_clauseContext) interface{}

	// Visit a parse tree produced by PandaParser#initializer_list.
	VisitInitializer_list(ctx *Initializer_listContext) interface{}

	// Visit a parse tree produced by PandaParser#braced_init_list.
	VisitBraced_init_list(ctx *Braced_init_listContext) interface{}

	// Visit a parse tree produced by PandaParser#class_name.
	VisitClass_name(ctx *Class_nameContext) interface{}

	// Visit a parse tree produced by PandaParser#class_specifier.
	VisitClass_specifier(ctx *Class_specifierContext) interface{}

	// Visit a parse tree produced by PandaParser#class_head.
	VisitClass_head(ctx *Class_headContext) interface{}

	// Visit a parse tree produced by PandaParser#class_head_name.
	VisitClass_head_name(ctx *Class_head_nameContext) interface{}

	// Visit a parse tree produced by PandaParser#member_specification.
	VisitMember_specification(ctx *Member_specificationContext) interface{}

	// Visit a parse tree produced by PandaParser#member_declaration.
	VisitMember_declaration(ctx *Member_declarationContext) interface{}

	// Visit a parse tree produced by PandaParser#member_declarator_list.
	VisitMember_declarator_list(ctx *Member_declarator_listContext) interface{}

	// Visit a parse tree produced by PandaParser#member_declarator.
	VisitMember_declarator(ctx *Member_declaratorContext) interface{}

	// Visit a parse tree produced by PandaParser#base_clause.
	VisitBase_clause(ctx *Base_clauseContext) interface{}

	// Visit a parse tree produced by PandaParser#base_specifier_list.
	VisitBase_specifier_list(ctx *Base_specifier_listContext) interface{}

	// Visit a parse tree produced by PandaParser#base_specifier.
	VisitBase_specifier(ctx *Base_specifierContext) interface{}

	// Visit a parse tree produced by PandaParser#class_or_decltype.
	VisitClass_or_decltype(ctx *Class_or_decltypeContext) interface{}

	// Visit a parse tree produced by PandaParser#base_type_specifier.
	VisitBase_type_specifier(ctx *Base_type_specifierContext) interface{}

	// Visit a parse tree produced by PandaParser#access_specifier.
	VisitAccess_specifier(ctx *Access_specifierContext) interface{}

	// Visit a parse tree produced by PandaParser#mem_initializer_list.
	VisitMem_initializer_list(ctx *Mem_initializer_listContext) interface{}

	// Visit a parse tree produced by PandaParser#mem_initializer.
	VisitMem_initializer(ctx *Mem_initializerContext) interface{}

	// Visit a parse tree produced by PandaParser#mem_initializer_id.
	VisitMem_initializer_id(ctx *Mem_initializer_idContext) interface{}

	// Visit a parse tree produced by PandaParser#operator_function_id.
	VisitOperator_function_id(ctx *Operator_function_idContext) interface{}

	// Visit a parse tree produced by PandaParser#template_parameter_list.
	VisitTemplate_parameter_list(ctx *Template_parameter_listContext) interface{}

	// Visit a parse tree produced by PandaParser#template_parameter.
	VisitTemplate_parameter(ctx *Template_parameterContext) interface{}

	// Visit a parse tree produced by PandaParser#type_parameter.
	VisitType_parameter(ctx *Type_parameterContext) interface{}

	// Visit a parse tree produced by PandaParser#template_id.
	VisitTemplate_id(ctx *Template_idContext) interface{}

	// Visit a parse tree produced by PandaParser#template_name.
	VisitTemplate_name(ctx *Template_nameContext) interface{}

	// Visit a parse tree produced by PandaParser#template_argument_list.
	VisitTemplate_argument_list(ctx *Template_argument_listContext) interface{}

	// Visit a parse tree produced by PandaParser#template_argument.
	VisitTemplate_argument(ctx *Template_argumentContext) interface{}

	// Visit a parse tree produced by PandaParser#type_name_specifier.
	VisitType_name_specifier(ctx *Type_name_specifierContext) interface{}

	// Visit a parse tree produced by PandaParser#try_block.
	VisitTry_block(ctx *Try_blockContext) interface{}

	// Visit a parse tree produced by PandaParser#function_try_block.
	VisitFunction_try_block(ctx *Function_try_blockContext) interface{}

	// Visit a parse tree produced by PandaParser#handler_sequence.
	VisitHandler_sequence(ctx *Handler_sequenceContext) interface{}

	// Visit a parse tree produced by PandaParser#handler.
	VisitHandler(ctx *HandlerContext) interface{}

	// Visit a parse tree produced by PandaParser#exception_declaration.
	VisitException_declaration(ctx *Exception_declarationContext) interface{}

	// Visit a parse tree produced by PandaParser#throw_expression.
	VisitThrow_expression(ctx *Throw_expressionContext) interface{}

	// Visit a parse tree produced by PandaParser#exception_specification.
	VisitException_specification(ctx *Exception_specificationContext) interface{}

	// Visit a parse tree produced by PandaParser#type_id_list.
	VisitType_id_list(ctx *Type_id_listContext) interface{}

	// Visit a parse tree produced by PandaParser#operators.
	VisitOperators(ctx *OperatorsContext) interface{}

	// Visit a parse tree produced by PandaParser#literal.
	VisitLiteral(ctx *LiteralContext) interface{}
}
