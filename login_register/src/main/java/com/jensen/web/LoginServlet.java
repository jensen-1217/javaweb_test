package com.jensen.web;

import com.jensen.pojo.User;
import com.jensen.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        User user = new User();
        user.setUsername(username);
        user.setPassword(pwd);
        UserServiceImpl userService = new UserServiceImpl();
        User u=userService.login(user);
        if(u==null){
            response.getWriter().print(false);
        }else {
            response.getWriter().print(true);
        }
    }
}
