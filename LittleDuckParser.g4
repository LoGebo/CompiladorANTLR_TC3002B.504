// LittleDuckParser.g4
parser grammar LittleDuckParser;

options { tokenVocab = LittleDuckLexer; } // Importa tokens de LittleDuckLexer

// Regla inicial
programa : PROGRAM ID SEMICOLON dec_vars? bloque_principal END DOT;

dec_vars : VAR dec_var_aux+;
dec_var_aux : lista_ids COLON tipo SEMICOLON;
lista_ids : ID (COMMA ID)*;
tipo : INT | FLOAT | VOID; // VOID podría ser solo para funciones

bloque_principal : MAIN LPAREN RPAREN bloque;
bloque : LBRACE estatuto* RBRACE; // Un bloque puede tener cero o más estatutos

estatuto : asignacion
         | condicion
         | ciclo_w
         | ciclo_do_w // Renombrado para claridad
         | escritura
         ;

asignacion : ID ASSIGN expresion SEMICOLON;

escritura : PRINT LPAREN print_args RPAREN SEMICOLON;
print_args : expresion (COMMA expresion)*
           | CTE_STRING (COMMA (expresion | CTE_STRING))* // Permitir imprimir múltiples cosas
           ;

condicion : IF LPAREN expresion RPAREN bloque (ELSE bloque)?;
ciclo_w : WHILE LPAREN expresion RPAREN DO bloque; // Como en el OCR original
ciclo_do_w : DO bloque WHILE LPAREN expresion RPAREN SEMICOLON;

// Expresiones
expresion : exp_comp ( (EQ_COMP | NEQ | LT | GT ) exp_comp )*; // Operadores de comparación
exp_comp : exp_arit ( (PLUS | MINUS) exp_arit )*; // Adición y sustracción
exp_arit : termino ( (MULT | DIV) termino )*; // Multiplicación y división
termino : LPAREN expresion RPAREN // Expresión entre paréntesis
        | (PLUS | MINUS)? factor // Factor con signo opcional
        ;

factor : ID
       | CTE_INT
       | CTE_FLOAT
       // | llamada_func // Podría añadirse en el futuro
       ;

// Nota: CTE_STRING no se incluye en 'factor' para expresiones aritméticas/lógicas,
// solo en 'escritura'. Si se permitieran operaciones con strings, se añadiría aquí. 