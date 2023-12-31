import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Vectores {	   
	public static PrintStream out; 
	public static Yylex lex;
	
	public static void main(String argv[]) {    
    try {
      Reader in = new InputStreamReader(System.in);	
      out = System.out;
      if (argv.length > 0) {
    	  in = new FileReader(argv[0]);
      }
      if (argv.length >  1) {
    	  out = new PrintStream(new FileOutputStream(argv[1]));
      }
      
      lex = new Yylex( in );
      
      parser p = new parser( lex );
      
      Object result = p.parse().value; 
          
    } catch (Exception e) {
     	System.err.println( "Error: "+e.getMessage() );
      e.printStackTrace();
    }
  }
}

