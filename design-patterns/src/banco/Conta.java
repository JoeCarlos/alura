package banco;

import java.util.Calendar;

public class Conta {
	protected double saldo;
	private String titular;
	private String agencia;
	private String numero;
	private Calendar dataAbertura;
	protected EstadoConta estado;
	
	public Conta (String titular, double saldo, Calendar dataAbertura) {
		this.saldo = saldo;
		this.titular = titular;
		this.estado = new Positivo();
		this.dataAbertura = dataAbertura;
	}

	public Conta(String string, int i) {
		this.saldo = saldo;
		this.titular = titular;
	}

	public double getSaldo() {
		return this.saldo;
	}
	
	public void deposita(double valor) {
		estado.deposita(this, valor);
	}
	
	public void saca(double valor) {
		estado.saca(this, valor);
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

	public Calendar getDataAbertura() {
		// TODO Auto-generated method stub
		return dataAbertura.getInstance();
	}
}
