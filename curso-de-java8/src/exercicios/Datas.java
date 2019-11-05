 package exercicios;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
	public static void main(String[] args) {
		LocalDate dataAtual = LocalDate.now();
		System.out.println(dataAtual);
		LocalDate diaTal = LocalDate.of(2099, Month.JANUARY, 25);
		System.out.println(diaTal);
		
		Period periodo = Period.between(dataAtual, diaTal);
		System.out.println(periodo);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = formatter.format(dataAtual);
		System.out.println(dataFormatada);
	}
}
