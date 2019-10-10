package desconto;
import servico.Orcamento;
public interface Desconto {
	public double desconto(Orcamento orcamento);
	public void setProximo(Desconto proximo);
}
