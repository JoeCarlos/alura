public class CriadorDeCalculadoraDeDesconto {
	private double valor;
	private String nome;
	private Item item;
	private Orcamento orcamento; 

	public CriadorDeCalculadoraDeDesconto para (double valor) {
		this.orcamento = new Orcamento(valor);
		return this;
	}
	public CriadorDeCalculadoraDeDesconto itens(Item item) {
		this.orcamento.adicionaItem(item);
		return this;
	}
	
	public CriadorDeCalculadoraDeDesconto constroi() {
		CalculadorDeDesconto calculadora = new CalculadorDeDesconto(this.orcamento);
		
	}
	
	
}
