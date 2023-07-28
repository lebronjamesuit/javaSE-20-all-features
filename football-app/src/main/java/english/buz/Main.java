package english.buz;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("Hello world!");

             // java 11
        HttpClientFactory httpClientFactory =  new HttpClientFactory();
        String body = httpClientFactory.connectionHttpClient();

    }
}
