/**
 * Thrift IDL.
 */
grammar ThriftBase;

program
    : header* definition*
    ;

header
    : include       #includeDefinition
    | cppInclude    #cppIncludeDefinition
    | namespace     #namespaceDefinition
    ;

include
    :   'include' LITERAL
    ;

cppInclude
    : 'cpp_include' LITERAL
    ;

namespace
    : 'namespace' namespaceScope ID
    | 'smalltalk.category' ST_ID
    | 'smalltalk.prefix' ID
    | 'xsd_namespace' LITERAL
    | 'php_namespace' LITERAL
    ;

namespaceScope
    : '*' | 'cpp' | 'java' | 'py' | 'perl' | 'rb' | 'cocoa' | 'csharp'
    ;

definition
    : constant          #constantDefinition
    | typeDefinition    #typeDefinitionDefinition
    | service           #serviceDefinition
    ;

typeDefinition
    : typedef           #typedefDefinition
    | enumeration       #enumerationDefinition
    | senum             #senumDefinition
    | struct            #structDefinition
    | xception          #exceptionDefinition
    ;

typedef
    : 'typedef' fieldType ID
    ;


enumeration
    : 'enum' ID '{' enumDef* '}' ;

enumDef
    : ID '=' INT commaOrSemicolon?
    | ID commaOrSemicolon?
    ;

senum:
    'senum' ID '{' senumDef* '}' ;

senumDef
    : LITERAL commaOrSemicolon?
    ;

constant
    : 'const' fieldType ID '=' constValue commaOrSemicolon?
    ;

constValue
    : '[' (constValue commaOrSemicolon?)* ']'
    | '{' (constValue ':' constValue commaOrSemicolon?)* '}'
    | LITERAL
    | ID
    | INT
    | DOUBLE
    ;

structHead
    : 'struct'
    | 'union'
    ;

struct
    : structHead ID XsdAll? '{' field* '}'
    ;

xsdAttributes
    : 'xsd_attrs' '{' field* '}'
    ;

xception
    : 'exception' ID '{' field* '}'
    ;

service
    : 'service' ID ('extends' ID)? '{' function* '}'
    ;

function
    : ONEWAY? functionType ID '(' field* ')' raise?  commaOrSemicolon?
    ;

raise
    : 'throws' '(' field+ ')'
    ;

field
    : fieldID FieldRequiredness? fieldType ID fieldValue? XsdOptional? XsdNillable? xsdAttributes? commaOrSemicolon?
    ;

fieldID
    : INT ':'
    ;


fieldValue
    : '=' constValue
    ;

functionType
    : fieldType  #returnType
    | 'void'     #voidType
    ;

primitives
    :'string' | 'binary' | 'slist' | 'bool' | 'byte' | 'i16' | 'i32' | 'i64' | 'double'
    ;

fieldType
    : 'map' cppType? '<' key = fieldType ',' value = fieldType '>'          #mapType
    | 'set' cppType? '<' element = fieldType '>'                            #setType
    | 'list' '<' element = fieldType '>' cppType?                           #listType
    | primitives                                                            #primitiveType
    | ID                                                                    #structType
    ;

commaOrSemicolon
    : ','
    | ';'
    ;

cppType
    : 'cpp_type' LITERAL
    ;


XsdAll
    : 'xsd_all'
    ;

XsdOptional
    : 'xsd_optional'
    ;

XsdNillable
    : 'xsd_nillable'
    ;

FieldRequiredness
    : 'required'
    | 'optional'
    ;

ONEWAY
    : 'oneway'
    ;

// Identifiers
ID
    : ID_LETTER (ID_LETTER | DIGIT | '.')*
    ;

ST_ID
    : ID_LETTER (ID_LETTER | DIGIT | '.' | '-')*
    ;

LITERAL
    : '"' .*? '"'
    | '\'' .*? '\''
    ;

// Numbers
INT
    :   SIGN? DIGIT+
    ;

DOUBLE
    : INT ('.' DIGIT+)? (EXPONENT INT)?
    | '.' DIGIT+ (EXPONENT INT)?
    ;

FLOAT
    :   DIGIT+ '.' DIGIT*
    |   '.' DIGIT+
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

// Whitespaces
WS
    : [ \t\n\r]+ -> skip
    ;

// Helpers
fragment ID_LETTER
    : [a-zA-Z_]
    ;

fragment DIGIT
    : [0-9]
    ;

fragment ESC
    :   '\\' [btnr"\\]  // \b, \t, \n, \r etc...
    ;

fragment SIGN
    : [+-]
    ;

fragment EXPONENT
    : [eE]
    ;