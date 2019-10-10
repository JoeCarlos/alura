package servico;
import desconto.Desconto;
import desconto.DescontoPor5Itens;
import desconto.DescontoPorMaisDe500;
import desconto.DescontoPorVendaCasada;
import desconto.SemDesconto;
public class CalculadorDeDesconto {
	public double calculaDesconto(Orcamento orcamento) {
		Desconto d1 = new DescontoPor5Itens();
		Desconto d2 = new DescontoPorMaisDe500();
		Desconto d3 = new DescontoPorVendaCasada();
		Desconto d4 = new SemDesconto();
		
		d1.setProximo(d2);
		d2.setProximo(d3);
		d3.setProximo(d4);
		
		return d1.desconto(orcamento);
	}
}
