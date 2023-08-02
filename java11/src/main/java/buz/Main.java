package buz;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        HttpClientFactory httpClientFactory =  new HttpClientFactory();
   //    HttpResponse<String> responseSync = httpClientFactory.connectionHttpClientSynchronous();


        HttpResponse<String> responseAsync = httpClientFactory.connectionHttpClientAsynchronous();


        //System.out.println(responseSync);
      //  System.out.println(responseAsync.toString());
      //  System.out.println(responseAsync.body());

    }
}
