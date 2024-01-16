import java.util.Vector;

public class TMFloat extends Tipo {
    private static TMFloat instancia = new TMFloat();
    public int tam;
    
    private TMFloat() {
        super("mfloat", 0);
    }

    public static TMFloat getInstancia() {
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
        if (m.equals("asignaInd")) {
            if (p.size() != 2) {
                TablaSimbolos.Error();
            }
            
            if (!(p.firstElement() instanceof Instancia)) {
                TablaSimbolos.Error();
            }
            if ((((Instancia) p.firstElement())).getTipo() != TFloat.getInstancia()) {
                TablaSimbolos.Error();
            }
            if (!o.isMutable()) {
                TablaSimbolos.Error();
            }
            if((((Instancia) p.firstElement())).getTipo() == TFloat.getInstancia()){
                PLXC.out.println(o.getNombre()+"["+p.lastElement().getNombre()+ "]=" + p.firstElement().getNombre() + ";");
            }
            
            return p.firstElement();
        }if (m.equals("asigna")) {
            if (p.size() != 1) {
                TablaSimbolos.Error();
            }
            
            if (!(p.firstElement() instanceof Instancia)) {
                TablaSimbolos.Error();
            }
            if ((((Instancia) p.firstElement())).getTipo() != TMFloat.getInstancia()) {
                TablaSimbolos.Error();
            }
            if (!o.isMutable()) {
                TablaSimbolos.Error();
            }
            if((((Instancia) p.firstElement())).getTipo() == TMFloat.getInstancia()){
                PLXC.out.println(o.getNombre()+ "=" + p.firstElement().getNombre() + ";");
            }
            
            return p.firstElement();
        }if(m.equals("obtener")){
            if(p.size() != 1){
                TablaSimbolos.Error();
            }
            Objeto nObj = new Instancia(Objeto.newNumObj(), TFloat.getInstancia(), TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre()+"=" + o.getNombre() + "["+p.firstElement().getNombre()+"];");
            return nObj;
        }
        return null;
    }
}
