package com.jr.module3.lesson10.solid.senders;

import java.util.List;

public interface Sender {

    void send(final List<String> allRecipients, final String message);
}
