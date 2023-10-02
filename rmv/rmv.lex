
%%

%unicode
%int

%{

String var = "";
String valor = "";

%}



variable = [a-zA-Z\_][a-zA-Z\_0-9]*
comando = [a-zA-Z][a-zA-Z\_0-9]*

%state VARIABLE
%state COMILLAS
%state COMANDO
%%


<YYINITIAL>{
    {variable}=         {var = yytext().substring(0,yytext().length()-1);yybegin(VARIABLE);}

    {comando}             {System.out.print(yytext());yybegin(COMANDO);}

    [^]                   {}
}


<VARIABLE>{

    [\;\|\n\t]             {TablaSimbolos.put(var,valor);var = "";valor = ""; yybegin(YYINITIAL);}

    [\"]                 {yybegin(COMILLAS);}

    \${variable}         {valor += TablaSimbolos.get(yytext());}

    [a-zA-Z0-9+-/*=]+         {valor += yytext();}

    [\\][\$\"\;]           {valor += yytext();}

    [^]                  {}

}


<COMILLAS>{

    [\"]                 {yybegin(VARIABLE);}

    \${variable}         {valor += TablaSimbolos.get(yytext());}

    (\\). | [^\"]        {valor += yytext();}

    [^]                  {}


}

<COMANDO>{

    [\;\|\n\t]             {System.out.println();yybegin(YYINITIAL);}


    \${variable}         {System.out.print(TablaSimbolos.get(yytext()));}


    [^]                  {System.out.print(yytext());}
}


