package exercicios;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaEForEach {
	public static void main(String[] args) {
		palavras.forEach(new Consumer<String>(){
		    public void accept(String palavra) {
		        System.out.println(palavra);
		    }
		});
		
		//com lambda
		palavras.forEach((palavra) -> System.out.println(palavra));
		
	
		palavras.sort(new Comparator<String>() {
		    @Override
		    public int compare(String s1, String s2) {
		        if(s1.length() < s2.length()) 
		            return -1;
		        if(s1.length() > s2.length()) 
		            return 1;
		        return 0;
		    }
		});
		
		//com lambda
		
		palavras.sort(( s1,  s2) ->{
		        if(s1.length() < s2.length()) 
		            return -1;
		        if(s1.length() > s2.length()) 
		            return 1;
		        return 0;
			});
		
		//lambda + Integer
		
		palavras.sort(( s1,  s2) -> Integer.compare(s1.length(), s2.length()));
		
		// ainda melhor, sem compare
		
		palavras.sort(( s1,  s2) -> s1.length()-s2.length());
		
		//Considere o seguinte código que executa um Runnable em uma Thread: Como podemos escrevê-lo usando uma expressão lambda?
		new Thread(()-> System.out.println("Executando um Runnable")).start();
		new Thread(() -> System.out.println("Executando um Runnable")).start();
	}
	
	
	palavras.sort(Comparator.comparing(String::length));
	//com
	
	palavras.sort(String.CASE_INSENSITIVE_ORDER);
}
