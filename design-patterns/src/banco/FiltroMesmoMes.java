package banco;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FiltroMesmoMes extends Filtro {
	public FiltroMesmoMes() {
		// TODO Auto-generated constructor stub
	}
	
	public FiltroMesmoMes (Filtro outroFiltro) {
		super(outroFiltro);
	}

	@Override
	public List<Conta> filtra(List<Conta> contas) {
		
		List<Conta> filtrada = new ArrayList<Conta>();
		for (Conta conta : contas) {
			
			if (conta.getDataAbertura().get(Calendar.MONTH) == Calendar.getInstance().get(Calendar.MONTH) &&
			conta.getDataAbertura().get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR)){
				filtrada.add(conta);
				System.out.println(conta.getDataAbertura().getTime() + "  --  " + Calendar.getInstance().getTime());
			}
			
		}
		filtrada.addAll(proximo(contas));
		return filtrada;
	}
}
