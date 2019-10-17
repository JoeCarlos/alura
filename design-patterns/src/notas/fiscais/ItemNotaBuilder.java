package notas.fiscais;

public class ItemNotaBuilder {
	private String descricao;
	private double valor;
	
	public ItemNotaBuilder comDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}
	
	public ItemNotaBuilder comValor(double valor) {
		this.valor = valor;
		return this;
	}
	
	public ItemDaNota controi() {
		return new ItemDaNota(descricao, valor);
	}
}
