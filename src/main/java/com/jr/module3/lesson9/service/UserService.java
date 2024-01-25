package com.jr.module3.lesson9.service;

import com.jr.module3.lesson9.bean.UserBean;
import com.jr.module3.lesson9.model.User;
import com.jr.module3.lesson9.repository.UserRepository;

import java.util.UUID;

/**
 * Main logic
 */
public class UserService {

    private static final UserRepository REPOSITORY = new UserRepository();

    public String create(final UserBean userBean) {
        System.out.println("Service step");
        if (userBean.age() <= 0) {
            throw new IllegalArgumentException("Age can't be less then 0");
        }
        final User user = createUser(userBean);
        REPOSITORY.save(user);
        return user.getId();
    }

    private User createUser(final UserBean userBean) {
        final User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(userBean.name());
        user.setAge(userBean.age());
        return user;
    }
}
