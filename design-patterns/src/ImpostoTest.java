import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
public class ImpostoTest {
	
	private Orcamento orcamento;
	private Imposto imposto;
	private CalculadorDeImposto calculador;
	@Before
	public void setUp() {
	CalculadorDeImposto calculador = new CalculadorDeImposto();
	orcamento = new Orcamento(100.0);
	}
			
	@Test
	public void deveCalcularICMS() {
		imposto = new ICMS();
		calculador.realizaCalculo(orcamento, imposto);
		assertEquals(10.0, calculador.getValor(),0.0001);
	}
	
	@Test 
	public void deveCalcularISS() {
		imposto = new ISS();
		calculador.realizaCalculo(orcamento, imposto);
		assertEquals(6, calculador.getValor(),0.0001);
	}
	
}
