package orcamento;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import servico.Item;

public class Orcamento {
	
	protected double valor;
	protected EstadoDeUmOrcamento estadoAtual;
	private List<Item> itens;

	
	
	public Orcamento (double valor) {
		this.valor = valor;
		itens = new ArrayList<Item>();
		this.estadoAtual = new EmAprovacao();
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
	
	
	public void aplicaDescontoExtra() {
		estadoAtual.aplicaDescontosExtras(this);
	}
	
	
	
    public void aprova() {
        estadoAtual.aprova(this);
      }

      public void reprova() {
        estadoAtual.reprova(this);
      }

      public void finaliza() {
        estadoAtual.finaliza(this);
      }
	
}
