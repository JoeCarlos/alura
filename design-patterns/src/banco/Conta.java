package banco;

public class Conta {
	private double saldo;
	private String titular;
	public Conta (String titular, double saldo) {
		this.saldo = saldo;
		this.titular = titular;
	}

	public double getSaldo() {
		return this.saldo;
	}
	
	public void deposita(double valor) {
		this.saldo += valor;
	}

	public String getTitular() {
		return titular;
	}
	
}
