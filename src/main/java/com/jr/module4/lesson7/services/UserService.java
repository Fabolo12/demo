package com.jr.module4.lesson7.services;

import com.jr.module4.lesson7.repositories.UserRepository;

public class UserService {
    private static final UserRepository USER_REPOSITORY = new UserRepository();
    public void registration(final String username, final String password) {
        if (USER_REPOSITORY.findUserByUsername(username).orElse(false)) {
            throw new IllegalStateException("MyClient already exist");
        } else {
            System.out.println("Can register user");
        }
    }
}
