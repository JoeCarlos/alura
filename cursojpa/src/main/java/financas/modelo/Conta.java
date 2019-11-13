package financas.modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;


@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titular;
	private String numero;
	private String banco;
	private String agencia;

	public Conta(String titular, String numero, String banco, String agencia) {
		this.titular = titular;
		this.numero = numero;
		this.banco = banco;
		this.agencia = agencia;
	}
	
	public Conta() {
		
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}


	public String getTitular() {
		return titular;
	}

	public String getNumero() {
		return numero;
	}

	public String getBanco() {
		return banco;
	}

	public String getAgencia() {
		return agencia;
	}
	
	@Override
	public String toString() {
		return titular + " - " + numero + " - " + banco + " agencia ";
	}

}
