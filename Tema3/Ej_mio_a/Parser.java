import java.io.IOException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.io.BufferedReader;

public class Parser {
    /**
     * Llama al analizador sintactico, usando el nombre del fichero que se le pasa
     * como
     * primer argumento, si no se le pasa ningun argumento usa la entrada estandar.
     */
    private static Yytoken actual;

    private static void checkActual() throws ParseException, IOException {
        if (actual == null) {
            throw new ParseException("Fin de fichero inexperado", lex.linea);
        }
    }

    private static void avanzar(int token, String mensaje) throws ParseException, IOException, IOException {
        if (actual.getToken() == token) {
            actual = lex.yylex();
        } else {
            throw new ParseException(mensaje, lex.linea);
        }
    }

    public static void main(String arg[]) throws ParseException, IOException {
        private static Yylex lex;
        lex = null;
        try {
            if (arg.length > 0) {
                lex = new Yylex(new FileReader(arg[0]));
                if (arg.length > 1) {

                }
            } else {
                lex = new Yylex(new BufferedReader(new InputStreamReader(System.in)));
            }

            if (lex != null) {
                actual = lex.yylex();
                S();
                System.out.print("OK");
            }

        } catch (IOException e) {
            System.err.println("Error al abrir el fichero de entrada");
        }
    }

    private static void S() throws ParseException, IOException {
        checkActual();
        switch (actual.getToken()) {
            case Yytoken.AP:
                E();
                avanzar(Yytoken.DOLAR, "ERROR");
                break;
            case Yytoken.N:
                E();
                avanzar(Yytoken.DOLAR, "ERROR");
                break;
            default:
                throw new ParseException("Error", lex.linea);

        }
    }

    private static void E() throws ParseException, IOException {
        checkActual();

        switch (actual.getToken()) {
            case Yytoken.N:
                T();
                E2();
                break;
            case Yytoken.AP:
                T();
                E2();
                break;
            default:

                throw new ParseException("Error", lex.linea);

        }
    }

    private static void E2() throws ParseException, IOException {
        checkActual();
        switch (actual.getToken()) {
            case Yytoken.CP:
                break;
            case Yytoken.MAS:
                avanzar(Yytoken.MAS, "ERROR");
                T();
                E2();
                break;
            case Yytoken.DOLAR:
                break;
            default:
                throw new ParseException("Error", lex.linea);

        }
    }

    private static void T() throws ParseException, IOException {
        checkActual();
        switch (actual.getToken()) {
            case Yytoken.N:
                avanzar(Yytoken.N, "ERROR");
                break;
            case Yytoken.AP:
                avanzar(Yytoken.AP, "ERROR");
                E();
                avanzar(Yytoken.CP, "ERROR");
                break;
            default:
                throw new ParseException("Error", lex.linea);

        }
    }
}
