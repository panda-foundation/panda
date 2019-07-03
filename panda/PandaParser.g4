parser grammar PandaParser;

options { tokenVocab = PandaLexer; }

/*Basic concepts*/

translation_unit
   : declaration_sequence? EOF
   ;

primary_expression
   : literal
   | This
   | '(' expression ')'
   | id_expression
   | lambda_expression
   ;

id_expression
   : unqualified_id
   | qualified_id
   ;

unqualified_id
   : Identifier
   | operator_function_id
   | template_id
   ;

qualified_id
   : nested_name_specifier unqualified_id
   ;

nested_name_specifier
   : type_name '.'
   | namespace_name '.'
   | nested_name_specifier Identifier '.'
   | nested_name_specifier template_id '.'
   ;

lambda_expression
   : lambda_declarator? compound_statement
   ;

lambda_declarator
   : '(' parameter_declaration_clause ')' trailing_return_type?
   ;

post_fix_expression
   : primary_expression
   | post_fix_expression '[' expression ']'
   | post_fix_expression '[' braced_init_list ']'
   | post_fix_expression '(' expression_list? ')'
   | simple_type_specifier '(' expression_list? ')'
   | type_name_specifier '(' expression_list? ')'
   | simple_type_specifier braced_init_list
   | type_name_specifier braced_init_list
   | post_fix_expression '.' id_expression
   | post_fix_expression '++'
   | post_fix_expression '--'
   | Cast '<' type_id '>' '(' expression ')'
   ;

expression_list
   : initializer_list
   ;

unary_expression
   : post_fix_expression
   | '++' unary_expression
   | '--' unary_expression
   | unary_operator unary_expression
   | new_expression
   ;

unary_operator
   : '|'
   | '+'
   | '!'
   | '~'
   | '-'
   ;

new_expression
   : New type_specifier_sequence new_initializer
   ;

new_initializer
   : '(' expression_list? ')'
   | braced_init_list
   ;

multiplicative_expression
   : unary_expression
   | multiplicative_expression '*' unary_expression
   | multiplicative_expression '/' unary_expression
   | multiplicative_expression '%' unary_expression
   ;

additive_expression
   : multiplicative_expression
   | additive_expression '+' multiplicative_expression
   | additive_expression '-' multiplicative_expression
   ;

shift_expression
   : additive_expression
   | shift_expression shiftoperator additive_expression
   ;

shiftoperator
   : RightShift
   | LeftShift
   ;

relational_expression
   : shift_expression
   | relational_expression '<' shift_expression
   | relational_expression '>' shift_expression
   | relational_expression '<=' shift_expression
   | relational_expression '>=' shift_expression
   ;

equality_expression
   : relational_expression
   | equality_expression '==' relational_expression
   | equality_expression '!=' relational_expression
   ;

and_expression
   : equality_expression
   | and_expression '&' equality_expression
   ;

exclusiveor_expression
   : and_expression
   | exclusiveor_expression '^' and_expression
   ;

inclusiveor_expression
   : exclusiveor_expression
   | inclusiveor_expression '|' exclusiveor_expression
   ;

logical_and_expression
   : inclusiveor_expression
   | logical_and_expression '&&' inclusiveor_expression
   ;

logical_or_expression
   : logical_and_expression
   | logical_or_expression '||' logical_and_expression
   ;

conditional_expression
   : logical_or_expression
   | logical_or_expression '?' expression ':' assignment_expression
   ;

assignment_expression
   : conditional_expression
   | logical_or_expression assignment_operator initializer_clause
   | throw_expression
   ;

assignment_operator
   : '='
   | '/='
   | '%='
   | '+='
   | '-='
   | RightShiftAssign
   | LeftShiftAssign
   | '&='
   | '^='
   | '|='
   ;

expression
   : assignment_expression
   | expression ',' assignment_expression
   ;

constant_expression
   : conditional_expression
   ;

/*Statements*/

statement
   : labeled_statement
   | expression_statement
   | compound_statement
   | selection_statement
   | iteration_statement
   | jump_statement
   | declaration_statement
   | try_block
   ;

labeled_statement
   : Identifier ':' statement
   | Case constant_expression ':' statement
   | Default ':' statement
   ;

expression_statement
   : expression? ';'
   ;

compound_statement
   : '{' statement_sequence? '}'
   ;

statement_sequence
   : statement
   | statement_sequence statement
   ;

selection_statement
   : If '(' condition ')' statement
   | If '(' condition ')' statement Else statement
   | Switch '(' condition ')' statement
   ;

condition
   : expression
   | decl_specifier_sequence declarator '=' initializer_clause
   | decl_specifier_sequence declarator braced_init_list
   ;

iteration_statement
   : For '(' for_init_statement condition? ';' expression? ')' statement
   | For '(' for_range_declaration ':' for_range_initializer ')' statement
   ;

for_init_statement
   : expression_statement
   | simple_declaration
   ;

for_range_declaration
   : decl_specifier_sequence declarator
   ;

for_range_initializer
   : expression
   | braced_init_list
   ;

jump_statement
   : Break ';'
   | Continue ';'
   | Return expression? ';'
   | Return braced_init_list ';'
   ;

declaration_statement
   : block_declaration
   ;

/*Declarations*/

declaration_sequence
   : declaration
   | declaration_sequence declaration
   ;

declaration
   : block_declaration
   | function_definition
   | namespace_definition
   | empty_declaration
   ;

block_declaration
   : simple_declaration
   | using_namespace
   ;

simple_declaration
   : decl_specifier_sequence? init_declarator_list? ';'
   ;

empty_declaration
   : ';'
   ;

decl_specifier
   : type_specifier
   ;

decl_specifier_sequence
   : decl_specifier
   | decl_specifier decl_specifier_sequence
   ;

type_specifier
   : trailing_type_specifier
   | class_specifier
   | enum_specifier
   ;

trailing_type_specifier
   : simple_type_specifier
   | type_name_specifier
   ;

type_specifier_sequence
   : type_specifier
   | type_specifier type_specifier_sequence
   ;

trailing_type_specifier_sequence
   : trailing_type_specifier
   | trailing_type_specifier trailing_type_specifier_sequence
   ;

simple_type_specifier
   : nested_name_specifier? type_name
   | nested_name_specifier template_id
   | Bool
   | Int8
   | Int16
   | Int32
   | Int64
   | Uint8
   | Uint16
   | Uint32
   | Uint64
   | Int
   | Uint
   | Short
   | Ushort
   | Long
   | Ulong
   | Float32
   | Float64
   | Float
   | Double
   | Void
   | Auto
   ;

type_name
   : class_name
   | enum_name
   | template_id
   ;

enum_name
   : Identifier
   ;

enum_specifier
   : enum_head '{' enumerator_list? '}'
   | enum_head '{' enumerator_list ',' '}'
   ;

enum_head
   : enum_key Identifier? enum_base?
   ;

enum_key
   : Enum
   ;

enum_base
   : ':' type_specifier_sequence
   ;

enumerator_list
   : enumerator_definition
   | enumerator_list ',' enumerator_definition
   ;

enumerator_definition
   : enumerator
   | enumerator '=' constant_expression
   ;

enumerator
   : Identifier
   ;

namespace_name
   : Identifier
   ;

namespace_definition
   : named_namespace_definition
   | unnamed_namespace_definition
   ;

named_namespace_definition
   : original_namespace_definition
   | extension_namespace_definition
   ;

original_namespace_definition
   : Namespace Identifier '{' namespace_body '}'
   ;

extension_namespace_definition
   : Namespace namespace_name '{' namespace_body '}'
   ;

unnamed_namespace_definition
   : Namespace '{' namespace_body '}'
   ;

namespace_body
   : declaration_sequence?
   ;

qualified_namespace_specifier
   : nested_name_specifier? namespace_name
   ;

using_namespace
   : Using nested_name_specifier? namespace_name ';'
   ;

/*Declarators*/

init_declarator_list
   : init_declarator
   | init_declarator_list ',' init_declarator
   ;

init_declarator
   : declarator initializer?
   ;

declarator
   : ptr_declarator
   | noptr_declarator parameters_and_qualifiers trailing_return_type
   ;

ptr_declarator
   : noptr_declarator
   | ref_operator ptr_declarator
   ;

noptr_declarator
   : declarator_id
   | noptr_declarator parameters_and_qualifiers
   | noptr_declarator '[' constant_expression? ']'
   | '(' ptr_declarator ')'
   ;

parameters_and_qualifiers
   : '(' parameter_declaration_clause ')' ref_qualifier? exception_specification?
   ;

trailing_return_type
   : '->' trailing_type_specifier_sequence
   ;

ref_operator
   : '&'
   ;

ref_qualifier
   : '&'
   | '&&'
   ;

declarator_id
   : '...'? id_expression
   ;

type_id
   : type_specifier_sequence
   ;

parameter_declaration_clause
   : parameter_declaration_list? '...'?
   | parameter_declaration_list ',' '...'
   ;

parameter_declaration_list
   : parameter_declaration
   | parameter_declaration_list ',' parameter_declaration
   ;

parameter_declaration
   : decl_specifier_sequence declarator
   | decl_specifier_sequence declarator '=' initializer_clause
   | decl_specifier_sequence
   | decl_specifier_sequence '=' initializer_clause
   ;

function_definition
   : decl_specifier_sequence? declarator function_body
   ;

function_body
   : compound_statement
   | function_try_block
   | '=' Default ';'
   ;

initializer
   : brace_or_equal_initializer
   | '(' expression_list ')'
   ;

brace_or_equal_initializer
   : '=' initializer_clause
   | braced_init_list
   ;

initializer_clause
   : assignment_expression
   | braced_init_list
   ;

initializer_list
   : initializer_clause '...'?
   | initializer_list ',' initializer_clause '...'?
   ;

braced_init_list
   : '{' initializer_list ','? '}'
   | '{' '}'
   ;

/*Classes*/

class_name
   : Identifier
   | template_id
   ;

class_specifier
   : class_head '{' member_specification? '}'
   ;

class_head
   : Class class_head_name base_clause?
   | Class base_clause?
   ;

class_head_name
   : nested_name_specifier? class_name
   ;

member_specification
   : member_declaration member_specification?
   | access_specifier ':' member_specification?
   ;

member_declaration
   : decl_specifier_sequence? member_declarator_list? ';'
   | function_definition
   | empty_declaration
   ;

member_declarator_list
   : memberdeclarator
   | member_declarator_list ',' memberdeclarator
   ;

memberdeclarator
   : declarator
   | declarator brace_or_equal_initializer?
   | Identifier? ':' constant_expression
   ;

/*Derived classes*/

base_clause
   : ':' base_specifier_list
   ;

base_specifier_list
   : base_specifier
   | base_specifier_list ',' base_specifier
   ;

base_specifier
   : base_type_specifier
   | access_specifier base_type_specifier
   ;

class_or_decltype
   : nested_name_specifier? class_name
   ;

base_type_specifier
   : class_or_decltype
   ;

access_specifier
   : Private
   | Protected
   | Public
   ;

/*Special member functions*/

mem_initializer_list
   : mem_initializer '...'?
   | mem_initializer '...'? ',' mem_initializer_list
   ;

mem_initializer
   : mem_initializer_id '(' expression_list? ')'
   | mem_initializer_id braced_init_list
   ;

mem_initializer_id
   : class_or_decltype
   | Identifier
   ;

/*Overloading*/

operator_function_id
   : Operator operator
   ;

/*Templates*/

template_parameter_list
   : template_parameter
   | template_parameter_list ',' template_parameter
   ;

template_parameter
   : type_parameter
   | parameter_declaration
   ;

type_parameter
   : Class '...'? Identifier?
   | Class Identifier? '=' type_id
   | '...'? Identifier?
   | Identifier? '=' type_id
   | '<' template_parameter_list '>' Class '...'? Identifier?
   | '<' template_parameter_list '>' Class Identifier? '=' id_expression
   ;

template_id
   : template_name '<' template_argument_list? '>'
   ;

template_name
   : Identifier
   ;

template_argument_list
   : template_argument
   | template_argument_list ',' template_argument
   ;

template_argument
   : type_id
   | constant_expression
   | id_expression
   ;

type_name_specifier
   : nested_name_specifier Identifier
   | nested_name_specifier template_id
   ;

/*Exception handling*/

try_block
   : Try compound_statement handler_sequence
   ;

function_try_block
   : Try compound_statement handler_sequence
   ;

handler_sequence
   : handler handler_sequence?
   ;

handler
   : Catch '(' exception_declaration ')' compound_statement
   ;

exception_declaration
   : type_specifier_sequence declarator
   | type_specifier_sequence
   | '...'
   ;

throw_expression
   : Throw assignment_expression?
   ;

exception_specification
   : Throw '(' type_id_list? ')'
   ;

type_id_list
   : type_id '...'?
   | type_id_list ',' type_id '...'?
   ;

operator
   : New
   | '+'
   | '-'
   | '*'
   | '/'
   | '%'
   | '^'
   | '&'
   | '|'
   | '~'
   | '!'
   | '='
   | '<'
   | '>'
   | '+='
   | '-='
   | '/='
   | '%='
   | '^='
   | '&='
   | '|='
   | '<<'
   | '>>'
   | '>>='
   | '<<='
   | '=='
   | '!='
   | '<='
   | '>='
   | '&&'
   | '||'
   | '++'
   | '--'
   | ','
   | '->'
   | '(' ')'
   | '[' ']'
   ;

literal
   : IntegerLiteral
   | FloatLiteral
   | StringLiteral
   | BooleanLiteral
   | PointerLiteral
   ;