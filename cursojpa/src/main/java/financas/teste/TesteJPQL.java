package financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import financas.modelo.Movimentacao;
import financas.util.JPAUtil;

public class TesteJPQL {
	
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String jpql = "select m from Movimentacao m where m.conta.id=7";
		Query query = em.createQuery(jpql);
		List<Movimentacao> resultados = query.getResultList();
		resultados.stream().forEach(m -> System.out.println(m));
		em.getTransaction().commit();
		em.close();
	}
}
