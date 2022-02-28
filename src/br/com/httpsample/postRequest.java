package br.com.httpsample;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class postRequest {

    private static final String url = "http://httpbin.org/forms/post";
    private static final String arquivo = "C:\\Users\\gusta\\IdeaProjects\\HttpSample\\src\\br\\com\\httpsample\\pedido.json";

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient newHttpClient = HttpClient.newHttpClient();


        // Criar a requisição q será enviada.

        HttpRequest request = HttpRequest.newBuilder()
                //.POST(HttpRequest.BodyPublishers.ofFile(Path.of(arquivo)))
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(url))
                .build();

        newHttpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

    }
}
