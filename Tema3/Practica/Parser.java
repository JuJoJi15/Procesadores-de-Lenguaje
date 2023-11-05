import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.io.FileReader;

class Parser {

	private static int token;
	private static Yylex lex;

	private static int yylex() {
		int token = 0;
		try {
			token = lex.yylex();
		} catch (IOException e) {
			System.out.println("IOException");
			System.exit(0);
		}
		return token;
	}

	private static void avanza(int i) {
		if (i == token) {

			token = yylex();
		} else {
			Yytoken.error(token);
		}
	}

	public static void main(String[] arg) {
		if (arg.length > 0) {
			try {
				lex = new Yylex(new FileReader(arg[0]));
				token = yylex();
				axioma();
			} catch (IOException e) {
			}
		}
	}

	private static void axioma() {
		switch (token) {
			case Yytoken.EOF:
				Yytoken.regla(0);
				L();
				avanza(Yytoken.EOF);
				break;
			case Yytoken.WHILE:
				Yytoken.regla(0);
				L();
				avanza(Yytoken.EOF);
				break;
			case Yytoken.ALL:
				Yytoken.regla(0);
				L();
				avanza(Yytoken.EOF);
				break;
			case Yytoken.IDENT:
				Yytoken.regla(0);
				L();
				avanza(Yytoken.EOF);
				break;
			default:
				Yytoken.error(token);

		}
	}

	private static void L() {
		switch (token) {
			case Yytoken.EOF:
				Yytoken.regla(2);
				break;
			case Yytoken.WHILE:
				Yytoken.regla(1);
				S();
				L();
				break;
			case Yytoken.ALL:
				Yytoken.regla(1);
				S();
				L();
				break;
			case Yytoken.CLL:
				Yytoken.regla(2);
				break;
			case Yytoken.IDENT:
				Yytoken.regla(1);
				S();
				L();
				break;
			case Yytoken.DO:
				Yytoken.regla(1);
				S();
				L();
				break;
			default:
				Yytoken.error(token);

		}
	}

	private static void S() {
		switch (token) {
			case Yytoken.WHILE:
				Yytoken.regla(3);
				avanza(Yytoken.WHILE);
				avanza(Yytoken.AP);
				C();
				avanza(Yytoken.CP);
				S();
				break;
			case Yytoken.ALL:
				Yytoken.regla(6);
				avanza(Yytoken.ALL);
				L();
				avanza(Yytoken.CLL);
				break;
			case Yytoken.IDENT:
				Yytoken.regla(5);
				avanza(Yytoken.IDENT);
				avanza(Yytoken.IGUAL);
				V();
				avanza(Yytoken.PYC);
				break;
			case Yytoken.DO:
				Yytoken.regla(4);
				avanza(Yytoken.DO);
				S();
				avanza(Yytoken.WHILE);
				avanza(Yytoken.AP);
				C();
				avanza(Yytoken.CP);
				avanza(Yytoken.PYC);
				break;
			default:
				Yytoken.error(token);

		}
	}

	private static void C() {
		switch (token) {
			case Yytoken.NUMERO:
				Yytoken.regla(7);
				V();
				avanza(Yytoken.MENOR);
				V();
				break;
			case Yytoken.IDENT:
				Yytoken.regla(7);
				V();
				avanza(Yytoken.MENOR);
				V();
				break;
			default:
				Yytoken.error(token);
		}
	}

	private static void V() {

		switch (token) {
			case Yytoken.NUMERO:

				Yytoken.regla(9);
				avanza(Yytoken.NUMERO);
				break;

			case Yytoken.IDENT:
				Yytoken.regla(8);
				avanza(Yytoken.IDENT);
				break;
			default:
				Yytoken.error(token);
		}
	}

}