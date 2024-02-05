package com.jr.module3.lesson11.chain;

public abstract class AuthenticationProcessor {

    public final AuthenticationProcessor nextProcessor;

    AuthenticationProcessor(final AuthenticationProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public abstract boolean isAuthorized(String authProvider);
}
