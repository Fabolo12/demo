package com.jr.module3.lesson11.chain;

public class Main {
    public static void main(String[] args) {
        final AuthenticationProcessor processor0 = new UsernamePasswordProcessor(null);
        final AuthenticationProcessor processor1 = new OAuthProcessor(processor0);


        System.out.println("IsAuthorized " + processor1.isAuthorized(""));
        System.out.println("IsAuthorized " + processor1.isAuthorized("OAuthTokenProvider"));
        System.out.println("IsAuthorized " + processor1.isAuthorized("UsernamePasswordProvider"));

    }
}
