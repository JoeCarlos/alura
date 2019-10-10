package servico;
import banco.Conta;
import desconto.Investimento;

public class RealizadorDeInvestimento {
	
	public void realizaInvestimento(Conta conta, Investimento investimento) {
		double resultado = investimento.CalculaInvestimento(conta);
		conta.deposita(resultado*0.75);
		System.out.println("Novo Saldo: " + conta.getSaldo());
	}
}
