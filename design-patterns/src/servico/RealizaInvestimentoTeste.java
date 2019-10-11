package servico;
import org.junit.Before;
import org.mockito.Mock;

import banco.Conta;
public class RealizaInvestimentoTeste {
	@Before
	public void setUp() {
		Conta conta = new Conta("Joe",1000);
		//Conta contaMock = mock(Conta.class);
	}
}
