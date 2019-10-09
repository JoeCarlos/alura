
public class CalculadorDeDesconto {
	public double calculaDesconto(Orcamento orcamento) {
		Desconto d1 = new DescontoPor5Itens();
		Desconto d2 = new DescontoPorMaisDe500();
		Desconto d3 = new SemDesconto();
		
		d1.setProximo(d2);
		d2.setProximo(d3);
		
		return d1.desconto(orcamento);
	}
}
