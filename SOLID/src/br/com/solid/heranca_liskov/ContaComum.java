package br.com.solid.heranca_liskov;

public class ContaComum {

	ManipuladorDeSaldo manipulador;
	
	
    public ContaComum() {
       this.manipulador = new ManipuladorDeSaldo();
    }
    
    public void rende() {
    	this.manipulador.rende(1.1);
    }
    public double getSaldo() {
    	return manipulador.getSaldo();
    }

	public void deposita(double valor) {
		manipulador.deposita(valor);
		
	}
}
