package desconto;
import orcamento.Orcamento;
public interface Desconto {
	public double desconto(Orcamento orcamento);
	public void setProximo(Desconto proximo);
}
