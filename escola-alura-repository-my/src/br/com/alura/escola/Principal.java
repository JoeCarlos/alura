package br.com.alura.escola;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.alura.escola.modelo.Curso;
import br.com.alura.escola.modelo.Turma;
import br.com.alura.escola.servico.AlunoServico;
import br.com.alura.escola.servico.TurmaServico;

public class Principal {

	public static void main(String...strings) {

		AlunoServico alunoServico = new AlunoServico();
		TurmaServico turmaServico = new TurmaServico();
//		alunoServico.listar().stream().forEach(System.out::println);
		List<String> alunos = alunoServico.listar().
				stream().flatMap(a -> Stream.ofNullable(a.getNome())).
				map(s -> s.toUpperCase()).collect(Collectors.toList());
	//	System.out.println(alunos);
	
	Map<Curso, List<Turma>> turmasPorCurso = turmaServico.listar().stream()
					.collect.groupingBy(Collectors.groupingBy(Turma::getCurso, Collectors.filtering(a -> a.getInicio().equals(LocalDate.of(2016,06,10), Collectors.toList())));
		System.out.println("Relação de turmas por curso: " + turmasPorCurso);
	}
}
