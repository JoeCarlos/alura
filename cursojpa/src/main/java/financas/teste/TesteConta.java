package financas.teste;

import javax.persistence.EntityManager;

import financas.modelo.Conta;
import financas.util.JPAUtil;

public class TesteConta {
	
	public static void main(String[] args) {
//		Conta conta = new Conta("Joe", "456", "Caixa", "sss");
		Conta conta = new Conta();
		conta.setAgencia("5434");
		conta.setBanco("Itau");
		conta.setNumero("123343");
		conta.setTitular("Yin");
		
		System.out.println(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.createQuery("FROM Conta", Conta.class).getResultList();
		
		em.getTransaction().begin();
		conta = em.find(Conta.class, 2);
		em.remove(conta);
		conta.setBanco("Caixa");
		em.getTransaction().commit();
	
		em.close();
	} //Teste push new user name
//	Push com novo email
	
}
