grammar AssigOneGrammar;

/*
GRAMMAR SYNTAX
*/
program: statement+; //a program is made up of multiple statements

statement: expr ';'          # printExpr
    | ID '=' expr ';'        # assign
    | NEW_LINE               # blank
    ; //a statement is made of expressions and assignments

expr: '(' expr ')'           # parens
    | expr op='^' expr       # power
    | expr op=('*'|'/') expr # Multi
    | expr op=('+'|'-') expr # Add
    | INT                    # int
    | ID                     # id
    ; //supports order of operations

/*
TOKENS
*/
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