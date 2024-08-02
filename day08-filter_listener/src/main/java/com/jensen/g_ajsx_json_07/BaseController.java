package com.jensen.g_ajsx_json_07;

import com.alibaba.fastjson.JSON;
import com.jensen.d_filter_04.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
    //解析前端提交的json格式的数据
    public static <T> T parseJsonToObject(HttpServletRequest request,Class<T> clazz) throws Exception{
       T obj = JSON.parseObject(request.getInputStream(), clazz);
        return obj;

    }

    //将后端的json数据响应给前端
    public static void responseJsonToBrowser(HttpServletResponse response,Object obj) throws Exception{
        String jsonString = JSON.toJSONString(obj);
        response.getWriter().print(jsonString);
    }
}
