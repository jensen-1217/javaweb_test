package com.jensen.session03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sessionDemo01Servlet")
public class SessionDemo01Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        session.setAttribute("msg","我是白岩的爸爸");
//        String sessionId = session.getId();
//        if (session.isNew()) {
//            response.getWriter().print("session创建成功，session的id是："+sessionId);
//        }else {
//            response.getWriter().print("服务器已经存在该session了，session的id是："+sessionId);
//        }

    }
}
