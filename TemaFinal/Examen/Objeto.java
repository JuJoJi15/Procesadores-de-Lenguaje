import java.util.Vector;

public abstract class Objeto implements Comparable<Objeto> {
    private String nombre;
    private int bloque;
    private boolean mutable;
    private static int numObj = 0;
    public String sv,sf;

    public static String newNumObj() {
        String res = "t"+numObj;
        numObj++;
        return res;    
    }

    public Objeto (String n, int b, boolean mut) {
        nombre = n;
        bloque = b;
        mutable = mut;    
    }

    public String getNombre() {
        return nombre;
    }

    public int getBloque() {
        return bloque;
    }

    public boolean isMutable() {
        return mutable;
    }

    public String getNombreB() {
        return nombre+bloque;
    }

    public void setCond(String v, String f){
        sv = v;
        sf = f;
    }

    @Override
    public boolean equals(Object obj) {
        Objeto o = (Objeto) obj;
        return o.getNombre().equals(this.getNombre()) && o.getBloque() == this.getBloque();    
    }

    public int compareTo(Objeto c) {
        if (this.getNombre().compareTo(c.getNombre()) < 0) {
            return -1;
        }
        if (this.getNombre().compareTo(c.getNombre()) > 0) {
            return 1;
        }
        if (this.getBloque() < c.getBloque()) {
            return -1;
        }
        if (this.getBloque() > c.getBloque()) {
            return 1;
        }
        return 0;
    }

    public abstract Objeto metodos(String o, Vector<Objeto> p);
}
