package TemaFinal.Ejemplo;

import java.util.*;

public class TablaSimbolos {
    
    private Map<String, TreeMap<Integer,Objeto>> tabla;
    public static int bActual = 0;
    private static int numEt = 0;
    public static String newEtiq(){

    }

    public static int contBloque = 0;
    public static int newBloque(){
        int ba = bActual;
        contBloque++;
        bActual = contBloque;
        return ba;
    }
    public TablaSimbolos(){
        tabla = new HashMap<String,TreeMap<Integer,Objeto>>();
    }
    public boolean contiene (String n){} // Comprueba si tiene el bloque con nombre n en cualquier bloque
    public boolean contiene (String n, int b){} // Comprueba si el bloque b contiene el obj n
    public int mayorBloque (String n){}//Devuelve le numero del mayor bloque donde este la variable
    public Objeto objeto(String n){} //Devuelve objeto de bloque mas grande
    public Objeto objeto(String n,int b){} // Devuelve objeto n en bloque b
    public void addObj(Objeto o){} // Añade objeto a la tabla de simbolos
    public void borrarObj(Objeto o){} // Borra objeto o de la tabla de simbolos
}
