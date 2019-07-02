grammar Panda;
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
   | '~' class_name
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

lambda_capture
   : capture_default
   | capture_list
   | capture_default ',' capture_list
   ;

capture_default
   : '&'
   | '='
   ;

capture_list
   : capture '...'?
   | capture_list ',' capture '...'?
   ;

capture
   : simple_capture
   | init_capture
   ;

simple_capture
   : Identifier
   | '&' Identifier
   | This
   ;

init_capture
   : Identifier initializer
   | '&' Identifier initializer
   ;

lambda_declarator
   : '(' parameter_declaration_clause ')' exception_specification? attribute_specifier_sequence? trailingreturntype?
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
   | post_fix_expression '->' id_expression
   | post_fix_expression '.' pseudode_structor_name
   | post_fix_expression '->' pseudode_structor_name
   | post_fix_expression '++'
   | post_fix_expression '--'
   ;

expression_list
   : initializerlist
   ;

pseudode_structor_name
   : nested_name_specifier? type_name '::' '~' type_name
   | nested_name_specifier simple_template_id '::' '~' type_name
   | nested_name_specifier? '~' type_name
   ;

unary_expression
   : post_fix_expression
   | '++' cast_expression
   | '--' cast_expression
   | unary_operator cast_expression
   | new_expression
   ;

unary_operator
   : '|'
   | '*'
   | '&'
   | '+'
   | '!'
   | '~'
   | '-'
   | 'not'
   ;

new_expression
   : New new_placement? new_type_id new_initializer?
   | New new_placement? '(' type_id ')' new_initializer?
   ;

new_placement
   : '(' expression_list ')'
   ;

new_type_id
   : type_specifier_sequence new_declarator?
   ;

new_declarator
   : reference_operator new_declarator?
   | noptrnew_declarator
   ;

noptrnew_declarator
   : '[' expression ']' attribute_specifier_sequence?
   | noptrnew_declarator '[' constantexpression ']' attribute_specifier_sequence?
   ;

new_initializer
   : '(' expression_list? ')'
   | braced_init_list
   ;

cast_expression
   : unary_expression
   | '(' type_id ')' cast_expression
   ;

pmexpression
   : cast_expression
   | pmexpression '.*' cast_expression
   | pmexpression '->*' cast_expression
   ;

multiplicativeexpression
   : pmexpression
   | multiplicativeexpression '*' pmexpression
   | multiplicativeexpression '/' pmexpression
   | multiplicativeexpression '%' pmexpression
   ;

additiveexpression
   : multiplicativeexpression
   | additiveexpression '+' multiplicativeexpression
   | additiveexpression '-' multiplicativeexpression
   ;

shiftexpression
   : additiveexpression
   | shiftexpression shiftoperator additiveexpression
   ;

shiftoperator
  : RightShift
  | LeftShift
  ;

relationalexpression
   : shiftexpression
   | relationalexpression '<' shiftexpression
   | relationalexpression '>' shiftexpression
   | relationalexpression '<=' shiftexpression
   | relationalexpression '>=' shiftexpression
   ;

equalityexpression
   : relationalexpression
   | equalityexpression '==' relationalexpression
   | equalityexpression '!=' relationalexpression
   ;

andexpression
   : equalityexpression
   | andexpression '&' equalityexpression
   ;

exclusiveorexpression
   : andexpression
   | exclusiveorexpression '^' andexpression
   ;

inclusiveorexpression
   : exclusiveorexpression
   | inclusiveorexpression '|' exclusiveorexpression
   ;

logicalandexpression
   : inclusiveorexpression
   | logicalandexpression '&&' inclusiveorexpression
   | logicalandexpression 'and' inclusiveorexpression
   ;

logicalorexpression
   : logicalandexpression
   | logicalorexpression '||' logicalandexpression
   | logicalorexpression 'or' logicalandexpression
   ;

conditionalexpression
   : logicalorexpression
   | logicalorexpression '?' expression ':' assignment_expression
   ;

assignment_expression
   : conditionalexpression
   | logicalorexpression assignmentoperator initializerclause
   | throw_expression
   ;

assignmentoperator
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

constantexpression
   : conditionalexpression
   ;
/*Statements*/


statement
   : labeledstatement
   | attribute_specifier_sequence? expressionstatement
   | attribute_specifier_sequence? compound_statement
   | attribute_specifier_sequence? selectionstatement
   | attribute_specifier_sequence? iterationstatement
   | attribute_specifier_sequence? jumpstatement
   | declarationstatement
   | attribute_specifier_sequence? tryblock
   ;

labeledstatement
   : attribute_specifier_sequence? Identifier ':' statement
   | attribute_specifier_sequence? Case constantexpression ':' statement
   | attribute_specifier_sequence? Default ':' statement
   ;

expressionstatement
   : expression? ';'
   ;

compound_statement
   : '{' statementseq? '}'
   ;

statementseq
   : statement
   | statementseq statement
   ;

selectionstatement
   : If '(' condition ')' statement
   | If '(' condition ')' statement Else statement
   | Switch '(' condition ')' statement
   ;

condition
   : expression
   | attribute_specifier_sequence? declspecifierseq declarator '=' initializerclause
   | attribute_specifier_sequence? declspecifierseq declarator braced_init_list
   ;

iterationstatement
   : While '(' condition ')' statement
   | For '(' forinitstatement condition? ';' expression? ')' statement
   | For '(' forrangedeclaration ':' forrangeinitializer ')' statement
   ;

forinitstatement
   : expressionstatement
   | simpledeclaration
   ;

forrangedeclaration
   : attribute_specifier_sequence? declspecifierseq declarator
   ;

forrangeinitializer
   : expression
   | braced_init_list
   ;

jumpstatement
   : Break Newline
   | Continue Newline
   | Return expression? Newline
   | Return braced_init_list Newline
   ;

declarationstatement
   : blockdeclaration
   ;
/*Declarations*/


declaration_sequence
   : declaration
   | declaration_sequence declaration
   ;

declaration
   : blockdeclaration
   | functiondefinition
   | namespacedefinition
   | emptydeclaration
   | attributedeclaration
   ;

blockdeclaration
   : simpledeclaration
   | namespacealiasdefinition
   | usingdeclaration
   | usingdirective
   | aliasdeclaration
   | opaqueenumdeclaration
   ;

aliasdeclaration
   : Using Identifier attribute_specifier_sequence? '=' type_id ';'
   ;

simpledeclaration
   : declspecifierseq? initdeclaratorlist? ';'
   | attribute_specifier_sequence declspecifierseq? initdeclaratorlist ';'
   ;

emptydeclaration
   : ';'
   ;

attributedeclaration
   : attribute_specifier_sequence ';'
   ;

declspecifier
   : storageclass_specifier
   | typespecifier
   ;

declspecifierseq
   : declspecifier attribute_specifier_sequence?
   | declspecifier declspecifierseq
   ;

storageclass_specifier
   : Static
   ;

typedef_name
   : Identifier
   ;

typespecifier
   : trailing_type_specifier
   | class_specifier
   | enum_specifier
   ;

trailing_type_specifier
   : simple_type_specifier
   | elaboratedtypespecifier
   | type_name_specifier
   ;

type_specifier_sequence
   : typespecifier attribute_specifier_sequence?
   | typespecifier type_specifier_sequence
   ;

trailing_type_specifier_sequence
   : trailing_type_specifier attribute_specifier_sequence?
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
   | F32
   | F64
   | Float
   | Double
   | Void
   | Auto
   ;

type_name
   : class_name
   | enum_name
   | typedef_name
   | simple_template_id
   ;

elaboratedtypespecifier
   : Class attribute_specifier_sequence? nested_name_specifier? Identifier
   | Class simple_template_id
   | Class nested_name_specifier simple_template_id
   | Enum nested_name_specifier? Identifier
   ;

enum_name
   : Identifier
   ;

enum_specifier
   : enumhead '{' enumeratorlist? '}'
   | enumhead '{' enumeratorlist ',' '}'
   ;

enumhead
   : enumkey attribute_specifier_sequence? Identifier? enumbase?
   | enumkey attribute_specifier_sequence? nested_name_specifier Identifier enumbase?
   ;

opaqueenumdeclaration
   : enumkey attribute_specifier_sequence? Identifier enumbase? ';'
   ;

enumkey
   : Enum
   | Enum Class
   ;

enumbase
   : ':' type_specifier_sequence
   ;

enumeratorlist
   : enumeratordefinition
   | enumeratorlist ',' enumeratordefinition
   ;

enumeratordefinition
   : enumerator
   | enumerator '=' constantexpression
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

usingdeclaration
   : Using nested_name_specifier unqualified_id ';'
   | Using '::' unqualified_id ';'
   ;

usingdirective
   : attribute_specifier_sequence? Using Namespace nested_name_specifier? namespace_name ';'
   ;

attribute_specifier_sequence
   : attributespecifier
   | attribute_specifier_sequence attributespecifier
   ;

attributespecifier
   : '[' '[' attributelist ']' ']'
   ;

attributelist
   : attribute?
   | attributelist ',' attribute?
   | attribute '...'
   | attributelist ',' attribute '...'
   ;

attribute
   : attributetoken attributeargumentclause?
   ;

attributetoken
   : Identifier
   | attributescopedtoken
   ;

attributescopedtoken
   : attributenamespace '::' Identifier
   ;

attributenamespace
   : Identifier
   ;

attributeargumentclause
   : '(' balancedtokenseq ')'
   ;

balancedtokenseq
   : balancedtoken?
   | balancedtokenseq balancedtoken
   ;

balancedtoken
   : '(' balancedtokenseq ')'
   | '[' balancedtokenseq ']'
   | '{' balancedtokenseq '}'
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
   | noptrdeclarator parametersandqualifiers trailingreturntype
   ;

ptrdeclarator
   : noptrdeclarator
   | reference_operator ptrdeclarator
   ;

noptrdeclarator
   : declaratorid attribute_specifier_sequence?
   | noptrdeclarator parametersandqualifiers
   | noptrdeclarator '[' constantexpression? ']' attribute_specifier_sequence?
   | '(' ptrdeclarator ')'
   ;

parametersandqualifiers
   : '(' parameter_declaration_clause ')' refqualifier? exception_specification? attribute_specifier_sequence?
   ;

trailingreturntype
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
   | noptrabstract_declarator? parametersandqualifiers trailingreturntype
   | abstractpackdeclarator
   ;

ptrabstract_declarator
   : noptrabstract_declarator
   | reference_operator ptrabstract_declarator?
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
   : attribute_specifier_sequence? declspecifierseq declarator
   | attribute_specifier_sequence? declspecifierseq declarator '=' initializerclause
   | attribute_specifier_sequence? declspecifierseq abstract_declarator?
   | attribute_specifier_sequence? declspecifierseq abstract_declarator? '=' initializerclause
   ;

functiondefinition
   : attribute_specifier_sequence? declspecifierseq? declarator functionbody
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
   : '=' initializerclause
   | braced_init_list
   ;

initializerclause
   : assignment_expression
   | braced_init_list
   ;

initializerlist
   : initializerclause '...'?
   | initializerlist ',' initializerclause '...'?
   ;

braced_init_list
   : '{' initializerlist ','? '}'
   | '{' '}'
   ;
/*Classes*/


class_name
   : Identifier
   | simple_template_id
   ;

class_specifier
   : classhead '{' memberspecification? '}'
   ;

classhead
   : Class attribute_specifier_sequence? classheadname baseclause?
   | Class attribute_specifier_sequence? baseclause?
   ;

classheadname
   : nested_name_specifier? class_name
   ;

memberspecification
   : memberdeclaration memberspecification?
   | accessspecifier ':' memberspecification?
   ;

memberdeclaration
   : attribute_specifier_sequence? declspecifierseq? memberdeclaratorlist? ';'
   | functiondefinition
   | usingdeclaration
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
   | Identifier? attribute_specifier_sequence? ':' constantexpression
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


baseclause
   : ':' basespecifierlist
   ;

basespecifierlist
   : basespecifier '...'?
   | basespecifierlist ',' basespecifier '...'?
   ;

basespecifier
   : attribute_specifier_sequence? basetypespecifier
   | attribute_specifier_sequence? accessspecifier basetypespecifier
   ;

classordecltype
   : nested_name_specifier? class_name
   ;

basetypespecifier
   : classordecltype
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
   : classordecltype
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
   : templatename '<' templateargumentlist? '>'
   ;

template_id
   : simple_template_id
   | operator_function_id '<' templateargumentlist? '>'
   | literal_operator_id '<' templateargumentlist? '>'
   ;

templatename
   : Identifier
   ;

templateargumentlist
   : templateargument '...'?
   | templateargumentlist ',' templateargument '...'?
   ;

templateargument
   : type_id
   | constantexpression
   | id_expression
   ;

type_name_specifier
   : nested_name_specifier Identifier
   | nested_name_specifier simple_template_id
   ;

/*Exception handling*/

tryblock
   : Try compound_statement handler_sequence
   ;

functiontryblock
   : Try ctorinitializer? compound_statement handler_sequence
   ;

handler_sequence
   : handler handler_sequence?
   ;

handler
   : Catch '(' exception_declaration ')' compound_statement
   ;

exception_declaration
   : attribute_specifier_sequence? type_specifier_sequence declarator
   | attribute_specifier_sequence? type_specifier_sequence abstract_declarator?
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
   | FloatingLiteral
   | StringLiteral
   | BooleanLiteral
   | PointerLiteral
   ;

/*Keywords*/

Auto
   : 'auto'
   ;

Bool
   : 'bool'
   ;

Break
   : 'break'
   ;
Byte
   : 'byte'
   ;

Case
   : 'case'
   ;

Catch
   : 'catch'
   ;

Class
   : 'class'
   ;

Const
   : 'const'
   ;

Continue
   : 'continue'
   ;

Default
   : 'default'
   ;

Double
   : 'double'
   ;

Else
   : 'else'
   ;

Enum
   : 'enum'
   ;

F32
   : 'f32'
   ;

F64
   : 'f64'
   ;

False
   : 'false'
   ;

Float
   : 'float'
   ;

For
   : 'for'
   ;

If
   : 'if'
   ;

Int
   : 'int'
   ;

Int8
   : 'i8'
   ;

Int16
   : 'i16'
   ;

Int32
   : 'i32'
   ;

Int64
   : 'i64'
   ;

Long
   : 'long'
   ;

Namespace
   : 'namespace'
   ;

New
   : 'new'
   ;

Null
   : 'null'
   ;

Operator
   : 'operator'
   ;

Private
   : 'private'
   ;

Protected
   : 'protected'
   ;

Public
   : 'public'
   ;

Return
   : 'return'
   ;

Static
   : 'static'
   ;

Short
   : 'short'
   ;

Switch
   : 'switch'
   ;

This
   : 'this'
   ;

Throw
   : 'throw'
   ;

True
   : 'true'
   ;

Try
   : 'try'
   ;

Uint
   : 'uint'
   ;

Uint8
   : 'u8'
   ;

Uint16
   : 'u16'
   ;

Uint32
   : 'u32'
   ;

Uint64
   : 'u64'
   ;

Ulong
   : 'ulong'
   ;

Ushort
   : 'ushort'
   ;

Using
   : 'using'
   ;

Void
   : 'void'
   ;

While
   : 'while'
   ;

/*Operators*/

LeftParen
   : '('
   ;

RightParen
   : ')'
   ;

LeftBracket
   : '['
   ;

RightBracket
   : ']'
   ;

LeftBrace
   : '{'
   ;

RightBrace
   : '}'
   ;

Plus
   : '+'
   ;

Minus
   : '-'
   ;

Star
   : '*'
   ;

Div
   : '/'
   ;

Mod
   : '%'
   ;

Caret
   : '^'
   ;

And
   : '&'
   ;

Or
   : '|'
   ;

Tilde
   : '~'
   ;

Not
   : '!'
   ;

Assign
   : '='
   ;

Less
   : '<'
   ;

Greater
   : '>'
   ;

PlusAssign
   : '+='
   ;

MinusAssign
   : '-='
   ;

DivAssign
   : '/='
   ;

ModAssign
   : '%='
   ;

XorAssign
   : '^='
   ;

AndAssign
   : '&='
   ;

OrAssign
   : '|='
   ;

LeftShift
   : '<<'
   ;

RightShift
   :
   '>>'
   ;

LeftShiftAssign
   : '<<='
   ;

RightShiftAssign
   :
   '>>='
   ;

Equal
   : '=='
   ;

NotEqual
   : '!='
   ;

LessEqual
   : '<='
   ;

GreaterEqual
   : '>='
   ;

AndAnd
   : '&&'
   ;

OrOr
   : '||'
   ;

PlusPlus
   : '++'
   ;

MinusMinus
   : '--'
   ;

Comma
   : ','
   ;

Question
   : '?'
   ;

Colon
   : ':'
   ;

Semi
   : ';'
   ;

Dot
   : '.'
   ;

Ellipsis
   : '...'
   ;

fragment Hexquad
   : HEXADECIMAL_DIGIT HEXADECIMAL_DIGIT HEXADECIMAL_DIGIT HEXADECIMAL_DIGIT
   ;

fragment UniversalCharacterName
   : '\\u' Hexquad
   | '\\U' Hexquad Hexquad
   ;

Identifier
   : IdentifierNonDigit (IdentifierNonDigit | DIGIT)*
   ;

fragment IdentifierNonDigit
   : NONDIGIT
   | UniversalCharacterName
   ;

fragment NONDIGIT
   : [a-zA-Z_]
   ;

fragment DIGIT
   : [0-9]
   ;

IntegerLiteral
   : DecimalLiteral
   | OctalLiteral
   | HexadecimalLiteral
   | BinaryLiteral
   ;

DecimalLiteral
   : NONZERO_DIGIT DIGIT*
   ;

OctalLiteral
   : '0' OCTAL_DIGIT*
   ;

HexadecimalLiteral
   : '0x' HEXADECIMAL_DIGIT+
   ;

BinaryLiteral
   : '0b' BINARY_DIGIT+
   ;

fragment NONZERO_DIGIT
   : [1-9]
   ;

fragment OCTAL_DIGIT
   : [0-7]
   ;

fragment HEXADECIMAL_DIGIT
   : [0-9a-fA-F]
   ;

fragment BINARY_DIGIT
   : [01]
   ;

fragment EscapeSequence
   : SimpleEscapeSequence
   | OctalEscapeSequence
   | HexadecimalEscapeSequence
   ;

fragment SimpleEscapeSequence
   : '\\\''
   | '\\"'
   | '\\?'
   | '\\\\'
   | '\\a'
   | '\\b'
   | '\\f'
   | '\\n'
   | '\\r'
   | '\\t'
   | '\\v'
   ;

fragment OctalEscapeSequence
   : '\\' OCTAL_DIGIT
   | '\\' OCTAL_DIGIT OCTAL_DIGIT
   | '\\' OCTAL_DIGIT OCTAL_DIGIT OCTAL_DIGIT
   ;

fragment HexadecimalEscapeSequence
   : '\\x' HEXADECIMAL_DIGIT+
   ;

fragment FloatingLiteral
   : DigitSequence? '.' DigitSequence
   | DigitSequence '.'
   ;

fragment SIGN
   : [+-]
   ;

fragment DigitSequence
   : DIGIT ('\''? DIGIT)*
   ;

StringLiteral
   : '"' Char* '"'
   | RawString
   ;

fragment Char
   : ~ ["\\\r\n]
   | EscapeSequence
   | UniversalCharacterName
   ;

fragment RawString
   : '`' .*? '`'
   ;

BooleanLiteral
   : False
   | True
   ;

PointerLiteral
   : Null
   ;

Whitespace
   : [ \t]+ -> skip
   ;

Newline
   : ('\r' '\n'? | '\n')
   ;

BlockComment
   : '/*' .*? '*/' -> channel(HIDDEN)
   ;

LineComment
   : '//' ~ [\r\n]* -> channel(HIDDEN)
   ;