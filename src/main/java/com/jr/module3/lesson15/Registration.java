package com.jr.module3.lesson15;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Registration", value = "/lesson15/registration")
public class Registration extends HttpServlet {
    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("I'm here");
        // TODO work with session
        resp.sendRedirect("/JavaRush/lesson15/game.jsp?action=start");
    }
}
