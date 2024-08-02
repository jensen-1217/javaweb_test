package com.jensen.b_filter_02;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/apple")
public class BFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //your code...
        System.out.println("BFilter前");
        chain.doFilter(request, response);
        System.out.println("BFilter后");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
