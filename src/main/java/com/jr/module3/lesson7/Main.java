package com.jr.module3.lesson7;

import com.google.gson.Gson;
import lombok.SneakyThrows;


public class Main {

    private static final Gson GSON = new Gson();

    @SneakyThrows
    public static void main(String[] args) {
        final MyHttpClient client = new MyHttpClient("http://localhost:8081/JavaRush/users");

        /*client.getRequest();
        client.postRequest();
        client.getRequest();

        final User user = new User("Test");
        final String jsonUser = GSON.toJson(user);
        client.postRequest(jsonUser);
        client.getRequest();

        client.postRequestWithParams("name=Test");
        client.getRequest();
        client.putRequest();
        client.deleteRequest();

        client.postRequestAsync();
        client.postRequestWithCookieSend();*/
        client.postRequestWithCookieReceived();
    }
}