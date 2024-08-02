package com.jensen.d_filter_04;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/hack.html")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //your code...
        User u = (User) request.getSession().getAttribute("u");
        if(u==null){
            response.sendRedirect("/login.html");
        }else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
