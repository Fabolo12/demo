package com.jr.module2.lesson17.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigLoader {

    private static final String FILE_CONFIG = "module2/lesson17/config.properties";

    private static final Properties CONFIG_PROPERTIES = new Properties();

    static {
        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_CONFIG)) {
            CONFIG_PROPERTIES.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static int getIntegerProperty(final String key) {
        return Integer.parseInt(CONFIG_PROPERTIES.getProperty(key));
    }

}
