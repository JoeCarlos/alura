package banco;

public class Conta {
	private double saldo;
	private String titular;
	private String agencia;
	private String numero;
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
	
	public String getAgencia() {
		return this.agencia;
	}

	public String getNumero() {
		// TODO Auto-generated method stub
		return this.numero;
	}
}
