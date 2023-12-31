package TemaFinal.Ejemplo;

public abstract class Tipo extends Object {
    public Tipo(String n, int b){
        super(n,b,false);
    }   
    public abstract Objeto metodosInstancia(Objeto o,String m,Vector<Objeto>);

}
