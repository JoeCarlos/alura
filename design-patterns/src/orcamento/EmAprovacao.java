package orcamento;

public class EmAprovacao implements EstadoDeUmOrcamento {

	@Override
	public void aplicaDescontosExtras(Orcamento orcamento) {
		orcamento.valor -= orcamento.valor * 0.05;
	}
	
}
