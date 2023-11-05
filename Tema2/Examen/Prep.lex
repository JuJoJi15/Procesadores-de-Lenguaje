
%%
%int


identificador = [a-zA-Z][a-zA-Z0-9_]*

%{
    String var,val;
    

    
%}


%state DEFINEID
%state DEFINEVAL
%state ERROR
%state IF
%state IFVALIDO
%state IFNOVALIDO
%state IFCODIGO
%state ERRORIF
%state ERRORCODIGO
%state IGNORAR
%%


<YYINITIAL>{

    ^(#define)\s  {yybegin(DEFINEID);var = ""; val = "";}

    \$\{{identificador}\}       {System.out.print(TablaSimbolos.get(yytext().substring(2,yylength()-1)));}

    ^(#ifdef)\s     {yybegin(IF);}

    ^(#endif)       {System.out.print("ERROR_ENDIF_SIN_IF");}

    [^]     {System.out.print(yytext());}

}

<DEFINEID>{
    
    {identificador}\s     {var = yytext().substring(0,yylength()-1);yybegin(DEFINEVAL);}

    [^]             {System.out.print("ERROR_DEFINICION");yybegin(ERROR);}

}

<DEFINEVAL>{

    [\n]        {TablaSimbolos.put(var,val);yybegin(YYINITIAL);}

    [^]         {val += yytext();}

}

<ERROR>{

    [\n]    {System.out.print(yytext());yybegin(YYINITIAL);}

    [^]     {}

}

<IF>{

    {identificador}     {if(TablaSimbolos.get(yytext()) != "ID_NO_DEFINIDO"){yybegin(IFVALIDO);}else{yybegin(IFNOVALIDO);}}

    [^]             {System.out.print("ERROR_IFDEF");yybegin(ERRORIF);}

}

<IFVALIDO>{

    [\n]    {yybegin(IFCODIGO);}

    [^]     {}
}

<IFNOVALIDO>{

    [\n]    {yybegin(ERRORIF);}

    [^]     {}
}

<IFCODIGO>{

    \$\{{identificador}\}       {System.out.print(TablaSimbolos.get(yytext().substring(2,yylength()-1)));}

    ^#endif / [\n]      {yybegin(IGNORAR);}

    ^#ifdef\s      {System.out.print("ERROR_IF_ANIDADO");yybegin(ERRORCODIGO);}

    #define     {System.out.print("ERROR_DEFINE_EN_IF");yybegin(ERRORCODIGO);}

    [^]     {System.out.print(yytext());}


}

<ERRORIF>{

  ^#endif / [\n]         {yybegin(IGNORAR);}

  #define   {System.out.println("ERROR_DEFINE_EN_IF");}

  [^]       {}  

}

<ERRORCODIGO>{

    [\n]    {System.out.print(yytext());yybegin(IFCODIGO);}

    [^]     {}
}

<IGNORAR>{

    [\n]    {yybegin(YYINITIAL);}

    [^] {}
}