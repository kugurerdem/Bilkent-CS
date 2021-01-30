%{
#include <stdio.h>
%}

/* Special Key Tokens*/
%token IF ELSE DO FOR WHILE DELETE RETURN VOID INPUT PRINT ADD REMOVE SIZE
%token INT_TYPE FLOAT_TYPE BOOLEAN_TYPE SET_TYPE CHAR_TYPE STRING_TYPE

/* Literal Tokens */
%token STRING CHAR FLOAT INT
%token BOOLEAN UNION_OP INTERSECT_OP SET_SUBSTRACTION_OP CARTESIAN_OP

/* Seperator Tokens */
%token LC RC LB RB

/* Operator Tokens */
%token ISEQUAL_OP NOTEQUAL_OP GREATEREQUAL_OP LESSEQUAL_OP GREATERTHAN_OP LESSTHAN_OP
%token ASSIGNMENT_OP ADDITION_OP SUBSTRACTION_OP DIVISION_OP MULTIPLICATION_OP MOD_OP
%token AND OR NOT

%token COMMA DOT SEMICOLON
%token IDENTIFIER

%%
start: statement_list { printf("Input prorgram is valid \n");};

// 1 Statements
statement_list: statement | statement_list statement;
statement:  declaration_statement 
            | assignment_statement 
            | if_statement
            | while_statement
            | do_while_statement
            | for_statement
            | print_statement 
            | set_property_statement 
            | delete_statement
            | function_declaration_statement
            | function_call_statement
            | return_statement 
;
// 1.1 Declaration/Assignment Statements
declaration_statement: declaration_expression SEMICOLON;
assignment_statement: assignment_expression SEMICOLON;
print_statement: PRINT LB expression RB SEMICOLON;

// 1.2 If/Else Statements
if_statement: IF LB boolean_expression RB LC statement_list RC else_if else;
else_if: | else_if ELSE IF LB boolean_expression RB LC statement_list RC;
else: ELSE LC statement_list RC | ;

// 1.3 Loops
while_statement: WHILE LB boolean_expression RB LC statement_list RC;
do_while_statement: DO LC statement_list RC WHILE LB boolean_expression RB SEMICOLON;
for_statement: FOR LB declaration_expression SEMICOLON boolean_expression SEMICOLON assignment_expression RB LC statement_list RC;

// 1.4 Methods (Functions)
parameter_list: parameter_list COMMA type IDENTIFIER | type IDENTIFIER | ;
function_declaration_statement: type IDENTIFIER LB parameter_list RB LC statement_list RC;
return_statement: RETURN expression SEMICOLON;
function_call_statement: function_expression SEMICOLON;

// 1.4.1 Special Method Statements
set_property_statement: IDENTIFIER DOT ADD LB expression_list RB SEMICOLON
                        | IDENTIFIER DOT REMOVE LB expression_list RB SEMICOLON
                        | IDENTIFIER DOT SIZE LB RB SEMICOLON;
delete_statement: DELETE IDENTIFIER SEMICOLON;

// 2 Expressions
expression: assignment_expression 
            | boolean_expression
            ;

// 2.1 Assignment Expression
assignment_expression: IDENTIFIER ASSIGNMENT_OP expression;
declaration_expression: type IDENTIFIER | type assignment_expression;

// 2.2 Boolean & Comparison Expressions
boolean_expression:  boolean_expression OR OR boolean_and_expression | boolean_and_expression;
boolean_and_expression: boolean_and_expression AND AND comparison_expression | comparison_expression;
comparison_expression:   comparison_expression LESSEQUAL_OP arithmetic_expression 
                        | comparison_expression GREATEREQUAL_OP arithmetic_expression 
                        | comparison_expression GREATERTHAN_OP arithmetic_expression 
                        | comparison_expression LESSTHAN_OP arithmetic_expression 
                        | comparison_expression ISEQUAL_OP arithmetic_expression 
                        | comparison_expression NOT arithmetic_expression 
                        | arithmetic_expression;

// 2.3 Arithmetic expressions
arithmetic_expression:  term ADDITION_OP arithmetic_expression
                       | term SUBSTRACTION_OP arithmetic_expression
                       | term;

term: term MULTIPLICATION_OP set_expression 
      | term DIVISION_OP set_expression
      | set_expression;

// 2.4 Set Operation Expressions
set_expression: set_expression SET_SUBSTRACTION_OP cartesian_expression | cartesian_expression;
cartesian_expression: cartesian_expression  CARTESIAN_OP function_expression | function_expression; 

// 2.5 Function expression
function_expression: IDENTIFIER LB input_parameters RB 
                    | IDENTIFIER LB RB 
                    | input_expression 
                    | simple_expression
                    | union_expression
                    | intersect_expression;

input_parameters: expression | input_parameters COMMA expression;
set_op_parameters: set_op_parameters COMMA expression | expression com_expr;
com_expr: COMMA expression;

input_expression: INPUT LB RB;
union_expression: UNION_OP LB set_op_parameters RB;
intersect_expression: INTERSECT_OP LB set_op_parameters RB;

// 2.6 Unit Expression
simple_expression: NOT unit_expression | unit_expression;
unit_expression: LB expression RB | literal | IDENTIFIER;

// 3 Literals
literal: INT | FLOAT | set |  STRING | CHAR | BOOLEAN;
type: INT_TYPE | FLOAT_TYPE | BOOLEAN_TYPE | SET_TYPE | CHAR_TYPE | STRING_TYPE;
set: LC expression_list RC | LC RC;
expression_list: expression_list COMMA expression | expression;

%%
#include "lex.yy.c"

int main() {
 return yyparse();
}

int yyerror( char *s ) { 
    extern int lineno;
    fprintf(stderr, "At line %d %s \n", lineno, s); 
}