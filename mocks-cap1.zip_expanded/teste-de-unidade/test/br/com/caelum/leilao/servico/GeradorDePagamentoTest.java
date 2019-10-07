package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Pagamento;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.infra.dao.RepositorioDeLeiloes;
import br.com.caelum.leilao.infra.dao.RepositorioDePagamentos;

public class GeradorDePagamentoTest {
	private Leilao leilao;
	private Usuario jose;
	private Usuario yin;
	RepositorioDeLeiloes dao;
	RepositorioDePagamentos pagamentos;
	Avaliador  avaliador;
	Relogio relogio;
	@Before
	public void setUp() {
		 dao = mock(RepositorioDeLeiloes.class);
		 pagamentos = mock(RepositorioDePagamentos.class);
		 relogio = mock(Relogio.class);
		 
	     avaliador = new Avaliador();
	     jose = new Usuario("Jose");
	     leilao = new CriadorDeLeilao().lance(jose,2000).lance(yin, 2500).constroi();
	}
	
	@Test
	public void deveGerarPagamentoParaUmLeilaoEncerrado() {
		leilao = new CriadorDeLeilao().lance(jose,2000).lance(yin, 2500).constroi();
		
		when(dao.encerrados()).thenReturn(Arrays.asList(leilao));
		
		GeradorDePagamento gerador = new GeradorDePagamento(dao, pagamentos, new Avaliador());
		gerador.gera();
		
		ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(Pagamento.class);
		verify(pagamentos).salva(argumento.capture());
		Pagamento pagamentoGerado= argumento.getValue();
		
		assertEquals(2500, pagamentoGerado.getValor(),0.001);
		
	}
	@Test
	public void deveEmpurrarSabadoParaOProximoDiaUtil(){
		Calendar sabado = Calendar.getInstance();
		sabado.set(2012, Calendar.APRIL, 7);
		
		when(dao.encerrados()).thenReturn(Arrays.asList(leilao));
		when(relogio.hoje()).thenReturn(sabado);
		GeradorDePagamento gerador = new GeradorDePagamento(dao, pagamentos, avaliador, relogio);
		gerador.gera();
		ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(Pagamento.class);
		verify(pagamentos).salva(argumento.capture());
		Pagamento pagamentoGerado = argumento.getValue();
		
		assertEquals(Calendar.MONDAY, pagamentoGerado.getData().get(Calendar.DAY_OF_WEEK));
		assertEquals(9, pagamentoGerado.getData().get(Calendar.DAY_OF_MONTH));
	}

	@Test 
	public void deveEmpurrarDomingoParaOProximoDiaUtil() {
		Calendar domingo = Calendar.getInstance();
		domingo.set(2012, Calendar.APRIL, 8);
		
		when (dao.encerrados()).thenReturn(Arrays.asList(leilao));
		when(relogio.hoje()).thenReturn(domingo);
		
		GeradorDePagamento gerador = new GeradorDePagamento(dao, pagamentos, avaliador, relogio);
		
		gerador.gera();
		
		ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(Pagamento.class);
		verify(pagamentos).salva(argumento.capture());
		
		Pagamento pagamentoGerado = argumento.getValue();
		assertEquals(Calendar.MONDAY, pagamentoGerado.getData().get(Calendar.DAY_OF_WEEK));
		assertEquals(9, pagamentoGerado.getData().get(Calendar.DAY_OF_MONTH));
		
	}
	
	}
