package test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import servico.Orcamento;
import builder.CriadorOrcamento;
import servico.CalculadorDeDesconto;
import servico.Item;
public class DescontoTest {
	
	private CriadorOrcamento criaOrcamento;
	private Orcamento orcamento;
	private CalculadorDeDesconto descontos;
	@Before
	public void setUp() {
		criaOrcamento = new CriadorOrcamento().adicionaItem("CANETA",100.00).
				adicionaItem("LAPIS", 100.00).
				adicionaItem("caderno", 100.00).
				adicionaItem("giz", 100.00).
				adicionaItem("borracha", 250.00);
				descontos = new CalculadorDeDesconto();
	}
	
	
	@Test 
	public void decontoPorMaisDe5Itens() {
		//assertEquals(expected, actual);   
		orcamento = this.criaOrcamento.valor(1000).para().adicionaItem("Quadro", 100.00).constroi();	
		//descontos.calculaDesconto(orcamento);
		assertEquals(100.0, descontos.calculaDesconto(orcamento),0.001);
	
	}
	
	@Test
	public void descontoPormais500() {
		 orcamento = this.criaOrcamento.valor(1000).para().constroi();
	//	 descontos.calculaDesconto(orcamento);
		 assertEquals(70, descontos.calculaDesconto(orcamento), 0.001);
	}
	@Test
	public void descontoPorVendaCasada() {
		orcamento = new CriadorOrcamento().valor(100).para().adicionaItem("CANETA",100.00).
				adicionaItem("LAPIS", 100.00).constroi();
//		descontos.calculaDesconto(orcamento);
		assertEquals(5, descontos.calculaDesconto(orcamento),0.001);
	}
}
