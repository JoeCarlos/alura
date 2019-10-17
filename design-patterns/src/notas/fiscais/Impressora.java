package notas.fiscais;

public class Impressora implements AposNFBuilder{

	
	
	@Override
	public void executa(NotaFiscal nf) {
		System.out.println("Imprimi");		
	}

}
