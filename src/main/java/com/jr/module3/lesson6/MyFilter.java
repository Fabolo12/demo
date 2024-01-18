package com.jr.module3.lesson6;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;

@WebFilter(filterName = "MyFilter", urlPatterns = "/*")
public class MyFilter implements Filter {
    @Override
    public void init(final FilterConfig filterConfig) {
        System.out.println("MyFilter installed");
    }

    @SneakyThrows
    @Override
    public void doFilter(
            final ServletRequest servletRequest,
            final ServletResponse servletResponse,
            final FilterChain filterChain
    )  {
        String ipAddress = servletRequest.getRemoteAddr();
        String url = ((HttpServletRequest) servletRequest).getRequestURL().toString();
        final String method = ((HttpServletRequest) servletRequest).getMethod();
        System.out.println("IP " + ipAddress + ", URL " + url + " , method: " + method);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
