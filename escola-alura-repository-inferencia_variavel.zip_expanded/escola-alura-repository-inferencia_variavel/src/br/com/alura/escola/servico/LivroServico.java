package br.com.alura.escola.servico;

import br.com.alura.escola.modelo.Livro;

public class LivroServico {

	public static Livro criar (String linha) {
		
		String[] split = linha.split(",");
		String nome = split[0];
		String autor = split[2];
		
		return new Livro(nome, autor);
		
	}
	
}
