package desconto;
import orcamento.Orcamento;
public class DescontoPor5Itens implements Desconto{

	private Desconto proximo;

	@Override
	public double desconto(Orcamento orcamento) {
		if (orcamento.getItens().size() > 5 ) {
			return orcamento.getValor() * 0.1;
		}
		else 
			return proximo.desconto(orcamento);
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
		
		
	}
	
}
