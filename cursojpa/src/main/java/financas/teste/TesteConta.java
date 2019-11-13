package financas.teste;

import javax.persistence.EntityManager;

import financas.modelo.Conta;
import financas.util.JPAUtil;

public class TesteConta {
	
	public static void main(String[] args) {
//		Conta conta = new Conta("Joe", "456", "Caixa", "sss");
		Conta conta = new Conta();
		conta.setAgencia("546");
		conta.setBanco("Bradesco");
		conta.setNumero("12323");
		conta.setTitular("Joe");
		
		System.out.println(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.createQuery("FROM Conta", Conta.class).getResultList();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
	
		em.close();
	}
	
}
