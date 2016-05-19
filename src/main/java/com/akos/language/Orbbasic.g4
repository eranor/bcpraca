/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar Orbbasic;

prog
    : line + EOF
    ;

line
    : (linenumber statement)| COMMENT
    ;

linenumber
    : NUMBER
    ;

statement
    : printstmt
    | conditionalstmt
    | forstmt
    | nextstmt
    | branchstmt
    | idxbranchstmt
    | delay
    | backled
    | varassign
    ;

printstmt
    : (PRINT | QMARK) printlist?
    ;

printlist
   : expression COMMA? printlist*
   ;

conditionalstmt
    : IF expression THEN statement (ELSE statement)?;
forstmt
    : FOR varassign TO expression (STEP expression)?
    ;
nextstmt
   : NEXT vardecl?
   ;

branchstmt
    : GOTO linenumber | GOSUB linenumber
    ;

idxbranchstmt
    : ON expression (GOTO|GOSUB) (COMMA linenumber)+
    ;

delay
    : DELAY expression
    ;

backled
    : BACKLED expression
    ;

vardecl
    : varname
    | SYSVARNAME
    ;

varname
    : VARLETTER
    ;

varassign
    : vardecl EQ expression
    ;

neq
    : NOT
    ;

number
   : NUMBER
   ;

func
    : number
    | vardecl
    | sqrtfunc
    | rndfunc
    | absfunc
    | LPAREN expression RPAREN
    ;

sqrtfunc
    : SQRT (expression | number)
    ;

rndfunc
    : RND (expression | number)
    ;

absfunc
    : ABS (expression | number)
    ;

signExpr
    : NOT? ((PLUS | MINUS))* func
    ;

multExpr
    : signExpr((TIMES | DIV | MOD | BINSHL | BINSHR) signExpr)*
    ;

addExpr
    : multExpr ((PLUS | MINUS) multExpr)*
    ;

relExpr
    : addExpr (( GT | LT | EQ | neq) addExpr)*
    ;

expression
    : func
    | relExpr (( AND | OR) relExpr )*
    ;

GT : '>';
LT : '<';
EQ : '=';
NOT : '!';
AND : 'and';
OR : 'or';

TIMES : '*';
DIV : '/';
MOD :'%';
PLUS : '+';
MINUS : '-';
BINSHL : '{' ;
BINSHR : '}' ;
BINAND : '&' ;
BINOR : '|' ;

SQRT : 'sqrt' ;
RND : 'rnd' ;
ABS : 'abs' ;

IF : 'if';
THEN : 'then';
ELSE : 'else';

FOR : 'for';
TO : 'to';
STEP : 'step';
NEXT : 'next';
GOTO : 'goto';
GOSUB : 'gosub';

ON : 'on';

COMMA : ',';
QMARK : '?';
LPAREN : '(';
RPAREN : ')';

PRINT : 'print';
DELAY : 'delay';
BACKLED : 'backLED';

SYSVARNAME
    : 'timer'[ABC]
    | 'ctrl'
    | 'speed'
    | 'yaw'
    | 'pitch'
    | 'roll'
    | 'accel'[XYZ]
    | 'gyro'[XYZ]
    | [VS]'batt'
    | ('cmd'|'spd'|'hdg')'val'
    | 'isconn'
    | 'dshake'
    | 'accelone'
    | [xy]'pos';

VARLETTER
    : [A-Y]|[a-y]
    ;

LISTLETTER
    : 'Z'
    ;

fragment CHAR
    : ~["\r\n]
    ;

COMMENT
    : '\\'CHAR*
    ;

fragment DIGIT
    : ('0' .. '9')
    ;

NUMBER
    : DIGIT + (('e' | 'E') NUMBER)*
    ;

WS
    : [ \t\n\r]+ -> channel(HIDDEN)
    ;


