package com.jr.module3.lesson10.solid.senders;

public final class MessageFabric {
    private MessageFabric () {

    }

    public static Sender build(final SenderType type) {
        return switch (type) {
            case SMS -> new MessageSenderSMS();
            case EMAIL -> new MessageSenderEmail();
            default -> throw new IllegalArgumentException(type.name());
        };
    }
}
