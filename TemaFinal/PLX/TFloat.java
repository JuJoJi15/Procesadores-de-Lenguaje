import java.util.Vector;

public class TFloat extends Tipo {
    private static TFloat instancia = new TFloat();
    
    private TFloat() {
        super("float", 0);
    }

    public static TFloat getInstancia() {
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
            if ((((Instancia) p.firstElement())).getTipo() != instancia && (((Instancia) p.firstElement())).getTipo() != TInt.getInstancia()) {
                TablaSimbolos.Error();
            }
            if (!o.isMutable()) {
                TablaSimbolos.Error();
            }
            if((((Instancia) p.firstElement())).getTipo() == instancia){
                PLXC.out.println(o.getNombre() + "=" + p.firstElement().getNombre() + ";");
            }else{
                PLXC.out.println(o.getNombre() + "= (float) " + p.firstElement().getNombre() + ";");
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
            p = convExp(p);
            if ((((Instancia) p.firstElement())).getTipo() != instancia) {
                TablaSimbolos.Error();
            }
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre() + "=" + o.getNombre() + " +r " + p.firstElement().getNombre() + ";");
            return nObj;
        }if (m.equals("resta")) {
            if (p.size() != 1) {
                TablaSimbolos.Error();
            }
            if (!(p.firstElement() instanceof Instancia)) {
                TablaSimbolos.Error();
            }
            p = convExp(p);
            if ((((Instancia) p.firstElement())).getTipo() != instancia) {
                TablaSimbolos.Error();
            }
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre() + "=" + o.getNombre() + " -r " + p.firstElement().getNombre() + ";");
            return nObj;
        }if (m.equals("multiplicar")) {
            if (p.size() != 1) {
                TablaSimbolos.Error();
            }
            if (!(p.firstElement() instanceof Instancia)) {
                TablaSimbolos.Error();
            }
            p = convExp(p);
            if ((((Instancia) p.firstElement())).getTipo() != instancia) {
                TablaSimbolos.Error();
            }
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre() + "=" + o.getNombre() + " *r " + p.firstElement().getNombre() + ";");
            return nObj;
        }if (m.equals("dividir")) {
            if (p.size() != 1) {
                TablaSimbolos.Error();
            }
            if (!(p.firstElement() instanceof Instancia)) {
                TablaSimbolos.Error();
            }
            p = convExp(p);
            if ((((Instancia) p.firstElement())).getTipo() != instancia) {
                TablaSimbolos.Error();
            }
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre() + "=" + o.getNombre() + " /r " + p.firstElement().getNombre() + ";");
            return nObj;
        }if (m.equals("menosUnario")) {
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre() + "= 0 -r " + o.getNombre() + ";");
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
            if ((((Tipo) p.firstElement())) != TInt.getInstancia()) {
                TablaSimbolos.Error();
            }
            Objeto nObj = new Instancia(Objeto.newNumObj(),(Tipo) p.firstElement(), TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre() + "= (int) " + o.getNombre() + ";");
            return nObj;
        }
        return null;
    }

    private Vector<Objeto> convExp(Vector<Objeto> p){
        Vector<Objeto> res = new Vector<Objeto>();
        for(Objeto o : p){
            if((o instanceof Instancia)){
           
            if((((Instancia) o).getTipo() == TInt.getInstancia())){
                Vector<Objeto> aux = new Vector<Objeto>();
                aux.add(instancia);
                res.add(((Instancia) o).metodos("convertir", aux));     
            }else{
                res.add(o);
            }
        }
        }
        TablaSimbolos.Error();
        return res;
    }
}
