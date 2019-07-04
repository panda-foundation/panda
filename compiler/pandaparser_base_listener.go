// Code generated from PandaParser.g4 by ANTLR 4.7.1. DO NOT EDIT.

package compiler // PandaParser
import "github.com/antlr/antlr4/runtime/Go/antlr"

// BasePandaParserListener is a complete listener for a parse tree produced by PandaParser.
type BasePandaParserListener struct{}

var _ PandaParserListener = &BasePandaParserListener{}

// VisitTerminal is called when a terminal node is visited.
func (s *BasePandaParserListener) VisitTerminal(node antlr.TerminalNode) {}

// VisitErrorNode is called when an error node is visited.
func (s *BasePandaParserListener) VisitErrorNode(node antlr.ErrorNode) {}

// EnterEveryRule is called when any rule is entered.
func (s *BasePandaParserListener) EnterEveryRule(ctx antlr.ParserRuleContext) {}

// ExitEveryRule is called when any rule is exited.
func (s *BasePandaParserListener) ExitEveryRule(ctx antlr.ParserRuleContext) {}

// EnterTranslation_unit is called when production translation_unit is entered.
func (s *BasePandaParserListener) EnterTranslation_unit(ctx *Translation_unitContext) {}

// ExitTranslation_unit is called when production translation_unit is exited.
func (s *BasePandaParserListener) ExitTranslation_unit(ctx *Translation_unitContext) {}

// EnterPrimary_expression is called when production primary_expression is entered.
func (s *BasePandaParserListener) EnterPrimary_expression(ctx *Primary_expressionContext) {}

// ExitPrimary_expression is called when production primary_expression is exited.
func (s *BasePandaParserListener) ExitPrimary_expression(ctx *Primary_expressionContext) {}

// EnterId_expression is called when production id_expression is entered.
func (s *BasePandaParserListener) EnterId_expression(ctx *Id_expressionContext) {}

// ExitId_expression is called when production id_expression is exited.
func (s *BasePandaParserListener) ExitId_expression(ctx *Id_expressionContext) {}

// EnterUnqualified_id is called when production unqualified_id is entered.
func (s *BasePandaParserListener) EnterUnqualified_id(ctx *Unqualified_idContext) {}

// ExitUnqualified_id is called when production unqualified_id is exited.
func (s *BasePandaParserListener) ExitUnqualified_id(ctx *Unqualified_idContext) {}

// EnterQualified_id is called when production qualified_id is entered.
func (s *BasePandaParserListener) EnterQualified_id(ctx *Qualified_idContext) {}

// ExitQualified_id is called when production qualified_id is exited.
func (s *BasePandaParserListener) ExitQualified_id(ctx *Qualified_idContext) {}

// EnterNested_name_specifier is called when production nested_name_specifier is entered.
func (s *BasePandaParserListener) EnterNested_name_specifier(ctx *Nested_name_specifierContext) {}

// ExitNested_name_specifier is called when production nested_name_specifier is exited.
func (s *BasePandaParserListener) ExitNested_name_specifier(ctx *Nested_name_specifierContext) {}

// EnterPost_fix_expression is called when production post_fix_expression is entered.
func (s *BasePandaParserListener) EnterPost_fix_expression(ctx *Post_fix_expressionContext) {}

// ExitPost_fix_expression is called when production post_fix_expression is exited.
func (s *BasePandaParserListener) ExitPost_fix_expression(ctx *Post_fix_expressionContext) {}

// EnterExpression_list is called when production expression_list is entered.
func (s *BasePandaParserListener) EnterExpression_list(ctx *Expression_listContext) {}

// ExitExpression_list is called when production expression_list is exited.
func (s *BasePandaParserListener) ExitExpression_list(ctx *Expression_listContext) {}

// EnterUnary_expression is called when production unary_expression is entered.
func (s *BasePandaParserListener) EnterUnary_expression(ctx *Unary_expressionContext) {}

// ExitUnary_expression is called when production unary_expression is exited.
func (s *BasePandaParserListener) ExitUnary_expression(ctx *Unary_expressionContext) {}

// EnterUnary_operator is called when production unary_operator is entered.
func (s *BasePandaParserListener) EnterUnary_operator(ctx *Unary_operatorContext) {}

// ExitUnary_operator is called when production unary_operator is exited.
func (s *BasePandaParserListener) ExitUnary_operator(ctx *Unary_operatorContext) {}

// EnterNew_expression is called when production new_expression is entered.
func (s *BasePandaParserListener) EnterNew_expression(ctx *New_expressionContext) {}

// ExitNew_expression is called when production new_expression is exited.
func (s *BasePandaParserListener) ExitNew_expression(ctx *New_expressionContext) {}

// EnterNew_initializer is called when production new_initializer is entered.
func (s *BasePandaParserListener) EnterNew_initializer(ctx *New_initializerContext) {}

// ExitNew_initializer is called when production new_initializer is exited.
func (s *BasePandaParserListener) ExitNew_initializer(ctx *New_initializerContext) {}

// EnterMultiplicative_expression is called when production multiplicative_expression is entered.
func (s *BasePandaParserListener) EnterMultiplicative_expression(ctx *Multiplicative_expressionContext) {
}

// ExitMultiplicative_expression is called when production multiplicative_expression is exited.
func (s *BasePandaParserListener) ExitMultiplicative_expression(ctx *Multiplicative_expressionContext) {
}

// EnterAdditive_expression is called when production additive_expression is entered.
func (s *BasePandaParserListener) EnterAdditive_expression(ctx *Additive_expressionContext) {}

// ExitAdditive_expression is called when production additive_expression is exited.
func (s *BasePandaParserListener) ExitAdditive_expression(ctx *Additive_expressionContext) {}

// EnterShift_expression is called when production shift_expression is entered.
func (s *BasePandaParserListener) EnterShift_expression(ctx *Shift_expressionContext) {}

// ExitShift_expression is called when production shift_expression is exited.
func (s *BasePandaParserListener) ExitShift_expression(ctx *Shift_expressionContext) {}

// EnterShiftoperator is called when production shiftoperator is entered.
func (s *BasePandaParserListener) EnterShiftoperator(ctx *ShiftoperatorContext) {}

// ExitShiftoperator is called when production shiftoperator is exited.
func (s *BasePandaParserListener) ExitShiftoperator(ctx *ShiftoperatorContext) {}

// EnterRelational_expression is called when production relational_expression is entered.
func (s *BasePandaParserListener) EnterRelational_expression(ctx *Relational_expressionContext) {}

// ExitRelational_expression is called when production relational_expression is exited.
func (s *BasePandaParserListener) ExitRelational_expression(ctx *Relational_expressionContext) {}

// EnterEquality_expression is called when production equality_expression is entered.
func (s *BasePandaParserListener) EnterEquality_expression(ctx *Equality_expressionContext) {}

// ExitEquality_expression is called when production equality_expression is exited.
func (s *BasePandaParserListener) ExitEquality_expression(ctx *Equality_expressionContext) {}

// EnterAnd_expression is called when production and_expression is entered.
func (s *BasePandaParserListener) EnterAnd_expression(ctx *And_expressionContext) {}

// ExitAnd_expression is called when production and_expression is exited.
func (s *BasePandaParserListener) ExitAnd_expression(ctx *And_expressionContext) {}

// EnterExclusiveor_expression is called when production exclusiveor_expression is entered.
func (s *BasePandaParserListener) EnterExclusiveor_expression(ctx *Exclusiveor_expressionContext) {}

// ExitExclusiveor_expression is called when production exclusiveor_expression is exited.
func (s *BasePandaParserListener) ExitExclusiveor_expression(ctx *Exclusiveor_expressionContext) {}

// EnterInclusiveor_expression is called when production inclusiveor_expression is entered.
func (s *BasePandaParserListener) EnterInclusiveor_expression(ctx *Inclusiveor_expressionContext) {}

// ExitInclusiveor_expression is called when production inclusiveor_expression is exited.
func (s *BasePandaParserListener) ExitInclusiveor_expression(ctx *Inclusiveor_expressionContext) {}

// EnterLogical_and_expression is called when production logical_and_expression is entered.
func (s *BasePandaParserListener) EnterLogical_and_expression(ctx *Logical_and_expressionContext) {}

// ExitLogical_and_expression is called when production logical_and_expression is exited.
func (s *BasePandaParserListener) ExitLogical_and_expression(ctx *Logical_and_expressionContext) {}

// EnterLogical_or_expression is called when production logical_or_expression is entered.
func (s *BasePandaParserListener) EnterLogical_or_expression(ctx *Logical_or_expressionContext) {}

// ExitLogical_or_expression is called when production logical_or_expression is exited.
func (s *BasePandaParserListener) ExitLogical_or_expression(ctx *Logical_or_expressionContext) {}

// EnterConditional_expression is called when production conditional_expression is entered.
func (s *BasePandaParserListener) EnterConditional_expression(ctx *Conditional_expressionContext) {}

// ExitConditional_expression is called when production conditional_expression is exited.
func (s *BasePandaParserListener) ExitConditional_expression(ctx *Conditional_expressionContext) {}

// EnterAssignment_expression is called when production assignment_expression is entered.
func (s *BasePandaParserListener) EnterAssignment_expression(ctx *Assignment_expressionContext) {}

// ExitAssignment_expression is called when production assignment_expression is exited.
func (s *BasePandaParserListener) ExitAssignment_expression(ctx *Assignment_expressionContext) {}

// EnterAssignment_operator is called when production assignment_operator is entered.
func (s *BasePandaParserListener) EnterAssignment_operator(ctx *Assignment_operatorContext) {}

// ExitAssignment_operator is called when production assignment_operator is exited.
func (s *BasePandaParserListener) ExitAssignment_operator(ctx *Assignment_operatorContext) {}

// EnterExpression is called when production expression is entered.
func (s *BasePandaParserListener) EnterExpression(ctx *ExpressionContext) {}

// ExitExpression is called when production expression is exited.
func (s *BasePandaParserListener) ExitExpression(ctx *ExpressionContext) {}

// EnterConstant_expression is called when production constant_expression is entered.
func (s *BasePandaParserListener) EnterConstant_expression(ctx *Constant_expressionContext) {}

// ExitConstant_expression is called when production constant_expression is exited.
func (s *BasePandaParserListener) ExitConstant_expression(ctx *Constant_expressionContext) {}

// EnterStatement is called when production statement is entered.
func (s *BasePandaParserListener) EnterStatement(ctx *StatementContext) {}

// ExitStatement is called when production statement is exited.
func (s *BasePandaParserListener) ExitStatement(ctx *StatementContext) {}

// EnterLabeled_statement is called when production labeled_statement is entered.
func (s *BasePandaParserListener) EnterLabeled_statement(ctx *Labeled_statementContext) {}

// ExitLabeled_statement is called when production labeled_statement is exited.
func (s *BasePandaParserListener) ExitLabeled_statement(ctx *Labeled_statementContext) {}

// EnterExpression_statement is called when production expression_statement is entered.
func (s *BasePandaParserListener) EnterExpression_statement(ctx *Expression_statementContext) {}

// ExitExpression_statement is called when production expression_statement is exited.
func (s *BasePandaParserListener) ExitExpression_statement(ctx *Expression_statementContext) {}

// EnterCompound_statement is called when production compound_statement is entered.
func (s *BasePandaParserListener) EnterCompound_statement(ctx *Compound_statementContext) {}

// ExitCompound_statement is called when production compound_statement is exited.
func (s *BasePandaParserListener) ExitCompound_statement(ctx *Compound_statementContext) {}

// EnterStatement_sequence is called when production statement_sequence is entered.
func (s *BasePandaParserListener) EnterStatement_sequence(ctx *Statement_sequenceContext) {}

// ExitStatement_sequence is called when production statement_sequence is exited.
func (s *BasePandaParserListener) ExitStatement_sequence(ctx *Statement_sequenceContext) {}

// EnterSelection_statement is called when production selection_statement is entered.
func (s *BasePandaParserListener) EnterSelection_statement(ctx *Selection_statementContext) {}

// ExitSelection_statement is called when production selection_statement is exited.
func (s *BasePandaParserListener) ExitSelection_statement(ctx *Selection_statementContext) {}

// EnterCondition is called when production condition is entered.
func (s *BasePandaParserListener) EnterCondition(ctx *ConditionContext) {}

// ExitCondition is called when production condition is exited.
func (s *BasePandaParserListener) ExitCondition(ctx *ConditionContext) {}

// EnterIteration_statement is called when production iteration_statement is entered.
func (s *BasePandaParserListener) EnterIteration_statement(ctx *Iteration_statementContext) {}

// ExitIteration_statement is called when production iteration_statement is exited.
func (s *BasePandaParserListener) ExitIteration_statement(ctx *Iteration_statementContext) {}

// EnterFor_init_statement is called when production for_init_statement is entered.
func (s *BasePandaParserListener) EnterFor_init_statement(ctx *For_init_statementContext) {}

// ExitFor_init_statement is called when production for_init_statement is exited.
func (s *BasePandaParserListener) ExitFor_init_statement(ctx *For_init_statementContext) {}

// EnterFor_range_declaration is called when production for_range_declaration is entered.
func (s *BasePandaParserListener) EnterFor_range_declaration(ctx *For_range_declarationContext) {}

// ExitFor_range_declaration is called when production for_range_declaration is exited.
func (s *BasePandaParserListener) ExitFor_range_declaration(ctx *For_range_declarationContext) {}

// EnterFor_range_initializer is called when production for_range_initializer is entered.
func (s *BasePandaParserListener) EnterFor_range_initializer(ctx *For_range_initializerContext) {}

// ExitFor_range_initializer is called when production for_range_initializer is exited.
func (s *BasePandaParserListener) ExitFor_range_initializer(ctx *For_range_initializerContext) {}

// EnterJump_statement is called when production jump_statement is entered.
func (s *BasePandaParserListener) EnterJump_statement(ctx *Jump_statementContext) {}

// ExitJump_statement is called when production jump_statement is exited.
func (s *BasePandaParserListener) ExitJump_statement(ctx *Jump_statementContext) {}

// EnterDeclaration_statement is called when production declaration_statement is entered.
func (s *BasePandaParserListener) EnterDeclaration_statement(ctx *Declaration_statementContext) {}

// ExitDeclaration_statement is called when production declaration_statement is exited.
func (s *BasePandaParserListener) ExitDeclaration_statement(ctx *Declaration_statementContext) {}

// EnterDeclaration_sequence is called when production declaration_sequence is entered.
func (s *BasePandaParserListener) EnterDeclaration_sequence(ctx *Declaration_sequenceContext) {}

// ExitDeclaration_sequence is called when production declaration_sequence is exited.
func (s *BasePandaParserListener) ExitDeclaration_sequence(ctx *Declaration_sequenceContext) {}

// EnterDeclaration is called when production declaration is entered.
func (s *BasePandaParserListener) EnterDeclaration(ctx *DeclarationContext) {}

// ExitDeclaration is called when production declaration is exited.
func (s *BasePandaParserListener) ExitDeclaration(ctx *DeclarationContext) {}

// EnterBlock_declaration is called when production block_declaration is entered.
func (s *BasePandaParserListener) EnterBlock_declaration(ctx *Block_declarationContext) {}

// ExitBlock_declaration is called when production block_declaration is exited.
func (s *BasePandaParserListener) ExitBlock_declaration(ctx *Block_declarationContext) {}

// EnterEmpty_declaration is called when production empty_declaration is entered.
func (s *BasePandaParserListener) EnterEmpty_declaration(ctx *Empty_declarationContext) {}

// ExitEmpty_declaration is called when production empty_declaration is exited.
func (s *BasePandaParserListener) ExitEmpty_declaration(ctx *Empty_declarationContext) {}

// EnterDecl_specifier is called when production decl_specifier is entered.
func (s *BasePandaParserListener) EnterDecl_specifier(ctx *Decl_specifierContext) {}

// ExitDecl_specifier is called when production decl_specifier is exited.
func (s *BasePandaParserListener) ExitDecl_specifier(ctx *Decl_specifierContext) {}

// EnterDecl_specifier_sequence is called when production decl_specifier_sequence is entered.
func (s *BasePandaParserListener) EnterDecl_specifier_sequence(ctx *Decl_specifier_sequenceContext) {}

// ExitDecl_specifier_sequence is called when production decl_specifier_sequence is exited.
func (s *BasePandaParserListener) ExitDecl_specifier_sequence(ctx *Decl_specifier_sequenceContext) {}

// EnterType_specifier_sequence is called when production type_specifier_sequence is entered.
func (s *BasePandaParserListener) EnterType_specifier_sequence(ctx *Type_specifier_sequenceContext) {}

// ExitType_specifier_sequence is called when production type_specifier_sequence is exited.
func (s *BasePandaParserListener) ExitType_specifier_sequence(ctx *Type_specifier_sequenceContext) {}

// EnterType_specifier is called when production type_specifier is entered.
func (s *BasePandaParserListener) EnterType_specifier(ctx *Type_specifierContext) {}

// ExitType_specifier is called when production type_specifier is exited.
func (s *BasePandaParserListener) ExitType_specifier(ctx *Type_specifierContext) {}

// EnterType_name is called when production type_name is entered.
func (s *BasePandaParserListener) EnterType_name(ctx *Type_nameContext) {}

// ExitType_name is called when production type_name is exited.
func (s *BasePandaParserListener) ExitType_name(ctx *Type_nameContext) {}

// EnterEnum_name is called when production enum_name is entered.
func (s *BasePandaParserListener) EnterEnum_name(ctx *Enum_nameContext) {}

// ExitEnum_name is called when production enum_name is exited.
func (s *BasePandaParserListener) ExitEnum_name(ctx *Enum_nameContext) {}

// EnterEnum_definition is called when production enum_definition is entered.
func (s *BasePandaParserListener) EnterEnum_definition(ctx *Enum_definitionContext) {}

// ExitEnum_definition is called when production enum_definition is exited.
func (s *BasePandaParserListener) ExitEnum_definition(ctx *Enum_definitionContext) {}

// EnterEnum_head is called when production enum_head is entered.
func (s *BasePandaParserListener) EnterEnum_head(ctx *Enum_headContext) {}

// ExitEnum_head is called when production enum_head is exited.
func (s *BasePandaParserListener) ExitEnum_head(ctx *Enum_headContext) {}

// EnterEnum_base is called when production enum_base is entered.
func (s *BasePandaParserListener) EnterEnum_base(ctx *Enum_baseContext) {}

// ExitEnum_base is called when production enum_base is exited.
func (s *BasePandaParserListener) ExitEnum_base(ctx *Enum_baseContext) {}

// EnterEnumerator_list is called when production enumerator_list is entered.
func (s *BasePandaParserListener) EnterEnumerator_list(ctx *Enumerator_listContext) {}

// ExitEnumerator_list is called when production enumerator_list is exited.
func (s *BasePandaParserListener) ExitEnumerator_list(ctx *Enumerator_listContext) {}

// EnterEnumerator_definition is called when production enumerator_definition is entered.
func (s *BasePandaParserListener) EnterEnumerator_definition(ctx *Enumerator_definitionContext) {}

// ExitEnumerator_definition is called when production enumerator_definition is exited.
func (s *BasePandaParserListener) ExitEnumerator_definition(ctx *Enumerator_definitionContext) {}

// EnterEnumerator is called when production enumerator is entered.
func (s *BasePandaParserListener) EnterEnumerator(ctx *EnumeratorContext) {}

// ExitEnumerator is called when production enumerator is exited.
func (s *BasePandaParserListener) ExitEnumerator(ctx *EnumeratorContext) {}

// EnterNamespace_name is called when production namespace_name is entered.
func (s *BasePandaParserListener) EnterNamespace_name(ctx *Namespace_nameContext) {}

// ExitNamespace_name is called when production namespace_name is exited.
func (s *BasePandaParserListener) ExitNamespace_name(ctx *Namespace_nameContext) {}

// EnterNamespace_definition is called when production namespace_definition is entered.
func (s *BasePandaParserListener) EnterNamespace_definition(ctx *Namespace_definitionContext) {}

// ExitNamespace_definition is called when production namespace_definition is exited.
func (s *BasePandaParserListener) ExitNamespace_definition(ctx *Namespace_definitionContext) {}

// EnterInclude_definition is called when production include_definition is entered.
func (s *BasePandaParserListener) EnterInclude_definition(ctx *Include_definitionContext) {}

// ExitInclude_definition is called when production include_definition is exited.
func (s *BasePandaParserListener) ExitInclude_definition(ctx *Include_definitionContext) {}

// EnterInclude_definition_sequence is called when production include_definition_sequence is entered.
func (s *BasePandaParserListener) EnterInclude_definition_sequence(ctx *Include_definition_sequenceContext) {
}

// ExitInclude_definition_sequence is called when production include_definition_sequence is exited.
func (s *BasePandaParserListener) ExitInclude_definition_sequence(ctx *Include_definition_sequenceContext) {
}

// EnterInit_declarator_list is called when production init_declarator_list is entered.
func (s *BasePandaParserListener) EnterInit_declarator_list(ctx *Init_declarator_listContext) {}

// ExitInit_declarator_list is called when production init_declarator_list is exited.
func (s *BasePandaParserListener) ExitInit_declarator_list(ctx *Init_declarator_listContext) {}

// EnterInit_declarator is called when production init_declarator is entered.
func (s *BasePandaParserListener) EnterInit_declarator(ctx *Init_declaratorContext) {}

// ExitInit_declarator is called when production init_declarator is exited.
func (s *BasePandaParserListener) ExitInit_declarator(ctx *Init_declaratorContext) {}

// EnterDeclarator is called when production declarator is entered.
func (s *BasePandaParserListener) EnterDeclarator(ctx *DeclaratorContext) {}

// ExitDeclarator is called when production declarator is exited.
func (s *BasePandaParserListener) ExitDeclarator(ctx *DeclaratorContext) {}

// EnterPtr_declarator is called when production ptr_declarator is entered.
func (s *BasePandaParserListener) EnterPtr_declarator(ctx *Ptr_declaratorContext) {}

// ExitPtr_declarator is called when production ptr_declarator is exited.
func (s *BasePandaParserListener) ExitPtr_declarator(ctx *Ptr_declaratorContext) {}

// EnterNoptr_declarator is called when production noptr_declarator is entered.
func (s *BasePandaParserListener) EnterNoptr_declarator(ctx *Noptr_declaratorContext) {}

// ExitNoptr_declarator is called when production noptr_declarator is exited.
func (s *BasePandaParserListener) ExitNoptr_declarator(ctx *Noptr_declaratorContext) {}

// EnterParameters_and_qualifiers is called when production parameters_and_qualifiers is entered.
func (s *BasePandaParserListener) EnterParameters_and_qualifiers(ctx *Parameters_and_qualifiersContext) {
}

// ExitParameters_and_qualifiers is called when production parameters_and_qualifiers is exited.
func (s *BasePandaParserListener) ExitParameters_and_qualifiers(ctx *Parameters_and_qualifiersContext) {
}

// EnterRef_operator is called when production ref_operator is entered.
func (s *BasePandaParserListener) EnterRef_operator(ctx *Ref_operatorContext) {}

// ExitRef_operator is called when production ref_operator is exited.
func (s *BasePandaParserListener) ExitRef_operator(ctx *Ref_operatorContext) {}

// EnterDeclarator_id is called when production declarator_id is entered.
func (s *BasePandaParserListener) EnterDeclarator_id(ctx *Declarator_idContext) {}

// ExitDeclarator_id is called when production declarator_id is exited.
func (s *BasePandaParserListener) ExitDeclarator_id(ctx *Declarator_idContext) {}

// EnterType_id is called when production type_id is entered.
func (s *BasePandaParserListener) EnterType_id(ctx *Type_idContext) {}

// ExitType_id is called when production type_id is exited.
func (s *BasePandaParserListener) ExitType_id(ctx *Type_idContext) {}

// EnterParameter_declaration_clause is called when production parameter_declaration_clause is entered.
func (s *BasePandaParserListener) EnterParameter_declaration_clause(ctx *Parameter_declaration_clauseContext) {
}

// ExitParameter_declaration_clause is called when production parameter_declaration_clause is exited.
func (s *BasePandaParserListener) ExitParameter_declaration_clause(ctx *Parameter_declaration_clauseContext) {
}

// EnterParameter_declaration_list is called when production parameter_declaration_list is entered.
func (s *BasePandaParserListener) EnterParameter_declaration_list(ctx *Parameter_declaration_listContext) {
}

// ExitParameter_declaration_list is called when production parameter_declaration_list is exited.
func (s *BasePandaParserListener) ExitParameter_declaration_list(ctx *Parameter_declaration_listContext) {
}

// EnterParameter_declaration is called when production parameter_declaration is entered.
func (s *BasePandaParserListener) EnterParameter_declaration(ctx *Parameter_declarationContext) {}

// ExitParameter_declaration is called when production parameter_declaration is exited.
func (s *BasePandaParserListener) ExitParameter_declaration(ctx *Parameter_declarationContext) {}

// EnterFunction_definition is called when production function_definition is entered.
func (s *BasePandaParserListener) EnterFunction_definition(ctx *Function_definitionContext) {}

// ExitFunction_definition is called when production function_definition is exited.
func (s *BasePandaParserListener) ExitFunction_definition(ctx *Function_definitionContext) {}

// EnterInitializer is called when production initializer is entered.
func (s *BasePandaParserListener) EnterInitializer(ctx *InitializerContext) {}

// ExitInitializer is called when production initializer is exited.
func (s *BasePandaParserListener) ExitInitializer(ctx *InitializerContext) {}

// EnterBrace_or_equal_initializer is called when production brace_or_equal_initializer is entered.
func (s *BasePandaParserListener) EnterBrace_or_equal_initializer(ctx *Brace_or_equal_initializerContext) {
}

// ExitBrace_or_equal_initializer is called when production brace_or_equal_initializer is exited.
func (s *BasePandaParserListener) ExitBrace_or_equal_initializer(ctx *Brace_or_equal_initializerContext) {
}

// EnterInitializer_clause is called when production initializer_clause is entered.
func (s *BasePandaParserListener) EnterInitializer_clause(ctx *Initializer_clauseContext) {}

// ExitInitializer_clause is called when production initializer_clause is exited.
func (s *BasePandaParserListener) ExitInitializer_clause(ctx *Initializer_clauseContext) {}

// EnterInitializer_list is called when production initializer_list is entered.
func (s *BasePandaParserListener) EnterInitializer_list(ctx *Initializer_listContext) {}

// ExitInitializer_list is called when production initializer_list is exited.
func (s *BasePandaParserListener) ExitInitializer_list(ctx *Initializer_listContext) {}

// EnterBraced_init_list is called when production braced_init_list is entered.
func (s *BasePandaParserListener) EnterBraced_init_list(ctx *Braced_init_listContext) {}

// ExitBraced_init_list is called when production braced_init_list is exited.
func (s *BasePandaParserListener) ExitBraced_init_list(ctx *Braced_init_listContext) {}

// EnterClass_definition is called when production class_definition is entered.
func (s *BasePandaParserListener) EnterClass_definition(ctx *Class_definitionContext) {}

// ExitClass_definition is called when production class_definition is exited.
func (s *BasePandaParserListener) ExitClass_definition(ctx *Class_definitionContext) {}

// EnterClass_name is called when production class_name is entered.
func (s *BasePandaParserListener) EnterClass_name(ctx *Class_nameContext) {}

// ExitClass_name is called when production class_name is exited.
func (s *BasePandaParserListener) ExitClass_name(ctx *Class_nameContext) {}

// EnterMember_specification is called when production member_specification is entered.
func (s *BasePandaParserListener) EnterMember_specification(ctx *Member_specificationContext) {}

// ExitMember_specification is called when production member_specification is exited.
func (s *BasePandaParserListener) ExitMember_specification(ctx *Member_specificationContext) {}

// EnterMember_declaration is called when production member_declaration is entered.
func (s *BasePandaParserListener) EnterMember_declaration(ctx *Member_declarationContext) {}

// ExitMember_declaration is called when production member_declaration is exited.
func (s *BasePandaParserListener) ExitMember_declaration(ctx *Member_declarationContext) {}

// EnterMember_declarator_list is called when production member_declarator_list is entered.
func (s *BasePandaParserListener) EnterMember_declarator_list(ctx *Member_declarator_listContext) {}

// ExitMember_declarator_list is called when production member_declarator_list is exited.
func (s *BasePandaParserListener) ExitMember_declarator_list(ctx *Member_declarator_listContext) {}

// EnterMember_declarator is called when production member_declarator is entered.
func (s *BasePandaParserListener) EnterMember_declarator(ctx *Member_declaratorContext) {}

// ExitMember_declarator is called when production member_declarator is exited.
func (s *BasePandaParserListener) ExitMember_declarator(ctx *Member_declaratorContext) {}

// EnterModifier_specifier_sequence is called when production modifier_specifier_sequence is entered.
func (s *BasePandaParserListener) EnterModifier_specifier_sequence(ctx *Modifier_specifier_sequenceContext) {
}

// ExitModifier_specifier_sequence is called when production modifier_specifier_sequence is exited.
func (s *BasePandaParserListener) ExitModifier_specifier_sequence(ctx *Modifier_specifier_sequenceContext) {
}

// EnterModifier_specifier is called when production modifier_specifier is entered.
func (s *BasePandaParserListener) EnterModifier_specifier(ctx *Modifier_specifierContext) {}

// ExitModifier_specifier is called when production modifier_specifier is exited.
func (s *BasePandaParserListener) ExitModifier_specifier(ctx *Modifier_specifierContext) {}

// EnterAccess_specifier is called when production access_specifier is entered.
func (s *BasePandaParserListener) EnterAccess_specifier(ctx *Access_specifierContext) {}

// ExitAccess_specifier is called when production access_specifier is exited.
func (s *BasePandaParserListener) ExitAccess_specifier(ctx *Access_specifierContext) {}

// EnterBase_clause is called when production base_clause is entered.
func (s *BasePandaParserListener) EnterBase_clause(ctx *Base_clauseContext) {}

// ExitBase_clause is called when production base_clause is exited.
func (s *BasePandaParserListener) ExitBase_clause(ctx *Base_clauseContext) {}

// EnterBase_specifier_list is called when production base_specifier_list is entered.
func (s *BasePandaParserListener) EnterBase_specifier_list(ctx *Base_specifier_listContext) {}

// ExitBase_specifier_list is called when production base_specifier_list is exited.
func (s *BasePandaParserListener) ExitBase_specifier_list(ctx *Base_specifier_listContext) {}

// EnterBase_specifier is called when production base_specifier is entered.
func (s *BasePandaParserListener) EnterBase_specifier(ctx *Base_specifierContext) {}

// ExitBase_specifier is called when production base_specifier is exited.
func (s *BasePandaParserListener) ExitBase_specifier(ctx *Base_specifierContext) {}

// EnterOperator_function_id is called when production operator_function_id is entered.
func (s *BasePandaParserListener) EnterOperator_function_id(ctx *Operator_function_idContext) {}

// ExitOperator_function_id is called when production operator_function_id is exited.
func (s *BasePandaParserListener) ExitOperator_function_id(ctx *Operator_function_idContext) {}

// EnterTemplate_id is called when production template_id is entered.
func (s *BasePandaParserListener) EnterTemplate_id(ctx *Template_idContext) {}

// ExitTemplate_id is called when production template_id is exited.
func (s *BasePandaParserListener) ExitTemplate_id(ctx *Template_idContext) {}

// EnterTemplate_definition is called when production template_definition is entered.
func (s *BasePandaParserListener) EnterTemplate_definition(ctx *Template_definitionContext) {}

// ExitTemplate_definition is called when production template_definition is exited.
func (s *BasePandaParserListener) ExitTemplate_definition(ctx *Template_definitionContext) {}

// EnterTemplate_argument_list is called when production template_argument_list is entered.
func (s *BasePandaParserListener) EnterTemplate_argument_list(ctx *Template_argument_listContext) {}

// ExitTemplate_argument_list is called when production template_argument_list is exited.
func (s *BasePandaParserListener) ExitTemplate_argument_list(ctx *Template_argument_listContext) {}

// EnterTemplate_argument is called when production template_argument is entered.
func (s *BasePandaParserListener) EnterTemplate_argument(ctx *Template_argumentContext) {}

// ExitTemplate_argument is called when production template_argument is exited.
func (s *BasePandaParserListener) ExitTemplate_argument(ctx *Template_argumentContext) {}

// EnterType_name_specifier is called when production type_name_specifier is entered.
func (s *BasePandaParserListener) EnterType_name_specifier(ctx *Type_name_specifierContext) {}

// ExitType_name_specifier is called when production type_name_specifier is exited.
func (s *BasePandaParserListener) ExitType_name_specifier(ctx *Type_name_specifierContext) {}

// EnterType_id_list is called when production type_id_list is entered.
func (s *BasePandaParserListener) EnterType_id_list(ctx *Type_id_listContext) {}

// ExitType_id_list is called when production type_id_list is exited.
func (s *BasePandaParserListener) ExitType_id_list(ctx *Type_id_listContext) {}

// EnterTry_block is called when production try_block is entered.
func (s *BasePandaParserListener) EnterTry_block(ctx *Try_blockContext) {}

// ExitTry_block is called when production try_block is exited.
func (s *BasePandaParserListener) ExitTry_block(ctx *Try_blockContext) {}

// EnterHandler_sequence is called when production handler_sequence is entered.
func (s *BasePandaParserListener) EnterHandler_sequence(ctx *Handler_sequenceContext) {}

// ExitHandler_sequence is called when production handler_sequence is exited.
func (s *BasePandaParserListener) ExitHandler_sequence(ctx *Handler_sequenceContext) {}

// EnterHandler is called when production handler is entered.
func (s *BasePandaParserListener) EnterHandler(ctx *HandlerContext) {}

// ExitHandler is called when production handler is exited.
func (s *BasePandaParserListener) ExitHandler(ctx *HandlerContext) {}

// EnterException_declaration is called when production exception_declaration is entered.
func (s *BasePandaParserListener) EnterException_declaration(ctx *Exception_declarationContext) {}

// ExitException_declaration is called when production exception_declaration is exited.
func (s *BasePandaParserListener) ExitException_declaration(ctx *Exception_declarationContext) {}

// EnterThrow_expression is called when production throw_expression is entered.
func (s *BasePandaParserListener) EnterThrow_expression(ctx *Throw_expressionContext) {}

// ExitThrow_expression is called when production throw_expression is exited.
func (s *BasePandaParserListener) ExitThrow_expression(ctx *Throw_expressionContext) {}

// EnterOperators is called when production operators is entered.
func (s *BasePandaParserListener) EnterOperators(ctx *OperatorsContext) {}

// ExitOperators is called when production operators is exited.
func (s *BasePandaParserListener) ExitOperators(ctx *OperatorsContext) {}

// EnterLiteral is called when production literal is entered.
func (s *BasePandaParserListener) EnterLiteral(ctx *LiteralContext) {}

// ExitLiteral is called when production literal is exited.
func (s *BasePandaParserListener) ExitLiteral(ctx *LiteralContext) {}
