%option main

 // Characters
digit                   [0-9]
uppercase               [A-Z]
lowercase               [a-z]
letter                  ({uppercase}|{lowercase})
dot                     \.
semicolon               \;
l_curly                 \{
r_curly                 \}
L_bracket               \(
r_bracket               \)

 // Literals
char                    \'.\'
string                  \"(.)*\" 
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

 // Identifiers
identifier_symbols      ({letter}|{digit}|_|$)
identifier              {letter}{identifier_symbols}*

 // Assignment operator
eq                      =

 // Set operators
union                   union
intersect               intersect
set_substraction        \\

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

 // For comments
comment_start           \/\* 
comment_end             \*\/
single_line_comment     \/\/

%%

{dot}                   printf(" DOT ");
{if}                    printf(" IF ");
{else}                  printf(" ELSE ");
{do}                    printf(" DO ");
{for_loop}              printf(" FOR ");
{while_loop}            printf(" WHILE ");
{delete_keyword}        printf(" DELETE ");
{return_keyword}        printf(" RETURN ");
{void_keyword}          printf(" VOID ");
{int_type}              printf(" INT_TYPE ");
{float_type}            printf(" FLOAT_TYPE "); 
{boolean_type}          printf(" BOOLEAN_TYPE ");
{set_type}              printf(" SET_TYPE ");
{char_type}             printf(" CHAR_TYPE ");
{string_type}           printf(" STRING_TYPE ");

{single_line_comment}   printf(" SINGLE_LINE_COMMENT ");
{comment_start}         printf(" COMMENT_START ");
{comment_end}           printf(" COMMENT_END ");

{boolean}               printf(" BOOLEAN ");
{union}                 printf(" UNION_OP ");
{intersect}             printf(" INTERSECT_OP ");
{set_substraction}      printf(" SET_SUBSTRACTION_OP ");
{char}                  printf(" CHAR ");
{string}                printf(" STRING ");
{float}                 printf(" FLOAT ");
{unsigned_int}          printf(" UNSIGNED ");
{int}                   printf(" INT ");

{l_curly}               printf(" LC ");
{r_curly}               printf(" RC ");
{L_bracket}             printf(" LB ");
{r_bracket}             printf(" RB ");

{isEqual}               printf(" ISEQUAL_OP ");
{notEqual}              printf(" NOTEQUAL_OP ");
{greaterorequal}        printf(" GREATEREQUAL_OP ");
{lessorequal}           printf(" LESSEQUAL_OP ");
{greaterthan}           printf(" GREATERTHAN_OP ");
{lessthan}              printf(" LESSTHAN_OP ");
{eq}                    printf(" ASSIGNMENT_OP ");
{plus}                  printf(" ADDITION_OP ");
{minus}                 printf(" SUBSTRACTION_OP ");
{divide}                printf(" DIVISION_OP ");
{multiply}              printf(" MULTIPLICATION_OP ");
{remainder}             printf(" MOD_OP ");

{semicolon}             printf(" SEMICOLON ");

{identifier}            printf(" IDENTIFIER ");
