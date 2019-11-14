package financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import financas.modelo.Conta;
import financas.modelo.Movimentacao;
import financas.modelo.TipoMovimentacao;
import financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		Conta conta = new Conta("Rae", "306", "Itau", "42");
		
		
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setDescricao("Churrasco");
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal(200.0));
		movimentacao.setConta(conta);
		
		EntityManager em = new  JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(movimentacao);
		em.persist(conta);
		
		em.getTransaction().commit();
		em.close();
	}
	
}
