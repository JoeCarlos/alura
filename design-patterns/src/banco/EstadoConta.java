package banco;

public interface EstadoConta {
	public void saca(Conta conta, double valor);
	public void deposita(Conta conta, double valor);
}
