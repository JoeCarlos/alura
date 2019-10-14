package desconto;
import orcamento.Orcamento;
import servico.*;
public class SemDesconto implements Desconto {

	@Override
	public double desconto(Orcamento orcamento) {
		return 0;
	}

	@Override
	public void setProximo(Desconto proximo) {
		
	}
	
}
