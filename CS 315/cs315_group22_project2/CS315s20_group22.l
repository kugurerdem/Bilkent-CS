%{
#include "y.tab.h"
int lineno = 1;
%}


 // Characters
digit                   [0-9]
uppercase               [A-Z]
lowercase               [a-z]
letter                  ({uppercase}|{lowercase})
dot                     \.
comma                   \,
semicolon               \;
l_curly                 \{
r_curly                 \}
L_bracket               \(
r_bracket               \)

 // Literals
char                    \'.\'
string                  ["][^"]*["]
unsigned_int            {digit}+
int                     [+-]?{unsigned_int}
float                   {int}?\.{unsigned_int}
boolean                 true|false

 // Type keywords
int_type                int
float_type              float
boolean_type            boolean
set_type                set
char_type               char
string_type             string

 // Other keywords
delete_keyword          delete 
return_keyword          return
void_keyword            void
if                      if
else                    else
do                      do
for_loop                for
while_loop              while
input					input
print					print
add						add
remove					remove
size					size

 // Identifiers
identifier_symbols      ({letter}|{digit}|_|$)
identifier              {letter}{identifier_symbols}*

 // Assignment operator
eq                      =

 // Set operators
union                   union
intersect               intersect
set_substraction        \\
cartesian				\^

 // Arithmetic operators
plus                    \+
minus                   -
divide                  \/
multiply                \*
remainder               %

 // Logical operators
greaterorequal          \>=
lessorequal             \<= 
greaterthan             \>
lessthan                \<
isEqual                 ==
notEqual                !=

 // Boolean operators
and_op 					&
or_op					\|
not_op 					!	

 // For comments
comment          		\/\*(.|\n)*\*\/
single_line_comment     \/\/(.)*

%%

\n 						{ lineno++; }

{string}                {/* printf( " STRING ");*/
						 int stringLineNo = 0;
						 int i;
						 for(i = 0; i < yyleng; i++){
							if( yytext[i] == '\n')
								stringLineNo++;
						 }
						 lineno = lineno + stringLineNo;

 						 return STRING;}

{single_line_comment}   {/* printf( " SINGLE_LINE_COMMENT ");*/}

{comment}               {/* printf( " COMMENT ");*/
						 int commentLineNo = 0;
						 int i;
						 for(i = 0; i < yyleng; i++){
							if( yytext[i] == '\n')
								commentLineNo++;
						 }
						 lineno = lineno + commentLineNo;
						}

{if}                    {/* printf( " IF ");*/ 
 						 return IF;}
{else}                  {/* printf( " ELSE ");*/ 
 						 return ELSE;}
{do}                    {/* printf( " DO ");*/ 
 						 return DO;}
{for_loop}              {/* printf( " FOR ");*/ 
 						 return FOR;}
{while_loop}            {/* printf( " WHILE ");*/ 
 						 return WHILE;}
{delete_keyword}        {/* printf( " DELETE ");*/ 
 						 return DELETE;}
{return_keyword}        {/* printf( " RETURN ");*/ 
 						 return RETURN;}
{void_keyword}          {/* printf( " VOID ");*/ 
 						 return VOID;}
{input}          		{/* printf( " INPUT ");*/ 
 						 return INPUT;}
{print}          		{/* printf( " PRINT ");*/ 
 						 return PRINT;}
{add}          			{/* printf( " ADD ");*/ 
 						 return ADD;}
{remove}          		{/* printf( " REMOVE ");*/ 
 						 return REMOVE;}
{size}          		{/* printf( " SIZE ");*/ 
 						 return SIZE;}
{int_type}              {/* printf( " INT_TYPE ");*/ 
 						 return INT_TYPE;}
{float_type}            {/* printf( " FLOAT_TYPE ");*/ 
 						 return FLOAT_TYPE;} 
{boolean_type}          {/* printf( " BOOLEAN_TYPE ");*/ 
 						 return BOOLEAN_TYPE;}
{set_type}              {/* printf( " SET_TYPE ");*/ 
 						 return SET_TYPE;}
{char_type}             {/* printf( " CHAR_TYPE ");*/ 
 						 return CHAR_TYPE;}
{string_type}           {/* printf( " STRING_TYPE ");*/ 
 						 return STRING_TYPE;}

{boolean}               {/* printf( " BOOLEAN ");*/ 
 						 return BOOLEAN;}
{union}                 {/* printf( " UNION_OP ");*/ 
 						 return UNION_OP;}
{intersect}             {/* printf( " INTERSECT_OP ");*/ 
 						 return INTERSECT_OP;}
{set_substraction}      {/* printf( " SET_SUBSTRACTION_OP ");*/ 
 						 return SET_SUBSTRACTION_OP;}
{cartesian}				{/* printf( " CARTESIAN_OP ");*/ 
 						 return CARTESIAN_OP;}

{char}                  {/* printf( " CHAR ");*/ 
 						 return CHAR;}
{float}                 {/* printf( " FLOAT ");*/ 
 						 return FLOAT;}
{unsigned_int}          {/* printf( " INT ");*/ 
 						 return INT;}

{l_curly}               {/* printf( " LC ");*/ 
 						 return LC;}
{r_curly}               {/* printf( " RC ");*/ 
 						 return RC;}
{L_bracket}             {/* printf( " LB ");*/ 
 						 return LB;}
{r_bracket}             {/* printf( " RB ");*/ 
 						 return RB;}

{isEqual}               {/* printf( " ISEQUAL_OP ");*/ 
 						 return ISEQUAL_OP;}
{notEqual}              {/* printf( " NOTEQUAL_OP ");*/ 
 						 return NOTEQUAL_OP;}
{greaterorequal}        {/* printf( " GREATEREQUAL_OP ");*/ 
 						 return GREATEREQUAL_OP;}
{lessorequal}           {/* printf( " LESSEQUAL_OP ");*/ 
 						 return LESSEQUAL_OP;}
{greaterthan}           {/* printf( " GREATERTHAN_OP ");*/ 
 						 return GREATERTHAN_OP;}
{lessthan}              {/* printf( " LESSTHAN_OP ");*/ 
 						 return LESSTHAN_OP;}
{eq}                    {/* printf( " ASSIGNMENT_OP ");*/ 
 						 return ASSIGNMENT_OP;}
{and_op}				{/* printf( " AND ");*/ 
 						 return AND;}
{or_op}					{/* printf( " OR ");*/ 
 						 return OR;}
{not_op}				{/* printf( " NOT ");*/ 
 						 return NOT;}
{plus}                  {/* printf( " ADDITION_OP ");*/ 
 						 return ADDITION_OP;}
{minus}                 {/* printf( " SUBSTRACTION_OP ");*/ 
 						 return SUBSTRACTION_OP;}
{divide}                {/* printf( " DIVISION_OP ");*/ 
 						 return DIVISION_OP;}
{multiply}              {/* printf( " MULTIPLICATION_OP ");*/ 
 						 return MULTIPLICATION_OP;}
{remainder}             {/* printf( " MOD_OP ");*/ 
 						 return MOD_OP;}

{semicolon}             {/* printf( " SEMICOLON ");*/ 
 						 return SEMICOLON;}

{dot}                   {/* printf( " DOT ");*/ 
 						 return DOT;}
{comma}                 {/* printf( " COMMA ");*/ 
 						 return COMMA;}

{identifier}            {/* printf( " IDENTIFIER ");*/ 
 						 return IDENTIFIER;}
                       
%%

int yywrap() { return 1; }

