package com.jensen.g_ajsx_json_07;

import com.alibaba.fastjson.JSON;
import com.jensen.d_filter_04.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajaxJsonTest02Servlet")
public class AjaxJsonTest02Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username+"---"+password);

        User user = new User();
        user.setName(username);
        user.setPassword(password);

        String s = JSON.toJSONString(user);

        response.getWriter().print(s);
    }
}
