package imposto;

import dominio.Orcamento;

public class ICPP extends TemplateDeImpostoCondicional{

	public ICPP() {	}
	
	public ICPP (Imposto outroImposto) {
		super(outroImposto);
}
	
	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor()*0.07;
	}

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor()*0.05;
	}

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		if (orcamento.getValor() > 500) {
			return true;
		}
		else 
			return false;
	}
	
}
