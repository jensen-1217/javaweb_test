package com.itheima.sh.a_axios_01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/axiosDemo01Servlet")
public class AxiosDemo01Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求数据
        // axios.get("/axiosDemo01Servlet?username=锁哥&password=1234")
        //.getParameter("username"); 函数的参数username是前端get函数中url后面参数的key
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.输出
        System.out.println(username+"---"+password);
        //模拟异常：
//        int i = 1 / 0;
        //3.响应数据给前端
        response.getWriter().print("axios实现ajax异步get请求,username="+username);
    }
}
