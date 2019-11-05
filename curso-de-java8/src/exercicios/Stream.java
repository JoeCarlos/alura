package exercicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Stream {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("JavaScript", 100));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		cursos.forEach(System.out::println);
		
		System.out.println("-----------------------------");
		
		cursos.stream().filter(c -> c.getAlunos()>50).sorted(Comparator.comparing(Curso::getNome)).forEach(System.out::println);
		
		System.out.println("-------------------------------------------");
	
		java.util.stream.Stream<String> nomes = cursos.stream().map(Curso::getNome);
		
		System.out.println("--------------------------");
		
		cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .map(Curso::getAlunos)
		   .forEach(System.out::println);
		
		System.out.println("--------------------------");
		
		System.out.println(cursos.stream()
		   .filter(c -> c.getAlunos() > 50).findFirst().toString());
		Optional<Curso> primeiro = cursos.stream()
		   .filter(c -> c.getAlunos() > 50).findFirst();
		System.out.println("Primeiro Curso " + primeiro);
		
	
		System.out.println("--------------------------");
		OptionalDouble media = cursos.stream().mapToInt(Curso::getAlunos).average();
		System.out.println("A media de alunos por curso é de " + media);
		
		System.out.println("--------------------------");
		 List<Curso> cursos50 = cursos.stream()
				   .filter(c -> c.getAlunos() > 50).collect(Collectors.toList());
		 System.out.println(cursos50);
	}
		
	
}
