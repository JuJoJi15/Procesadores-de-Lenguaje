import java.util.Vector;

public class TSet extends Tipo {
    private static TSet instancia = new TSet();
    public TSet() {
        super("set", 0);
    }
    public static TSet getInstancia(){
        return instancia;
    }
    public Objeto metodos(String m, Vector<Objeto> p) {
        TablaSimbolos.Error();
        return null;
    }
    @Override
    public Objeto metodosInstancia(Objeto o, String m, Vector<Objeto> p) {
        if (!(o instanceof Instancia)) {
            TablaSimbolos.Error();
        }
        if (((Instancia) o).getTipo() != instancia) {
            TablaSimbolos.Error();
        }
        if (m.equals("asigna")) {

            Objeto t0 = new Instancia(Objeto.newNumObj(),TMInt.getInstancia(),TablaSimbolos.bActual,false); //T0
            Objeto t1 = new Instancia(Objeto.newNumObj(),TMInt.getInstancia(),TablaSimbolos.bActual,false); //T0
            Objeto t2 = new Instancia(Objeto.newNumObj(),TMInt.getInstancia(),TablaSimbolos.bActual,false); //T0
            Objeto t3 = new Instancia(Objeto.newNumObj(),TMInt.getInstancia(),TablaSimbolos.bActual,false); //T0
            Objeto t4 = new Instancia(Objeto.newNumObj(),TMInt.getInstancia(),TablaSimbolos.bActual,false); //T0
            
            String L0 = TablaSimbolos.newEtiq();
            String L1 = TablaSimbolos.newEtiq();
            String L2 = TablaSimbolos.newEtiq();
            String L3 = TablaSimbolos.newEtiq();
            String L4 = TablaSimbolos.newEtiq();
            String L5 = TablaSimbolos.newEtiq();
            
            int pos = 0;
            for(Objeto v : p){
                PLXC.out.println("$"+t0.getNombre()+"["+pos+"]="+v.getNombre()+";");
                pos++;
            }
            PLXC.out.println("# asignar array c <- $t0\r\n" + //
                    "   $"+o.getNombre()+"_length = 0;\r\n" + //
                    "   $"+t1.getNombre()+" = 0;\r\n" + //
                    L0+":\r\n" + //
                    "   if ($"+t1.getNombre()+" < "+p.size()+") goto "+L1+";\r\n" + //
                    "   goto "+L2+";\r\n" + //
                    ""+L1+":\r\n" + //
                    "   $"+t2.getNombre()+" = $"+t0.getNombre()+"[$"+t1.getNombre()+"];\r\n" + //
                    "   $"+t3.getNombre()+" = 0;\r\n" + //
                    ""+L3+":\r\n" + //
                    "   if ($"+t3.getNombre()+" == $"+o.getNombre()+"_length) goto "+L4+";\r\n" + //
                    "   $"+t4.getNombre()+" = "+o.getNombre()+"[$"+t3.getNombre()+"];\r\n" + //
                    "   if ($"+t4.getNombre()+" == $"+t2.getNombre()+") goto "+L5+";\r\n" + //
                    "   $"+t3.getNombre()+" = $"+t3.getNombre()+" + 1;\r\n" + //
                    "   goto "+L3+";\r\n" + //
                    ""+L4+":\r\n" + //
                    "   "+o.getNombre()+"[$"+o.getNombre()+"_length] = $"+t2.getNombre()+";\r\n" + //
                    "   $"+o.getNombre()+"_length = $"+o.getNombre()+"_length + 1;\r\n" + //
                    ""+L5+":\r\n" + //
                    "   $"+t1.getNombre()+" = $"+t1.getNombre()+" + 1;\r\n" + //
                    "   goto "+L0+";\r\n" + //
                    ""+L2+":\r\n"  //
                    );
        }
        if(m.equals("print")){
            String L6 = TablaSimbolos.newEtiq();
            String L7 = TablaSimbolos.newEtiq();
            String L8 = TablaSimbolos.newEtiq();
            Objeto t5 = new Instancia(Objeto.newNumObj(),TMInt.getInstancia(),TablaSimbolos.bActual,false); //T0
            Objeto t6 = new Instancia(Objeto.newNumObj(),TMInt.getInstancia(),TablaSimbolos.bActual,false); //T0


            PLXC.out.println("   $"+t5.getNombre()+" = 0;\r\n" + //
            ""+L6+":\r\n" + //
            "   if ($"+t5.getNombre()+" < $"+o.getNombre()+"_length) goto "+L7+";\r\n" + //
            "   goto "+L8+";\r\n" + //
            ""+L7+":\r\n" + //
            "   $"+t6.getNombre()+" = "+o.getNombre()+"[$"+t5.getNombre()+"];\r\n" + //
            "   write $"+t6.getNombre()+";\r\n" + //
            "   writec 32;\r\n" + //
            "   $"+t5.getNombre()+" = $"+t5.getNombre()+" + 1;\r\n" + //
            "   goto "+L6+";\r\n" + //
            ""+L8+":\r\n" + //
            "   writec 10;");

        }
        if(m.equals("asignaS")){
            PLXC.out.println("$"+o.getNombre()+"_length = $"+p.firstElement().getNombre()+"_length;\r\n" + //
                    "   "+o.getNombre()+" = "+p.firstElement().getNombre()+";");
        }if(m.equals("asignaA")){
            Objeto t0 = new Instancia(Objeto.newNumObj(),TMInt.getInstancia(),TablaSimbolos.bActual,false); //T0
            Objeto t1 = new Instancia(Objeto.newNumObj(),TMInt.getInstancia(),TablaSimbolos.bActual,false); //T0
            Objeto t2 = new Instancia(Objeto.newNumObj(),TMInt.getInstancia(),TablaSimbolos.bActual,false); //T0
            Objeto t3 = new Instancia(Objeto.newNumObj(),TMInt.getInstancia(),TablaSimbolos.bActual,false); //T0
            
            String L0 = TablaSimbolos.newEtiq();
            String L1 = TablaSimbolos.newEtiq();
            String L2 = TablaSimbolos.newEtiq();
            String L3 = TablaSimbolos.newEtiq();
            String L4 = TablaSimbolos.newEtiq();
            String L5 = TablaSimbolos.newEtiq();

            PLXC.out.println("# asignar array c <- a\r\n" + //
                    "   $"+o.getNombre()+"_length = 0;\r\n" + //
                    "   $"+t0.getNombre()+" = 0;\r\n" + //
                    ""+L0+":\r\n" + //
                    "   if ($"+t0.getNombre()+" < "+TablaSimbolos.getTam(p.firstElement())+") goto "+L1+";\r\n" + //
                    "   goto "+L2+";\r\n" + //
                    ""+L1+":\r\n" + //
                    "   $"+t1.getNombre()+" = "+p.firstElement().getNombre()+"[$"+t0.getNombre()+"];\r\n" + //
                    "   $"+t2.getNombre()+" = 0;\r\n" + //
                    ""+L3+":\r\n" + //
                    "   if ($"+t2.getNombre()+" == $"+o.getNombre()+"_length) goto "+L4+";\r\n" + //
                    "   $"+t3.getNombre()+" = "+o.getNombre()+"[$"+t2.getNombre()+"];\r\n" + //
                    "   if ($"+t3.getNombre()+" == $"+t1.getNombre()+") goto "+L5+";\r\n" + //
                    "   $"+t2.getNombre()+" = $"+t2.getNombre()+" + 1;\r\n" + //
                    "   goto "+L3+";\r\n" + //
                    ""+L4+":\r\n" + //
                    "   "+o.getNombre()+"[$"+o.getNombre()+"_length] = $"+t1.getNombre()+";\r\n" + //
                    "   $"+o.getNombre()+"_length = $"+o.getNombre()+"_length + 1;\r\n" + //
                    ""+L5+":\r\n" + //
                    "   $"+t0.getNombre()+" = $"+t0.getNombre()+" + 1;\r\n" + //
                    "   goto "+L0+";\r\n" + //
                    ""+L2+":");
        }if(m.equals("obtener")){
            TablaSimbolos.Error();
        }if(m.equals("in")){
            Objeto t0 = new Instancia(Objeto.newNumObj(),TMInt.getInstancia(),TablaSimbolos.bActual,false);
            Objeto t1 = new Instancia(Objeto.newNumObj(),TMInt.getInstancia(),TablaSimbolos.bActual,false);

            String L5 = TablaSimbolos.newEtiq();
            String L3 = TablaSimbolos.newEtiq();
            String L2 = TablaSimbolos.newEtiq();
            String L4 = TablaSimbolos.newEtiq();
            PLXC.out.println("   $t0 = 0;\r\n" + //
                    "L4:\r\n" + //
                    "   if ($c_length < $t0) goto L3;\r\n" + //
                    "   if ($c_length == $t0) goto L3;\r\n" + //
                    "   $t1 = c[$t0];\r\n" + //
                    "   if ($t1 == 3) goto L2;\r\n" + //
                    "   $t0 = $t0 + 1;\r\n" + //
                    "   goto L4;\r\n" + //
                    "L2:\r\n" + //
                    "   print 3;\r\n" + //
                    "   goto L5;\r\n" + //
                    "L3:\r\n" + //
                    "L5:");
        }
        return null;
    }
    
}
