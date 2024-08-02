package com.jensen.g_ajsx_json_07;

import com.alibaba.fastjson.JSON;
import com.jensen.d_filter_04.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@WebServlet("/ajaxJsonTest04Servlet")
public class AjaxJsonTest04Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        User user = JSON.parseObject(request.getInputStream(), User.class);
//        System.out.println(user);
        try {
            User user = BaseController.parseJsonToObject(request, User.class);
            System.out.println(user);

            ArrayList<User> list = new ArrayList<>();
            Collections.addAll(list,new User("白岩","1234"),
                    new User("白岩2","1234"),
                    new User("白岩3","1234"));

            Result result = new Result(true, "查询用户成功", list);

//            String jsonString = JSON.toJSONString(result);
//
//            response.getWriter().print(jsonString);
            BaseController.responseJsonToBrowser(response,result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
