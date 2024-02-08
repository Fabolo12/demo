package com.jr.module3.lesson11.template;

public class Main {
    public static void main(String[] args) {
        final TemplateMethod method1 = new EmailSender();
        method1.sendMessage("Sender", "Message body");
        System.out.println();
        final TemplateMethod method2 = new SmsSender();
        method2.sendMessage("Sender", "Message body");
    }
}
