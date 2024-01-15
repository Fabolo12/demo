package com.jr.module3.lesson6;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@WebServlet(name = "MyServlet", value = "/user")
public class MyServlet extends HttpServlet {

    private static final Map<String, User> USER_MAP = new HashMap<>();

    @Override
    public void init(final ServletConfig config) {
        System.out.println("Init MyServlet");
    }

    @SneakyThrows
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) {
        try (final PrintWriter writer = resp.getWriter()) {
            USER_MAP.values().stream()
                    .map(user -> String.format("User {id: %s, name: %s}", user.id(), user.name()))
                    .forEach(writer::println);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) {
        final String id = UUID.randomUUID().toString();
        final String name = Objects.requireNonNullElse(req.getParameter("name"), "Default name");
        final User user = new User(id, name);
        USER_MAP.put(id, user);

        try (final PrintWriter writer = resp.getWriter()) {
            writer.println(String.format("User with id [%s] created!", id));
        }
    }

    @Override
    protected void doPut(final HttpServletRequest req, final HttpServletResponse resp) {
        final HttpSession session = req.getSession();

        System.out.println("Session id: " + session.getId());

        final String userId = (String) session.getAttribute("userId");
        if (userId != null) {
            final User user = USER_MAP.get(userId);
            System.out.println(user.name());
        } else {
            session.setAttribute("userId", USER_MAP.keySet().iterator().next());
        }
    }

    @SneakyThrows
    @Override
    protected void doDelete(final HttpServletRequest req, final HttpServletResponse resp) {
        final String id = Objects.requireNonNull(req.getParameter("id"));
        final User removedUser = USER_MAP.remove(id);

        try (final PrintWriter writer = resp.getWriter()) {
            writer.println(String.format("User %s removed!", removedUser.name()));
        }
    }
}
