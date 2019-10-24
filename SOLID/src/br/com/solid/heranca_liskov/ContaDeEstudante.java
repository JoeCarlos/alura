package br.com.solid.heranca_liskov;

public class ContaDeEstudante extends ContaComum {
	  private int milhas;

	  private ManipuladorDeSaldo manipulador;
	  
	  public ContaDeEstudante () {
		  manipulador = new ManipuladorDeSaldo();
	  }
	    public void deposita(double valor) {
	        this.milhas += (int)valor;
	        this.manipulador.deposita(valor);
	    }

	    public int getMilhas() {
	        return milhas;
	    }
	    
	    public double getSaldo() {
	    	return manipulador.getSaldo();
	    }
	    
}
