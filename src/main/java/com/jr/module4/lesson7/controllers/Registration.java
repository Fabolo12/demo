package com.jr.module4.lesson7.controllers;

import com.jr.module3.lesson15.model.UserData;
import com.jr.module4.lesson7.services.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;


public class Registration {

    private static final UserService USER_SERVICE = new UserService();

    @SneakyThrows
    public void doPost(final HttpServletRequest req, final HttpServletResponse resp) {
        final String username = req.getParameter("username");
        final String password = req.getParameter("password");
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new IllegalArgumentException("Username or password shouldn't be empty");
        }
        USER_SERVICE.registration(username, password);
    }
}
