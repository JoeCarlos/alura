package financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import financas.modelo.Cliente;
import financas.modelo.Conta;
import financas.util.JPAUtil;

public class TestaContaCliente {
		
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("YIN");
		cliente.setEndereco("Rua J, 306");
		cliente.setProfisssao("Dona de Casa");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("YANG");
		cliente2.setEndereco("Rua J, 306");
		cliente2.setProfisssao("Estagiario TI");
		
		Conta conta = new Conta();
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		conta = em.find(Conta.class, 1);
		cliente.setConta(conta);
//		cliente2.setConta(conta);
		em.persist(cliente);
		em.persist(cliente2);
		em.getTransaction().commit();
		em.close();
	}
	
}
