import java.util.Vector;

public class TInt extends Tipo {
    private static TInt instancia = new TInt();
    
    private TInt() {
        super("int", 0);
    }

    public static TInt getInstancia() {
        return instancia;
    }

    public Objeto metodos(String m, Vector<Objeto> p) {
        //ERROR
        return null;
    }

    public Objeto metodosInstancia(Objeto o, String m, Vector<Objeto> p) {
        if (!(o instanceof Instancia)) {
            //ERROR
        }
        if (((Instancia) o).getTipo() != instancia) {
            //ERROR
        }
        if (m.equals("asigna")) {
            if (p.size() != 1) {
                //ERROR
            }
            if (!(p.firstElement() instanceof Instancia)) {
                //ERROR
            }
            if ((((Instancia) p.firstElement())).getTipo() != instancia) {
                //ERROR
            }
            if (!o.isMutable()) {
                //ERROR
            }
            PLC.out.println(o.getNombreB() + "=" + p.firstElement().getNombreB() + ";");
            return o;
        }
        if (m.equals("suma")) {
            if (/*TODO*/) {
                //ERROR
            }
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLC.out.println(nObj.getNombreB() + "=" + o.getNombreB() + "+" + p.firstElement().getNombreB() + ";");
            return nObj;
        }
    }
}
