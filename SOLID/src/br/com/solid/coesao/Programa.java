package br.com.solid.coesao;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Calendar;

public class Programa {
//	
//	public static void main(String[] args) {
//		Funcionario fun = new Funcionario(1, "Joe", Cargo.DESENVOLVEDOR, Calendar.getInstance(), 3500);
//		double sal = fun.calculaSalario();
//		System.out.println(sal);
//		
//	}
	@Test
	public void TestaSalarioDevMaior3000() {
		Funcionario funcionario = new Funcionario(1, "Joe", Cargo.DESENVOLVEDOR, Calendar.getInstance(), 3500);
		double salario = funcionario.calculaSalario();
		System.out.println(funcionario.calculaSalario());
		assertEquals(2800, salario,0.001);
	}
	
	
}
