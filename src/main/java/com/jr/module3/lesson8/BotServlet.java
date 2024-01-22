package com.jr.module3.lesson8;

import com.jr.module3.lesson8.model.Bot;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

@WebServlet(name = "BotServlet", value = "/lesson8/bot")
public class BotServlet extends HttpServlet {
    private Bot bot;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        bot = new Bot(1, "Amigo", "228274635");
    }

    @SneakyThrows
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {
        String action = request.getParameter("action");
        request.setAttribute("bot", bot);

        switch (action == null ? "info" : action) {
            case "update" -> request.getRequestDispatcher("/lesson8/update.jsp").forward(request, response);
            case "info" -> request.getRequestDispatcher("/lesson8/bot.jsp").forward(request, response);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) {
        String action = request.getParameter("action");
        if ("submit".equals(action)) {
            bot.setId(Integer.parseInt(request.getParameter("id")));
            bot.setName(request.getParameter("name"));
            bot.setSerial(request.getParameter("serial"));
        }
        request.setAttribute("bot", bot);
        request.getRequestDispatcher("/lesson8/bot.jsp").forward(request, response);
    }
}
