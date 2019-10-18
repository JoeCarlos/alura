package cap4;

public class RaizQuadrada implements Expressao {

	private Expressao expressao;
	
	public RaizQuadrada(Expressao expressao) {
		this.expressao = expressao;
	}
	
	@Override
	public int avalia() {
		return (int) Math.sqrt(expressao.avalia());
	}

}
