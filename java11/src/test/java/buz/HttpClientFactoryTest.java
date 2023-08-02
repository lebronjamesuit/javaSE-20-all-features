package buz;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HttpClientFactoryTest {

    public final String URI_FOOTBALL = "https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/football_session/football.json";
    public final String URI_HUGEDATA = "https://restcountries.com/v3.1/all";

    private HttpClientFactory httpClientFactory;

    private HttpClient httpClient1;
    private HttpClient httpClient2;

    @BeforeEach
    public void init(){
        httpClient1 = createHttpClient1();
        httpClient2 = createHttpClient2();
    }

  /*  HTTP/1.1 loads resources one after the other,
    so if one resource cannot be loaded, it blocks all the other resources behind it.*/
    private HttpClient createHttpClient1() {
       return HttpClient.newBuilder()
                // Default is HTTP_1_1
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(2)).build();
    }

   /* HTTP/2 is able to use a single TCP connection
    to send multiple streams of data at once so that
    no one resource blocks any other resource*/
    private HttpClient createHttpClient2(){
        return HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(2)).build();
    }

    /**
     * Provides a basic example of using {@link HttpClient} to make a (blocking) HTTP GET request, including building
     * the HTTP request, sending the request, and processing the HTTP response, including retrieving the status code, a
     * named header, and deserialising the response body to string.
     *
     */
    @Test
    public void testGetRequest() throws Exception {
        var request = HttpRequest.newBuilder()
                .uri(URI.create(URI_FOOTBALL))
                // HTTP method defaults to GET if not specified
                .build();

        HttpResponse<String> response = httpClient1.send(request, HttpResponse.BodyHandlers.ofString());

        assertHttpResponseStatusCodeInSuccessRange(response);
        assertFalse(response.headers().firstValue("content-type").isEmpty());
        assertFalse(response.body().isEmpty());
    }

    /**
     * Provides an example of the support that {@link HttpClient} provides for executing requests asynchronously in a
     * non-blocking fashion using {@link HttpClient#sendAsync(HttpRequest, HttpResponse.BodyHandler)}. The method
     * returns a {@link CompletableFuture} which can be used to compose processing of the response in a separate thread.
     *
     * @throws Exception if an unexpected error occurs.
     * @see #testGetRequest()
     */
    @Test
    public void testAsyncGetRequestWithHttp1_1() throws Exception {

        // Step 1: Given
        var request = HttpRequest
                .newBuilder(URI.create(URI_HUGEDATA))
                .build();
        // Step 2: When
        // Use HttpClient.sendAsync(...) method to execute request without blocking. Returns response as CompletableFuture.
        CompletableFuture<HttpResponse<String>> future =
                this.httpClient1.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        // Step 4 Chain processing of future HttpResponse without blocking (when it's returned), subject to time-out.
        future.thenApply(whole -> whole.body())
                .thenAccept( whole -> System.out.println(" then accept: " + whole));

        // Step 3
        System.out.println("Non-block, this will run before BIG data of future return");
        for (int i = 0; i < 500; i++) {
            System.out.println(i);
        }

        // Step 5 We join all the result together, it's blocked the current thread
        HttpResponse<String> response =  future.join();

        // Then
        assertHttpResponseStatusCodeInSuccessRange(response);

    }


    @Test
    public void testAsyncGetRequestWithHttp2() throws Exception {

        // Step 1: Given
        var request = HttpRequest
                .newBuilder(URI.create(URI_HUGEDATA))
                .build();

        // Step 2: When
        // Use HttpClient.sendAsync(...) method to execute request without blocking. Returns response as CompletableFuture.
        CompletableFuture<HttpResponse<String>> future =
                this.httpClient2.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        // Step 4 Chain processing of future HttpResponse without blocking (when it's returned), subject to time-out.
        future.thenApply(whole -> whole.body())
                .thenAccept( whole -> System.out.println(" then accept: " + whole));

        // Step 3
        System.out.println("Non-block, this will run before BIG data of future return");
        for (int i = 0; i < 500; i++) {
            System.out.println(i);
        }

        // Step 5 We join all the result together, it's blocked the current thread
        HttpResponse<String> response =  future.join();
        // Then
        assertHttpResponseStatusCodeInSuccessRange(response);
    }

    private void assertHttpResponseStatusCodeInSuccessRange(HttpResponse<?> response) {
        assertTrue(response.statusCode() >= 200 && response.statusCode() < 300 );
    }

}
