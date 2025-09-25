grammar Prova;

parse : body EOF;

body :
  block
;

block : statementChain* ;

statementChain
  : statement
  | ifStatement
  | switchStatement
  ;

statement
 : ( assignment ) (TERMINATOR)? ;

assignment : IDENTIFIER ASSIGNMENT expression ;

enclosedBlock : OPEN_BLOCK block CLOSE_BLOCK ;

ifStatement : conditionalBlock (ELSE conditionalBlock)* (elseBlock)? ;
conditionalBlock : IF enclosedExpression enclosedBlock ;
elseBlock : ELSE enclosedBlock
 | ELSE ifStatement;

switchStatement : SWITCH enclosedExpression OPEN_BLOCK (caseBlock)* (defaultBlock)? CLOSE_BLOCK ;
caseBlock : CASE literal enclosedBlock ;
defaultBlock : DEFAULT enclosedBlock ;

expression
 : enclosedExpression                                               #precedenceOverride
 | MINUS expression                                                 #unaryMinusOperator
 | NOT expression                                                   #notOperator
 | expression EQUALS                 expression                     #equalsOperator
 | expression DIFFERS                expression                     #differsOperator
 | expression GREATER_THAN           expression                     #greaterThanOperator
 | expression GREATER_OR_EQUAL_TO    expression                     #greaterOrEqualOperator
 | expression LOWER_THAN             expression                     #lowerThanOperator
 | expression LOWER_OR_EQUAL_TO      expression                     #lowerOrEqualOperator
 | expression AND                    expression                     #andOperator
 | expression OR                     expression                     #orOperator
 | expression sign=(DIVIDE|MULTIPLY) expression                     #multiplicationOrDivisionOperator
 | expression sign=(PLUS|MINUS)      expression                     #plusOrMinusOperator
 | literal                                                          #literalExpression
 | IDENTIFIER                                                       #identifierExpression
 ;

enclosedExpression : OPEN_PAREN expression CLOSE_PAREN ;

literal
 : INTEGER #integer
 | DOUBLE  #double
 | STRING  #string
 | DATE    #date
 | TRUE    #true
 | FALSE   #false
 | NULL     #null
 ;

OPEN_PAREN             : '(' ;
CLOSE_PAREN            : ')' ;
OPEN_BLOCK             : '{' ;
CLOSE_BLOCK            : '}' ;
TERMINATOR             : ';' ;
ASSIGNMENT             : '=' ;
EQUALS                 : '==' ;
DIFFERS                : '!=' ;
GREATER_THAN           : '>'  ;
GREATER_OR_EQUAL_TO    : '>=' ;
LOWER_THAN             : '<'  ;
LOWER_OR_EQUAL_TO      : '<=' ;
AND                    : '&&' ;
OR                     : '||' ;
NOT                    : '!'  ;
PLUS                   : '+'  ;
MINUS                  : '-'  ;
DIVIDE                 : '/'  ;
MULTIPLY               : '*'  ;
IF                     : 'if' ;
ELSE                   : 'else' ;
SWITCH                 : 'switch' ;
CASE                   : 'case' ;
DEFAULT                : 'default' ;
TRUE                   : 'true' ;
FALSE                  : 'false' ;
NULL                   : 'null' ;
INTEGER                : DIGIT+ ;
DOUBLE                 : DIGIT+ '.' DIGIT+ | '.' DIGIT+ ;
DATE                   : FOUR_DIGITS '-' (DIGIT | TWO_DIGITS) '-' (DIGIT | TWO_DIGITS) ;
fragment FOUR_DIGITS   : DIGIT DIGIT DIGIT DIGIT ;
fragment TWO_DIGITS    : DIGIT DIGIT ;
fragment DIGIT         : [0-9] ;
IDENTIFIER             : [a-zA-Z] [a-zA-Z_0-9]* ;
COMMENT                : '//' ~[\r\n]* -> skip ;
SPACE                  : [ \t\r\n] -> skip ;
STRING
  : '"' (~["\r\n] | '""')* '"'
  | '\'' (~['\r\n] | '\'\'')* '\''
  ;
