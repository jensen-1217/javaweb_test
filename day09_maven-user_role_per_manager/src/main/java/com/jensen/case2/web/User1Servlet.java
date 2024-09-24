package com.jensen.case2.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/user/*")
public class User1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void delete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("删除用户");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("添加用户");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("更新用户");
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("查询所有用户");
    }

}
