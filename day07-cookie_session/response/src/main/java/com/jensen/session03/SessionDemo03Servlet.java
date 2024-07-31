package com.jensen.session03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sessionDemo03Servlet")
public class SessionDemo03Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        session.invalidate();//立即销毁session
//        session.setMaxInactiveInterval(3);//设置session到期时间，单位是秒
        String sessionId = session.getId();
        Cookie cookie = new Cookie("JSESSIONID", sessionId);
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
        System.out.println("sessionId = " + sessionId);

    }
}
