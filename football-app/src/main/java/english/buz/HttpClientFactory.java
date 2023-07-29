package english.buz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientFactory {

    public final String urlFootball = "https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/football_session/football.json";

    // Since Java 11
    private HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofDays(1)).build();

    public String connectionHttpClient() {
        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .GET()
                    .uri(URI.create(urlFootball))
                    .headers("Accept", "application/xml")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            HttpHeaders headers = response.headers();
            headers.map().forEach((k, v) -> System.out.println(k + ": values are" + v));

            System.out.println(response.statusCode());
            System.out.println(response.body());

            return response.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
