package buz;

import com.fasterxml.jackson.databind.json.JsonMapper;
import dto.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HttpClientCRMTest {

    public final String uri = "https://api.hubapi.com/crm/v3/objects/contacts?limit=10&archived=false";
    // Token will expire in 7 days
    private final String tokenApi = "Bearer pat-eu1-e2ac55c8-e006-4c81-9823-50f8a3d30e06";
    private final String keyAuthorization = "authorization";
    private HttpClient httpClient2;

    @BeforeEach
    public void init(){
        httpClient2 = createHttpClient2();
    }

    private HttpClient createHttpClient2(){
        return HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(5)).build();
    }

    @Test
    public void testGetRequest() throws Exception {

       HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create(uri))
               .GET()
               .setHeader(keyAuthorization, tokenApi)
               .build();

        HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();
        CompletableFuture<HttpResponse<String>> futureResult = httpClient2.sendAsync(request, bodyHandler);

        HttpResponse<String> httpResponse =  futureResult.join();



        JsonMapper mapper = new JsonMapper();
        /* This is record, they are immutable Java 15,
        Records are ideal candidates when modeling things like domain model classes
        (potentially to be persisted via ORM), or data transfer objects (DTOs).*/
        Result results  =  mapper.readValue(httpResponse.body().toString(), Result.class);
        System.out.println(results.toString());

        // This is Object



        assertHttpResponseStatusCodeInSuccessRange(httpResponse);
        assertFalse(httpResponse.headers().firstValue("content-type").isEmpty());
        assertFalse(httpResponse.body().isEmpty());
    }

    @Test
    public void testPostRequest() throws Exception {

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of("src/main/resources/crm/contacts.json")))
                .setHeader( "Content-Type", "application/json")
                .setHeader(keyAuthorization, tokenApi)
                .build();

        HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();
        CompletableFuture<HttpResponse<String>> futureResult = httpClient2.sendAsync(postRequest, bodyHandler);

        HttpResponse<String> httpResponse =  futureResult.join();

        System.out.println(httpResponse.headers().toString());
        System.out.println(httpResponse.body().toString());

        assertHttpResponseStatusCodeInSuccessRange(httpResponse);
        assertTrue(httpResponse.statusCode() == 201);
        assertFalse(httpResponse.headers().firstValue("content-type").isEmpty());
        assertFalse(httpResponse.body().isEmpty());

        /* The 201 status code indicates that the server has successfully
         processed the request, the new resource has been created */
    }

    private void assertHttpResponseStatusCodeInSuccessRange(HttpResponse<?> response) {
        assertTrue(response.statusCode() >= 200 && response.statusCode() < 300 );
    }

}
