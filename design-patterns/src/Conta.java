
public class Conta {
	private double saldo;
	
	public Conta (double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return this.saldo;
	}
	
	public void deposita(double valor) {
		this.saldo += valor;
	}
	
}
