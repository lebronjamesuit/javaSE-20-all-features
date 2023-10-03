package buz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import dto.Result;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class HttpClientCRM {

    public static final String uri = "https://api.hubapi.com/crm/v3/objects/contacts?limit=10&archived=false";
    // Token will expire in 7 days
    private static final String tokenApi = "Bearer pat-eu1-e2ac55c8-e006-4c81-9823-50f8a3d30e06";
    private static final String keyAuthorization = "authorization";
    private static HttpClient httpClient2 = createHttpClient2();



    private static HttpClient createHttpClient2(){
        return HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(5)).build();
    }

    public static void main(String... args) throws JsonProcessingException {

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
    }



}
