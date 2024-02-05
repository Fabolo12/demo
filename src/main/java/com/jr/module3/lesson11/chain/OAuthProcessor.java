package com.jr.module3.lesson11.chain;

public class OAuthProcessor extends AuthenticationProcessor {
    public OAuthProcessor(AuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isAuthorized(String authProvider) {
        if (authProvider.equals("OAuthTokenProvider")) {
            return true;
        } else if (nextProcessor != null) {
            return nextProcessor.isAuthorized(authProvider);
        }

        return false;
    }
}
