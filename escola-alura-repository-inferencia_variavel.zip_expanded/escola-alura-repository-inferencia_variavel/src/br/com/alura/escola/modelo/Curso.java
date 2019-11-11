package br.com.alura.escola.modelo;

public class Curso {

	private String nome;
	private String ementa;
	private String cargaHoraria;
	private Livro livro;

	public Curso(String nome, String ementa, String cargaHoraria, Livro livro) {
		this.nome = nome;
		this.ementa = ementa;
		this.cargaHoraria = cargaHoraria;
		this.livro = livro;
	}

	@Override
	public String toString() {
		return nome + " ";
	}

	public String getNome() {
		return nome;
	}

	public String getEmenta() {
		return ementa;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public Livro getLivro() {
		return livro;
	}
	
	public String getNomeLivro() {
		return livro.getNome();
	}

}
