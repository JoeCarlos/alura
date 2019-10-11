package servico;
import dominio.Orcamento;
import imposto.Imposto;

public class CalculadorDeImposto {
	double valor;
	public void realizaCalculo(Orcamento orcamento, Imposto imposto) {
		valor  = imposto.calcula(orcamento);
		System.out.println("Total de Imposto devido: " + valor);
	}
	public double getValor() {
		return this.valor;
	}
	 
}
