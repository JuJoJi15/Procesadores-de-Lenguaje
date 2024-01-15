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
            if ((((Instancia) p.firstElement())).getTipo() != instancia && (((Instancia) p.firstElement())).getTipo() != TChar.getInstancia()) {
                TablaSimbolos.Error();
            }
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre() + "=" + o.getNombre() + "+" + p.firstElement().getNombre() + ";");
            return nObj;
        }if (m.equals("resta")) {
            if (p.size() != 1) {
                TablaSimbolos.Error();
            }
            if (!(p.firstElement() instanceof Instancia)) {
                TablaSimbolos.Error();
            }
            if ((((Instancia) p.firstElement())).getTipo() != instancia && (((Instancia) p.firstElement())).getTipo() != TChar.getInstancia()) {
                TablaSimbolos.Error();
            }
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre() + "=" + o.getNombre() + "-" + p.firstElement().getNombre() + ";");
            return nObj;
        }if (m.equals("multiplicar")) {
            
            if (p.size() != 1) {
                TablaSimbolos.Error();
            }
            if (!(p.firstElement() instanceof Instancia)) {
                TablaSimbolos.Error();
            }
            if ((((Instancia) p.firstElement())).getTipo() != instancia) {
                TablaSimbolos.Error();
            }
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre() + "=" + o.getNombre() + "*" + p.firstElement().getNombre() + ";");
            return nObj;
        }if (m.equals("dividir")) {
            
            if (p.size() != 1) {
                TablaSimbolos.Error();
            }
            if (!(p.firstElement() instanceof Instancia)) {
                TablaSimbolos.Error();
            }
            if ((((Instancia) p.firstElement())).getTipo() != instancia) {
                TablaSimbolos.Error();
            }
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre() + "=" + o.getNombre() + "/" + p.firstElement().getNombre() + ";");
            return nObj;
        }if (m.equals("menosUnario")) {
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre() + "= 0 - " + o.getNombre() + ";");
            return nObj;
        }if (m.equals("print")) {
            PLXC.out.println("print "+o.getNombre()+";");
        }if (m.equals("convertir")) {
            if (p.size() != 1) {
                TablaSimbolos.Error();
            }
            if (!(p.firstElement() instanceof Tipo)) {
                TablaSimbolos.Error();
            }
            if ((((Tipo) p.firstElement())) != TFloat.getInstancia() && (((Tipo) p.firstElement())) != TChar.getInstancia() && (((Tipo) p.firstElement())) != TInt.getInstancia()) {
                TablaSimbolos.Error();
            }
            Objeto nObj = null;
            if((((Tipo) p.firstElement())) == TFloat.getInstancia()){
                 nObj = new Instancia(Objeto.newNumObj(),(Tipo) p.firstElement(), TablaSimbolos.bActual, false);
                PLXC.out.println(nObj.getNombre() + "= (float) " + o.getNombre() + ";");
            }else if((((Tipo) p.firstElement())) == TChar.getInstancia()){
                 nObj = new Instancia(o.getNombre(),(Tipo) p.firstElement(), TablaSimbolos.bActual, false);
            }else if((((Tipo) p.firstElement())) == TInt.getInstancia()){
                return o;
            }
            return nObj;
        }
        return null;
    }
}
