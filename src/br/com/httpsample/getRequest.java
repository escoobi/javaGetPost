package br.com.httpsample;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;


public class getRequest {

    //private static final String url = "https://jsonplaceholder.typicode.com/posts";
    private static final String url = "http://httpbin.org/get";
    public static void main(String[] args) throws IOException, InterruptedException {
        // Nosso cliente http
        HttpClient newHttpClient = HttpClient.newHttpClient();

        // Criar a requisição q será enviada.

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(url))
                .build();

        // enviando uma solicitação

        HttpResponse<String> response = newHttpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());

    }
}
