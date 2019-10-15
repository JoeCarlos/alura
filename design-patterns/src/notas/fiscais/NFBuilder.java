package notas.fiscais;

import java.util.ArrayList;
import java.util.List;

public class NFBuilder {
	private String razaoSocial;
	private String cnpj;
	private List<ItemDaNota> todosItens = new ArrayList<ItemDaNota>();
	private double valorBruto;
	private double impostos;

	public NFBuilder paraEmpresa(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}
	
	public NFBuilder comCnpj (String cnpj) {
		this.cnpj = cnpj;
		return this;
	}
	
	public NFBuilder comItem(ItemDaNota item) {
		todosItens.add(item);
		valorBruto += item.getValor();
		impostos += item.getValor() * 0.05;
		return this;
	}
}
