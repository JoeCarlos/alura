package banco;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestaRequisicao {
	
//	private Conta conta;
//	private Requisicao requisicao;
//	private Resposta reposta;
//
//	@Before
//	public void setUp() {
//		conta = new Conta("Joe",2000);
//	}
	
//	@Test
//	public static void testaRequisicaoXml() {
//		requisicao = new Requisicao(Formato.XML);
//		reposta.responde(requisicao, conta);
//	}
	public static void main(String[] args) {
		Conta conta = new Conta("Joe",2000);
		Requisicao requisicao;
		Resposta reposta = new RespostaEmXml();
		requisicao = new Requisicao(Formato.XML);
		reposta.responde(requisicao, conta);	
		
		requisicao = new Requisicao(Formato.PORCENTO);
		Resposta resposta2 = new RespostaEmPorCento();
		resposta2.responde(requisicao, conta);
//		
		
		requisicao = new Requisicao(Formato.CSV);
		Resposta resposta3 = new RepostaEmCsv();
		resposta3.responde(requisicao, conta);
		
	}
}
