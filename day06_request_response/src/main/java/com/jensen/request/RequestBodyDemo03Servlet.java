package com.jensen.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/requestBodyDemo03Servlet")
public class RequestBodyDemo03Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
    1.获取请求体数据的方法
        1）ServletInputStream getInputStream()该方法可以获取字节和字符数据
        2）BufferedReader getReader()获取字符数据
*/
        //1.获取输入流对象
        BufferedReader reader = request.getReader();
        //2.使用字符缓冲流读取字符数据
        String line=null;
        while ((line=reader.readLine())!=null){
            System.out.println(line);
        }

    }
}
