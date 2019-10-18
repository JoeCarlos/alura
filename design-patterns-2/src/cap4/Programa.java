package cap4;

public class Programa {
	public static void main(String[] args) {
		Expressao esquerda = new Subtracao(new Numero(10),new Numero(9));
		Expressao direita =  new Soma (new Numero(10), new Soma(new Numero(30), new Numero(1)));
		
		Expressao conta = new Soma(esquerda, direita);
		
		int resultado = conta.avalia();
		System.out.println(resultado);
		
		
		
		
		Expressao raiz = new RaizQuadrada(new Numero(30));
		int res = raiz.avalia();
		System.out.println(res);
	}
}
