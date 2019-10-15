package orcamento;

import javax.management.RuntimeErrorException;

public class Reprovado implements EstadoDeUmOrcamento{

	@Override
	public void aplicaDescontosExtras(Orcamento orcamento) {
		throw new RuntimeException("Orçamentos reprovaos não recebem desconto extra!");
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Orçamento está reprovado, não pode ser aprovado!");
		
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Orçamento já está em reprovação");
		
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		orcamento.estadoAtual = new Finalizado();
		
	}

}
