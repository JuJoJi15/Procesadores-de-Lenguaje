import java.util.Vector;

public abstract class Objeto implements Comparable<Objeto>{
    private String nombre;
    private int bloque;
    private boolean mutable;
    private static int numObjeto = 0;
    public static String newNumObjeto(){}
    public Objeto(String n,int b, boolean m){

    }
    public String getNombre(){}
    public int getBloque(){}
    public boolean getMutable(){}
    public String getNombreBloque(){}
    @Override
    public boolean equals(Object obj){
        Objeto b = (Objeto) obj;
        return b.getNombre().equals(this.getNombre()) && b.getBloque() == this.getBloque();
    }

    @Override
    public int compareTo(Object obj){
        Objeto b = (Objeto) obj;
        if(this.getNombre().compareTo(b.getNombre())<0){
            return -1;
        }
        if(this.getNombre().compareTo(b.getNombre())<0){
            return 1;
        }
        if(this.getBloque()<b.getBloque()){
            return -1;
        }
        if(this.getBloque()>b.getBloque()){
            return 1;
        }
    }

    public  Object metodos(String m,Vector<Object> p);
    public void errorYPara(String mensaje,Vector<Object> p){}
}