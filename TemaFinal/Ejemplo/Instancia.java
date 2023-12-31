package TemaFinal.Ejemplo;

public class Instancia extends Object {
    private Tipo tipo;

    public Instancia(String n,Tipo t, int b, boolean mut){
        tipo = t;
        super(n,b,mut);
    }
    public Tipo getTipo(){return tipo;}
    public Object metodos(String m,Vector<Objeto> p){
        tipo.metodosInstancia(this, m,p);
    }
    
}
