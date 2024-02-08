package com.jr.module3.lesson11.template;

public abstract class TemplateMethod {
    public void sendMessage(final String sender, final String body) {
        final String newSender = processSender(sender);
        final String newBody = processBody(body);
        System.out.println("LOG");
        send(newSender, newBody);
    }

    private void send(final String newSender, final String newBody) {
        System.out.println("Send to: " + newSender);
        System.out.println("Message: " + newBody);
    }

    protected String processBody(final String body) {
        return "***" + body + "***";
    }

    protected abstract String processSender(final String sender);
}
