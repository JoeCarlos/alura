package banco;

import java.util.Calendar;
import java.util.List;

public class RelatorioComplexo extends TemplateRelatorio{

	@Override
	protected void cabecalho() {
		System.out.println("BNDES \n08001306 \nAvenida República do Chile, 300");
		
	}

	@Override
	protected void rodape() {
		System.out.println("bndes@gmail.org.br\n" + Calendar.getInstance().getTime());
		
	}

	@Override
	protected void corpo(List<Conta> contas) {
		for (Conta conta : contas) {
			System.out.println("Titular: "+ conta.getTitular() +" - Agencia: " + conta.getAgencia() + 
					"Conta: " + conta.getNumero() + " - Saldo: 1.000.00");
		}
		
	}


}
