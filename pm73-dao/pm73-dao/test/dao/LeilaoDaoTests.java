package dao;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;

import br.com.caelum.pm73.dao.CriadorDeSessao;
import br.com.caelum.pm73.dao.LeilaoDao;
import br.com.caelum.pm73.dao.UsuarioDao;
import br.com.caelum.pm73.dominio.Leilao;
import br.com.caelum.pm73.dominio.Usuario;

public class LeilaoDaoTests {
	
	private Session session;
	private UsuarioDao usuarioDao;
	private LeilaoDao leilaoDao;
	
	
	@Before
	public void setUp() {
		session = new CriadorDeSessao().getSession();
		usuarioDao = new UsuarioDao(session);
		leilaoDao = new LeilaoDao(session);
	}
	
	@After
	public void encerra() {
		session.close();
	}

	public void deveContarLeiloesNaoEncerrados() {
		Usuario usuario = new Usuario("Joe", "jose@gmail.com");
		Leilao ativo = new Leilao("Carro", 21.000, usuario , false);
		Leilao encerrado = new Leilao("Aparelho", 2.000, usuario, false);
		
		usuarioDao.salvar(usuario);
		leilaoDao.salvar(ativo);
		leilaoDao.salvar(encerrado);
		
		long total = leilaoDao.total();
		
		assertEquals(1L, total);
		
	}


}
