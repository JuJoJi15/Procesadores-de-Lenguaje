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
\.      { return new Symbol(sym.PUNTO); }
\,      { return new Symbol(sym.COMA); }
\;      { return new Symbol(sym.PYC); }
\(      { return new Symbol(sym.AP); }
\)      { return new Symbol(sym.CP); }
\[      { return new Symbol(sym.AC); }
\]      { return new Symbol(sym.CC); }
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
int | char | float | string    { return new Symbol(sym.TIPO, yytext()); }
set     { return new Symbol(sym.SET); }
size              { return new Symbol(sym.SIZE,yytext());}
in                { return new Symbol(sym.IN,yytext()); }
length            { return new Symbol(sym.LENGTH, yytext()); }
\"[a-zA-Z0-9\\\"]*\" { return new Symbol(sym.STRING,yytext()); } //Cuidado con caracteres especiales
(0|[1-9][0-9]*)\.(0|[1-9][0-9]*)(E[+-][0-9]+)? { return new Symbol(sym.FLOAT, yytext()); }
('\\'')|('\\b')|('\\n')|('\\f')|('\\r')|('\\t')|('\\\\')|('\\\"') { return new Symbol(sym.CHAR, String.valueOf(Integer.valueOf(yytext().charAt(2)))); }
('\\u[0-9A-Za-z]{4}') { return new Symbol(sym.CHAR, String.valueOf(Integer.parseInt(yytext().substring(3,yytext().length()-1), 16))); }
('[!-~]') { return new Symbol(sym.CHAR, String.valueOf(Integer.valueOf(yytext().charAt(1)))); }
(0|[1-9][0-9]*) { return new Symbol(sym.ENTERO, yytext()); }
[a-zA-Z][a-zA-Z0-9]*            { return new Symbol(sym.IDENT, yytext() ); }
[\s\r]      {}
[^]     { throw new Error("Illegal character <"+yytext()+">"); } 