package br.com.alura.escola.servico;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.alura.escola.dao.LivroDAO;
import br.com.alura.escola.modelo.Curso;
import br.com.alura.escola.modelo.Livro;

public class CursoServico {

	LivroDAO livroDAO = new LivroDAO();

	public List<Livro> pegarLivros() {
		HttpResponse<String> livrosApi = livroDAO.listarSincronamente();
		return Stream.of(livrosApi.body().split("\n"))
				.map(LivroServico::criar)
				.collect(Collectors.toList());
	}

	public List<Curso> listar() {
		List<Livro> livros = pegarLivros();
		Curso java = new Curso("Java OO", "Conceitos básicos de OO", "12 horas", livros.get(0));
		Curso spring = new Curso("Spring", "Novidades do spring", "12 horas", livros.get(1));
		Curso ejb = new Curso("EJB", "EJB avançado", "16 horas", livros.get(4));
		return List.of(java, spring, ejb);
	}
}