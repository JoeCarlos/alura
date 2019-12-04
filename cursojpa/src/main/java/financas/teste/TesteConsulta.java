package financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import financas.modelo.Categoria;
import financas.modelo.Movimentacao;
import financas.util.JPAUtil;

public class TesteConsulta {
	 public static void main(String[] args) {

	        EntityManager em = new JPAUtil().getEntityManager();
	        em.getTransaction().begin();

	        Categoria categoria = new Categoria();
	        categoria.setId(2);

	        String jpql = "select m from Movimentacao m left join m.categoria c where c = :pCategoria";

	        Query query = em.createQuery(jpql);
	        query.setParameter("pCategoria", categoria);

	        List<Movimentacao> resultados = query.getResultList();

	        //...
}
}
