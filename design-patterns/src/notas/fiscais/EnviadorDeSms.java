package notas.fiscais;

public class EnviadorDeSms implements AposNFBuilder{

	@Override
	public void executa(NotaFiscal nf) {
		System.out.println("Enviei por SMS");
		
	}

}
