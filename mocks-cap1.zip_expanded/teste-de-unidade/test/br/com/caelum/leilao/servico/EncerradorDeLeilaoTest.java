package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.infra.dao.RepositorioDeLeiloes;

public class EncerradorDeLeilaoTest {
	private RepositorioDeLeiloes dao;
	private EncerradorDeLeilao encerrador;
	private EnviadorDeEmail carteiro;
	private Leilao leilao;

	@Before
	public void setup() {
		this.dao = mock(RepositorioDeLeiloes.class);
		carteiro = mock(EnviadorDeEmail.class);
		this.encerrador = new EncerradorDeLeilao(dao, carteiro);

	}

	@Test
	public void deveEncerrarLeiloesQueComecaramUmaSemanaAtras() {
		Calendar antiga = Calendar.getInstance();
		antiga.set(2018, 3, 12);
		leilao = new CriadorDeLeilao().para("Carro").naData(antiga).constroi();

		when(dao.correntes()).thenReturn(Arrays.asList(leilao));
		encerrador.encerra();

		assertTrue(leilao.isEncerrado());
		assertEquals(1, encerrador.getTotalEncerrados());

	}

	@Test
	public void naoDeveEncerrarLeiloesQueComecaramMenosDeUmaSemanaAtras() {
		Calendar ontem = Calendar.getInstance();
		ontem.add(Calendar.DAY_OF_MONTH, -1);

		leilao = new CriadorDeLeilao().naData(ontem).constroi();

		when(dao.correntes()).thenReturn(Arrays.asList(leilao));
		encerrador.encerra();

		assertFalse(leilao.isEncerrado());
		assertEquals(0, encerrador.getTotalEncerrados());
		verify(dao, never()).atualiza(leilao);

	}

	@Test
	public void naoDeveEncerrarLeiloesCasoNaoHajaNenhum() {
		when(dao.correntes()).thenReturn(new ArrayList<Leilao>());
		encerrador.encerra();

		assertEquals(0, encerrador.getTotalEncerrados());

	}

	@Test
	public void deveAtualizarLeiloesEncerrados() {
		Calendar antiga = Calendar.getInstance();
		antiga.set(2018, 12, 3);

		leilao = new CriadorDeLeilao().naData(antiga).constroi();

		when(dao.correntes()).thenReturn(Arrays.asList(leilao));
		encerrador.encerra();
		verify(dao, times(1)).atualiza(leilao);

	}

	@Test
	public void deveEnviarEmailAposPersistirLeilaoEncerrado() {
		Calendar antiga = Calendar.getInstance();
		antiga.set(1999, 1, 20);

		leilao = new CriadorDeLeilao().para("TV de plasma").naData(antiga).constroi();

		when(dao.correntes()).thenReturn(Arrays.asList(leilao));

		encerrador.encerra();

		InOrder inOrder = inOrder(dao, carteiro);
		inOrder.verify(dao, times(1)).atualiza(leilao);
		inOrder.verify(carteiro, times(1)).envia(leilao);
	}

	@Test()
	public void deveContinuarQuandoDaoFalha() {
		Calendar antiga = Calendar.getInstance();
		antiga.set(2018, 12, 3);

		leilao = new CriadorDeLeilao().para("TV de plasma").naData(antiga).constroi();

		Leilao leilao2 = new CriadorDeLeilao().naData(antiga).constroi();

		when(dao.correntes()).thenReturn(Arrays.asList(leilao, leilao2));
		doThrow(new RuntimeException()).when(dao).atualiza(leilao);
		encerrador.encerra();
		verify(dao).atualiza(leilao2);
		verify(carteiro).envia(leilao2);
		verify(carteiro, times(0)).envia(leilao);
	}

	@Test
	public void deveContinuarAExecucaoMesmoQuandoEnviadorDeEmaillFalha() {
		Calendar antiga = Calendar.getInstance();
		antiga.set(2018, 12, 3);
		leilao = new CriadorDeLeilao().naData(antiga).constroi();
		Leilao leilao2 = new CriadorDeLeilao().naData(antiga).constroi();

		when(dao.correntes()).thenReturn(Arrays.asList(leilao, leilao2));
		doThrow(new RuntimeException()).when(dao).atualiza(leilao);
		encerrador.encerra();
		verify(dao).atualiza(leilao2);
		verify(carteiro).envia(leilao2);
		verify(carteiro, times(0)).envia(leilao);
		verify(carteiro, times(1)).envia(leilao2);
	}
	
	@Test
	public void enviadorDeEmailSempreFalha() {
		Calendar antiga = Calendar.getInstance();
		antiga.set(2018, 12, 3);
        leilao = new CriadorDeLeilao().para("TV de plasma")
                .naData(antiga).constroi();
     
		Leilao leilao2 = new CriadorDeLeilao().naData(antiga).constroi();

		when(dao.correntes()).thenReturn(Arrays.asList(leilao, leilao2));
		doThrow(new RuntimeException()).when(dao).atualiza(any(Leilao.class));
		encerrador.encerra();

		verify(carteiro, never()).envia(any(Leilao.class));

	}
}
