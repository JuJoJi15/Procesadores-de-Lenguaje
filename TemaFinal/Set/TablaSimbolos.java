
import java.util.*;

public class TablaSimbolos {
    
    private Map<String, Objeto> tabla;
    private static Map<String, Integer> tablaT;
    public static int bActual = 0;
    private static int nEtiq = 0;
    public static String newEtiq(){
        String res = "L"+nEtiq;
        nEtiq++;
        return res;
    }
    public static void Error(){
        PLXC.out.println("error;");
        PLXC.out.println("halt;");
    }
    public static void newBloque(){
        bActual++;
    }
    public TablaSimbolos(){
        tabla = new HashMap<String,Objeto>();
        tablaT = new HashMap<String,Integer>();
    }

    // Comprueba si tiene el objeto con nombre n en cualquier bloque
    public boolean contiene (String n){      
        return tabla.containsKey(n);
    } 

    public Objeto objeto(String n){
        return tabla.get(n);
    }

    // Añade objeto a la tabla de simbolos
    public void addObj(Objeto o){
        tabla.put(o.getNombre(),o);
    } 

    // Borra objeto o de la tabla de simbolos
    public void borrarObj(Objeto o){
        tabla.remove(o.getNombre());
    } 

    public void borrarBloque(){
        for(Objeto o : tabla.values()){
            if(o.getBloque() == bActual){
                borrarObj(o);
            }
        }
        bActual--;
    }
    public static void addTam(Objeto o, int t){
        tablaT.put(o.getNombre(), t);
    }

    public static String getTam(Objeto o){
        return String.valueOf(tablaT.get(o.getNombre()));
    }



     /*  Comprueba si el bloque b contiene el obj n
    public boolean contiene (String n, int b){
        if(tabla.containsKey(n)){
            return tabla.get(n).containsKey(b);
        }
        return false;
    } */

    /*Devuelve le numero del mayor bloque donde este la variable
    public int mayorBloque (String n){
        int mayor = -1;
        for(Integer i : tabla.get(n).keySet()){
            if(i>mayor){
                mayor = i;
            }
        }
        return mayor;
    } */

    /*Devuelve objeto de bloque mas grande
    public Objeto objeto(String n){
        return tabla.get(n).get(mayorBloque(n));
    } */

    /*  Devuelve objeto n en bloque b
    public Objeto objeto(String n,int b){
        return tabla.get(n).get(b);
    } */

    
}
