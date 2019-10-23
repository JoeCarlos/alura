package br.com.solid.encapsulamento;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Programa {
	@Test
	public void TestaGeradorDeBoleto() {
		ProcessadorDeBoletos processadorDeBoletos = new ProcessadorDeBoletos();
		Fatura fatura = new Fatura("Joe", 50000);
		Pagamento pagamento = new Pagamento(200, MeioDePagamento.BOLETO);
		fatura.AdcionaPagamentos(new Pagamento(200, MeioDePagamento.BOLETO));
		processadorDeBoletos.processa(boletos, fatura);
	}
}
