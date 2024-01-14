import java.io.IOException;
import java_cup.runtime.*;
%%

%line
%column
%cup

%{

    public int getLine(){
        return yyline;
    }
    public int getColumna(){
        return yycolumn;
    }
%}

%%

\+      { return new Symbol(sym.MAS); }
\-      { return new Symbol(sym.MENOS); }
\*      { return new Symbol(sym.MULT); }
\/      { return new Symbol(sym.DIVID); }
\=\=      { return new Symbol(sym.IGUAL); }
\>\=    { return new Symbol(sym.MAYIG); }
\=      { return new Symbol(sym.ASIGNA); }
\>      { return new Symbol(sym.MAYOR); }
\<\=    { return new Symbol(sym.MENIG); }
\<      { return new Symbol(sym.MENOR); }
\!\=    { return new Symbol(sym.DIF); }
\!      { return new Symbol(sym.NOT); }
\,      { return new Symbol(sym.COMA); }
\;      { return new Symbol(sym.PYC); }
\(      { return new Symbol(sym.AP); }
\)      { return new Symbol(sym.CP); }
\{      { return new Symbol(sym.ALL); }
\}      { return new Symbol(sym.CLL); }
\&\&    { return new Symbol(sym.AND); }
\|\|    { return new Symbol(sym.OR); }
if      { return new Symbol(sym.IF, yytext()); }
else    { return new Symbol(sym.ELSE, yytext()); }
while   { return new Symbol(sym.WHILE, yytext()); }
do      { return new Symbol(sym.DO, yytext()); }
for     { return new Symbol(sym.FOR, yytext()); }
print   { return new Symbol(sym.PRINT, yytext()); }
int | char | float     { return new Symbol(sym.TIPO, yytext()); }
(0|[1-9][0-9]*) { return new Symbol(sym.ENTERO, yytext()); }
[a-zA-Z][a-zA-Z0-9]*            { return new Symbol(sym.IDENT, yytext() ); }
[\s\r]      {}
[^]     { throw new Error("Illegal character <"+yytext()+">"); } 