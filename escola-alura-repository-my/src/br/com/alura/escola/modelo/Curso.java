package br.com.alura.escola.modelo;

public class Curso {
	private String nome;
	private String ementa;
	private String CargaHoraria;
	public Curso(String nome, String ementa, String cargaHoraria) {
		super();
		this.nome = nome;
		this.ementa = ementa;
		CargaHoraria = cargaHoraria;
	}
	
	@Override
	public String toString() {
		return nome + " ";
	}
}
