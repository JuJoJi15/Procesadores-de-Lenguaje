import java.util.Vector;

public class TBool extends Tipo {
    private static TBool instancia = new TBool();

    private TBool() {
        super("boolean",0);
        //TODO Auto-generated constructor stub
    }

    public static TBool getInstancia() {
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
        if(m.equals("asigna")){

            
            if (!o.isMutable()) {
                TablaSimbolos.Error();
            }
            String L2 = TablaSimbolos.newEtiq();
            PLXC.out.println(o.sv+":");
            PLXC.out.println(o.getNombre() + "= 1;");
            PLXC.out.println ("goto "+L2+";");
            PLXC.out.println(o.sf+":");
            PLXC.out.println(o.getNombre() + "= 0;");
            PLXC.out.println (L2+":");
        }
        if(m.equals("asignaExp")){
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
                String L3 = TablaSimbolos.newEtiq();
                String L4 = TablaSimbolos.newEtiq();
                String L5 = TablaSimbolos.newEtiq();
                PLXC.out.println("if(0 < "+p.firstElement().getNombre()+") goto "+L3+";");
                PLXC.out.println("goto "+L4+";");
                PLXC.out.println(L3+":");
                PLXC.out.println(o.getNombre()+" = 1;");
                PLXC.out.println("goto "+L5+";");
                PLXC.out.println(L4+":");
                PLXC.out.println(o.getNombre()+" = 0;");
                PLXC.out.println(L5+":");
            }
            
        }
        return null;
    }
    
}
