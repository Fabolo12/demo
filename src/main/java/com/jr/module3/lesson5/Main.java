package com.jr.module3.lesson5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Main {

    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        final int number = new Random().nextInt(100);

        if (number < 50) {
            LOGGER.info("Number " + number); // error
            LOGGER.info("Number {}", number); // ok
        }
        LOGGER.trace("Number {}", number);
        LOGGER.debug("Number {}", number);
        LOGGER.info("Number {}", number);
        LOGGER.warn("Number {}", number);
        LOGGER.error("Number {}", number);
    }
}
