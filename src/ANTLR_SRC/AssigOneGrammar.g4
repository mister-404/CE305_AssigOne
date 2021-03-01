grammar AssigOneGrammar;

program: statement+; //a program is made up of multiple statements

statement: expr NEWLINE      # printExpr
    | ID '=' expr NEWLINE    # assign
    | NEWLINE                # blank
    ; //a statement is made of expressions and assignments

expr: expr op=('*'|'/') expr # Multi
    | expr op=('+'|'-') expr # Add
    | INT                    # int
    | ID                     # id
    | '(' expr ')'           # parens
    ;

ID : [a-zA-Z]+ ; // matches variable names
INT : [0-9]+ ; // matches integers
NEWLINE:'\r'? '\n' ;
WS : [ \t]+ -> skip ; // removes whitespace

MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;