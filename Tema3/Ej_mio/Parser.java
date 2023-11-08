import java.io.FileReader;
import java.text.ParseException;

public class Parser {
    private static Yytoken actual;

    public static void main(String[] argv) {
        Yylex lex = null;
        if (argv.length > 0) {
            lex = new Yylex(new FileReader(argv[0]));

            actual = lex.yylex();
            S();
        }
    }

    private static void checkActual() throws ParseException {
        if (actual == null) {
            throw new ParseException("Fin de fichero inexperado", lex.linea);
        }
    }

    private static void avanzar(int token, String mensaje) {
        if (actual.getToken() == token) {
            actual = lex.yylex();
        } else {
            throw new ParseException(mensaje, lex.linea);
        }
    }

    private static void S() throws ParseException {
        checkActual();
        switch (actual.getToken()) {
            case Yytoken.AP:
                E();
                avanzar(Yytoken.DOLAR, "ERROR");
                break;
            case Yytoken.N:
                E();
                avanzar(Yytoken.DOLAR, "ERROR");
            default:
                throw new ParseException("Error", lex.linea);
                break;
        }
    }

    private static void E() throws ParseException {
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
                break;
        }
    }

    private static void E2() throws ParseException {
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
                break;
        }
    }

    private static void T() throws ParseException {
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
                break;
        }
    }

}
