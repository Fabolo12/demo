package com.jr.module3.lesson8;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SimpleServlet", value = "/lesson8/servlet")
public class SimpleServlet extends HttpServlet {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");

    @SneakyThrows
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {
        response.setContentType("text/html");

        try (final PrintWriter writer = response.getWriter()) {
            final LocalDate now = LocalDate.now();

            writer.println("<html>");
            writer.println("<head>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println(String.format("Today: %s", formatter.format(now)));
            writer.println(String.format("Request method: %s", request.getMethod()));
            writer.println("</body>");
            writer.println("</html>");
        }
    }
}
