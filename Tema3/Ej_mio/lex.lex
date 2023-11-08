

%%



%%


n       {linea++;return new Yytoken(Yytoken.N,0);}
\$       {linea++;return new Yytoken(Yytoken.DOLAR,0);}
\(      {linea++;return new Yytoken(Yytoken.AP,0);}
\)      {linea++;return new Yytoken(Yytoken.CP,0);}
\+      {linea++;return new Yytoken(Yytoken.MAS,0);}
[^]         {}