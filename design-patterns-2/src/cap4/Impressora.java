package cap4;

public class Impressora implements Visitor {

	@Override
	public void visitaSoma(Soma soma) {
		System.out.print(" + ");
		System.out.print("(");
		soma.getEsquerda().aceita(this);
		System.out.print("  ");
		soma.getDireita().aceita(this);
		System.out.print(")");
	}

	@Override
	public void visitaSubtracao(Subtracao subtracao) {
		System.out.print(" - ");
		System.out.print("(");
		subtracao.getEsquerda().aceita(this);
		System.out.print("  ");
		subtracao.getDireita().aceita(this);
		System.out.print(")");

	}

	@Override
	public void visitaNumero(Numero numero) {
		System.out.print(numero.getNumero());
	}

	@Override
	public void visitaRaizQuadrada(RaizQuadrada raiz) {
		System.out.print("√(");
		raiz.getExpressao().aceita(this);
		System.out.print(")");
	}
}
