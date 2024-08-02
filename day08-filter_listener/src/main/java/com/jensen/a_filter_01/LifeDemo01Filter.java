package com.jensen.a_filter_01;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/demo02.html")
public class LifeDemo01Filter implements Filter {
    public LifeDemo01Filter() {
        System.out.println("无参构造方法");
    }

    @Override
    public void destroy() {
        System.out.println("destroy....");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //your code...
        System.out.println("doFilter....");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init....");
    }

}
