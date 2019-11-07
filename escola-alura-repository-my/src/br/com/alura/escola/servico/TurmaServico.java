package br.com.alura.escola.servico;

import java.time.LocalDate;
import java.util.List;

import br.com.alura.escola.modelo.Turma;

public class TurmaServico {
	AlunoServico alunoServico = new AlunoServico();
	CursoServico cursoServico = new CursoServico();
	
	public List<Turma> listar(){
		return List.of (
		new Turma(new Turma(LocalDate.of(2019, , 06, 10), LocalDate.of(2019, 06, 17), cursoServico.listar().get(0), alunoServico.listar().get(0), alunoServico.listar().get(1))),
		new Turma(new Turma(LocalDate.of(2019, , 06, 10), LocalDate.of(2019, 06, 17), cursoServico.listar().get(1), alunoServico.listar().get(2)))); 
	}
}
