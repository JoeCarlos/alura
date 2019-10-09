

public class Conservador implements Investimento{

	@Override
	public double CalculaInvestimento(Conta conta) {
		return conta.getSaldo()*0.008;
	}




}
