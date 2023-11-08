package Tema3.Ejemplo_Procesor;

import java.text.ParseException;

public class Parser {
    private static Yytoken actual;

    public static void main(String[] argv) {
        lex = new Yylex(in);
        actual = lex.yylex();
        S();
        out.println("OK");
    }

    private static void checkACtual() throws ParseException {
        if (Object.isNull(actual)) {
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
        checkACtual();
        switch (actual.getToken()) {
            case Yytoken.AP:
                L();
                avanza(Yytoken.DOLAR, "ERROR");
                break;

            default:
                throw new ParseException("Error", lex.linea);
                break;
        }
    }

    private static void L() throws ParseException {
        checkActual();
        switch (actual.getToken()) {
            case Yytoken.AP:
                O();
                E();
                break;

            default:
                throw new ParseException("Error", lex.linea);
                break;
        }
    }
}
