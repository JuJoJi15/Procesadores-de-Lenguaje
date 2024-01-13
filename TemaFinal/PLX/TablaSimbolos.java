
import java.util.*;

public class TablaSimbolos {
    
    private Map<String, TreeMap<Integer,Objeto>> tabla;
    public static int bActual = 0;
    private static int nEtiq = 0;
    public String newEtiq(){
        String res = "L"+nEtiq;
        nEtiq++;
        return res;
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

    // Comprueba si tiene el objeto con nombre n en cualquier bloque
    public boolean contiene (String n){      
        return tabla.containsKey(n);
    } 

     // Comprueba si el bloque b contiene el obj n
    public boolean contiene (String n, int b){
        if(tabla.containsKey(n)){
            return tabla.get(n).containsKey(b);
        }
        return false;
    }

    //Devuelve le numero del mayor bloque donde este la variable
    public int mayorBloque (String n){
        int mayor = -1;
        for(Integer i : tabla.get(n).keySet()){
            if(i>mayor){
                mayor = i;
            }
        }
        return mayor;
    }

    //Devuelve objeto de bloque mas grande
    public Objeto objeto(String n){
        return tabla.get(n).get(mayorBloque(n));
    } 

    // Devuelve objeto n en bloque b
    public Objeto objeto(String n,int b){
        return tabla.get(n).get(b);
    } 

    // Añade objeto a la tabla de simbolos
    public void addObj(Objeto o){
        if(!contiene(o.getNombre())){
            TreeMap<Integer,Objeto> tm = new TreeMap<Integer,Objeto>();
            tm.put(bActual,o);
            tabla.put(o.getNombre(),tm);
        }else{
            TreeMap<Integer,Objeto> tm = tabla.get(o.getNombre());
            tm.put(bActual,o);
            tabla.put(o.getNombre(),tm);
        }
    } 

    // Borra objeto o de la tabla de simbolos
    public void borrarObj(Objeto o){ // Cuando se borra?
        TreeMap<Integer,Objeto> tm = tabla.get(o.getNombre());
        tm.remove(o.getBloque());
        if(tm.isEmpty()){
            tabla.remove(o.getNombre());
        }else{
            tabla.put(o.getNombre(), tm);
        }

    } 
}
