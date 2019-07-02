parser grammar PandaParser;

options {
  tokenVocab = PandaLexer;
}

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
   | conversion_function_id
   | literal_operator_id
   | template_id
   ;

qualified_id
   : nested_name_specifier unqualified_id
   ;

nested_name_specifier
   : '.'
   | type_name '.'
   | namespace_name '.'
   | nested_name_specifier Identifier '.'
   | nested_name_specifier simple_template_id '.'
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
   | '*='
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
   | declspecifierseq declarator '=' initializer_clause
   | declspecifierseq declarator braced_init_list
   ;

iteration_statement
   : For '(' for_init_statement condition? ';' expression? ')' statement
   | For '(' for_range_declaration ':' forrangeinitializer ')' statement
   ;

for_init_statement
   : expression_statement
   | simple_declaration
   ;

for_range_declaration
   : declspecifierseq declarator
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
   | functiondefinition
   | namespacedefinition
   | empty_declaration
   ;

block_declaration
   : simple_declaration
   | namespacealiasdefinition
   | using_namespace
   ;

simple_declaration
   : declspecifierseq? initdeclaratorlist? ';'
   ;

empty_declaration
   : ';'
   ;

declspecifier
   : storage_class_specifier
   | type_specifier
   ;

declspecifierseq
   : declspecifier
   | declspecifier declspecifierseq
   ;

storage_class_specifier
   : Static
   ;

type_specifier
   : trailing_type_specifier
   | class_specifier
   | enum_specifier
   ;

trailing_type_specifier
   : simple_type_specifier
   | elaborated_types_pecifier
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
   | nested_name_specifier simple_template_id
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
   | simple_template_id
   ;

elaborated_type_specifier
   : Class nested_name_specifier? Identifier
   | Class simple_template_id
   | Class nested_name_specifier simple_template_id
   | Enum nested_name_specifier? Identifier
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
   : enumeratordefinition
   | enumerator_list ',' enumeratordefinition
   ;

enumeratordefinition
   : enumerator
   | enumerator '=' constant_expression
   ;

enumerator
   : Identifier
   ;

namespace_name
   : originalnamespace_name
   | namespacealias
   ;

originalnamespace_name
   : Identifier
   ;

namespacedefinition
   : namednamespacedefinition
   | unnamednamespacedefinition
   ;

namednamespacedefinition
   : originalnamespacedefinition
   | extensionnamespacedefinition
   ;

originalnamespacedefinition
   : Namespace Identifier '{' namespacebody '}'
   ;

extensionnamespacedefinition
   : Namespace originalnamespace_name '{' namespacebody '}'
   ;

unnamednamespacedefinition
   : Namespace '{' namespacebody '}'
   ;

namespacebody
   : declaration_sequence?
   ;

namespacealias
   : Identifier
   ;

namespacealiasdefinition
   : Namespace Identifier '=' qualifiednamespacespecifier ';'
   ;

qualifiednamespacespecifier
   : nested_name_specifier? namespace_name
   ;

using_namespace
   : Using nested_name_specifier? namespace_name ';'
   ;

/*Declarators*/

initdeclaratorlist
   : initdeclarator
   | initdeclaratorlist ',' initdeclarator
   ;

initdeclarator
   : declarator initializer?
   ;

declarator
   : ptrdeclarator
   | noptrdeclarator parametersandqualifiers trailing_return_type
   ;

ptrdeclarator
   : noptrdeclarator
   | reference_operator ptrdeclarator
   ;

noptrdeclarator
   : declaratorid
   | noptrdeclarator parametersandqualifiers
   | noptrdeclarator '[' constantexpression? ']'
   | '(' ptrdeclarator ')'
   ;

parametersandqualifiers
   : '(' parameter_declaration_clause ')' refqualifier? exception_specification?
   ;

trailing_return_type
   : '->' trailing_type_specifier_sequence abstract_declarator?
   ;

reference_operator
   : '&' attribute_specifier_sequence?
   ;

refqualifier
   : '&'
   | '&&'
   ;

declaratorid
   : '...'? id_expression
   ;

type_id
   : type_specifier_sequence abstract_declarator?
   ;

abstract_declarator
   : ptrabstract_declarator
   | noptrabstract_declarator? parametersandqualifiers trailing_return_type
   | abstractpackdeclarator
   ;

noptrabstract_declarator
   : noptrabstract_declarator parametersandqualifiers
   | parametersandqualifiers
   | noptrabstract_declarator '[' constantexpression? ']' attribute_specifier_sequence?
   | '[' constantexpression? ']' attribute_specifier_sequence?
   | '(' ptrabstract_declarator ')'
   ;

abstractpackdeclarator
   : noptrabstractpackdeclarator
   | reference_operator abstractpackdeclarator
   ;

noptrabstractpackdeclarator
   : noptrabstractpackdeclarator parametersandqualifiers
   | noptrabstractpackdeclarator '[' constantexpression? ']' attribute_specifier_sequence?
   | '...'
   ;

parameter_declaration_clause
   : parameterdeclarationlist? '...'?
   | parameterdeclarationlist ',' '...'
   ;

parameterdeclarationlist
   : parameterdeclaration
   | parameterdeclarationlist ',' parameterdeclaration
   ;

parameterdeclaration
   : declspecifierseq declarator
   | declspecifierseq declarator '=' initializer_clause
   | declspecifierseq abstract_declarator?
   | declspecifierseq abstract_declarator? '=' initializer_clause
   ;

functiondefinition
   : declspecifierseq? declarator functionbody
   ;

functionbody
   : ctorinitializer? compound_statement
   | functiontryblock
   | '=' Default ';'
   ;

initializer
   : braceorequalinitializer
   | '(' expression_list ')'
   ;

braceorequalinitializer
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
   | simple_template_id
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
   : memberdeclaration member_specification?
   | accessspecifier ':' member_specification?
   ;

memberdeclaration
   : declspecifierseq? memberdeclaratorlist? ';'
   | functiondefinition
   | aliasdeclaration
   | emptydeclaration
   ;

memberdeclaratorlist
   : memberdeclarator
   | memberdeclaratorlist ',' memberdeclarator
   ;

memberdeclarator
   : declarator purespecifier?
   | declarator braceorequalinitializer?
   | Identifier? ':' constantexpression
   ;

/*
purespecifier:
   '=' '0'//Conflicts with the lexer
 ;
 */


purespecifier
   : Assign val = OctalLiteral
   {if($val.text.compareTo("0")!=0) throw new InputMismatchException(this);}
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
   | accessspecifier base_type_specifier
   ;

class_or_decltype
   : nested_name_specifier? class_name
   ;

base_type_specifier
   : class_or_decltype
   ;

accessspecifier
   : Private
   | Protected
   | Public
   ;
/*Special member functions*/


conversion_function_id
   : Operator conversiontypeid
   ;

conversiontypeid
   : type_specifier_sequence conversiondeclarator?
   ;

conversiondeclarator
   : reference_operator conversiondeclarator?
   ;

ctorinitializer
   : ':' meminitializerlist
   ;

meminitializerlist
   : meminitializer '...'?
   | meminitializer '...'? ',' meminitializerlist
   ;

meminitializer
   : meminitializerid '(' expression_list? ')'
   | meminitializerid braced_init_list
   ;

meminitializerid
   : class_or_decltype
   | Identifier
   ;
/*Overloading*/


operator_function_id
   : Operator operator
   ;

literal_operator_id
   : Operator StringLiteral Identifier
   ;

/*Templates*/

templateparameterlist
   : templateparameter
   | templateparameterlist ',' templateparameter
   ;

templateparameter
   : typeparameter
   | parameterdeclaration
   ;

typeparameter
   : Class '...'? Identifier?
   | Class Identifier? '=' type_id
   | '...'? Identifier?
   | Identifier? '=' type_id
   | '<' templateparameterlist '>' Class '...'? Identifier?
   | '<' templateparameterlist '>' Class Identifier? '=' id_expression
   ;

simple_template_id
   : template_name '<' template_argument_list? '>'
   ;

template_id
   : simple_template_id
   | operator_function_id '<' template_argument_list? '>'
   | literal_operator_id '<' template_argument_list? '>'
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
   | nested_name_specifier simple_template_id
   ;

/*Exception handling*/

try_block
   : Try compound_statement handler_sequence
   ;

function_try_block
   : Try ctorinitializer? compound_statement handler_sequence
   ;

handler_sequence
   : handler handler_sequence?
   ;

handler
   : Catch '(' exception_declaration ')' compound_statement
   ;

exception_declaration
   : type_specifier_sequence declarator
   | type_specifier_sequence abstract_declarator?
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
   | 'not'
   | '='
   | '<'
   | '>'
   | '+='
   | '-='
   | '*='
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
   | 'and'
   | '||'
   | 'or'
   | '++'
   | '--'
   | ','
   | '->*'
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