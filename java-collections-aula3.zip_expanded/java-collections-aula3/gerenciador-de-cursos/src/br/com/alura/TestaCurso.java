package br.com.alura;

import java.util.List;

public class TestaCurso {
	public static void main(String[] args) {
		long tempoInicio = System.currentTimeMillis();
		
		Curso javaColecoes = new Curso("Dominando as colecoes do Java", "Paulo Silveira");

		List<Aula> aulas = javaColecoes.getAulas();
		System.out.println(aulas);

//		javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21));

		for(int i = 0; i<= 10000; i++) {
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com colecoes", 24));
		}
		System.out.println(aulas);
		System.out.printf("%.3f segundos%n", (System.currentTimeMillis() - tempoInicio) / 1000d);
	}
}
