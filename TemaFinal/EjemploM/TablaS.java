public abstract class Objeto implements Comparable<Objeto> {
    private String nombre;
    private int bloque;
    private boolean mutable;
    private static int numObj = 0;

    public static String newNumObj() {
        //TODO    
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
        //TODO
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
}

public class Instancia extends Objeto {
    private Tipo tipo;

    public Instancia(string n, Tipo t, int b, boolean mut) {
        //TODO    
    }
    
    public Tipo getTipo() {
        return tipo;
    }

    public Objeto metodos(String m, Vector<Objeto> p) {
        return tipo.metodosInstancia(this, m, p):
    }
}

public abstract class Tipo extends Objeto {
    public Tipo(String n, int b) {
        super(n, b, false);
    }

    public abstract Objeto metodosInstancia(Objeto o, String m, Vector<Objeto> p);
}

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
            if ((((Instancia) p).firstElement()).getTipo != instancia) {
                //ERROR
            }
            if (!o.isMutable()) {
                //ERROR
            }
            PLC.out.println(o.getNombreB + "=" + p.firstElement().getNombreB() + ";");
            return o;
        }
        if (m.equals("suma")) {
            if (//TODO) {
                //ERROR
            }
            Objeto nObj = new Instancia(Objeto.newNomObj(), instancia, bActual, false);
            PLC.out.println(nObj.getNombreB() + "=" + o.getNombreB() + "+" + p.firstElement().getNombreB() + ";");
            return nObj;
        }
    }
}

public class TablaS {
    private Map<String, TreeMap<Integer, Objeto>> tabla;
    public static int bActual = 0;
    private static int numEt = 0;
    public static String newEtiq() {
        //TODO
    }
    private static int contBloque = 0;

    public static int newBloque() {
        int ba = bActual;
        contBloque++;
        bActual = contBloque;
        return ba;
    }

    public TablaS() {
        tabla = new HashMap<>();
    }

    public boolean contiene(String n) {
        //TODO    
    }

    public boolean contieneB(String n, int b) {
        //TODO
    }

    public int mayorBloque(String n) {
        //TODO
    }

    public Objeto objeto(String n) {
        //TODO
    }

    public Objeto objetoB(String n, int b) {
        //TODO
    }

    public void addObj(Objeto o) {
        //TODO    
    }

    public void borrarBloque(int b) {
        //TODO
    }
}
