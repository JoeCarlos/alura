package br.com.alura;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Curso {
	private String nome;
	private String instrutor;
	private List<Aula> aulas = new LinkedList<Aula>();
	private int tempoTotal;
	private Set<Aluno> alunos = new HashSet<>();
	
	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getNome() {
		return nome;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}

	public void adiciona(Aula aula) {
		aulas.add(aula);
		tempoTotal = getTempoTotal() + aula.getTempo();
	}

	@Override
	public String toString() {
		return "[" + "Curso: " + nome + ", " + "tempo total: " + getTempoTotal() + ", Aulas: " + aulas +"]";
	}

	public int getTempoTotal() {
		return tempoTotal;
	}

	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}
	
	public void matricula(Aluno aluno){
	    this.alunos.add(aluno);
	}

}
