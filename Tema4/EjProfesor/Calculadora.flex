import java_cup.runtime.*;
%%

/*  Declaraciones */   
   
%cup 
%line
%column

*{

    public int getLine(){
        return yyline;
    }
    public int getColumn(){
        return yycolumn;
    }
}*
%%   

/* Expresiones y reglas */
   
    "+"                { return new Symbol(sym.MAS); }
    "-"                { return new Symbol(sym.MENOS); }
    "*"                { return new Symbol(sym.MULT); }
    "/"                { return new Symbol(sym.DIVID); }
    "("                { return new Symbol(sym.AP); }
    ")"                { return new Symbol(sym.CP); }
    ";"                { return new Symbol(sym.PYC); }
    0|[1-9][0-9]*      { return new Symbol(sym.NUMERO, new Integer(yytext()) ); }
    [A-Za-z_][A-Za-z0-9_]* { return new Symbol(sym.ID, yytext();)}
    \r|\n              {  }   
    [^]                { throw new IOException("Illegal character <"+yytext()+"> en linea "+yyline); }
