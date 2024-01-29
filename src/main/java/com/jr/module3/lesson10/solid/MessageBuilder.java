package com.jr.module3.lesson10.solid;

public class MessageBuilder {
    public String build() {
        return buildBody() + buildTitle();
    }

    private String buildBody() {
        return "";
    }

    private String buildTitle() {
        return "";
    }
}
