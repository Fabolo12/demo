package com.jr.module3.lesson9.repository;

import com.jr.module3.lesson9.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Work with database
 */
public class UserRepository {

    private static final User[] USERS1 = new User[10];
    private static final List<User> USERS2 = new ArrayList<>();
    public void save(final User user) {
        System.out.println("Repository step");
        System.out.println("Save to database user with id: " + user.getId());
        USERS2.add(user);
    }
}
