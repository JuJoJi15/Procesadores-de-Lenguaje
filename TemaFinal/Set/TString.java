import java.util.Vector;

public class TString extends Tipo {
    private static TString instancia = new TString();
    public int tam;
    
    private TString() {
        super("string", 0);
    }

    public static TString getInstancia() {
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
            if ((((Instancia) p.firstElement())).getTipo() != TString.getInstancia()) {
                TablaSimbolos.Error();
            }
            if (!o.isMutable()) {
                TablaSimbolos.Error();
            }
            if((((Instancia) p.firstElement())).getTipo() == TString.getInstancia()){
                if((((Instancia) p.firstElement())).getNombre().charAt(0)=='"'){
                int i = 0;
                boolean primer = false;
                String s = p.firstElement().getNombre().substring(1, p.firstElement().getNombre().length()-1);
                for(char c : s.toCharArray()){
                if(c != '\\' || primer == true){
                    PLXC.out.println(o.getNombre()+"["+i+"]= "+Integer.valueOf(c)+";");
                    primer = false;
                    i++;
                }else{
                    primer = true;
                }
                TablaSimbolos.addTam(o, p.firstElement().getNombre().length()-2);
            }
            }else{
                String s = Objeto.newNumObj();
                for(int i = 0;i<Integer.valueOf(TablaSimbolos.getTam((((Instancia) p.firstElement()))));i++){
                    PLXC.out.println(s+"= "+(((Instancia) p.firstElement())).getNombre()+"["+i+"];");
                    PLXC.out.println(o.getNombre()+"["+i+"]= "+s+";");
                }
                TablaSimbolos.addTam(o,Integer.valueOf(TablaSimbolos.getTam((((Instancia) p.firstElement())))));
            }
            }
            
            return p.firstElement();
        }if(m.equals("print")){
            boolean primer = false;
            if(o.getNombre().charAt(0)=='"'){
            String s = o.getNombre().substring(1, o.getNombre().length()-1);
            for(char c : s.toCharArray()){
                if(c != '\\' || primer == true){
                    PLXC.out.println("writec "+Integer.valueOf(c)+";");
                    primer = false;
                }else{
                    primer = true;
                }
            }
            PLXC.out.println("writec 10;");
        }else{
            String obj = Objeto.newNumObj();
            for(int i = 0;i<Integer.parseInt(TablaSimbolos.getTam(o));i++){
                PLXC.out.println(obj+" = "+o.getNombre()+"["+i+"];");
                PLXC.out.println("writec "+obj+";");
            }
            PLXC.out.println("writec 10;");
        }
        }
        return null;    
    }
}
