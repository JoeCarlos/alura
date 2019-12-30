package br.com.alura.maven.lojaweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.maven.Produto;
import br.com.caelum.stella.tinytype.CPF;


@WebServlet(urlPatterns = {"/contato"})
public class ContatoServlet extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			CPF cpf = new CPF("15788668719");
			boolean valido = cpf.isValido();
			Produto produto = new Produto("Coleira", 25.00);
			PrintWriter writer = resp.getWriter();
		
			writer.println("<html><h2>Fale conosco!</h2><br><h3>O cpf de numero " + cpf);
			if(!valido)
				writer.println(" não");
			
			writer.println(" é válido</h3>");
			
			writer.println("<h4>E você comprou "+ produto.getNome() + "</h4></html>");
			writer.close();
		}
}
