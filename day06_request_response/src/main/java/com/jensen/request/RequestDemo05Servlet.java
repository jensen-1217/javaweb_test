package com.jensen.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestDemo05Servlet")
public class RequestDemo05Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.解决请求体乱码，只能解决tomcat8之后post请求，8之前get不能使用
//        request.setCharacterEncoding("UTF-8");



        Map<String, String[]> map = request.getParameterMap();
        //jdk8遍历map
        map.forEach((key,value)->{
            System.out.println(key+"---"+ Arrays.toString(value).replace("[","").replace("]",""));
        });

        /*Set<String> keys = map.keySet();
        System.out.println(keys);
        for (String key : keys) {
            System.out.print(key+":");

            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value+" ");
            }
            System.out.println();
        }*/

        String[] hobbies = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));

           String username = request.getParameter("username");

//2.使用javaseAPI解决乱码
//        先编码，再解码
//        username = URLEncoder.encode(username, "ISO-8859-1");
//        username = URLDecoder.decode(username, "UTF-8");

// 3.使用javaseAPI解决，String类
        byte[] bytes = username.getBytes("ISO-8859-1");
        username = new String(bytes, "UTF-8");

        System.out.println(username);

    }
}
