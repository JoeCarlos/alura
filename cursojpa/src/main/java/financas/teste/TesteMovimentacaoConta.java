package financas.teste;

import javax.persistence.EntityManager;

import financas.modelo.Conta;
import financas.modelo.Movimentacao;
import financas.util.JPAUtil;

public class TesteMovimentacaoConta {

    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Movimentacao movimentacao = em.find(Movimentacao.class, 13);
        Conta conta = movimentacao.getConta();

        System.out.println(conta.getTitular()); 
        System.out.println(conta.getMovimentacoes().size());
    }
    
}