package com.jr.module2.lesoon3.menu;

import com.jr.module2.lesoon3.menu.actions.MenuOptions;

import java.util.Scanner;

public class Main {
//    private BufferedInputStream reader = new BufferedInputStream(new InputStreamReader(System.in));

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final MenuOptions[] values = MenuOptions.values();

        do {
            int number = -1;
            do {
                for (int i = 0; i < values.length; i++) {
                    System.out.printf("%d. %s%n", i, values[i]);
                }

                try {
                    number = Integer.parseInt(scanner.next());
                } catch (Exception e) {
                    System.out.println("Write a number");
                }
            } while (number < 0 || number > values.length);
            values[number].exec();
        } while (true);

    }
}
