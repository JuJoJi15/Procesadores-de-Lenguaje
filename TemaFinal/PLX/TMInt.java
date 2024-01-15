import java.util.Vector;

public class TMInt extends Tipo {
    private static TMInt instancia = new TMInt();
    public int tam;
    
    private TMInt() {
        super("mint", 0);
    }

    public static TMInt getInstancia() {
        return instancia;
    }

    public Objeto metodos(String m, Vector<Objeto> p) {
        TablaSimbolos.Error();
        return null;
    }

    public Objeto metodosInstancia(Objeto o, String m, Vector<Objeto> p) {
        if (!(o instanceof Instancia)) {
            TablaSimbolos.Error();
        }
        if (((Instancia) o).getTipo() != instancia) {
            TablaSimbolos.Error();
        }
        if (m.equals("asigna")) {
            if (p.size() != 2) {
                TablaSimbolos.Error();
            }
            
            if (!(p.firstElement() instanceof Instancia)) {
                TablaSimbolos.Error();
            }
            if ((((Instancia) p.firstElement())).getTipo() != TInt.getInstancia()) {
                TablaSimbolos.Error();
            }
            if (!o.isMutable()) {
                TablaSimbolos.Error();
            }
            if((((Instancia) p.firstElement())).getTipo() == TInt.getInstancia()){
                PLXC.out.println(o.getNombre()+"["+p.lastElement().getNombre()+ "]=" + p.firstElement().getNombre() + ";");
            }
            return p.firstElement();
        }if(m.equals("obtener")){
            if(p.size() != 1){
                TablaSimbolos.Error();
            }
            Objeto nObj = new Instancia(Objeto.newNumObj(), TInt.getInstancia(), TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre()+"=" + o.getNombre() + "["+p.firstElement().getNombre()+"];");
            return nObj;
        }
        TablaSimbolos.Error();
        return null;
    }
}
