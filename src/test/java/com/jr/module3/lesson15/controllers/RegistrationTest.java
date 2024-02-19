package com.jr.module3.lesson15.controllers;

import com.jr.module3.lesson15.model.UserData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class RegistrationTest {

    private Registration target;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @BeforeEach
    void setUp() {
        target = new Registration();
        Mockito.when(request.getSession()).thenReturn(session);
    }

    @SneakyThrows
    @Test
    void doPost() {
        final String username = "   XXXXXXXX   ";
        Mockito.when(request.getParameter("username")).thenReturn(username);
        target.doPost(request, response);


        ArgumentMatcher<UserData> matcher = o -> {
            if (!o.getUsername().equals(username.trim())) {
                return false;
            }
            if (!o.getDate().equals(LocalDate.now())) {
                return false;
            }
            if (o.getScore() != 0) {
                return false;
            }

            return true;
        };

        Mockito.verify(session).setAttribute(Mockito.eq(UserData.SESSION_ATTRIBUTE), Mockito.argThat(matcher));
        Mockito.verify(response).sendRedirect("/JavaRush/lesson15/game-action?action=start");
    }

    @Nested
    class UsernameChecks {
        private final String usernameErrorMessage = "Username shouldn't be empty";

        @Test
        void doPostUsernameNull() {
            Mockito.when(request.getParameter("username")).thenReturn(null);
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> target.doPost(request, response),
                    usernameErrorMessage
            );
        }

        @Test
        void doPostUsernameEmpty() {
            Mockito.when(request.getParameter("username")).thenReturn("");
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> target.doPost(request, response),
                    usernameErrorMessage
            );
        }

        @Test
        void doPostUsernameBlank() {
            Mockito.when(request.getParameter("username")).thenReturn("    ");
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> target.doPost(request, response),
                    usernameErrorMessage
            );
        }
    }


}