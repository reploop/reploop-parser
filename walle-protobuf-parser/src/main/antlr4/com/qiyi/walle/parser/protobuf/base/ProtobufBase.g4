grammar ProtobufBase;

program
    : (option | header)* (message | enumeration | service | extend)+
    ;

header
    : namespace #namespaceDefinition
    | include   #includeDefinition
    | syntax    #syntaxDefinition
    ;

syntax
    : STRING ';'
    ;

namespace
    : 'package' ID ';'
    ;

include
    : 'import' STRING ';'
    ;

message
    : 'message' ID '{' (option | message | enumeration | field | extend | extensions)+ '}'
    ;

option
    : 'option'  pair ';'
    ;

pair
    : '(' name=ID ')' ('.' attr=ID)? '=' value  #optionPair
    | 'default' '=' value                       #defaultPair
    | ID  '=' value                             #commonPair
    ;

enumeration
    : 'enum' ID '{' nameIndex+ '}'
    ;

nameIndex
    : ID '=' INT multiOptions?';'
    ;

field
    : FieldModifier? fieldType fieldName '=' INT multiOptions? ';'
    ;

fieldName
    : 'syntax'      #syntaxName
    | 'package'     #packageName
    | 'message'     #messageName
    | ID            #idName
    ;

multiOptions
    : '[' pair (',' pair)* ']'
    ;

value
    : INT           #intVal
    | FLOAT         #floatVal
    | BOOL_LITERAL  #boolValue
    | STRING        #stringValue
    | ID            #structValue
    ;

FieldModifier
    : 'required'
    | 'optional'
    | 'repeated'
    ;

fieldType
    : ScalarType         #primitiveType
    | '.'? ID            #messageOrEnumType
    ;

extensions
    : 'extensions' from=INT 'to' to=ID ';'
    ;

extend
    : 'extend' ID '{' field+ '}'
    ;

ScalarType
    : 'double'
    | 'float'
    | 'int32'
    | 'int64'
    | 'uint32'
    | 'uint64'
    | 'sint32'
    | 'sint64'
    | 'fixed32'
    | 'fixed64'
    | 'sfixed32'
    | 'sfixed64'
    | 'bool'
    | 'string'
    | 'bytes'
    ;

service
    : 'service' ID '{' (option | function)+ '}'
    ;

function
    : 'rpc' ID '(' requestType = fieldType ')' 'returns' '(' responseType = fieldType ')' (';' | ('{' option* '}')?)
    ;

BOOL_LITERAL
    : 'true'
    | 'false'
    ;

FLOAT
    : SIGN? (ZERO | (POSITIVE_DIGIT DIGIT*)) ('.' DIGIT* EXP?)
    ;

ID
    : ID_LETTER (ID_LETTER | DIGIT | '.')*
    ;

INT
    : SIGN? DIGIT+
    ;

// Strings
STRING
    :   '"' ( ESC | . )*? '"'
    ;

// Comments
LINE_COMMENT
    :   '//' .*? '\n' -> channel(HIDDEN)
    ;

COMMENT
    :   '/*' .*? '*/' -> channel(HIDDEN)
    ;

// Whitespaces, \t, \n, \r, space
WS
    : [ \t\n\r]+ -> skip
    ;

fragment EXP
   : [Ee] [+\-]? DIGIT*
   ;

fragment ZERO
    : '0'
    ;

fragment ID_LETTER
    : [a-zA-Z_]
    ;

fragment POSITIVE_DIGIT
    : [1-9]
    ;

fragment DIGIT
    : [0-9]
    ;

fragment SIGN
    : [+-]
    ;

fragment ESC
    : '\\' [btnr"\\]  // \b, \t, \n etc...
    ;
