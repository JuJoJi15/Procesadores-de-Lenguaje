import java.io.*;

public class XML2JSON {
  public static Yylex lex;

  static public void main(String argv[]) {
    /* Start the parser */
    try {
      lex = new Yylex(new FileReader(argv[0]));
      parser p = new parser(lex);
      Object result = p.parse().value;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
