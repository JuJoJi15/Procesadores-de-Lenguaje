class Resta extends AST {
	public Resta(AST izq, AST der) {
		this.izq = izq;
		this.der = der;
	}
	public Integer exec() {
		return izq.exec() - der.exec();
	}
	
	public String codigoPostfija() {
		return izq.codigoPostfija() + " " + der.codigoPostfija() + " - ";
	}
	
	public String codigoPrefija() {
		return " - " + izq.codigoPrefija() + " " + der.codigoPrefija() ;
	}

	public String codigoInfija() {
		return izq.codigoInfija() + " - " + der.codigoInfija() ;
	}

}