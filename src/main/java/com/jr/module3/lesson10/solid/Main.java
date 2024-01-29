package com.jr.module3.lesson10.solid;

import com.jr.module3.lesson10.solid.senders.MessageFabric;
import com.jr.module3.lesson10.solid.senders.Sender;
import com.jr.module3.lesson10.solid.senders.SenderType;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final RecipientsSystem recipientsSystem = new RecipientsSystem();
        final List<String> allRecipients = recipientsSystem.getAllRecipients();

        final MessageBuilder messageBuilder = new MessageBuilder();
        final String message = messageBuilder.build();

        Sender sender = MessageFabric.build(SenderType.SMS);
        sender.send(allRecipients, message);

        sender = MessageFabric.build(SenderType.EMAIL);
        sender.send(allRecipients, message);
    }
}
