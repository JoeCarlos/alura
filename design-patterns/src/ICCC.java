

public class ICCC implements Imposto {

	@Override
	public double calcula(Orcamento orcamento) {
		double resultado = 0;
		
			if (orcamento.getValor()<1000)
				resultado = orcamento.getValor()*0.05;
			else if ((orcamento.getValor()>=1000)&&(orcamento.getValor()<=3000))
				resultado = orcamento.getValor()*0.07;
			else if (orcamento.getValor()>3000)
				resultado = orcamento.getValor()*0.08+30;
			
		return resultado;
	}

}
