package br.com.alura.escola.servico;

import java.util.List;

import br.com.alura.escola.modelo.Curso;

public class CursoServico {
	Curso java = new Curso("Java OO", "Conceitos básicos de OO", "12 horas");
	Curso spring = new Curso("Spring", "Novidades do spring", "12 horas");
	Curso ejb = new Curso("EJB", "EJOB avançado", "16 horas");
	
	public List<Curso> listar(){
		List cursos =  List.of(java, spring, ejb);
		return cursos;
	}
}
