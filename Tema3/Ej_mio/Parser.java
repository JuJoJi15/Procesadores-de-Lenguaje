import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class Parser {
    private static Yytoken actual;
    private static Yylex lex;

    public static void main(String[] argv) throws ParseException, IOException {
        lex = null;
        if (argv.length > 0) {
            lex = new Yylex(new FileReader(argv[0]));

            actual = lex.yylex();
            S();
        }
    }

    private static void checkActual() throws ParseException, IOException {
        if (actual == null) {
            throw new ParseException("Fin de fichero inexperado", lex.linea);
        }
    }

    private static void avanzar(int token, String mensaje) throws ParseException, IOException {
        if (actual.getToken() == token) {
            actual = lex.yylex();
        } else {
            throw new ParseException(mensaje, lex.linea);
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
                System.out.println(lex.linea);
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
            default:
                throw new ParseException("Error", lex.linea);

        }
    }

}
