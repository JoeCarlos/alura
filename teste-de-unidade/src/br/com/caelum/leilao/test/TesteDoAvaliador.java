package br.com.caelum.leilao.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class TesteDoAvaliador {

	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		// cenario: 3 lances em ordem crescente
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));

		// executando a acao
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		double maiorEsperado = 400;
		double menorEsperado = 250;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescenteComOutrosValores() {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(joao, 1000.0));
		leilao.propoe(new Lance(jose, 2000.0));
		leilao.propoe(new Lance(maria, 3000.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(3000.0, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(1000.0, leiloeiro.getMenorLance(), 0.0001);
	}

    @Test
    public void deveEntenderLeilaoComApenasUmLance() {
        Usuario joao = new Usuario("João"); 
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 1000.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(1000.0, leiloeiro.getMenorLance(), 0.0001);
    }

    @Test
    public void deveEncontrarOsTresMaioresLances() {
        Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(maria, 400.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(3, maiores.size());
    }

    @Test
    public void deveEntenderLancesAleatorios() {
    	
    	Usuario jose = new Usuario("Jose");
    	Usuario ingryd = new Usuario("Ingryd");
    	Leilao leilao = new Leilao("Playstation 3");
    	
    	leilao.propoe(new Lance(jose,200.0));
    	leilao.propoe(new Lance(ingryd,450.0));
    	leilao.propoe(new Lance(jose,120.0));
    	leilao.propoe(new Lance(ingryd,700.0));
    	leilao.propoe(new Lance(jose,630.0));
    	leilao.propoe(new Lance(ingryd,230.0));
    
    	Avaliador leiloeiro = new Avaliador();
    	leiloeiro.avalia(leilao);
    	
    	assertEquals(700.0, leiloeiro.getMaiorLance(), 0.0001);
    	assertEquals(120,leiloeiro.getMenorLance(),0.0001);
    }

    public void deveEntenderLancesEmOrdemDecrescente() {
		Usuario yin = new Usuario ("Yin");
		Usuario yang = new Usuario("Yang");
		
		Leilao leilao = new Leilao("Valendo aquilo");
		leilao.propoe(new Lance(yin, 400));
		leilao.propoe(new Lance(yang, 300));
		leilao.propoe(new Lance(yang, 200));
		leilao.propoe(new Lance(yin, 100));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(400, leiloeiro.getMaiorLance(),0.0001);
		assertEquals(100, leiloeiro.getMenorLance(),0.0001);
    }
    
    @Test
    public void testeq () {	
	Leilao leilao = new Leilao("Esolha do bairro");
	leilao.propoe(new Lance(new Usuario ("Marujo"), 41500));
	leilao.propoe(new Lance(new Usuario ("Marujo"), 25300));
	leilao.propoe(new Lance( new Usuario("Sereia"), 251100));
	leilao.propoe(new Lance( new Usuario("Sereia"), 10150));
	leilao.propoe(new Lance( new Usuario("Sereia"), 10000));
	
	//nada
	Avaliador leiloeiro = new Avaliador();
	leiloeiro.avalia(leilao);
    	}
    
    @Test
    
    public void naoDeveAceitarDoisSeguidosDoMesmoUsuario (){
    	Leilao leilao= new Leilao("Carro 0km");
    	Usuario joe = new Usuario("Joe");
    	leilao.propoe(new Lance(joe,2000));
    	leilao.propoe(new Lance(joe,3000));
    	assertEquals(1, leilao.getLances().size());
    	assertEquals(2000, leilao.getLances().get(0).getValor(),0.00001);
    }
    
    
    @Test
    public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
        Leilao leilao = new Leilao("Macbook Pro 15");
        Usuario steveJobs = new Usuario("Steve Jobs");
        Usuario billGates = new Usuario("Bill Gates");

        leilao.propoe(new Lance(steveJobs, 2000.0));
        leilao.propoe(new Lance(billGates, 3000.0));
        leilao.propoe(new Lance(steveJobs, 4000.0));
        leilao.propoe(new Lance(billGates, 5000.0));
        leilao.propoe(new Lance(steveJobs, 6000.0));
        leilao.propoe(new Lance(billGates, 7000.0));
        leilao.propoe(new Lance(steveJobs, 8000.0));
        leilao.propoe(new Lance(billGates, 9000.0));
        leilao.propoe(new Lance(steveJobs, 10000.0));
        leilao.propoe(new Lance(billGates, 11000.0));

        // deve ser ignorado
        leilao.propoe(new Lance(steveJobs, 12000.0));
        
        assertEquals(10, leilao.getLances().size());
        assertEquals(11000, leilao.getLances().get(leilao.getLances().size()-1).getValor(),0.0001);
    
    
    	}
    
    @Test
    public void dobraLanceTeste() {
    	Leilao leilao = new Leilao("Carro");
    	Usuario joe = new Usuario("Joe");
    	Usuario ingryd = new Usuario ("Ingryd");
    	leilao.propoe(new Lance(ingryd,3000));
    	leilao.propoe(new Lance(joe,5000));
    	leilao.dobrarLance(ingryd);
    	assertEquals(6000, leilao.getLances().get(2).getValor(),0.0001);
    	assertEquals(3, leilao.getLances().size());
    }
    
    @Test
    public void naoDeveDobrarCasoNaoHajaLanceAnterior() {
        Leilao leilao = new Leilao("Macbook Pro 15");
        Usuario steveJobs = new Usuario("Steve Jobs");

        leilao.dobrarLance(steveJobs);

        assertEquals(0, leilao.getLances().size());
    }
    
    }
