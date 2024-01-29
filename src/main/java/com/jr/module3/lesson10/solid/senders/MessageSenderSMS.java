package com.jr.module3.lesson10.solid.senders;

import java.util.List;

class MessageSenderSMS implements Sender {

    @Override
    public void send(final List<String> allRecipients, final String message) {
        System.out.println("Send to SMS");
    }
}
