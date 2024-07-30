package com.jensen.response01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo01Servlet")
public class ResponseDemo01Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-Type","text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter pw = response.getWriter();
//        pw.print("我是白岩的爸爸");
        response.getWriter().print("<h1>我是白岩的爸爸</h1>");
    }
}
