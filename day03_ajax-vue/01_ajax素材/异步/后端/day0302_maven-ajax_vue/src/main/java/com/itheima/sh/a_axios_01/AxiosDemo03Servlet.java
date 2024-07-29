package com.itheima.sh.a_axios_01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/axiosDemo03Servlet")
public class AxiosDemo03Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求数据
        //  axios.post("/axiosDemo02Servlet","username=锁哥&password=1234")
        //.getParameter("username"); 函数的参数username是前端post函数中url后面参数的key

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.输出
        System.out.println(username+"---"+password);
        //3.响应数据
        response.getWriter().print("axios实现ajax异步post请求,username="+username);
    }
}
