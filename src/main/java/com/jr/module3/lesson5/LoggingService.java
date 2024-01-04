package com.jr.module3.lesson5;

import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggingService {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyy hh:mm:ss");

    private static final String LOG_FILE_NAME = "system.log";

    public static void log(final String message) {
        logToConsole(message);
        logToFile(message);
    }

    private static void logToConsole(final String message) {
        System.out.println(formatString(message));
    }

    @SneakyThrows
    private static void logToFile(final String message) {
        BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_NAME, true));
        writer.write(formatString(message) + "\n");
        writer.flush();
    }

    private static String formatString(final String message) {
        final String name = Thread.currentThread().getName();
        return String.format("[%s] [Thread: %s] log: %s", DATE_FORMAT.format(new Date()), name, message);
    }
}
