package com.jensen.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestRowDemo01Servlet")
public class RequestRowDemo01Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//* 获取请求方式: `GET`  String getMethod()
        System.out.println(request.getMethod());

//* 获取虚拟目录(项目访问路径): `/request-demo`  String getContextPath()
        System.out.println(request.getContextPath());

//* 获取URL(统一资源定位符): `http://localhost:8080/request-demo/req1` StringBuffer getRequestURL()
        System.out.println(request.getRequestURL());

//* 获取URI(统一资源标识符): `/request-demo/req1` String getRequestURI()
        System.out.println(request.getRequestURI());

//* 获取请求参数(GET方式): `username=zhangsan&password=123`   String getQueryString()
        System.out.println(request.getQueryString());
    }
}
