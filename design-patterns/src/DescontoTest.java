import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
public class DescontoTest {
	
	private Orcamento orcamento;
	private	CalculadorDeDesconto calculador;

	
	@Test 
	public void decontoPorMaisDe5Itens() {
		CalculadorDeDesconto descontos = new CalculadorDeDesconto();
		
		orcamento = new Orcamento(510.00);
		orcamento.adicionaItem(new Item("Caneta", 250.00));
		orcamento.adicionaItem(new Item("Lapis", 26.00));
		//assertEquals(expected, actual);   
		double descontoFinal = descontos.calculaDesconto(orcamento);
		
		System.out.println(descontoFinal);

		
		orcamento = new Orcamento(10.00);
		orcamento.adicionaItem(new Item("Caneta", 250.00));
		orcamento.adicionaItem(new Item("Lapis", 26.00));
		orcamento.adicionaItem(new Item("caderno", 26.00));
		orcamento.adicionaItem(new Item("giz", 26.00));
		orcamento.adicionaItem(new Item("borracha", 26.00));
		orcamento.adicionaItem(new Item("Quadro", 26.00));
		//assertEquals(expected, actual);   
		descontoFinal = descontos.calculaDesconto(orcamento);
		
		System.out.println(descontoFinal);
	}
}
