package notas.fiscais;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NFBuilder {
	private String razaoSocial;
	private String cnpj;
	private List<ItemDaNota> todosItens = new ArrayList<ItemDaNota>();
	private double valorBruto;
	private double impostos;
	private Calendar data;
	private String obs;
	private List<AposNFBuilder> acoes = new ArrayList<AposNFBuilder>();;

	public void adicionaAcao (AposNFBuilder acao) {
		this.acoes.add(acao);
		
	}
	
	public NFBuilder paraEmpresa(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}

	public NFBuilder comCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	public NFBuilder com(ItemDaNota item) {
		todosItens.add(item);
		valorBruto += item.getValor();
		impostos += item.getValor() * 0.05;
		return this;
	}

	public NFBuilder naData(Calendar novaData) {
		this.data = novaData;
		return this;
	}

	public NFBuilder comObs(String obs) {
		this.obs = obs;
		return this;
	}
	
    public NFBuilder(List<AposNFBuilder> lista) {
        this.acoes = lista;
      }
	
	public NotaFiscal constroi () {
    	 NotaFiscal nf =  new NotaFiscal(razaoSocial, cnpj, data, valorBruto, impostos, todosItens, obs);
    	 
    	 for (AposNFBuilder acao : acoes) {
			 acao.executa(nf);
		}
    	 
    	 
    	 
    	 return nf;
	}

}
