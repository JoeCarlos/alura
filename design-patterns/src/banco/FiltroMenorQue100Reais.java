package banco;

import java.util.ArrayList;
import java.util.List;

public class FiltroMenorQue100Reais extends Filtro{
	
	public FiltroMenorQue100Reais() {
		super();
	}
	
    public FiltroMenorQue100Reais(Filtro outroFiltro) {
        super(outroFiltro);
      }

	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> filtrada = new ArrayList<Conta>();
		for (Conta conta : contas) {
			if(conta.getSaldo()<100) {
				filtrada.add(conta);
			}
		}
		filtrada.addAll(proximo(contas));
		return filtrada;
	}
}
