package com.jr.module3.lesson15;

import com.jr.module3.lesson15.model.Question;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(name = "GameAction", value = "/lesson15/game-action")
public class GameAction extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String action = req.getParameter("action");
        if (action != null) {
            processStart(req, resp);
        } else {
            processGame(req, resp);
        }
    }

    @SneakyThrows
    private void processStart(final HttpServletRequest req, final HttpServletResponse resp) {
        req.setAttribute("question", new Question());
        resp.sendRedirect("/JavaRush/lesson15/game.jsp");
    }

    @SneakyThrows
    private void processGame(final HttpServletRequest req, final HttpServletResponse resp) {
        final String question = req.getParameter("question");
        final String answer = req.getParameter("answer");
        System.out.printf("Question: %s, answer: %s%n", question, answer);
        resp.sendRedirect("/JavaRush/lesson15/game.jsp");
    }
}
