import java.io.*;
    
public class Calculadora {
  private static boolean DEBUG = false;
  private static Reader in = null; 
  public  static PrintStream out = null; 
  /** 
   * Funcion para depuración
   * @param st: mensaje de depuracion
   */
  public static void debug(String st) {
      if(DEBUG) System.out.println(st);
  }
  /** 
   * Método principal
   * @param argv: lista de argumentos de entrada
   *   Ejemplo: Calculadora -d file1 file2
   *   -d: modo de depuración
   *   file1: fichero de entrada
   *   file2 : fichero de salida
   *   En caso de que falte el fichero de salida o 
   *   de entrada se usa la salida/entrada estandar.
   */
  public static void main(String argv[]) {    
    try {
      // Leer parametros de entrada
      for(int i=0; i<argv.length; i++) {
          if ("-d".equals(argv[i])) {
              DEBUG = true;
           } else if(in == null) {
         	  in = new FileReader(argv[i]);
           } else if(out == null) {
         	  out = new PrintStream(new FileOutputStream(argv[1]));
           }
      }
      // Asignar ficheros por defecto
      if (in == null) {
    	  new InputStreamReader(System.in);
      }
      if (out == null) {
          out = System.out;
      }
      // Crear y lanzar el analizador lexico y sintactico
      @SuppressWarnings({ "deprecation" })
      parser p = new parser(new Yylex(in));
      p.parse();      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


