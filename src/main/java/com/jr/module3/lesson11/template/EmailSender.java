package com.jr.module3.lesson11.template;

public class EmailSender extends TemplateMethod{
    @Override
    protected String processSender(final String sender) {
        return "EMAIL:" + sender;
    }

    @Override
    protected String processBody(final String body) {
        return "---" + body + "---";
    }
}
