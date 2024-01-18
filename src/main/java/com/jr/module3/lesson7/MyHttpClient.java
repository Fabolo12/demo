package com.jr.module3.lesson7;

import lombok.SneakyThrows;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Executors;

public class MyHttpClient {
    private final HttpClient httpClient;

    private final URI uriAddress;

    private final CookieManager cookieManager;

    public MyHttpClient(final String uri) {
        cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

        httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .cookieHandler(cookieManager)
                .executor(Executors.newCachedThreadPool())
                .build();
        uriAddress = URI.create(uri);
    }

    public void postRequestAsync() {
        final HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.noBody())
                .uri(uriAddress)
                .build();

        System.out.println("Before postRequestAsync");
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println);
        System.out.println("After postRequestAsync");
    }

    public void postRequestWithCookieSend() {
        final HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.noBody())
                .header("Cookie", "name=name")
                .uri(uriAddress)
                .build();
        printResponse("POST", sendRequest(request));
    }

    public void postRequestWithCookieReceived() {
        final HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.noBody())
                .header("Cookie", "name=name")
                .uri(uriAddress)
                .build();
        printResponse("POST", sendRequest(request));
        System.out.println(cookieManager.getCookieStore().getCookies());
    }

    public void postRequest() {
        final HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.noBody())
                .uri(uriAddress)
                .build();
        printResponse("POST", sendRequest(request));
    }

    public void putRequest() {
        final HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.noBody())
                .uri(uriAddress)
                .build();
        printResponse("PUT", sendRequest(request));
    }

    public void deleteRequest() {
        final HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .uri(uriAddress)
                .build();
        printResponse("DELETE", sendRequest(request));
    }


    public void postRequest(final String body) {
        final HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .header("Content-Type", "application/json")
                .uri(uriAddress)
                .build();
        printResponse("POST", sendRequest(request));
    }

    public void postRequestWithParams(final String... params) {
        final HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.noBody())
                .uri(createUriWithParams(params))
                .build();
        printResponse("POST", sendRequest(request));
    }

    private URI createUriWithParams(final String... params) {
        final String paramsString = String.join("&", params);
        return URI.create(uriAddress + "?" + paramsString);
    }


    public void getRequest() {
        final HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uriAddress)
                .build();
        printResponse("GET", sendRequest(request));
    }

    @SneakyThrows
    private HttpResponse<String> sendRequest(final HttpRequest request) {
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private void printResponse(final String method, final HttpResponse<String> getResponse) {
        System.out.println("~~~" + method + "~~~");
        System.out.println(getResponse.statusCode());
        System.out.println(getResponse.body());
    }
}
