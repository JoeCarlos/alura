package cap4;

public class RaizQuadrada implements Expressao {

	private Expressao expressao;
	
	public RaizQuadrada(Expressao expressao) {
		this.expressao = expressao;
	}
	
	@Override
	public int avalia() {
		return (int) Math.sqrt(getExpressao().avalia());
	}

	@Override
	public void aceita(Visitor visitor) {
		visitor.visitaRaizQuadrada(this);
	}

	public Expressao getExpressao() {
		return expressao;
	}

}
