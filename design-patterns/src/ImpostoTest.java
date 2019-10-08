import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
public class ImpostoTest {
	
	private Orcamento orcamento;
	private Imposto imposto;
	private CalculadorDeImposto calculador;
	@Before
	public void setUp() {
	calculador = new CalculadorDeImposto();
	orcamento = new Orcamento(100.0);
	}
			
	@Test
	public void deveCalcularICMS() {
		imposto = new ICMS();
		calculador.realizaCalculo(orcamento, imposto);
		assertEquals(55.00, calculador.getValor(),0.0001);
	}
	
	@Test 
	public void deveCalcularISS() {
		imposto = new ISS();
		calculador.realizaCalculo(orcamento, imposto);
		assertEquals(6, calculador.getValor(),0.0001);
	}
	
	@Test 
	public void deveCalcularICCCMenor1000() {
		imposto = new ICCC();
		calculador.realizaCalculo(orcamento, imposto);
		assertEquals(5.0, calculador.getValor(),0.001);
	}
	
	@Test 
	public void deveCalcularICCCMaior1000Menor3000() {
		imposto = new ICCC();
		orcamento = new Orcamento(2000);
		calculador.realizaCalculo(orcamento, imposto);
		assertEquals(140, calculador.getValor(),0.001);
	}
	
	@Test 
	public void deveCalcularICCCMaior3000() {
		imposto = new ICCC();
		orcamento = new Orcamento(10000);
		calculador.realizaCalculo(orcamento, imposto);
		assertEquals(830, calculador.getValor(),0.001);
	}
}
