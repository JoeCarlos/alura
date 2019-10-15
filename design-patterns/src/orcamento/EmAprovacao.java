package orcamento;

public class EmAprovacao implements EstadoDeUmOrcamento {

	private boolean descontoAplicado = false;
	
	
	@Override
	public void aplicaDescontosExtras(Orcamento orcamento) {
        
		try {
			if(!descontoAplicado) {
	            orcamento.valor -= orcamento.valor * 0.05;
	            descontoAplicado = true;
	            System.out.println("Psso");
	          }	
		} catch (RuntimeException e){
			System.out.println("Desconto já aplicado!");
		}
	}

	@Override
	public void aprova(Orcamento orcamento) {
		 orcamento.estadoAtual = new Aprovado();		
	}

	@Override
	public void reprova(Orcamento orcamento) {
		orcamento.estadoAtual = new Reprovado();
		
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Orcamento em aprovação não podem ir para finalizado diretamente");
		
	}
	
}
