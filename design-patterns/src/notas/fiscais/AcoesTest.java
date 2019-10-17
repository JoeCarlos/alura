package notas.fiscais;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test; 

public class AcoesTest {
	private NFBuilder builder;

	@Before
	public void CriaNF() {

	builder = new NFBuilder();
	
	builder.adicionaAcao(new EnviadorDeEmail());
	NotaFiscal nf = builder.constroi();	
	}
	
	@Test
	public void Teste() {
//		verify(builder, times(1)).constroi();
	}
}
