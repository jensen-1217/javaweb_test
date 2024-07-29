package com.itheima.sh.b_json_02;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@WebServlet("/axiosJsonDemo01Servlet")
public class AxiosJsonDemo01Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=utf-8");
            // 需求：查询当前用户的好友 List<Friend> list,转成json格式字符串,最后响应
            //1.创建集合对象保存多个好友
            ArrayList<Friend> list = new ArrayList<>();
            //2.向集合添加数据
            Collections.addAll(list, new Friend("001", "张三", 18), new Friend("002", "李四", 19),
                    new Friend("003", "王五", 20));

            //3.创建Result类的对象
            /*
                true : 表示查询成功
                "查询好友列表成功" 查询好友成功的信息
                list:存放好友的集合数据
             */
            Result result = new Result(true, "查询好友列表成功", list);

//            int i = 1/0;

            //5.使用fastjson中的JSON类的方法String toJsonString(Object obj)
            String s = JSON.toJSONString(result);
            //5.响应给前端
            response.getWriter().print(s);
        } catch (Exception e) {
            e.printStackTrace();
            //告知浏览器查询好友列表失败
            /*
                false : 表示查询失败
                "查询好友列表成功" 查询好友成功的信息
                list:存放好友的集合数据
             */
            Result result = new Result(false, "查询好友列表失败");
            //5.使用fastjson中的JSON类的方法String toJsonString(Object obj)
            String s = JSON.toJSONString(result);
            //5.响应给前端
            response.getWriter().print(s);
        }
    }
}
