package imposto;

import java.util.ArrayList;
import java.util.List;

import dominio.Orcamento;
import servico.Item;

public class IHIT extends TemplateDeImpostoCondicional {

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		if (existemDoisItensComMesmoNome(orcamento)) {
			return true;
		}
		else
		return false;
	}

	private boolean existemDoisItensComMesmoNome(Orcamento orcamento) {
		List<String> noOrcamento = new ArrayList<String>();
		
		for (Item item : orcamento.getItens()) {
			if(noOrcamento.contains(item.getNome())) return true;
			else noOrcamento.add(item.getNome());
		}
		return false;
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		// TODO Auto-generated method stub
		return orcamento.getValor()*0.13 + 100.00;
	}

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		// TODO Auto-generated method stub
		return orcamento.getValor() * (0.01*orcamento.getItens().size());
	}

}
