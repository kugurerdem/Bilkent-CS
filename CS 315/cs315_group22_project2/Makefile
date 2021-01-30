parser: y.tab.c lex.yy.c
	gcc -o parser y.tab.c
y.tab.c: CS315s20_group22.y lex.yy.c
	yacc -d CS315s20_group22.y
lex.yy.c: CS315s20_group22.l
	lex CS315s20_group22.l
clean:
	rm -f lex.yy.c y.tab.c parser
