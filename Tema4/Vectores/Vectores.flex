import java.io.IOException;
import java_cup.runtime.*;
%%

/*  Declaraciones */   

%line
%column
%cup 

Espacio = \s
Retorno = \R

%{

    public int getLine(){
        return yyline;
    }
    public int getColumn(){
        return yycolumn;
    }
%}

%%

/* Expresiones y reglas */
   
    "("                		{ return new Symbol(sym.AP); }
    ")"                		{ return new Symbol(sym.CP); }
    ","							{ return new Symbol(sym.COMA); }
    "C"							{ return new Symbol(sym.C); }
    "D"							{ return new Symbol(sym.D); }
    "I"							{ return new Symbol(sym.I); }
    "L"							{ return new Symbol(sym.L); }
    -?0|[1-9][0-9]*          { return new Symbol(sym.NUMERO, Integer.valueOf(yytext()) ); }
    {Retorno}          		{  }   
    {Espacio}          		{  }  
    [^]                		{ throw new  IOException("Illegal character <"+yytext()+"> en línea "+yyline);  }
    
