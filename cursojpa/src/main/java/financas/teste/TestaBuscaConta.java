package financas.teste;

import javax.persistence.EntityManager;

import financas.modelo.Conta;
import financas.util.JPAUtil;

public class TestaBuscaConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Conta conta = em.find(Conta.class, 3);
		
		System.out.println(conta);
		
		conta.setTitular("YIN");
		
		Conta conta2 = em.find(Conta.class, 3);
		
		System.out.println(conta2);
		
		em.getTransaction().commit();
	}
}
