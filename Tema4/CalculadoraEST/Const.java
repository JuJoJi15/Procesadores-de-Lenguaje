class Const extends AST {
	protected Integer valor;
	
	public Const(Integer val) {
		this.valor = val ;
	}
	
	public Integer exec() {
		return valor;
	}
	
	public String codigoPostfija() {
		return ""+valor;
	}
	
	public String codigoPrefija() {
		return ""+valor;
	}

	public String codigoInfija() {
		return ""+valor;
	}

}