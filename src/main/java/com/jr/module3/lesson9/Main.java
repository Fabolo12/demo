package com.jr.module3.lesson9;

import com.jr.module3.lesson9.controller.UserController;
import com.jr.module3.lesson9.utils.Request;
import com.jr.module3.lesson9.utils.Response;

public class Main {
    public static void main(String[] args) {
        final UserController userController = new UserController();
        userController.createEndpoint(new Request("{'name':'test', 'age': '10'}"), new Response());
    }
}
