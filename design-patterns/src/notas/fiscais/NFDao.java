package notas.fiscais;

public class NFDao implements AposNFBuilder{

	@Override
	public void executa(NotaFiscal nf) {
		System.out.println("Salvei no banco");
		
	}
	
}
