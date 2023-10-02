import java.io.FileReader;
import java.io.IOException;

public class JCom {
    static int com, comest, comdobest;

    public static void main(String[] args) {

        if (args.length > 0) {

            Yylex lex = null;

            try {
                lex = new Yylex(new FileReader(args[0]));
                lex.yylex();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("\\\\  " + com);
            System.out.println("\\*  " + comest);
            System.out.println("\\**  " + comdobest);

        }

    }
}
