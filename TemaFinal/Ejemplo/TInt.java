package TemaFinal.Ejemplo;


public class TInt extends Tipo {


    private static TInt instancia = new TInt();
    private TInt(){
        super("int",0);
    }    
    public stattic TInt getInstancia(){
        return instancia;
    }
    public Objeto metodo(String m, Vector<Objeto> p){
        ErrorYPar();
        return null;
    }
    public Object metodosInstancia(Object o,String m,Vector<Objeto> p){
        if(!(o.instanceOf(Instancia))){
            ErrorYPar();
        }
        if(((Instancia) o).getTipo() != instancia){
            ErrorYPar();
        }
        if(m.equals("asignar")){
            if(p.size()!=1){
                ErrorYPar;
            }
            if(!p.firstElement().instanceof(Instancia)){
                ErrorYPar();
            }
            if(((Instancia) p.firstElement()).getTipo != instancia){
                ErrorYPar();
            }
        }
        if(!((Instancia) o).getMutable()){
            ErrorYPar();
        }
        PLC.out.println(o.getNonbreBloque +"="+p.firstElement(),getNombreBloque+";");
        return o;

    }
}
