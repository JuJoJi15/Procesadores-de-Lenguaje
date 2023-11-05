// gramática
// regla 0 --- "axioma -> expresion EOF",
// regla 1 --- "expr   -> term expr_2",
// regla 2 --- "expr_2 -> MAS term expr_2",
// regla 3 --- "expr_2 -> ",
// regla 4 --- "term   -> AP expr CP",
// regla 5 --- "term   -> NUM"

import java.io.IOException;
import java.io.FileReader;

class ParserSumaSimple
{
	private static int token;
	private static Yylex lex;
	private static int yylex()
	{
		int token = 0;
		try
		{
			token = lex.yylex();
		}
		catch (IOException e)
		{
			System.out.println("IOException");
			System.exit(0);
		}
		return token;
	}

	public static void main(String[] arg)
	{
	    if (arg.length>0)
	    {
	        try
	        {
	            lex = new Yylex(new FileReader(arg[0]));
	            token = yylex ();
	            axioma ();
	        }
	        catch (IOException e) {} 
	    }
	}

	private static void axioma ()
	{
		if ((token == Token.NUM) || (token == Token.AP))
		{
			System.out.println("regla 0");

			expr (); 			
			if (token == Token.EOF) System.out.println("RECONOCIDO");
			else System.out.println("ERROR");
		}
		else System.out.println("Error");
	}

	private static void expr ()
	{
		if ((token == Token.NUM) || (token == Token.AP))
		{
			System.out.println("regla 1");

			term ();
			expr_2 ();
		}
		else System.out.println("Error");
	}

	private static void expr_2 ()
	{
		if (token == Token.MAS)
		{
			System.out.println("regla 2");

			if (token == Token.MAS) token = yylex (); 
			else System.out.println("Error");
			
			term (); 	
			expr_2 ();
		}
		else if((token == Token.CP) || (token == Token.EOF))
		{
			System.out.println("regla 3");

			;
		}
		else System.out.println("Error");
	}


	private static void term ()
	{
		if (token == Token.AP)
		{
			System.out.println("regla 4");

			if (token == Token.AP) token = yylex (); 
			else System.out.println("Error");
			expr ();
			if (token == Token.CP) token = yylex (); 
			else System.out.println("Error");
		}
		else if(token == Token.NUM)
		{
			System.out.println("regla 5");

			if (token == Token.NUM) token = yylex (); 
			else System.out.println("Error");
		}
		else System.out.println("Error");
	}

}
