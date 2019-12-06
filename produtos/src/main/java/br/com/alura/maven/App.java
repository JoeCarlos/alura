package br.com.alura.maven;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Produto produto = new Produto("R2D2", 79.90);
        System.out.println("Quero comprar este " + produto.getTest() + " para ela: " + produto.getNome() + " que custa R$" + produto.getPreco());
    }
}
