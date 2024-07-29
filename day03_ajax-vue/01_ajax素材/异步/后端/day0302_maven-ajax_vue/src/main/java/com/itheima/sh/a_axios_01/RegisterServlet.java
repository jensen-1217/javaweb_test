package com.itheima.sh.a_axios_01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数
        //后台如何获取usernameValue的值：request.getParameter("username");
        String username = request.getParameter("username");
        //2.将获取的name值传递到service层，这里我们暂时不写了，判断
        if("岩岩".equals(username)){
            //响应数据，说明用户名存在，不能注册
            response.getWriter().print(false);
        }else{
            //响应数据，说明用户名不存在，能注册
            response.getWriter().print(true);
        }
    }
}
