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
		session.beginTransaction();
		usuario = new Usuario("Joe", "jose@gmail.com");
		usuarioDao.salvar(usuario);
		leilao = new Leilao("Xbox", 500.00, usuario, false);
		leilaoDao.salvar(leilao);
		}
	
	@After
	public void encerra() {
		session.getTransaction().rollback();
		session.close();
	}

	@Test
	public void deveContarLeiloesNaoEncerrados() {
		Leilao encerrado = new Leilao("Aparelho", 2.000, usuario, false);
		encerrado.encerra();
		leilaoDao.salvar(encerrado);
		
		long total = leilaoDao.total();
		
		assertEquals(1L, total);
		
	}
	
	@Test
	public void totalLeiloes0Test() {
		Leilao encerrado2 = new Leilao("Carro", 21.000, usuario , false);
		leilaoDao.salvar(encerrado2);
		leilao.encerra();
		encerrado2.encerra();
		
		long total = leilaoDao.total();
		
		assertEquals(0L, total);
	
	}
	
	@Test
	public void deveRetornarLeiloesNaoUtilizados() {
		Leilao leilao2 = new Leilao("PS4", 1200.00, usuario, true);
		leilaoDao.salvar(leilao2);
		
		assertEquals(1L, leilaoDao.novos().size());
		assertEquals("Xbox", leilaoDao.novos().get(0).getNome());
	}

	@Test 
	public void deveRetornarLeiloesAntigos(){
		Leilao leilaoAntigo = new Leilao("Morte", 10000.0, usuario, false);
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
		Leilao leilao2 = new Leilao("Carro", 30.000, usuario, false);
	
		Calendar foraDoIntervalo = Calendar.getInstance();
		foraDoIntervalo.add(Calendar.MONTH, -30);
		leilao2.setDataAbertura(foraDoIntervalo);
		
		leilaoDao.salvar(leilao2);
//		leilao2.encerra();
		Calendar dataInicio = Calendar.getInstance();
		dataInicio.add(Calendar.MONTH, -1);
		List<Leilao> porPeriodo = leilaoDao.porPeriodo(dataInicio, Calendar.getInstance());
		
		assertEquals(1L, porPeriodo.size());
		assertEquals("Xbox", porPeriodo.get(0).getNome());
//		assertEquals("Carro", porPeriodo.get(1).getNome());

	}
	
//	@Test
//	public void 
}
