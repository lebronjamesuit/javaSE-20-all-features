package english.buz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

public class HttpClientFactoryTest {

    private static final String urlFootball = "https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/football_session/football.json";
    private static HttpRequest request = null;
    private static HttpClient client = null;

    @BeforeAll
    public static void prepareData() {

        client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.of(10, ChronoUnit.SECONDS)).build();

        request = HttpRequest
                .newBuilder()
                .GET()
                .uri(URI.create(urlFootball))
                .headers("Accept", "application/xml")
                .build();

    }

    // Test Headers, body and status
    @Test
    public void testSendGetRequest() throws IOException, InterruptedException {

        HttpResponse<String> result = client.send(request, HttpResponse.BodyHandlers.ofString());

        HttpHeaders headers = result.headers();
        List<String> strings = headers.map().get("server");

        Assertions.assertNotNull(result.headers());
        assertNotNull(result.body());
        assertEquals(200, result.statusCode());
        assertEquals("AmazonS3", strings.get(0));
    }

    // Purpose: test timeout case
    @Test
    public void testSendGetRequestTimeOut() {

        Duration shortDuration = Duration.of(1, ChronoUnit.MILLIS);
        HttpClient client2 = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(shortDuration).build();

        Executable lambdaExecute = () -> {
            client2.send(request, HttpResponse.BodyHandlers.ofString());
        };
        assertThrows(IOException.class, lambdaExecute);
    }

}
