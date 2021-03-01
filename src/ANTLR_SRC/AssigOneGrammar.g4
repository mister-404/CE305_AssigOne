grammar AssigOneGrammar;

program: statement+; //a program is made up of multiple statements

statement: expr ';'          # printExpr
    | ID '=' expr ';'        # assign
    | NEW_LINE                # blank
    ; //a statement is made of expressions and assignments

expr: expr op=('*'|'/') expr # Multi
    | expr op=('+'|'-') expr # Add
    | NUM                    # num
    | ID                     # id
    | '(' expr ')'           # parens
    ;

NUM: INT
   | FLOAT
;



ID : [a-zA-Z]+ ; // matches variable names
FLOAT: INT'.'INT
     | '.'INT
;
INT : [0-9]+ ; // matches integers
NEW_LINE:'\r'? '\n' ;
WS : [ \t]+ -> skip ; // removes whitespace
ENDSTMT : ';' ;

MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;