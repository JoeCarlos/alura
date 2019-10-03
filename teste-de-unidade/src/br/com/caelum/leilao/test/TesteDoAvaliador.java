package br.com.caelum.leilao.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class TesteDoAvaliador {
	@BeforeClass
	public static void testandoBeforeClass() {
	  System.out.println("before class");
	}

	@AfterClass
	public static void testandoAfterClass() {
	  System.out.println("after class");
	}

	private Avaliador leiloeiro;
	private Usuario jose;
	private Usuario yin;
	private Usuario cabecao;

	@Before
	public void setUp() {
		this.leiloeiro = new Avaliador();
		this.jose = new Usuario("José");
		this.yin = new Usuario("Yin");
		this.cabecao = new Usuario("Cabeção");
	}

	@Test(expected = RuntimeException.class)
	public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
	        Leilao leilao = new CriadorDeLeilao()
	            .para("Playstation 3 Novo")
	            .constroi();

	        leiloeiro.avalia(leilao);

	}
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		
		// cenario: 3 lances em ordem crescente

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").
				lance(yin, 250.0).
				lance(cabecao, 300.0).
				lance(jose, 400.0).
				constroi();

		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		double maiorEsperado = 400;
		double menorEsperado = 250;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescenteComOutrosValores() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").
				lance(yin, 1000.0).lance(jose, 2000.0).
				lance(cabecao, 3000.0).
				constroi();

		leiloeiro.avalia(leilao);

		assertEquals(3000.0, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(1000.0, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
    public void deveEntenderLeilaoComApenasUmLance() {
    	Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").
    			lance(cabecao,1000.0).
    			constroi();

        leiloeiro.avalia(leilao);

        assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(1000.0, leiloeiro.getMenorLance(), 0.0001);
    }

	@Test
	public void deveEncontrarOsTresMaioresLances() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").
				lance(cabecao, 100.0).
				lance(yin, 200.0).
				lance(cabecao, 300.0).
				lance(yin, 400.0).
				constroi();

		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();

		assertEquals(3, maiores.size());
		assertEquals(400.0, maiores.get(0).getValor(), 0.00001);
		assertEquals(300.0, maiores.get(1).getValor(), 0.00001);
		assertEquals(200.0, maiores.get(2).getValor(), 0.00001);
	}

	@Test
	public void deveEntenderLancesAleatorios() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").
				lance(jose, 200.0).
				lance(yin, 450.0).
				lance(jose, 120.0).
				lance(yin, 700.0).
				lance(jose, 630.0).
				lance(yin, 230.0).
				constroi();

		leiloeiro.avalia(leilao);

		assertEquals(700.0, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(120, leiloeiro.getMenorLance(), 0.0001);
	}
	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").
				
				lance(yin, 400).
				lance(jose, 300.0).
				lance(yin, 200.0).
				lance(jose, 100.0).
				constroi();
				System.out.println(leilao.getLances().get(2).getValor());
		leiloeiro.avalia(leilao);

		assertEquals(400, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(100, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void testeq() {
		Leilao leilao = new Leilao("Esolha do bairro");
		leilao.propoe(new Lance(new Usuario("Marujo"), 41500));
		leilao.propoe(new Lance(new Usuario("Marujo"), 25300));
		leilao.propoe(new Lance(new Usuario("Sereia"), 251100));
		leilao.propoe(new Lance(new Usuario("Sereia"), 10150));
		leilao.propoe(new Lance(new Usuario("Sereia"), 10000));

		leiloeiro.avalia(leilao);
	}

	@Test

	public void naoDeveAceitarDoisSeguidosDoMesmoUsuario() {
		Leilao leilao = new CriadorDeLeilao().para("Casa").
				lance(jose, 2000).
				lance(jose, 3000).
				constroi();
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
	}

	@Test
	public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
		Leilao leilao = new Leilao("Macbook Pro 15");

		leilao.propoe(new Lance(jose, 2000.0));
		leilao.propoe(new Lance(yin, 3000.0));
		leilao.propoe(new Lance(jose, 4000.0));
		leilao.propoe(new Lance(yin, 5000.0));
		leilao.propoe(new Lance(jose, 6000.0));
		leilao.propoe(new Lance(yin, 7000.0));
		leilao.propoe(new Lance(jose, 8000.0));
		leilao.propoe(new Lance(yin, 9000.0));
		leilao.propoe(new Lance(jose, 10000.0));
		leilao.propoe(new Lance(yin, 11000.0));

		// deve ser ignorado
		leilao.propoe(new Lance(jose, 12000.0));

		assertEquals(10, leilao.getLances().size());
		assertEquals(11000, leilao.getLances().get(leilao.getLances().size() - 1).getValor(), 0.0001);

	}

	@Test
	public void dobraLanceTeste() {
		Leilao leilao = new Leilao("Carro");
		leilao.propoe(new Lance(yin, 3000));
		leilao.propoe(new Lance(jose, 5000));
		leilao.dobrarLance(yin);
		assertEquals(6000, leilao.getLances().get(2).getValor(), 0.0001);
		assertEquals(3, leilao.getLances().size());
	}

	@Test
	public void naoDeveDobrarCasoNaoHajaLanceAnterior() {
		Leilao leilao = new Leilao("Macbook Pro 15");

		leilao.dobrarLance(jose);

		assertEquals(0, leilao.getLances().size());
	}

}
