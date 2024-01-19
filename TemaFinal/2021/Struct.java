import java.util.ArrayList;
import java.util.Vector;

public class Struct extends Tipo {

    private static Struct instancia = new Struct();
    private static ArrayList<Objeto> list = new ArrayList<Objeto>();

    public static Struct getInstancia(){
        return instancia;
    }

    public static ArrayList<Objeto> getList(){
        return list;
    }

    public Struct() {
        super("struct", 0);
        //TODO Auto-generated constructor stub
    }

    public Objeto metodos(String m, Vector<Objeto> p) {
        TablaSimbolos.Error();
        return null;
    }
    public Objeto metodosInstancia(Objeto o, String m, Vector<Objeto> p) {
        if(m.equals("add")){
            for(Objeto o2 : p){
                list.add(o2);
            }
        }
        return null;
    }
    
}
