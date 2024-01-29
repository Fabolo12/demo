package com.jr.module3.lesson10.broken;

import org.apache.commons.lang3.StringUtils;

public class BrokenBLP {
    public static void main(String[] args) {
        final Parent parent = new Child();
        final boolean send = parent.send("");

        System.out.println("Massage was sending: " + send);
    }

    static class Parent {
        boolean send(final String massage) {
            return StringUtils.isEmpty(massage) ? false : true;
        }
    }

    static class Child extends Parent {
        @Override
        boolean send(final String massage) {
            /*if (StringUtils.isEmpty(massage)) { // ERROR
                throw new Exception();
            }*/

            if (massage.length() < 15) {
                return false;
            }

            final String newMassage = "*" + massage + "*";
            return true;
        }
    }
}
