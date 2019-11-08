package br.com.alura.escola.modelo;

import java.util.List;
import java.time.LocalDate;

public class Turma {
	private LocalDate inicio;
	private LocalDate fim;
	private Curso curso;
	public LocalDate getInicio() {
		return inicio;
	}

	public LocalDate getFim() {
		return fim;
	}

	public Curso getCurso() {
		return curso;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	private List<Aluno> alunos;
	
	public Turma(LocalDate inicio, LocalDate fim, Curso curso, Aluno ...aluno) {
		this.inicio = inicio;
		this.fim = fim;
		this.curso = curso;
		this.alunos = List.of(aluno);
	}
	
}
