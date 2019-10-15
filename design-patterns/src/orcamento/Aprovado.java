package orcamento;

public class Aprovado implements EstadoDeUmOrcamento{

    private boolean descontoAplicado = false;

	
	@Override
	public void aplicaDescontosExtras(Orcamento orcamento) {
		if (!descontoAplicado) {
			orcamento.valor -= orcamento.valor * 0.02;
			descontoAplicado = true;
		} else {
			throw new RuntimeException("Desconto já aplicado!");
		}
		
	}

	@Override
	public void aprova(Orcamento orcamento) {
		 throw new RuntimeException("Orçamento já está em estado de aprovação");		
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Orçamento está em estado de aprovação e não pode ser reprovado");
		
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		orcamento.estadoAtual = new Finalizado();
		
	}

}
