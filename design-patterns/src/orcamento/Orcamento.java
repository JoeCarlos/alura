package orcamento;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import servico.Item;

public class Orcamento {
	
	protected double valor;
	private List<Item> itens;

	
	public Orcamento (double valor) {
		this.valor = valor;
		itens = new ArrayList<Item>();
	}

	public double getValor() {
		return valor;
	}
	
	public void adicionaItem(Item item) {
		itens.add(item);
	}
	public void adicionaListaItens(List itens) {
		this.itens = itens;
	}
	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	} 
}
