package cap7;

import java.util.Calendar;
import java.util.Date;

public class Pedido {
	private String cliente;
	private double valor;
	private Status status;
	private Date dataFinalizacao;
	
	
	public Pedido(String cliente, double valor) {
		this.cliente = cliente;
		this.valor = valor;
	}
	
	public void paga() {
		status = Status.PAGO;
	}	
	
	public void finaliza() {
		dataFinalizacao =  new Relogio().dataAtual();
		status = Status.ENTREGUE;
	}
	
	
}
