package imposto;

import java.util.Random;

import banco.Conta;
import desconto.Investimento;

public class Moderado implements Investimento {
	private Random random;
	
	public Moderado() {
		this.random = new Random();
	}

	@Override
	public double CalculaInvestimento(Conta conta) {
		if (random.nextInt(2) == 0) 
			return conta.getSaldo()*0.025;
		else return conta.getSaldo()*0.007;		
	}
	
	
}
