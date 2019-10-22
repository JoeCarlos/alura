package br.com.solid.acoplamento;

public class EnviadorDeEmail implements AcaoAposGerarNotaFiscal{

	@Override
	public void executa(NotaFiscal nf) {
		System.out.println("envia email da nf " + nf.getId());
		
	}
}
