package builder;
import java.util.ArrayList;
import java.util.List;

import orcamento.Orcamento;
import servico.Item;
public class CriadorOrcamento {
	
	private Orcamento orcamento;
	private double valor;
	private List itens = new ArrayList<Item>();

	public CriadorOrcamento valor(double valor) {
		this.valor = valor;
		return this;
	}
	public CriadorOrcamento para() {
		orcamento = new Orcamento(this.valor);
		return this;
	}
	public CriadorOrcamento adicionaItem (String nome, double valor) {
		this.itens.add(new Item(nome, valor));
		return this;
	}
	public Orcamento constroi() {
		orcamento.adicionaListaItens(this.itens);
		return orcamento;
	}
}
