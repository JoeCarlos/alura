package banco;

import java.util.Calendar;

public class Conta {
	private double saldo;
	private String titular;
	private String agencia;
	private String numero;
	private Calendar dataAbertura;
	public Conta (String titular, double saldo, Calendar dataAbertura) {
		this.saldo = saldo;
		this.titular = titular;
		this.dataAbertura = dataAbertura;
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

	public Calendar getDataAbertura() {
		// TODO Auto-generated method stub
		return dataAbertura.getInstance();
	}
}
