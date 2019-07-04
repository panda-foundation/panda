lexer grammar PandaLexer;

/*Keywords*/

Base
   : 'base'
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

Cast
   : 'cast'
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

Float32
   : 'f32'
   ;

Float64
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

Include
   : 'include'
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

Var
   : 'var'
   ;
   
Void
   : 'void'
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
   : NON_DIGIT
   ;

fragment NON_DIGIT
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

FloatLiteral
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
   | '@' '"' Char* '"'
   ;

fragment Char
   : ~ ["\\\r\n]
   | EscapeSequence
   | UniversalCharacterName
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
   : ('\r' '\n'? | '\n') -> skip
   ;

BlockComment
   : '/*' .*? '*/' -> channel(HIDDEN)
   ;

LineComment
   : '//' ~ [\r\n]* -> channel(HIDDEN)
   ;