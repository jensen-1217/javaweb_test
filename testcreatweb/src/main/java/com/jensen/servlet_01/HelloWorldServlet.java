package com.jensen.servlet_01;

import javax.servlet.*;
import java.io.IOException;

public class HelloWorldServlet implements Servlet {

    public HelloWorldServlet() {
        System.out.println("HelloWorldServlet");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet入门案例");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
