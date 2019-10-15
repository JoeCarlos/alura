package orcamento;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EstadoOrcamentoTest {

	private Orcamento orcamento;
	
//	@Before
//	public void setUp() {
//		orcamento = new Orcamento(100.00);
//	}
//	
	@Test
	public void descontoExtraEmAprovacaoTest() {
		orcamento.aplicaDescontoExtra();
		assertEquals(95, orcamento.getValor(), 0.001);
	}
	@Test (expected = RuntimeException.class)
	public void descontoExtraJaAplicadoEmAprovacaoLancaRuntimeException() {
		orcamento = new Orcamento(100);
		orcamento.aplicaDescontoExtra();
		orcamento.aplicaDescontoExtra();
		assertEquals(95, orcamento.getValor(), 0.01);
		System.out.println(orcamento.getValor());
	}
}
