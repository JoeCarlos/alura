package br.com.alura;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TesteRecibo {
	public static void main(String[] args) {
		Recibo rc1 = new Recibo("Carro");
		Recibo rc2 = new Recibo("Bicicleta");
		Recibo rc3 = new Recibo("Chocolate");
		Collection<Recibo> recibos = new TreeSet<Recibo>();
		recibos.add(rc1);
		recibos.add(rc2);
		recibos.add(rc3);
		
//		List<String> letras = new LinkedList<>();
//		letras.add("A");
//		letras.add("B");
//		letras.add("C");

//		letras.forEach(letra -> {
//		    System.out.println(letra);
//		});
		
//		Iterator<String> it = letras.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
//		
	}
}
