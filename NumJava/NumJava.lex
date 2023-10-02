


%%

decimal = 0|[1-9][0-9]*
octal = 0[0-7]+
hexadecimal = 0x[0-9a-fA-F]+
exponencial = E[\+\-]?{decimal}+
%%

{decimal} | {octal} | {hexadecimal}         {return new Yytoken(Yytoken.TOKEN_CTE_ENTERO,yytext());}

({decimal} | {octal} | {hexadecimal})[lL]   {return new Yytoken(Yytoken.TOKEN_CTE_ENTERO_LARGO,yytext());}

({decimal}{exponencial}|{decimal}+\.{decimal}*{exponencial}?|{decimal}*\.{decimal}+{exponencial}? )[fF]   {return new Yytoken(Yytoken.TOKEN_CTE_REAL_CORTO,yytext());}

({decimal}{exponencial}|{decimal}+\.{decimal}*{exponencial}?|{decimal}*\.{decimal}+{exponencial}? )[dD]? {return new Yytoken(Yytoken.TOKEN_CTE_REAL_LARGO,yytext());}

({decimal} | {octal} | {hexadecimal})([fF])        {return new Yytoken(Yytoken.TOKEN_CTE_REAL_CORTO,yytext());}

({decimal} | {octal} | {hexadecimal})([dD]?)        {return new Yytoken(Yytoken.TOKEN_CTE_REAL_LARGO,yytext());}


[^\n\s\t\r]+    {return new Yytoken(Yytoken.TOKEN_ERROR,yytext());}

[^]             {}