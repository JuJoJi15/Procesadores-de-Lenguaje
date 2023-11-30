import java_cup.runtime.*;
%%

/*  Declaraciones */   
   
%cup 
// %debug

%%   

/* Expresiones y reglas */
    
    "+"                { return new Symbol(sym.MAS); }
    "-"                { return new Symbol(sym.MENOS); }
    "*"                { return new Symbol(sym.POR); }
    "/"                { return new Symbol(sym.DIV); }
    "("                { return new Symbol(sym.AP); }
    ")"                { return new Symbol(sym.CP); }
    ";"                { return new Symbol(sym.PYC); }
    0|[1-9][0-9]*      { return new Symbol(sym.NUMERO, Integer.parseInt(yytext()) ); }
    \r|\n              { return new Symbol(sym.EOLN); }   
    \ |\t\f            {  }  
    [^]                { throw new Error("Illegal character <"+yytext()+">"); }
