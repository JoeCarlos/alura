package banco;

public class Negativo implements EstadoConta {

	@Override
	public void saca(Conta conta, double valor) {
		throw new RuntimeException("Sua conta está sem saldo. Não é possivel realizar saque!");

	}

	@Override
	public void deposita(Conta conta, double valor) {
		conta.saldo += valor * 0.95;
		if (conta.saldo > 0) {
			conta.estado = new Positivo();
		}
	}

}
