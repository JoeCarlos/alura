package br.com.solid.coesao;

public class CalculaSalario15Ou25PorCento implements CalculaSalario{

	@Override
	public double calcular(Funcionario funcionario) {
	     if(funcionario.getSalarioBase() > 2000.0) {
	            return funcionario.getSalarioBase() * 0.75;
	        }
	        else {
	            return funcionario.getSalarioBase() * 0.85;
	        }
	}

}
