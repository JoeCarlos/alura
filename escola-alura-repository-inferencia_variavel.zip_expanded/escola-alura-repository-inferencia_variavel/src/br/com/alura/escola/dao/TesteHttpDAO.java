package br.com.alura.escola.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class TesteHttpDAO {
	
	public void testarConexaoHttp2() throws IOException, URISyntaxException, InterruptedException {
		
		URI uri = new URI("https://www.facebook.com.br");
		
		HttpClient client= HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build();
		
		HttpRequest req = HttpRequest.newBuilder(uri).GET().build();
		
		HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(resp.statusCode());
	}
	
	public void testarConexaoHttp1() throws IOException {
		URL url = new URL("https://www.facebook.com.br");
		URLConnection urlConnection = url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line;
		
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
	}
}
