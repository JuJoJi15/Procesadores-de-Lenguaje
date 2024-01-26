import java.util.Vector;

public class Instancia extends Objeto {
    private Tipo tipo;

    public Instancia(String n, Tipo t, int b, boolean mut) {
        super(n,b,mut); 
        tipo = t;   
    }
    
    public Tipo getTipo() {
        return tipo;
    }

    public Objeto metodos(String m, Vector<Objeto> p) {
        return tipo.metodosInstancia(this, m, p);
    }
}