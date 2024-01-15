import java.util.Vector;

public class TChar extends Tipo {
    private static TChar instancia = new TChar();
    
    private TChar() {
        super("char", 0);
    }

    public static TChar getInstancia() {
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
            if (p.size() != 1) {
                TablaSimbolos.Error();
            }
            if (!(p.firstElement() instanceof Instancia)) {
                TablaSimbolos.Error();
            }
            if ((((Instancia) p.firstElement())).getTipo() != instancia) {
                TablaSimbolos.Error();
            }
            if (!o.isMutable()) {
                TablaSimbolos.Error();
            }
            if((((Instancia) p.firstElement())).getTipo() == instancia){
                PLXC.out.println(o.getNombre() + "=" + p.firstElement().getNombre() + ";");
            }
            return p.firstElement();
        }
        if (m.equals("suma")) {
            if (p.size() != 1) {
                TablaSimbolos.Error();
            }
            if (!(p.firstElement() instanceof Instancia)) {
                TablaSimbolos.Error();
            }
            if ((((Instancia) p.firstElement())).getTipo() != instancia) {
                TablaSimbolos.Error();
            }
            Objeto nObj = new Instancia(Objeto.newNumObj(), TInt.getInstancia(), TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre() + "=" + o.getNombre() + "+" + p.firstElement().getNombre() + ";");
            return nObj;
        }if (m.equals("resta")) {
            if (p.size() != 1) {
                TablaSimbolos.Error();
            }
            if (!(p.firstElement() instanceof Instancia)) {
                TablaSimbolos.Error();
            }
            if ((((Instancia) p.firstElement())).getTipo() != instancia && (((Instancia) p.firstElement())).getTipo() != TInt.getInstancia()) {
                TablaSimbolos.Error();
            }
            Objeto nObj = new Instancia(Objeto.newNumObj(), TInt.getInstancia(), TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre() + "=" + o.getNombre() + "-" + p.firstElement().getNombre() + ";");
            return nObj;
        }if (m.equals("print")) {
            PLXC.out.println("printc "+o.getNombre()+";");
        }if (m.equals("convertir")) {
            if (p.size() != 1) {
                TablaSimbolos.Error();
            }
            if (!(p.firstElement() instanceof Tipo)) {
                TablaSimbolos.Error();
            }
            if ((((Tipo) p.firstElement())) != TInt.getInstancia()) {
                TablaSimbolos.Error();
            }
            Objeto nObj = new Instancia(o.getNombre(),(Tipo) p.firstElement(), TablaSimbolos.bActual, false);
            return nObj;
        }
        TablaSimbolos.Error();
        return null;
    }
}
