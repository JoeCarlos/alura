package banco;

import java.util.ArrayList;
import java.util.List;

public class FiltroMaiorQue500MilReais extends Filtro{

	public FiltroMaiorQue500MilReais() {}
	
	public FiltroMaiorQue500MilReais (Filtro outroFiltro) {
		super(outroFiltro);
	}
	
	
	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> filtrada = new ArrayList<Conta>();
		for (Conta conta : filtrada) {
			if (conta.getSaldo()>500000.00) {
				filtrada.add(conta);
			}
		}
		filtrada.addAll(proximo(contas));
		return filtrada;
	}

}
