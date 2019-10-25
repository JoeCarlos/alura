package dao;
import static org.junit.Assert.assertEquals;
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
	
	@Before
	public void setup() {
		session = new CriadorDeSessao().getSession();
		usuarioDao = new UsuarioDao(session);
	}
	@After
	public void fecha() {
		session.close();
	}
	
	@Test
	public void buscarPorNomeEEmail() {
	        
	        Usuario novoUsuario = new Usuario("João da Silva", "joao@dasilva.com.br");
	        usuarioDao.salvar(novoUsuario);
	        
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
}
