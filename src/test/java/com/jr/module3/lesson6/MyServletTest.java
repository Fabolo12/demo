package com.jr.module3.lesson6;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.PrintWriter;

class MyServletTest {

    private MyServlet target;

    private HttpServletRequest request;

    private HttpServletResponse response;

    @SneakyThrows
    @BeforeEach
    void setUp() {
        target = new MyServlet();
        final ServletConfig config = Mockito.mock(ServletConfig.class);
        target.init(config);
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
    }

    @Test
    void doDeleteWithoutId() {
        Assertions.assertThrows(NullPointerException.class, () -> target.doDelete(request, response));
    }

    @Test
    void doDeleteWithId() {
        Mockito.when(request.getParameter("id")).thenReturn("1");
        Assertions.assertDoesNotThrow(() -> target.doDelete(request, response));
    }
}