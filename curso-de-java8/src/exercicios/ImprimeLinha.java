package exercicios;
import java.util.function.Consumer;

public class ImprimeLinha implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);

	}

}
