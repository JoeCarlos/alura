package financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import financas.modelo.Conta;

public class TesteConta {
	
	public static void main(String[] args) {
		Conta conta = new Conta("Joe", "456", "Caixa", "123");
		
		EntityManagerFactory emf = new JPAUtil().getManager();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
	
		em.close();
		emf.close();
	}
	
}
