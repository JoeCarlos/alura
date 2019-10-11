package imposto;

import dominio.Orcamento;
import servico.Item;


public class IKCV extends TemplateDeImpostoCondicional {

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.10;
	}

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor()*0.06;
	}

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		if (orcamento.getValor() > 500 && temItemMaiorQue100ReaisNo(orcamento)) return true;
		else
			return false;
	}


	public boolean temItemMaiorQue100ReaisNo(Orcamento orcamento) {
		for (Item item : orcamento.getItens()) {
			if(item.getValor()>100) {
				return true;
			}
		}
		return false;
	}

	
}
