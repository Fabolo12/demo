package com.jr.module3.lesson15.controllers;

import com.jr.module3.lesson15.model.UserData;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

@WebServlet(name = "Registration", value = "/lesson15/registration")
public class Registration extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) {
        final String username = req.getParameter("username");
        if (StringUtils.isBlank(username)) {
            throw new IllegalArgumentException("Username should'n be empty");
        }
        final UserData userData = new UserData(username.trim(), LocalDate.now(), 0);
        final HttpSession session = req.getSession();
        session.setAttribute(UserData.SESSION_ATTRIBUTE, userData);
        resp.sendRedirect("/JavaRush/lesson15/game-action?action=start");
    }
}
