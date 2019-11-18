package financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.swing.JApplet;

import financas.modelo.Categoria;
import financas.modelo.Conta;
import financas.modelo.Movimentacao;
import financas.modelo.TipoMovimentacao;
import financas.util.JPAUtil;

public class TesteMovimentacoesComCategoria {
	
	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria = new Categoria("Negocios");

		Conta conta = new Conta();
		conta.setId(1);
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescricao("Viagem a SP");
		movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal("100"));
		movimentacao1.setCategoria(Arrays.asList(categoria,categoria1));
		
		movimentacao1.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("Viagem ao RJ");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("300"));
		movimentacao2.setCategoria(Arrays.asList(categoria,categoria1));
		
		movimentacao2.setConta(conta);
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(categoria);
		em.persist(categoria1);
		em.persist(movimentacao1);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		em.close();
	}
}
