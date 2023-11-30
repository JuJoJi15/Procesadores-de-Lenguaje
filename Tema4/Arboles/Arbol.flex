import java_cup.runtime.*;

%%
%cup
%line
%column
%{

    public int getLine(){
        return yyline;
    }
    public int getColumn(){
        return yycolumn;
    }
%}
%%
\{                                                    { return new Symbol(sym.ALL); }
\}                                                    { return new Symbol(sym.CLL); }
\,                                                    { return new Symbol(sym.COMA); }
\-?(0|[1-9][0-9]*)                                    { return new Symbol(sym.NUMERO, new Integer(yytext()) ); }
\/\/.*											      {  }
\r|\n                                                 {  }
\ |\t|\f                                              {  }
[^]                                                   { throw new Error("Illegal character <"+yytext()+">"); }

