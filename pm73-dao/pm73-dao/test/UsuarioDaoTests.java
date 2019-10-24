import org.junit.Test;

import br.com.caelum.pm73.dao.UsuarioDao;
import br.com.caelum.pm73.dominio.Usuario;

import static org.mockito.Mockito.mock;

import javax.management.Query;

import org.hsqldb.Session;

public class UsuarioDaoTests {
	@Test
	public void buscarPorNomeEEmail() {
		Usuario usuario = mock(Usuario.class);
		 Session session  = mock(Session.class);
		Query query = mock(Query.class);
		
		UsuarioDao usuarioDao = new UsuarioDao(session);
	}
}
