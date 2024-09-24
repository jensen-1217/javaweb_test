package com.jensen.case2.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

//@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求资源的路径
        String uri = request.getRequestURI();
        //2.获取uri最后一个/的索引值
        int lastIndex = uri.lastIndexOf("/");
        //3.截取最后一个/的下一个字符到字符串末尾
        String methodName = uri.substring(lastIndex + 1);
//        System.out.println("methodName = " + methodName);
        try {
            Class<?> clazz = this.getClass();
            Method m = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            m.setAccessible(true);
            m.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
