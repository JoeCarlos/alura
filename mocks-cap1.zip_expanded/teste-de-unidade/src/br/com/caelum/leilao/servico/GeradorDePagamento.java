package br.com.caelum.leilao.servico;

import java.util.Calendar;
import java.util.List;

import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Pagamento;
import br.com.caelum.leilao.infra.dao.RepositorioDeLeiloes;
import br.com.caelum.leilao.infra.dao.RepositorioDePagamentos;

public class GeradorDePagamento {
	private final RepositorioDeLeiloes leiloes;
	private final Avaliador avaliador;
	private final RepositorioDePagamentos pagamentos;
	public GeradorDePagamento(RepositorioDeLeiloes leiloes,RepositorioDePagamentos pagamentos, Avaliador avaliador) {
		this.leiloes = leiloes;
		this.pagamentos = pagamentos;
		this.avaliador = avaliador;
	}
	
	public void gera () {
	List<Leilao> leiloesEncerrados = this.leiloes.encerrados();
	for (Leilao leilao : leiloesEncerrados) {
		this.avaliador.avalia(leilao);
		Pagamento pagamento = new Pagamento(avaliador.getMaiorLance(),primeiroDiaUtil());
		this.pagamentos.salva(pagamento);
	}
	}

	private Calendar primeiroDiaUtil() {
		Calendar data = Calendar.getInstance();
		int diaDaSemana = data.get(Calendar.DAY_OF_WEEK);
//		if (diaDaSemana == Calendar.SATURDAY)
		return null;
	}
}
