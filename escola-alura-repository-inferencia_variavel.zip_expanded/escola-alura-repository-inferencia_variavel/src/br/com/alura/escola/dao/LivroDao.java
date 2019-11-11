package br.com.alura.escola.dao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LivroDao {

	public HttpResponse<String> criarResponse() throws URISyntaxException, IOException, InterruptedException{
		HttpClient cliente = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build();
		HttpRequest request = HttpRequest.newBuilder(new URI("https:turini.github.io/livro-java-9/books.csv")).GET().build();
		return cliente.send(request, HttpResponse.BodyHandlers.ofString());
		
	}
	
}
