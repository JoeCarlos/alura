package br.com.alura;

public class Aluno {
	private String nome;
	private int numeroMatricula;
	
	public Aluno(String nome, int numeroMatricula) {
		if (nome == null) {
			throw new NullPointerException("Informe o nome!");
		}
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}
	public String getNome() {
		return nome;
	}
	public int getNumeroMatricula() {
		return numeroMatricula;
	}
	
	@Override
	public String toString() {
		return "[Aluno: " + nome + ", matrícula: " + numeroMatricula + "]";
	}
}
