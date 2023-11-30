public abstract class AST {
	protected AST izq, der;

	public abstract Integer exec() ;
	public abstract String codigoPostfija() ;
	public abstract String codigoPrefija() ;
	public abstract String codigoInfija() ;
	
	public String toString() {
		return ""+exec();
	}

}