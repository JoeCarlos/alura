package br.com.alura.escola.servico;

import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.List;

import br.com.alura.escola.dao.LivroDao;
import br.com.alura.escola.modelo.Curso;
import br.com.alura.escola.modelo.Livro;
import br.com.alura.escola.modelo.Turma;

public class CursoServico {
	AlunoServico alunoServico = new AlunoServico();
	LivroDao dao = new LivroDao();
	
	public List<Livro> buscarLivros(){
		HttpResponse<String> livros = dao.criarResponse();
				return Stream.of(Livros.body().split("\n"))
						.map(LivroServico::criar)
						.collect(Collectors.toList());
	}
	
	public List<Turma> listar() {
		List<Livro> livros = this.buscarLivros();
		
		Curso java = new Curso("Java OO", "Conceitos básicos de OO", "12 horas", livros.get(0));
		Curso spring = new Curso("Spring", "Novidades do spring", "12 horas", livros.get(2));
		Curso ejb = new Curso("EJB", "EJB avançado", "16 horas", livros.get(5));

		return List.of(
				new Turma(LocalDate.of(2019, 4, 3), LocalDate.of(2019,  4, 5), java, alunoServico.listar().get(0) , alunoServico.listar().get(1)),
				new Turma(LocalDate.of(2019, 4, 3), LocalDate.of(2019,  4, 13), spring, alunoServico.listar().get(0)),
				new Turma(LocalDate.of(2019, 4, 17), LocalDate.of(2019, 4, 19), ejb, alunoServico.listar().get(1)));
	}

}
