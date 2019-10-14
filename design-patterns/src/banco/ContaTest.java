package banco;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

public class ContaTest {
	@Test
	public void FiltroMesTest() {
		Conta conta = new Conta("Joe", 50, Calendar.getInstance());
		List<Conta> contas= new ArrayList<Conta>();
		contas.add(conta);
		Filtro filtro = new FiltroMesmoMes();
		assertEquals(1, filtro.filtra(contas).size());
	}
}
