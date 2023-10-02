

%%

%int




%state COMENTARIO
%state COMENESTRELLA
%state COMENDOBLEESTRELLA
%state COMILLA
%%


<YYINITIAL>{

    \/\/    {yybegin(COMENTARIO);}

    \/\*    {yybegin(COMENESTRELLA);}

    \/\*\*  {yybegin(COMENDOBLEESTRELLA);}

    \"      {yybegin(COMILLA);}

    [^]     {}

}

<COMENTARIO>{


    \n      {yybegin(YYINITIAL);}

    [^\s\n\r\t]     {JCom.com++;}

    [^]     {}

}

<COMENESTRELLA>{

    
    \*\/    {yybegin(YYINITIAL);}

    [^\s\n\r\t]     {JCom.comest++;}

    [^]     {}


}

<COMENDOBLEESTRELLA>{


    \*\/    {yybegin(YYINITIAL);}

    [^\s\n\r\t]     {JCom.comdobest++;}

    [^]     {}


}

<COMILLA>{

    \"      {yybegin(YYINITIAL);}

    [^]     {}


}
