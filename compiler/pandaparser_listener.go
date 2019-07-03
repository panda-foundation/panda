// Code generated from PandaParser.g4 by ANTLR 4.7.1. DO NOT EDIT.

package compiler // PandaParser
import "github.com/antlr/antlr4/runtime/Go/antlr"

// PandaParserListener is a complete listener for a parse tree produced by PandaParser.
type PandaParserListener interface {
	antlr.ParseTreeListener

	// EnterTranslation_unit is called when entering the translation_unit production.
	EnterTranslation_unit(c *Translation_unitContext)

	// EnterPrimary_expression is called when entering the primary_expression production.
	EnterPrimary_expression(c *Primary_expressionContext)

	// EnterId_expression is called when entering the id_expression production.
	EnterId_expression(c *Id_expressionContext)

	// EnterUnqualified_id is called when entering the unqualified_id production.
	EnterUnqualified_id(c *Unqualified_idContext)

	// EnterQualified_id is called when entering the qualified_id production.
	EnterQualified_id(c *Qualified_idContext)

	// EnterNested_name_specifier is called when entering the nested_name_specifier production.
	EnterNested_name_specifier(c *Nested_name_specifierContext)

	// EnterLambda_expression is called when entering the lambda_expression production.
	EnterLambda_expression(c *Lambda_expressionContext)

	// EnterLambda_declarator is called when entering the lambda_declarator production.
	EnterLambda_declarator(c *Lambda_declaratorContext)

	// EnterPost_fix_expression is called when entering the post_fix_expression production.
	EnterPost_fix_expression(c *Post_fix_expressionContext)

	// EnterExpression_list is called when entering the expression_list production.
	EnterExpression_list(c *Expression_listContext)

	// EnterUnary_expression is called when entering the unary_expression production.
	EnterUnary_expression(c *Unary_expressionContext)

	// EnterUnary_operator is called when entering the unary_operator production.
	EnterUnary_operator(c *Unary_operatorContext)

	// EnterNew_expression is called when entering the new_expression production.
	EnterNew_expression(c *New_expressionContext)

	// EnterNew_initializer is called when entering the new_initializer production.
	EnterNew_initializer(c *New_initializerContext)

	// EnterMultiplicative_expression is called when entering the multiplicative_expression production.
	EnterMultiplicative_expression(c *Multiplicative_expressionContext)

	// EnterAdditive_expression is called when entering the additive_expression production.
	EnterAdditive_expression(c *Additive_expressionContext)

	// EnterShift_expression is called when entering the shift_expression production.
	EnterShift_expression(c *Shift_expressionContext)

	// EnterShiftoperator is called when entering the shiftoperator production.
	EnterShiftoperator(c *ShiftoperatorContext)

	// EnterRelational_expression is called when entering the relational_expression production.
	EnterRelational_expression(c *Relational_expressionContext)

	// EnterEquality_expression is called when entering the equality_expression production.
	EnterEquality_expression(c *Equality_expressionContext)

	// EnterAnd_expression is called when entering the and_expression production.
	EnterAnd_expression(c *And_expressionContext)

	// EnterExclusiveor_expression is called when entering the exclusiveor_expression production.
	EnterExclusiveor_expression(c *Exclusiveor_expressionContext)

	// EnterInclusiveor_expression is called when entering the inclusiveor_expression production.
	EnterInclusiveor_expression(c *Inclusiveor_expressionContext)

	// EnterLogical_and_expression is called when entering the logical_and_expression production.
	EnterLogical_and_expression(c *Logical_and_expressionContext)

	// EnterLogical_or_expression is called when entering the logical_or_expression production.
	EnterLogical_or_expression(c *Logical_or_expressionContext)

	// EnterConditional_expression is called when entering the conditional_expression production.
	EnterConditional_expression(c *Conditional_expressionContext)

	// EnterAssignment_expression is called when entering the assignment_expression production.
	EnterAssignment_expression(c *Assignment_expressionContext)

	// EnterAssignment_operator is called when entering the assignment_operator production.
	EnterAssignment_operator(c *Assignment_operatorContext)

	// EnterExpression is called when entering the expression production.
	EnterExpression(c *ExpressionContext)

	// EnterConstant_expression is called when entering the constant_expression production.
	EnterConstant_expression(c *Constant_expressionContext)

	// EnterStatement is called when entering the statement production.
	EnterStatement(c *StatementContext)

	// EnterLabeled_statement is called when entering the labeled_statement production.
	EnterLabeled_statement(c *Labeled_statementContext)

	// EnterExpression_statement is called when entering the expression_statement production.
	EnterExpression_statement(c *Expression_statementContext)

	// EnterCompound_statement is called when entering the compound_statement production.
	EnterCompound_statement(c *Compound_statementContext)

	// EnterStatement_sequence is called when entering the statement_sequence production.
	EnterStatement_sequence(c *Statement_sequenceContext)

	// EnterSelection_statement is called when entering the selection_statement production.
	EnterSelection_statement(c *Selection_statementContext)

	// EnterCondition is called when entering the condition production.
	EnterCondition(c *ConditionContext)

	// EnterIteration_statement is called when entering the iteration_statement production.
	EnterIteration_statement(c *Iteration_statementContext)

	// EnterFor_init_statement is called when entering the for_init_statement production.
	EnterFor_init_statement(c *For_init_statementContext)

	// EnterFor_range_declaration is called when entering the for_range_declaration production.
	EnterFor_range_declaration(c *For_range_declarationContext)

	// EnterFor_range_initializer is called when entering the for_range_initializer production.
	EnterFor_range_initializer(c *For_range_initializerContext)

	// EnterJump_statement is called when entering the jump_statement production.
	EnterJump_statement(c *Jump_statementContext)

	// EnterDeclaration_statement is called when entering the declaration_statement production.
	EnterDeclaration_statement(c *Declaration_statementContext)

	// EnterDeclaration_sequence is called when entering the declaration_sequence production.
	EnterDeclaration_sequence(c *Declaration_sequenceContext)

	// EnterDeclaration is called when entering the declaration production.
	EnterDeclaration(c *DeclarationContext)

	// EnterBlock_declaration is called when entering the block_declaration production.
	EnterBlock_declaration(c *Block_declarationContext)

	// EnterSimple_declaration is called when entering the simple_declaration production.
	EnterSimple_declaration(c *Simple_declarationContext)

	// EnterEmpty_declaration is called when entering the empty_declaration production.
	EnterEmpty_declaration(c *Empty_declarationContext)

	// EnterDecl_specifier is called when entering the decl_specifier production.
	EnterDecl_specifier(c *Decl_specifierContext)

	// EnterDecl_specifier_sequence is called when entering the decl_specifier_sequence production.
	EnterDecl_specifier_sequence(c *Decl_specifier_sequenceContext)

	// EnterType_specifier is called when entering the type_specifier production.
	EnterType_specifier(c *Type_specifierContext)

	// EnterTrailing_type_specifier is called when entering the trailing_type_specifier production.
	EnterTrailing_type_specifier(c *Trailing_type_specifierContext)

	// EnterType_specifier_sequence is called when entering the type_specifier_sequence production.
	EnterType_specifier_sequence(c *Type_specifier_sequenceContext)

	// EnterTrailing_type_specifier_sequence is called when entering the trailing_type_specifier_sequence production.
	EnterTrailing_type_specifier_sequence(c *Trailing_type_specifier_sequenceContext)

	// EnterSimple_type_specifier is called when entering the simple_type_specifier production.
	EnterSimple_type_specifier(c *Simple_type_specifierContext)

	// EnterType_name is called when entering the type_name production.
	EnterType_name(c *Type_nameContext)

	// EnterEnum_name is called when entering the enum_name production.
	EnterEnum_name(c *Enum_nameContext)

	// EnterEnum_specifier is called when entering the enum_specifier production.
	EnterEnum_specifier(c *Enum_specifierContext)

	// EnterEnum_head is called when entering the enum_head production.
	EnterEnum_head(c *Enum_headContext)

	// EnterEnum_key is called when entering the enum_key production.
	EnterEnum_key(c *Enum_keyContext)

	// EnterEnum_base is called when entering the enum_base production.
	EnterEnum_base(c *Enum_baseContext)

	// EnterEnumerator_list is called when entering the enumerator_list production.
	EnterEnumerator_list(c *Enumerator_listContext)

	// EnterEnumerator_definition is called when entering the enumerator_definition production.
	EnterEnumerator_definition(c *Enumerator_definitionContext)

	// EnterEnumerator is called when entering the enumerator production.
	EnterEnumerator(c *EnumeratorContext)

	// EnterNamespace_name is called when entering the namespace_name production.
	EnterNamespace_name(c *Namespace_nameContext)

	// EnterNamespace_definition is called when entering the namespace_definition production.
	EnterNamespace_definition(c *Namespace_definitionContext)

	// EnterNamed_namespace_definition is called when entering the named_namespace_definition production.
	EnterNamed_namespace_definition(c *Named_namespace_definitionContext)

	// EnterOriginal_namespace_definition is called when entering the original_namespace_definition production.
	EnterOriginal_namespace_definition(c *Original_namespace_definitionContext)

	// EnterExtension_namespace_definition is called when entering the extension_namespace_definition production.
	EnterExtension_namespace_definition(c *Extension_namespace_definitionContext)

	// EnterUnnamed_namespace_definition is called when entering the unnamed_namespace_definition production.
	EnterUnnamed_namespace_definition(c *Unnamed_namespace_definitionContext)

	// EnterNamespace_body is called when entering the namespace_body production.
	EnterNamespace_body(c *Namespace_bodyContext)

	// EnterQualified_namespace_specifier is called when entering the qualified_namespace_specifier production.
	EnterQualified_namespace_specifier(c *Qualified_namespace_specifierContext)

	// EnterUsing_namespace is called when entering the using_namespace production.
	EnterUsing_namespace(c *Using_namespaceContext)

	// EnterInit_declarator_list is called when entering the init_declarator_list production.
	EnterInit_declarator_list(c *Init_declarator_listContext)

	// EnterInit_declarator is called when entering the init_declarator production.
	EnterInit_declarator(c *Init_declaratorContext)

	// EnterDeclarator is called when entering the declarator production.
	EnterDeclarator(c *DeclaratorContext)

	// EnterPtr_declarator is called when entering the ptr_declarator production.
	EnterPtr_declarator(c *Ptr_declaratorContext)

	// EnterNoptr_declarator is called when entering the noptr_declarator production.
	EnterNoptr_declarator(c *Noptr_declaratorContext)

	// EnterParameters_and_qualifiers is called when entering the parameters_and_qualifiers production.
	EnterParameters_and_qualifiers(c *Parameters_and_qualifiersContext)

	// EnterTrailing_return_type is called when entering the trailing_return_type production.
	EnterTrailing_return_type(c *Trailing_return_typeContext)

	// EnterRef_operator is called when entering the ref_operator production.
	EnterRef_operator(c *Ref_operatorContext)

	// EnterRef_qualifier is called when entering the ref_qualifier production.
	EnterRef_qualifier(c *Ref_qualifierContext)

	// EnterDeclarator_id is called when entering the declarator_id production.
	EnterDeclarator_id(c *Declarator_idContext)

	// EnterType_id is called when entering the type_id production.
	EnterType_id(c *Type_idContext)

	// EnterParameter_declaration_clause is called when entering the parameter_declaration_clause production.
	EnterParameter_declaration_clause(c *Parameter_declaration_clauseContext)

	// EnterParameter_declaration_list is called when entering the parameter_declaration_list production.
	EnterParameter_declaration_list(c *Parameter_declaration_listContext)

	// EnterParameter_declaration is called when entering the parameter_declaration production.
	EnterParameter_declaration(c *Parameter_declarationContext)

	// EnterFunction_definition is called when entering the function_definition production.
	EnterFunction_definition(c *Function_definitionContext)

	// EnterFunction_body is called when entering the function_body production.
	EnterFunction_body(c *Function_bodyContext)

	// EnterInitializer is called when entering the initializer production.
	EnterInitializer(c *InitializerContext)

	// EnterBrace_or_equal_initializer is called when entering the brace_or_equal_initializer production.
	EnterBrace_or_equal_initializer(c *Brace_or_equal_initializerContext)

	// EnterInitializer_clause is called when entering the initializer_clause production.
	EnterInitializer_clause(c *Initializer_clauseContext)

	// EnterInitializer_list is called when entering the initializer_list production.
	EnterInitializer_list(c *Initializer_listContext)

	// EnterBraced_init_list is called when entering the braced_init_list production.
	EnterBraced_init_list(c *Braced_init_listContext)

	// EnterClass_name is called when entering the class_name production.
	EnterClass_name(c *Class_nameContext)

	// EnterClass_specifier is called when entering the class_specifier production.
	EnterClass_specifier(c *Class_specifierContext)

	// EnterClass_head is called when entering the class_head production.
	EnterClass_head(c *Class_headContext)

	// EnterClass_head_name is called when entering the class_head_name production.
	EnterClass_head_name(c *Class_head_nameContext)

	// EnterMember_specification is called when entering the member_specification production.
	EnterMember_specification(c *Member_specificationContext)

	// EnterMember_declaration is called when entering the member_declaration production.
	EnterMember_declaration(c *Member_declarationContext)

	// EnterMember_declarator_list is called when entering the member_declarator_list production.
	EnterMember_declarator_list(c *Member_declarator_listContext)

	// EnterMember_declarator is called when entering the member_declarator production.
	EnterMember_declarator(c *Member_declaratorContext)

	// EnterBase_clause is called when entering the base_clause production.
	EnterBase_clause(c *Base_clauseContext)

	// EnterBase_specifier_list is called when entering the base_specifier_list production.
	EnterBase_specifier_list(c *Base_specifier_listContext)

	// EnterBase_specifier is called when entering the base_specifier production.
	EnterBase_specifier(c *Base_specifierContext)

	// EnterClass_or_decltype is called when entering the class_or_decltype production.
	EnterClass_or_decltype(c *Class_or_decltypeContext)

	// EnterBase_type_specifier is called when entering the base_type_specifier production.
	EnterBase_type_specifier(c *Base_type_specifierContext)

	// EnterAccess_specifier is called when entering the access_specifier production.
	EnterAccess_specifier(c *Access_specifierContext)

	// EnterMem_initializer_list is called when entering the mem_initializer_list production.
	EnterMem_initializer_list(c *Mem_initializer_listContext)

	// EnterMem_initializer is called when entering the mem_initializer production.
	EnterMem_initializer(c *Mem_initializerContext)

	// EnterMem_initializer_id is called when entering the mem_initializer_id production.
	EnterMem_initializer_id(c *Mem_initializer_idContext)

	// EnterOperator_function_id is called when entering the operator_function_id production.
	EnterOperator_function_id(c *Operator_function_idContext)

	// EnterTemplate_parameter_list is called when entering the template_parameter_list production.
	EnterTemplate_parameter_list(c *Template_parameter_listContext)

	// EnterTemplate_parameter is called when entering the template_parameter production.
	EnterTemplate_parameter(c *Template_parameterContext)

	// EnterType_parameter is called when entering the type_parameter production.
	EnterType_parameter(c *Type_parameterContext)

	// EnterTemplate_id is called when entering the template_id production.
	EnterTemplate_id(c *Template_idContext)

	// EnterTemplate_name is called when entering the template_name production.
	EnterTemplate_name(c *Template_nameContext)

	// EnterTemplate_argument_list is called when entering the template_argument_list production.
	EnterTemplate_argument_list(c *Template_argument_listContext)

	// EnterTemplate_argument is called when entering the template_argument production.
	EnterTemplate_argument(c *Template_argumentContext)

	// EnterType_name_specifier is called when entering the type_name_specifier production.
	EnterType_name_specifier(c *Type_name_specifierContext)

	// EnterTry_block is called when entering the try_block production.
	EnterTry_block(c *Try_blockContext)

	// EnterFunction_try_block is called when entering the function_try_block production.
	EnterFunction_try_block(c *Function_try_blockContext)

	// EnterHandler_sequence is called when entering the handler_sequence production.
	EnterHandler_sequence(c *Handler_sequenceContext)

	// EnterHandler is called when entering the handler production.
	EnterHandler(c *HandlerContext)

	// EnterException_declaration is called when entering the exception_declaration production.
	EnterException_declaration(c *Exception_declarationContext)

	// EnterThrow_expression is called when entering the throw_expression production.
	EnterThrow_expression(c *Throw_expressionContext)

	// EnterException_specification is called when entering the exception_specification production.
	EnterException_specification(c *Exception_specificationContext)

	// EnterType_id_list is called when entering the type_id_list production.
	EnterType_id_list(c *Type_id_listContext)

	// EnterOperators is called when entering the operators production.
	EnterOperators(c *OperatorsContext)

	// EnterLiteral is called when entering the literal production.
	EnterLiteral(c *LiteralContext)

	// ExitTranslation_unit is called when exiting the translation_unit production.
	ExitTranslation_unit(c *Translation_unitContext)

	// ExitPrimary_expression is called when exiting the primary_expression production.
	ExitPrimary_expression(c *Primary_expressionContext)

	// ExitId_expression is called when exiting the id_expression production.
	ExitId_expression(c *Id_expressionContext)

	// ExitUnqualified_id is called when exiting the unqualified_id production.
	ExitUnqualified_id(c *Unqualified_idContext)

	// ExitQualified_id is called when exiting the qualified_id production.
	ExitQualified_id(c *Qualified_idContext)

	// ExitNested_name_specifier is called when exiting the nested_name_specifier production.
	ExitNested_name_specifier(c *Nested_name_specifierContext)

	// ExitLambda_expression is called when exiting the lambda_expression production.
	ExitLambda_expression(c *Lambda_expressionContext)

	// ExitLambda_declarator is called when exiting the lambda_declarator production.
	ExitLambda_declarator(c *Lambda_declaratorContext)

	// ExitPost_fix_expression is called when exiting the post_fix_expression production.
	ExitPost_fix_expression(c *Post_fix_expressionContext)

	// ExitExpression_list is called when exiting the expression_list production.
	ExitExpression_list(c *Expression_listContext)

	// ExitUnary_expression is called when exiting the unary_expression production.
	ExitUnary_expression(c *Unary_expressionContext)

	// ExitUnary_operator is called when exiting the unary_operator production.
	ExitUnary_operator(c *Unary_operatorContext)

	// ExitNew_expression is called when exiting the new_expression production.
	ExitNew_expression(c *New_expressionContext)

	// ExitNew_initializer is called when exiting the new_initializer production.
	ExitNew_initializer(c *New_initializerContext)

	// ExitMultiplicative_expression is called when exiting the multiplicative_expression production.
	ExitMultiplicative_expression(c *Multiplicative_expressionContext)

	// ExitAdditive_expression is called when exiting the additive_expression production.
	ExitAdditive_expression(c *Additive_expressionContext)

	// ExitShift_expression is called when exiting the shift_expression production.
	ExitShift_expression(c *Shift_expressionContext)

	// ExitShiftoperator is called when exiting the shiftoperator production.
	ExitShiftoperator(c *ShiftoperatorContext)

	// ExitRelational_expression is called when exiting the relational_expression production.
	ExitRelational_expression(c *Relational_expressionContext)

	// ExitEquality_expression is called when exiting the equality_expression production.
	ExitEquality_expression(c *Equality_expressionContext)

	// ExitAnd_expression is called when exiting the and_expression production.
	ExitAnd_expression(c *And_expressionContext)

	// ExitExclusiveor_expression is called when exiting the exclusiveor_expression production.
	ExitExclusiveor_expression(c *Exclusiveor_expressionContext)

	// ExitInclusiveor_expression is called when exiting the inclusiveor_expression production.
	ExitInclusiveor_expression(c *Inclusiveor_expressionContext)

	// ExitLogical_and_expression is called when exiting the logical_and_expression production.
	ExitLogical_and_expression(c *Logical_and_expressionContext)

	// ExitLogical_or_expression is called when exiting the logical_or_expression production.
	ExitLogical_or_expression(c *Logical_or_expressionContext)

	// ExitConditional_expression is called when exiting the conditional_expression production.
	ExitConditional_expression(c *Conditional_expressionContext)

	// ExitAssignment_expression is called when exiting the assignment_expression production.
	ExitAssignment_expression(c *Assignment_expressionContext)

	// ExitAssignment_operator is called when exiting the assignment_operator production.
	ExitAssignment_operator(c *Assignment_operatorContext)

	// ExitExpression is called when exiting the expression production.
	ExitExpression(c *ExpressionContext)

	// ExitConstant_expression is called when exiting the constant_expression production.
	ExitConstant_expression(c *Constant_expressionContext)

	// ExitStatement is called when exiting the statement production.
	ExitStatement(c *StatementContext)

	// ExitLabeled_statement is called when exiting the labeled_statement production.
	ExitLabeled_statement(c *Labeled_statementContext)

	// ExitExpression_statement is called when exiting the expression_statement production.
	ExitExpression_statement(c *Expression_statementContext)

	// ExitCompound_statement is called when exiting the compound_statement production.
	ExitCompound_statement(c *Compound_statementContext)

	// ExitStatement_sequence is called when exiting the statement_sequence production.
	ExitStatement_sequence(c *Statement_sequenceContext)

	// ExitSelection_statement is called when exiting the selection_statement production.
	ExitSelection_statement(c *Selection_statementContext)

	// ExitCondition is called when exiting the condition production.
	ExitCondition(c *ConditionContext)

	// ExitIteration_statement is called when exiting the iteration_statement production.
	ExitIteration_statement(c *Iteration_statementContext)

	// ExitFor_init_statement is called when exiting the for_init_statement production.
	ExitFor_init_statement(c *For_init_statementContext)

	// ExitFor_range_declaration is called when exiting the for_range_declaration production.
	ExitFor_range_declaration(c *For_range_declarationContext)

	// ExitFor_range_initializer is called when exiting the for_range_initializer production.
	ExitFor_range_initializer(c *For_range_initializerContext)

	// ExitJump_statement is called when exiting the jump_statement production.
	ExitJump_statement(c *Jump_statementContext)

	// ExitDeclaration_statement is called when exiting the declaration_statement production.
	ExitDeclaration_statement(c *Declaration_statementContext)

	// ExitDeclaration_sequence is called when exiting the declaration_sequence production.
	ExitDeclaration_sequence(c *Declaration_sequenceContext)

	// ExitDeclaration is called when exiting the declaration production.
	ExitDeclaration(c *DeclarationContext)

	// ExitBlock_declaration is called when exiting the block_declaration production.
	ExitBlock_declaration(c *Block_declarationContext)

	// ExitSimple_declaration is called when exiting the simple_declaration production.
	ExitSimple_declaration(c *Simple_declarationContext)

	// ExitEmpty_declaration is called when exiting the empty_declaration production.
	ExitEmpty_declaration(c *Empty_declarationContext)

	// ExitDecl_specifier is called when exiting the decl_specifier production.
	ExitDecl_specifier(c *Decl_specifierContext)

	// ExitDecl_specifier_sequence is called when exiting the decl_specifier_sequence production.
	ExitDecl_specifier_sequence(c *Decl_specifier_sequenceContext)

	// ExitType_specifier is called when exiting the type_specifier production.
	ExitType_specifier(c *Type_specifierContext)

	// ExitTrailing_type_specifier is called when exiting the trailing_type_specifier production.
	ExitTrailing_type_specifier(c *Trailing_type_specifierContext)

	// ExitType_specifier_sequence is called when exiting the type_specifier_sequence production.
	ExitType_specifier_sequence(c *Type_specifier_sequenceContext)

	// ExitTrailing_type_specifier_sequence is called when exiting the trailing_type_specifier_sequence production.
	ExitTrailing_type_specifier_sequence(c *Trailing_type_specifier_sequenceContext)

	// ExitSimple_type_specifier is called when exiting the simple_type_specifier production.
	ExitSimple_type_specifier(c *Simple_type_specifierContext)

	// ExitType_name is called when exiting the type_name production.
	ExitType_name(c *Type_nameContext)

	// ExitEnum_name is called when exiting the enum_name production.
	ExitEnum_name(c *Enum_nameContext)

	// ExitEnum_specifier is called when exiting the enum_specifier production.
	ExitEnum_specifier(c *Enum_specifierContext)

	// ExitEnum_head is called when exiting the enum_head production.
	ExitEnum_head(c *Enum_headContext)

	// ExitEnum_key is called when exiting the enum_key production.
	ExitEnum_key(c *Enum_keyContext)

	// ExitEnum_base is called when exiting the enum_base production.
	ExitEnum_base(c *Enum_baseContext)

	// ExitEnumerator_list is called when exiting the enumerator_list production.
	ExitEnumerator_list(c *Enumerator_listContext)

	// ExitEnumerator_definition is called when exiting the enumerator_definition production.
	ExitEnumerator_definition(c *Enumerator_definitionContext)

	// ExitEnumerator is called when exiting the enumerator production.
	ExitEnumerator(c *EnumeratorContext)

	// ExitNamespace_name is called when exiting the namespace_name production.
	ExitNamespace_name(c *Namespace_nameContext)

	// ExitNamespace_definition is called when exiting the namespace_definition production.
	ExitNamespace_definition(c *Namespace_definitionContext)

	// ExitNamed_namespace_definition is called when exiting the named_namespace_definition production.
	ExitNamed_namespace_definition(c *Named_namespace_definitionContext)

	// ExitOriginal_namespace_definition is called when exiting the original_namespace_definition production.
	ExitOriginal_namespace_definition(c *Original_namespace_definitionContext)

	// ExitExtension_namespace_definition is called when exiting the extension_namespace_definition production.
	ExitExtension_namespace_definition(c *Extension_namespace_definitionContext)

	// ExitUnnamed_namespace_definition is called when exiting the unnamed_namespace_definition production.
	ExitUnnamed_namespace_definition(c *Unnamed_namespace_definitionContext)

	// ExitNamespace_body is called when exiting the namespace_body production.
	ExitNamespace_body(c *Namespace_bodyContext)

	// ExitQualified_namespace_specifier is called when exiting the qualified_namespace_specifier production.
	ExitQualified_namespace_specifier(c *Qualified_namespace_specifierContext)

	// ExitUsing_namespace is called when exiting the using_namespace production.
	ExitUsing_namespace(c *Using_namespaceContext)

	// ExitInit_declarator_list is called when exiting the init_declarator_list production.
	ExitInit_declarator_list(c *Init_declarator_listContext)

	// ExitInit_declarator is called when exiting the init_declarator production.
	ExitInit_declarator(c *Init_declaratorContext)

	// ExitDeclarator is called when exiting the declarator production.
	ExitDeclarator(c *DeclaratorContext)

	// ExitPtr_declarator is called when exiting the ptr_declarator production.
	ExitPtr_declarator(c *Ptr_declaratorContext)

	// ExitNoptr_declarator is called when exiting the noptr_declarator production.
	ExitNoptr_declarator(c *Noptr_declaratorContext)

	// ExitParameters_and_qualifiers is called when exiting the parameters_and_qualifiers production.
	ExitParameters_and_qualifiers(c *Parameters_and_qualifiersContext)

	// ExitTrailing_return_type is called when exiting the trailing_return_type production.
	ExitTrailing_return_type(c *Trailing_return_typeContext)

	// ExitRef_operator is called when exiting the ref_operator production.
	ExitRef_operator(c *Ref_operatorContext)

	// ExitRef_qualifier is called when exiting the ref_qualifier production.
	ExitRef_qualifier(c *Ref_qualifierContext)

	// ExitDeclarator_id is called when exiting the declarator_id production.
	ExitDeclarator_id(c *Declarator_idContext)

	// ExitType_id is called when exiting the type_id production.
	ExitType_id(c *Type_idContext)

	// ExitParameter_declaration_clause is called when exiting the parameter_declaration_clause production.
	ExitParameter_declaration_clause(c *Parameter_declaration_clauseContext)

	// ExitParameter_declaration_list is called when exiting the parameter_declaration_list production.
	ExitParameter_declaration_list(c *Parameter_declaration_listContext)

	// ExitParameter_declaration is called when exiting the parameter_declaration production.
	ExitParameter_declaration(c *Parameter_declarationContext)

	// ExitFunction_definition is called when exiting the function_definition production.
	ExitFunction_definition(c *Function_definitionContext)

	// ExitFunction_body is called when exiting the function_body production.
	ExitFunction_body(c *Function_bodyContext)

	// ExitInitializer is called when exiting the initializer production.
	ExitInitializer(c *InitializerContext)

	// ExitBrace_or_equal_initializer is called when exiting the brace_or_equal_initializer production.
	ExitBrace_or_equal_initializer(c *Brace_or_equal_initializerContext)

	// ExitInitializer_clause is called when exiting the initializer_clause production.
	ExitInitializer_clause(c *Initializer_clauseContext)

	// ExitInitializer_list is called when exiting the initializer_list production.
	ExitInitializer_list(c *Initializer_listContext)

	// ExitBraced_init_list is called when exiting the braced_init_list production.
	ExitBraced_init_list(c *Braced_init_listContext)

	// ExitClass_name is called when exiting the class_name production.
	ExitClass_name(c *Class_nameContext)

	// ExitClass_specifier is called when exiting the class_specifier production.
	ExitClass_specifier(c *Class_specifierContext)

	// ExitClass_head is called when exiting the class_head production.
	ExitClass_head(c *Class_headContext)

	// ExitClass_head_name is called when exiting the class_head_name production.
	ExitClass_head_name(c *Class_head_nameContext)

	// ExitMember_specification is called when exiting the member_specification production.
	ExitMember_specification(c *Member_specificationContext)

	// ExitMember_declaration is called when exiting the member_declaration production.
	ExitMember_declaration(c *Member_declarationContext)

	// ExitMember_declarator_list is called when exiting the member_declarator_list production.
	ExitMember_declarator_list(c *Member_declarator_listContext)

	// ExitMember_declarator is called when exiting the member_declarator production.
	ExitMember_declarator(c *Member_declaratorContext)

	// ExitBase_clause is called when exiting the base_clause production.
	ExitBase_clause(c *Base_clauseContext)

	// ExitBase_specifier_list is called when exiting the base_specifier_list production.
	ExitBase_specifier_list(c *Base_specifier_listContext)

	// ExitBase_specifier is called when exiting the base_specifier production.
	ExitBase_specifier(c *Base_specifierContext)

	// ExitClass_or_decltype is called when exiting the class_or_decltype production.
	ExitClass_or_decltype(c *Class_or_decltypeContext)

	// ExitBase_type_specifier is called when exiting the base_type_specifier production.
	ExitBase_type_specifier(c *Base_type_specifierContext)

	// ExitAccess_specifier is called when exiting the access_specifier production.
	ExitAccess_specifier(c *Access_specifierContext)

	// ExitMem_initializer_list is called when exiting the mem_initializer_list production.
	ExitMem_initializer_list(c *Mem_initializer_listContext)

	// ExitMem_initializer is called when exiting the mem_initializer production.
	ExitMem_initializer(c *Mem_initializerContext)

	// ExitMem_initializer_id is called when exiting the mem_initializer_id production.
	ExitMem_initializer_id(c *Mem_initializer_idContext)

	// ExitOperator_function_id is called when exiting the operator_function_id production.
	ExitOperator_function_id(c *Operator_function_idContext)

	// ExitTemplate_parameter_list is called when exiting the template_parameter_list production.
	ExitTemplate_parameter_list(c *Template_parameter_listContext)

	// ExitTemplate_parameter is called when exiting the template_parameter production.
	ExitTemplate_parameter(c *Template_parameterContext)

	// ExitType_parameter is called when exiting the type_parameter production.
	ExitType_parameter(c *Type_parameterContext)

	// ExitTemplate_id is called when exiting the template_id production.
	ExitTemplate_id(c *Template_idContext)

	// ExitTemplate_name is called when exiting the template_name production.
	ExitTemplate_name(c *Template_nameContext)

	// ExitTemplate_argument_list is called when exiting the template_argument_list production.
	ExitTemplate_argument_list(c *Template_argument_listContext)

	// ExitTemplate_argument is called when exiting the template_argument production.
	ExitTemplate_argument(c *Template_argumentContext)

	// ExitType_name_specifier is called when exiting the type_name_specifier production.
	ExitType_name_specifier(c *Type_name_specifierContext)

	// ExitTry_block is called when exiting the try_block production.
	ExitTry_block(c *Try_blockContext)

	// ExitFunction_try_block is called when exiting the function_try_block production.
	ExitFunction_try_block(c *Function_try_blockContext)

	// ExitHandler_sequence is called when exiting the handler_sequence production.
	ExitHandler_sequence(c *Handler_sequenceContext)

	// ExitHandler is called when exiting the handler production.
	ExitHandler(c *HandlerContext)

	// ExitException_declaration is called when exiting the exception_declaration production.
	ExitException_declaration(c *Exception_declarationContext)

	// ExitThrow_expression is called when exiting the throw_expression production.
	ExitThrow_expression(c *Throw_expressionContext)

	// ExitException_specification is called when exiting the exception_specification production.
	ExitException_specification(c *Exception_specificationContext)

	// ExitType_id_list is called when exiting the type_id_list production.
	ExitType_id_list(c *Type_id_listContext)

	// ExitOperators is called when exiting the operators production.
	ExitOperators(c *OperatorsContext)

	// ExitLiteral is called when exiting the literal production.
	ExitLiteral(c *LiteralContext)
}
