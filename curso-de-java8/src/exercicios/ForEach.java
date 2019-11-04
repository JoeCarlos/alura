package exercicios;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ForEach {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");

		for (String string : palavras) {
			System.out.println(string);
		}

		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		System.out.println("---------------------------");
		Consumer<String> consumidor = new ImprimeLinha();
		palavras.forEach(consumidor);

		Consumer<String> comparador2 = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t + " -  com classe anônima");
			}
		};
		System.out.println("----------------------------");
		palavras.forEach(comparador2);

		System.out.println("----------------------------");

		palavras.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t + " - com classe anonima por parâmetro!");

			}
		});

		System.out.println("----------------------------");

		palavras.forEach(System.out::println);
	}

}
