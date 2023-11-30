PROG=Calculadora

$(PROG).class: $(PROG).java parser.java Yylex.java sym.java
	javac $(PROG).java

parser.java sym.java: $(PROG).cup 
	cup  $(PROG).cup

Yylex.java: $(PROG).flex sym.java
	jflex  $(PROG).flex

clean:
	rm -f *.class Yylex.* sym.* parser.*
