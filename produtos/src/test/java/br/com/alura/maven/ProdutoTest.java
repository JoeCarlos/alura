package br.com.alura.maven;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
public class ProdutoTest {

	
	@Test
	public void testaProdutoComImposto(){
		Produto produto= new Produto("Caixa de Bis", 10);
		 assertEquals(11, produto.getPrecoComImposto(),0.0001);
	}
}
