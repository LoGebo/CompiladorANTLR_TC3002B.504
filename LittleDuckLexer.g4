// LittleDuckLexer.g4
lexer grammar LittleDuckLexer;

// Palabras Reservadas
PROGRAM : 'program';
MAIN : 'main';
END : 'end';
VAR : 'var';
INT : 'int';
FLOAT : 'float';
VOID : 'void';
IF : 'if';
ELSE : 'else';
WHILE : 'while';
DO : 'do';
PRINT : 'print';

// Identificadores
ID : [a-zA-Z][a-zA-Z0-9]*;

// Constantes
CTE_INT : [0-9]+;
CTE_FLOAT : [0-9]+ '.' [0-9]+;
CTE_STRING : '"' (ESC | ~["\\])* '"'; // Maneja escapes básicos
fragment ESC : '\\' ('\\' | '"' | 'u' HEX HEX HEX HEX) ; // Para escapes
fragment HEX : [0-9a-fA-F] ;

// Operadores
PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
ASSIGN : '='; // Asignación
EQ_COMP : '=='; // Comparación de igualdad
NEQ : '!=';
LT : '<';
GT : '>';

// Delimitadores
LPAREN : '(';
RPAREN : ')';
LBRACE : '{';
RBRACE : '}';
SEMICOLON : ';';
COMMA : ',';
COLON : ':';
DOT : '.'; // Para el 'end.'

// Ignorar espacios en blanco y comentarios
WS : [ \t\r\n]+ -> skip;
// COMMENT : '//' ~[\r\n]* -> skip; // Ejemplo de comentario de una línea
// ML_COMMENT : '/*' .*? '*/' -> skip; // Ejemplo de comentario multilínea 