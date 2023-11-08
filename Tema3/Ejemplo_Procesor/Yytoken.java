public class Yytoken {
	public final static int DOLAR = 0;
	public final static int AP = 1; // Abre Parentesis
	public final static int CP = 2; // Cierra Parentesis
	public final static int MAS = 3; 
	public final static int MENOS = 4; 
	public final static int ENTERO = 5;
	public final static int ERROR = 6; 
	
	private int token;
	private int valor;

	public Yytoken(int token, int valor){
		this.token = token;
		this.valor = valor;
	}

	public int getToken(){
		return token;
	}

	public int getValor(){
		return valor;
	}

	@Override
	public String toString(){
		return "<"+token+","+valor+">";
	}
}
