package br.com.solid.opc_dip;

public class CalculadoraDePrecos {

	private TabelaDePreco tabela;
	private Frete servicoDeEntrega;
	public CalculadoraDePrecos(TabelaDePreco tabela, Frete servicoDeEntrega) {
		this.tabela = tabela;
		this.servicoDeEntrega = servicoDeEntrega;
	}
    public double calcula(Compra produto) {
        double desconto = tabela.descontoPara(produto.getValor());
        double frete = servicoDeEntrega.para(produto.getCidade());

        return produto.getValor() * (1-desconto) + frete;
    }
}
