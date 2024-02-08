package com.jr.module3.lesson11.template;

public class SmsSender extends TemplateMethod {
    @Override
    protected String processSender(final String sender) {
        return "SMS:" + sender;
    }
}
