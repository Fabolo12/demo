package com.jr.module2.lesson16;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

    private static final String FILE_CONFIG = "module2/lesson16/config.properties";

    private static final Properties CONFIG = new Properties();

    public static void main(String[] args) {
        init();
        System.out.println(CONFIG.getProperty("app.version"));
        final Config config = new Config();
        System.out.println(config.getAppVersion());
        System.out.println(CONFIG.getProperty("animal.size"));
    }

    private static void init() {
        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_CONFIG)) {
            CONFIG.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


class Config {
    private static final Properties CONFIG = new Properties();

    private static final String FILE_CONFIG = "module2/lesson16/config.properties";

    static {
        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_CONFIG)) {
            CONFIG.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getAppVersion() {
        return CONFIG.getProperty("app.ver");
    }
}