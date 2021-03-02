grammar AssigOneGrammar;

/*
GRAMMAR SYNTAX
*/
program: statement+; //a program is made up of multiple statements

statement: expr ';'                     # printExpr
    | ID '=' expr ';'                   # assign
    | NEW_LINE                          # blank
    ; //a statement is made of expressions and assignments

expr: '(' expr ')'                      # parens
    | left=expr op='^' right=expr       # power
    | left=expr op=('*'|'/') right=expr # Multi
    | left=expr op=('+'|'-') right=expr # Add
    | INT                               # int
    | FLOAT                             # float
    | ID                                # id
    ; //supports order of operations

/*
TOKENS
*/
FLOAT : INT? '.' INT;
ID : [a-zA-Z]+ ; // matches variable names
INT : [0-9]+ ; // matches integers
NEW_LINE:'\r'? '\n' ;
WS : [ \t]+ -> skip ; // removes whitespace
ENDSTMT : ';' ;

/*
MATHEMATICAL OPERATION TOKENS
*/
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
POW : '^' ;