import java.util.LinkedList;
import java.util.List;
%%

%int

numeros = [1-9][0-9]+|[0-9]
operadores = [\+\-\/\*]

%{

LinkedList<Integer> lista = new LinkedList<Integer>();
String operador;
int posicion = 0;
public void operar(LinkedList lista,String oper){
    int res = 0;
    Integer a = (Integer) lista.remove(posicion);
    Integer b = (Integer) lista.remove(posicion);
    switch(oper){
        case "+":res = a + b;break;
        case "-":res = a - b;break;
        case "*":res = a * b;break;
        case "/":res = a / b;break;
        default :System.err.println("Error al operar");

    }

    lista.add(posicion,res);



}



    
    
%}

%state OPERANDO

%%

<YYINITIAL>{

    {numeros}              {lista.add(Integer.valueOf(yytext()));}

    {operadores}             {operador = yytext();yybegin(OPERANDO);}

    \(                       {if(lista.size()>0){posicion++;}}

    \)                       {if(posicion!=0){posicion--;operar(lista,"*");} }

    [\;]                      {System.out.println((Integer) lista.remove());}

    [^]                     {}

}


<OPERANDO>{

    {numeros}               {lista.add(Integer.valueOf(yytext()));operar(lista,operador);yybegin(YYINITIAL);}

    [^]                     {}

}


