package orcamento;

import javax.management.RuntimeErrorException;

public class Reprovado implements EstadoDeUmOrcamento{

	@Override
	public void aplicaDescontosExtras(Orcamento orcamento) {
		throw new RuntimeException("Or�amentos reprovaos n�o recebem desconto extra!");
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Or�amento est� reprovado, n�o pode ser aprovado!");
		
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Or�amento j� est� em reprova��o");
		
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		orcamento.estadoAtual = new Finalizado();
		
	}

}
