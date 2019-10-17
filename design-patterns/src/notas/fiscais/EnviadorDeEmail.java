package notas.fiscais;

public class EnviadorDeEmail  implements AposNFBuilder{

	@Override
	public void executa(NotaFiscal nf) {
		System.out.println("Enviei por email");
		
	}

}
