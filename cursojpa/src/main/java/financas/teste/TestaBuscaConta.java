package financas.teste;

import javax.persistence.EntityManager;

import financas.modelo.Conta;
import financas.util.JPAUtil;

public class TestaBuscaConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Conta conta = em.find(Conta.class, 1);
		
		System.out.println(conta);
		
		
		conta.setTitular("Naruto");
		em.merge(conta);
		
		System.out.println(conta);
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();
		
		conta.setTitular("Itachi");
		em2.merge(conta);
		em2.getTransaction().commit();
		em2.close();
	}
}
