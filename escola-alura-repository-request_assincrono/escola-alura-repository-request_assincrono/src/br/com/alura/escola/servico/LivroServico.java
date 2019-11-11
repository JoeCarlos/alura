package br.com.alura.escola.servico;

import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import br.com.alura.escola.dao.LivroDAO;
import br.com.alura.escola.modelo.Livro;

public class LivroServico {

	private LivroDAO livroDAO = new LivroDAO();

	public static Livro criar(String linha) {
		String[] split = linha.split(",");
		String nome = split[0];
		String autor = split[2];
		return new Livro(nome, autor);
	}

	public CompletableFuture<HttpResponse<String>> listar() {
		try {
			return livroDAO.listarAssincronamente();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
