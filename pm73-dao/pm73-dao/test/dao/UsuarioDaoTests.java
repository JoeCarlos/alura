package dao;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.pm73.dao.CriadorDeSessao;
import br.com.caelum.pm73.dao.UsuarioDao;
import br.com.caelum.pm73.dominio.Usuario;

public class UsuarioDaoTests {
	
	private Session session;
	private UsuarioDao usuarioDao;
	private Usuario usuario;
	@Before
	public void setup() {
		session = new CriadorDeSessao().getSession();
		usuarioDao = new UsuarioDao(session);
		usuario = new Usuario("João da Silva", "joao@dasilva.com.br");	
		usuarioDao.salvar(usuario);
		session.beginTransaction();
	}
	@After
	public void fecha() {
		session.getTransaction().rollback();
		session.close();
	}
	
	@Test
	public void buscarPorNomeEEmail() {
	        
	        
	        Usuario usuario = usuarioDao
	                .porNomeEEmail("João da Silva", "joao@dasilva.com.br");

	        assertEquals("João da Silva", usuario.getNome());
	        assertEquals("joao@dasilva.com.br", usuario.getEmail());
	     

	}
	
	@Test 
	public void dveRetornarNuloPorNomeEEmail() {
		Usuario usuario = usuarioDao.porNomeEEmail("Joe", "jose.ozelzo10@gmail.com");
		
		assertNull(usuario);

	}
	
	@Test
	public void deletaUsuario() {
		usuarioDao.deletar(usuario);
        session.flush();
		Usuario usuarioBanco = usuarioDao.porNomeEEmail("João da Silva", "joa@dasilva.com.br");
		assertNull(usuarioBanco);
		
	}
	
	@Test 
	public void alteraUsuario() {
		usuario.setNome("Joe");
		usuario.setEmail("Yin@Yang");
		usuarioDao.atualizar(usuario);
		
		session.flush();
		Usuario usuarioBanco = usuarioDao.porNomeEEmail("Joe", "Yin@Yang");
		assertNotNull(usuarioBanco);
		System.out.println(usuarioBanco.getNome());
	
		Usuario usuarioBancoAntigo = usuarioDao.porNomeEEmail("João da Silva", "joa@dasilva.com.br");
		assertNull(usuarioBancoAntigo);
	}
}
