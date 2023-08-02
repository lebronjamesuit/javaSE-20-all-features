package buz;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class HttpClientFactory {

    public final String urlFootball = "https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/football_session/football.json";

    // Since Java 11 - Synchronous -
    public  HttpResponse<String> connectionHttpClientSynchronous() {

        HttpClient client = HttpClient.newBuilder()
                // Default is HTTP_1_1
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(10)).build();

        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    // GET is the default,
                    .GET()
                    .uri(URI.create(urlFootball))
                    .headers("Accept", "application/xml")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            HttpHeaders headers = response.headers();
            headers.map().forEach((k, v) -> System.out.println(k + ": values are" + v));

            return response;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

     public  HttpResponse<String> connectionHttpClientAsynchronous(){
         HttpClient client = HttpClient.newBuilder()
                 .version(HttpClient.Version.HTTP_2)
                 .connectTimeout(Duration.ofSeconds(10)).build();

         HttpRequest request = HttpRequest.newBuilder()
                 .GET()
                 .uri(URI.create(urlFootball))
                 .setHeader("User-Agent", "Java 11 HttpClient ")
                 .headers("Accept", "application/xml")
                 .build();


         CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
         HttpResponse<String> responseString = future.join();


         return responseString;
    }

}
