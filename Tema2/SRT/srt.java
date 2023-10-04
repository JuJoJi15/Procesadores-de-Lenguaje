
import java.io.FileReader;
import java.io.IOException;

public class srt {
    protected static int numSubtitulos = 0;
    protected static int tiempo = 0;
    protected static int numLineas = 0;
    protected static int numPalabras = 0;

    public static void main(String arg[]) {
        if (arg.length > 0) {
            try {
                Yylex lex = new Yylex(new FileReader(arg[0]));
                lex.yylex();
                System.out.println("NUM_SUBTITULOS " + numSubtitulos);
                System.out.println("TIEMPO_TOTAL " + tiempo);
                System.out.println("NUM_LINEAS " + numLineas);
                System.out.println("NUM_PALABRAS " + numPalabras);
            } catch (IOException e) {
            }
        }
    }
}