package com.jensen.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/requestDemo07Servlet")
public class RequestDemo07Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("requestDemo07Servlet...");

        request.setAttribute("msg","我是白岩的爸爸");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/requestDemo08Servlet");

        dispatcher.forward(request,response);

    }
}
