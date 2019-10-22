package br.com.solid.coesao;

public class CalculaSalario10Ou20PorCento implements CalculaSalario{

	@Override
	public double calcular(Funcionario funcionario) {
        if(funcionario.getSalarioBase() > 3000.0) {
            return funcionario.getSalarioBase() * 0.8;
        }
        else {
            return funcionario.getSalarioBase() * 0.9;
        }
		
	}

}
