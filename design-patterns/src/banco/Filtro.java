package banco;

import java.util.ArrayList;
import java.util.List;

public abstract class Filtro {
	protected Filtro outroFiltro;
	private List<Conta> contas;

	public Filtro() {}
	
	public Filtro (Filtro outroFiltro) {
		this.outroFiltro = outroFiltro;
	}
	
	public abstract List<Conta> filtra(List<Conta> contas);

	protected List<Conta> proximo(List<Conta> contas){
		if (outroFiltro != null) {
			return outroFiltro.filtra(contas);
		}
		else 
			return new ArrayList<Conta>();
	}
	
	}

