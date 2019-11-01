package br.com.alura;

import java.util.Set;

public class AlunoTest {
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as colecoes do Java", "Paulo Silveira");
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
	    javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
	    javaColecoes.adiciona(new Aula("Modelando com colecoes", 24));
	    
        Aluno a1 = new Aluno("Rodrigo Turini", 34672);
        Aluno a2 = new Aluno("Guilherme Silveira", 5617);
        Aluno a3 = new Aluno("Mauricio Aniche", 17645);
        
        javaColecoes.matricula(a1);
        javaColecoes.matricula(a2);
        javaColecoes.matricula(a3);
        
        javaColecoes.getAlunos().forEach(aluno -> {
        		System.out.println(aluno);});	
        
        Set<Aluno> alunos = javaColecoes.getAlunos();    
//        alunos.add(new Aluno("Joe", 306));
        
        javaColecoes.estaMatriculado(a1);
        System.out.println(javaColecoes.estaMatriculado(a1));
	} 
		
    
}
