

%%

%int

palabra = [a-zA-Z0-9\.\,\;\:\'\"\-\_\?\¿\'\¡\!\[\]\(\)]*[a-zA-Z0-9\.\,\;\:\'\"\-\_\?\¿\'\¡\!\[\]\(\)][a-zA-Z0-9\.\,\;\:\'\"\-\_\?\¿\'\¡\!\[\]\(\)]* // que contenga al menos un a-zA-Z0-9
lineaVacia = \n\n
indice = \s*[0-9]+\s*+\n

%{

int tiempo = 0;
int lineas = 0;
int palabras = 0;


public void reset(){
    tiempo = 0;
    lineas = 0;
    palabras = 0;
    

}

public void anadir(){
    srt.numSubtitulos += 1;
    srt.tiempo += tiempo;
    srt.numLineas += lineas;
    srt.numPalabras += palabras;
}

%}



%state SUBTITULO
%state HORAIN
%state MINUTOIN
%state SEGUNDOIN
%state MILIIN
%state HORAFIN
%state MINUTOFIN
%state SEGUNDOFIN
%state MILIFIN
%state SEPARADOR
%state ERROR
%%




<YYINITIAL>{

    ^{indice}\n            {yybegin(ERROR);}

    ^{indice}        {yybegin(HORAIN);reset();}

    

    [^]             {}

}

<HORAIN>{

    

    [0-9][0-9]:     {tiempo -= Integer.valueOf(yytext().substring(0,yylength()-1))*3600;yybegin(MINUTOIN);}

    [^]     {yybegin(ERROR);}
}

<MINUTOIN>{

    [0-9][0-9]:     {tiempo -= Integer.valueOf(yytext().substring(0,yylength()-1))*60;yybegin(SEGUNDOIN);}

    [^]     {yybegin(ERROR);}

}

<SEGUNDOIN>{

    [0-9][0-9],     {tiempo -= Integer.valueOf(yytext().substring(0,yylength()-1));yybegin(MILIIN);}    

    [^]     {yybegin(ERROR);}

}

<MILIIN>{

    [0-9][0-9][0-9]    {yybegin(SEPARADOR);}

    [^]     {yybegin(ERROR);}

}

<SEPARADOR> {

    -->(\s)*             {yybegin(HORAFIN);}

    [\s]        {}

    [^]     {yybegin(ERROR);}
}

<HORAFIN>{

    [0-9][0-9]:     {tiempo += Integer.valueOf(yytext().substring(0,yylength()-1))*3600;yybegin(MINUTOFIN);}

    [^]     {yybegin(ERROR);}
}

<MINUTOFIN>{

    [0-9][0-9]:     {tiempo += Integer.valueOf(yytext().substring(0,yylength()-1))*60;yybegin(SEGUNDOFIN);}

    [^]     {yybegin(ERROR);}

}

<SEGUNDOFIN>{

    [0-9][0-9],     {tiempo += Integer.valueOf(yytext().substring(0,yylength()-1));yybegin(MILIFIN);}    

    [^]     {yybegin(ERROR);}

}

<MILIFIN>{

    [0-9][0-9][0-9]    {}

    \n\n    {yybegin(ERROR);}

    \n     {yybegin(SUBTITULO);}

    [^]     {yybegin(ERROR);}

}


<SUBTITULO>{

    \<[^<>]+\> {}

    \{[^{}]+\} {}

    {palabra}      {System.out.println(yytext());palabras++;}

    \n\n    {lineas++;if(palabras != 0){anadir();}else{reset();}yybegin(YYINITIAL);}

    \n      {lineas++;}

    \s      {}

    \r      {}

    \t      {}

    [^]     {}


}

<ERROR>{

    \n\n    {yybegin(YYINITIAL);reset();}

    [^]     {}

}
