package com.jr.module3.lesson9.controller;

import com.google.gson.Gson;
import com.jr.module3.lesson9.bean.UserBean;
import com.jr.module3.lesson9.service.UserService;
import com.jr.module3.lesson9.utils.Request;
import com.jr.module3.lesson9.utils.Response;
import org.apache.commons.lang3.StringUtils;

/**
 * Class for receive request/response, like servlet
 */
public class UserController {

    private static final UserService SERVICE = new UserService();

    private static final Gson GSON = new Gson();

    public void createEndpoint(final Request request, final Response response) {
        System.out.println("Controller step");
        if (StringUtils.isEmpty(request.body())) {
            throw new IllegalArgumentException("Body can't be empty");
        }

        final UserBean userBean = GSON.fromJson(request.body(), UserBean.class);
        final String userId = SERVICE.create(userBean);
        response.writePayload(userId);
    }
}
