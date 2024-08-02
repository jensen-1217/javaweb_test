package com.jensen.f_listener_06;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContext2Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext创建了");
        ServletContext servletContext = sce.getServletContext();
        String jdbcStr = servletContext.getInitParameter("jdbc");
        System.out.println(jdbcStr);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
