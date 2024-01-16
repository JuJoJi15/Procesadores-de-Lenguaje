import java.util.Vector;

public class TMChar extends Tipo {
    private static TMChar instancia = new TMChar();
    public int tam;
    
    private TMChar() {
        super("mchar", 0);
    }

    public static TMChar getInstancia() {
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
            if ((((Instancia) p.firstElement())).getTipo() != TChar.getInstancia()) {
                TablaSimbolos.Error();
            }
            if (!o.isMutable()) {
                TablaSimbolos.Error();
            }
            if((((Instancia) p.firstElement())).getTipo() == TChar.getInstancia()){
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
            if ((((Instancia) p.firstElement())).getTipo() != TMChar.getInstancia()) {
                TablaSimbolos.Error();
            }
            if (!o.isMutable()) {
                TablaSimbolos.Error();
            }
            if((((Instancia) p.firstElement())).getTipo() == TMChar.getInstancia()){
                PLXC.out.println(o.getNombre()+ "=" + p.firstElement().getNombre() + ";");
            }
            
            return p.firstElement();
        }if(m.equals("obtener")){
            if(p.size() != 1){
                TablaSimbolos.Error();
            }
            Objeto nObj = new Instancia(Objeto.newNumObj(), TChar.getInstancia(), TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre()+"=" + o.getNombre() + "["+p.firstElement().getNombre()+"];");
            return nObj;
        }
        return null;
    }
}
