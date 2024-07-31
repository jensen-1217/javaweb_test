package com.jensen.cookie02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/cookieDemo04Servlet")
public class CookieDemo04Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value="bai  yan";
        String encode = URLEncoder.encode(value, "UTF-8");
        Cookie cookie = new Cookie("username", encode);
        cookie.setMaxAge(60*60*24*7);
        response.addCookie(cookie);
    }
}
