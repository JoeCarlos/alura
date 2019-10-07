
public class CalculadorDeImposto {
	private double icms;
	public void realizaCalculo(Orcamento orcamento, Imposto imposto) {
		 this.icms = imposto.calcula(orcamento);
	}
	public double getValor() {
		return this.icms;
	}
	 
}
