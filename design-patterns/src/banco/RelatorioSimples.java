package banco;

import java.util.List;

public class RelatorioSimples extends TemplateRelatorio{

	@Override
	protected void cabecalho() {
		System.out.print("Banco do Brasil");
	}

	@Override
	protected void rodape() {
		System.out.println("21 0800-0312");
	}

	@Override
	protected void corpo(List<Conta> contas) {
		for (Conta conta : contas) {
			System.out.println("Titular: " + conta.getTitular() + " - Saldo: " + conta.getSaldo());
		}
	}

}
