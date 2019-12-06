package br.com.alura.maven;

public class Produto {
	
	private final String nome;
	private final double preco;
	private final String test = "presente";
	
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}


	public String getNome() {
		return nome;
	}


	public double getPreco() {
		// TODO Auto-generated method stub
		return preco;
	}


	public String getTest() {
		return test;
	}


	public double getPrecoComImposto() {
		// TODO Auto-generated method stub
		return preco*1.10;
	}	
	
	
	
}
