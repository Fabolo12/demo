package com.jr.module4.lesson7.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationTest {

    private Registration target;

    private HttpServletRequest req;

    private HttpServletResponse resp;

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @BeforeEach
    void setUp() {
        target = new Registration();
        req = Mockito.mock(HttpServletRequest.class);
        resp = Mockito.mock(HttpServletResponse.class);
    }

    @Test
    void cannotRegister() {
        Mockito.when(req.getParameter(USERNAME)).thenReturn("Test");
        Mockito.when(req.getParameter(PASSWORD)).thenReturn("-");

        Assertions.assertThrows(
                IllegalStateException.class, () ->  target.doPost(req, resp), "User already exist"
        );
    }

    @Test
    void canRegister() {
        Mockito.when(req.getParameter(USERNAME)).thenReturn("Test1");
        Mockito.when(req.getParameter(PASSWORD)).thenReturn("-");

        Assertions.assertDoesNotThrow(() ->  target.doPost(req, resp));
    }
}