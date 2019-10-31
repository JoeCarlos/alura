package br.com.alura;

import java.util.*;

public class ImprimindoAlunosSemAcentos {

    public static void main(String[] args) {

        Set<String> alunos = new HashSet<>();
        alunos.add("Paulo");
        alunos.add("Rae");
        alunos.add("Alberto");
        alunos.add("YIN");
        alunos.add("Pedro");    
        alunos.add("Joe");
        alunos.add("Cabeção");
        alunos.add("Nico");    
        alunos.add("Nico");    
        alunos.add("Nico");    

        for (String aluno : alunos) {
			System.out.println(aluno);
		}
    }
}
//
//Joe
//Paulo
//Nico
//Alberto
//Pedro
