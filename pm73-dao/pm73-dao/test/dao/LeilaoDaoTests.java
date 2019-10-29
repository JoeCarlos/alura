package dao;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.pm73.dao.CriadorDeSessao;
import br.com.caelum.pm73.dao.LeilaoDao;
import br.com.caelum.pm73.dao.UsuarioDao;
import br.com.caelum.pm73.dominio.Leilao;
import br.com.caelum.pm73.dominio.Usuario;
import builder.LeilaoBuilder;

public class LeilaoDaoTests {
	
	private Session session;
	private UsuarioDao usuarioDao;
	private LeilaoDao leilaoDao;
	private Usuario usuario;
	private Leilao leilao;
	
	@Before
	public void setUp() {
		session = new CriadorDeSessao().getSession();
		
		usuarioDao = new UsuarioDao(session);
		
		leilaoDao = new LeilaoDao(session);
		
		usuario = new Usuario("Joe", "jose@gmail.com");

		
		Leilao leilao = new LeilaoBuilder().comDono(usuario).comValor(500.00).comNome("Xbox").constroi();
		
		leilaoDao.salvar(leilao);
		usuarioDao.salvar(usuario);		

		session.beginTransaction();
		}
	
	@After
	public void encerra() {
		session.getTransaction().rollback();
		session.close();
	}

	@Test
	public void deveContarLeiloesNaoEncerrados() {
		Leilao encerrado = new LeilaoBuilder().comNome("Aparelho").comDono(usuario).comValor(2.000).constroi();
		encerrado.encerra();
		leilaoDao.salvar(encerrado);
		
		long total = leilaoDao.total();
		
		assertEquals(1L, total);
		
	}
	
	@Test
	public void totalLeiloes0Test() {
		Leilao encerrado2 = new LeilaoBuilder().comNome("Carro").comDono(usuario).comValor(21.000).encerrado().constroi(); 
		leilaoDao.salvar(encerrado2);
		leilao.encerra();
		
		long total = leilaoDao.total();
		
		assertEquals(0L, total);
	
	}
	
	@Test
	public void deveRetornarLeiloesNaoUtilizados() {
		Leilao leilao2 = new LeilaoBuilder().comNome("PS4").comDono(usuario).comValor(1200.00).constroi();
		leilaoDao.salvar(leilao2);
		
		assertEquals(1L, leilaoDao.novos().size());
		assertEquals("Xbox", leilaoDao.novos().get(0).getNome());
	}

	@Test 
	public void deveRetornarLeiloesAntigos(){
		Leilao leilaoAntigo = new LeilaoBuilder().comValor(10000.00).comDono(usuario).comNome("Morte").constroi();
		leilao.setDataAbertura(Calendar.getInstance());
		Calendar dataAntiga = Calendar.getInstance();
		dataAntiga.add(Calendar.DAY_OF_MONTH, -10);
		leilaoAntigo.setDataAbertura(dataAntiga);
		leilaoDao.salvar(leilaoAntigo);
		
		assertEquals(1L, leilaoDao.antigos().size());
		assertEquals("Morte", leilaoDao.antigos().get(0).getNome());
	}
	
	@Test 
	public void retornarLeilaoCriadoHaExatamente7Dias() {
		Calendar dataAbertura = Calendar.getInstance();
		dataAbertura.add(Calendar.DAY_OF_MONTH, -7);
		leilao.setDataAbertura(dataAbertura);
		  List<Leilao> antigos = leilaoDao.antigos();
		assertEquals(1, leilaoDao.antigos().size());
	}

	@Test
	public void retornaLeiloesNaoEncerradosDentroDeUmPeriodo() {
		
		leilao.setDataAbertura(Calendar.getInstance());
		Leilao leilao2 = new LeilaoBuilder().comNome("Carro").comValor(300000.00).comDono(usuario).constroi();
	
		Calendar foraDoIntervalo = Calendar.getInstance();
		foraDoIntervalo.add(Calendar.MONTH, -30);
		leilao2.setDataAbertura(foraDoIntervalo);
		
		leilaoDao.salvar(leilao2);
		leilao2.encerra();
		Calendar dataInicio = Calendar.getInstance();
		dataInicio.add(Calendar.MONTH, -1);
		List<Leilao> porPeriodo = leilaoDao.porPeriodo(dataInicio, Calendar.getInstance());
		
		assertEquals(1L, porPeriodo.size());
		assertEquals("Xbox", porPeriodo.get(0).getNome());
		assertEquals("Carro", porPeriodo.get(1).getNome());

	}
	
	@Test
	public void naoRetornarLeiloesEncerradosDentroDoPeriodo() {
		leilao.setDataAbertura(Calendar.getInstance());
		leilao.encerra();
		
		
		Calendar dataInicio = Calendar.getInstance();
		dataInicio.add(Calendar.MONTH, -1);
		List<Leilao> porPeriodo = leilaoDao.porPeriodo(dataInicio, Calendar.getInstance());
		
		
		assertEquals(0, porPeriodo.size());
	}
	
    @Test
    public void deveRetornarLeiloesDisputados() {
        Usuario mauricio = new Usuario("Mauricio", "mauricio@aniche.com.br");
        Usuario marcelo = new Usuario("Marcelo", "marcelo@aniche.com.br");

        Leilao leilao1 = new LeilaoBuilder()
                .comDono(marcelo)
                .comValor(3000.0)
                .comLance(Calendar.getInstance(), mauricio, 3000.0)
                .comLance(Calendar.getInstance(), marcelo, 3100.0)
                .constroi();

        Leilao leilao2 = new LeilaoBuilder()
                .comDono(mauricio)
                .comValor(3200.0)
                .comLance(Calendar.getInstance(), mauricio, 3000.0)
                .comLance(Calendar.getInstance(), marcelo, 3100.0)
                .comLance(Calendar.getInstance(), mauricio, 3200.0)
                .comLance(Calendar.getInstance(), marcelo, 3300.0)
                .comLance(Calendar.getInstance(), mauricio, 3400.0)
                .comLance(Calendar.getInstance(), marcelo, 3500.0)
                .constroi();

        usuarioDao.salvar(marcelo);
        usuarioDao.salvar(mauricio);
        leilaoDao.salvar(leilao1);
        leilaoDao.salvar(leilao2);

        List<Leilao> leiloes = leilaoDao.disputadosEntre(2500, 3500);

        assertEquals(1, leiloes.size());
        assertEquals(3200.0, leiloes.get(0).getValorInicial(), 0.00001);
    }
	
	
}
