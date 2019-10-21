package cap7;

public class ConcluiPedido implements Comando{

	private Pedido pedido;

	public ConcluiPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	@Override
	public void executa() {
		pedido.finaliza();
		
	}

}
