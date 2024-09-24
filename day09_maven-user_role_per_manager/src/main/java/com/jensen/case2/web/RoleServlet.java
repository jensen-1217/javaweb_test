package com.jensen.case2.web;

import com.jensen.case2.pojo.po.Role;
import com.jensen.case2.pojo.vo.Result;
import com.jensen.case2.service.RoleService;
import com.jensen.case2.utils.BaseController;
import com.jensen.case2.utils.BeansFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/role/*")
public class RoleServlet extends BaseServlet {

    //定义用户下拉框中显示角色的方法
    public void findAllRoses(HttpServletRequest request, HttpServletResponse response){
        try {
            //1.获取业务层对象
            //参数：roleService是配置文件beans.properties中的等号左边的key
            //roleService=com.jensen.case2.service.impl.RoleServiceImpl
            RoleService roleService = BeansFactory.getInstance("roleService");
            //2.使用对象调用业务层方法查询角色
            List<Role> list = roleService.findAllRoses();
            //3.将list封装到Result对象中
            Result result = new Result(true, "查询角色成功", list);
            //4.使用工具类响应给前端
            BaseController.printResult(response,result);
        } catch (Exception e) {
            //显示错误信息到idea控制台给程序员看的
            e.printStackTrace();
            try {
                //5.将list封装到Result对象中
                Result result = new Result(false, "查询角色失败");
                //6.使用工具类响应给前端
                BaseController.printResult(response,result);
            } catch (Exception ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
