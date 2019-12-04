package financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;

import financas.modelo.Conta;
import financas.modelo.Movimentacao;
import financas.modelo.TipoMovimentacao;
import financas.util.JPAUtil;

public class TesteJPQL {
	
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta =new Conta();
		conta.setId(2);
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta and m.tipo = :pTipo order by m.valor desc";
		Query query = em.createQuery(jpql);
		
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		
		List<Movimentacao> resultados = query.getResultList();
		resultados.stream().forEach(System.out::println);
		em.getTransaction().commit();
		em.close();
		
	}
}
