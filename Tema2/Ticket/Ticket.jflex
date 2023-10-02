

%%
%{
    
    int unidades;
    float descuento,precio;

%}

%int

%state COMPRA

%%
    


<YYINITIAL>{

    ^\-      {yybegin(COMPRA);descuento = 1;unidades = 1;precio = 0;}

    [^]     {}


}


<COMPRA>{

    [0-9]+(.[0-9])? / %       {descuento = (100 - Float.valueOf(yytext()))/100;}

    [0-9]+ / uds        {unidades = Integer.valueOf(yytext());}

    [0-9]+\.[0-9]{1,2}|[0-9]+  {precio = unidades*descuento*Float.valueOf(yytext());yybegin(YYINITIAL);Ticket.addItemsDistintos(1);Ticket.addItems(unidades);Ticket.addCompra(precio);}

    [^] {}



}