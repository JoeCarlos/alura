package br.com.alura.escola.modelo;

public class Livro {

	public Livro(String nome, String autor) {
		this.nome = nome;
		this.autor = autor;
	}

	private String nome;
	private String autor;

	public String getAutor() {
		return autor;
	}

	public String getNome() {
		return nome;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
