package imposto;

import dominio.Orcamento;

public class ICMS extends Imposto{
	public ICMS() {}
	
	public ICMS(Imposto outroImposto) {
			super(outroImposto);
	}
	
	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor()* 0.05 + 50.00;
	}
}
