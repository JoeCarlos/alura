package cap4;

public class Subtracao implements Expressao{
	private Expressao esquerda;
	private Expressao direita;

	
	public Expressao getEsquerda() {
		return esquerda;
	}


	public Expressao getDireita() {
		return direita;
	}


	public Subtracao(Expressao esquerda, Expressao direita) {
		this.esquerda = esquerda;
		this.direita = direita;
	
}


	@Override
	public int avalia() {
		int resultadoDaEsquerda = esquerda.avalia();
		int resultadoDaDireita = direita.avalia();
		return resultadoDaEsquerda - resultadoDaDireita;
	}


	@Override
	public void aceita(Visitor visitor) {
			visitor.visitaSubtracao(this);
		System.out.println("aceita");
	}

}
