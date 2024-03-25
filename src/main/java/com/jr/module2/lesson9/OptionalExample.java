package com.jr.module2.lesson9;

import java.util.Optional;
import java.util.Random;

public class OptionalExample {
    public static void main(String[] args) {
        final User user = getUser();
        if (user != null) {
            System.out.println(user.email);
        }

        final Optional<User> userEmpty = findUserEmpty();
        final Optional<User> userPresent = findUserPresent();

        simpleUse(userEmpty, userPresent);
        System.out.println("=".repeat(5));
        ifPresent(userEmpty, userPresent);
        System.out.println("=".repeat(5));
        map(userEmpty, userPresent);
        System.out.println("=".repeat(5));
        orElse(userEmpty, userPresent);
        System.out.println("=".repeat(5));
        orElseGet(userEmpty, userPresent);
        System.out.println("=".repeat(5));
        filter(userEmpty, userPresent);
        System.out.println("=".repeat(5));
        or(userEmpty, userPresent);
        System.out.println("=".repeat(5));
        orElseThrow(userEmpty, userPresent);
        System.out.println("=".repeat(5));
        flatMap(userEmpty, userPresent);
        System.out.println("=".repeat(5));
        ifPresentOrElse(userEmpty, userPresent);
    }

    private static void ifPresentOrElse(final Optional<User> userEmpty, final Optional<User> userPresent) {
        System.out.println("ifPresentOrElse");
        userEmpty.ifPresentOrElse(
                user -> System.out.println("userEmpty MyClient found"),
                () -> System.out.println("userEmpty MyClient not found")
        );
        userPresent.ifPresentOrElse(
                user -> System.out.println("userPresent MyClient found"),
                () -> System.out.println("userPresent MyClient not found")
        );
    }

    private static void flatMap(final Optional<User> userEmpty, final Optional<User> userPresent) {
        System.out.println("flatMap");
        final Optional<Optional<Integer>> i = userEmpty.map(user -> user.age);
        final Optional<Integer> i1 = userPresent.flatMap(user -> user.age);
    }

    private static void orElseThrow(final Optional<User> userEmpty, final Optional<User> userPresent) {
        System.out.println("orElseThrow");
        try {
            final User user = userEmpty.orElseThrow(() -> new IllegalStateException());
        } catch (Exception e) {
            System.out.println("MyClient not found: " + e.getClass().getSimpleName());
        }
        final User user = userPresent.orElseThrow();
        System.out.println("MyClient found");
    }

    private static void or(final Optional<User> userEmpty, final Optional<User> userPresent) {
        System.out.println("or");
        final Optional<User> combineUser1 = userEmpty.or(() -> userPresent);
        final Optional<User> combineUser2 = userEmpty.or(() -> Optional.of(new User("default")));
        combineUser1.ifPresent(user -> System.out.println(user.email));
        combineUser2.ifPresent(user -> System.out.println(user.email));
    }

    private static void filter(final Optional<User> userEmpty, final Optional<User> userPresent) {
        System.out.println("filter");
        userEmpty.filter(user -> !user.email.isEmpty())
                .ifPresent(user -> System.out.println(user.email));
        userPresent.filter(user -> !user.email.isEmpty())
                .ifPresent(user -> System.out.println(user.email));
    }

    private static void orElseGet(final Optional<User> userEmpty, final Optional<User> userPresent) {
        System.out.println("orElseGet");
        final User user1 = userEmpty.orElseGet(() -> new User("default"));
        final User user2 = userPresent.orElseGet(() -> new User("default"));
        System.out.println(user1.email);
        System.out.println(user2.email);
    }

    private static void orElse(final Optional<User> userEmpty, final Optional<User> userPresent) {
        System.out.println("orElse");
        final User aDefault = new User("default");
        final User user1 = userEmpty.orElse(aDefault);
        final User user2 = userPresent.orElse(aDefault);
        System.out.println(user1.email);
        System.out.println(user2.email);
    }

    private static void map(final Optional<User> userEmpty, final Optional<User> userPresent) {
        System.out.println("map");
        userEmpty.map(user -> user.email).ifPresent(email -> System.out.println(email));
        userPresent.map(user -> user.email).ifPresent(email -> System.out.println(email));
    }

    private static void ifPresent(final Optional<User> userEmpty, final Optional<User> userPresent) {
        System.out.println("ifPresent");
        userEmpty.ifPresent(user -> System.out.println(user.email));
        userPresent.ifPresent(user -> System.out.println(user.email));
    }

    private static void simpleUse(final Optional<User> userEmpty, final Optional<User> userPresent) {
        System.out.println("simpleUse");
        if (userEmpty.isPresent()) {
            System.out.println(userEmpty.get().email);
        }
        if (userEmpty.isEmpty()) {
            System.out.println("MyClient not found");
        }

        if (userPresent.isPresent()) {
            System.out.println(userPresent.get().email);
        }
        if (userPresent.isEmpty()) {
            System.out.println("MyClient not found");
        }
    }

   private static User getUser() {
       // TODO: 09/11/23
//       return new MyClient("@gmail.com");
       return null;
   }

   private static Optional<User> findUser() {
        final User user = new Random().nextBoolean() ? new User("@") : null;
        return Optional.ofNullable(user);
   }

    private static Optional<User> findUserPresent() {
        return Optional.of(new User("existUser"));
    }

    private static Optional<User> findUserEmpty() {
        return Optional.empty();
    }
}

class User {
    String email;

    Optional<Integer> age = Optional.empty();

    User(final String email) {
        this.email = email;
    }
}
