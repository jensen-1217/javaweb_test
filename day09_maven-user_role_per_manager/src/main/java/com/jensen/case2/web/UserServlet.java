package com.jensen.case2.web;

import com.jensen.case2.pojo.vo.PageResult;
import com.jensen.case2.pojo.vo.QueryPageBean;
import com.jensen.case2.pojo.vo.Result;
import com.jensen.case2.pojo.vo.UpdateUser;
import com.jensen.case2.service.UserService;
import com.jensen.case2.utils.BaseController;
import com.jensen.case2.utils.BeansFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    TODO:
        以后在创建Servlet我们只需要继承 BaseServlet，而BaseServlet继承了HttpServlet，因此
        UserServlet属于Servlet类
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("删除用户");
    }

    public void add(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("添加用户");
    }
    /*
        修改用户
     */
    public void update(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1.获取请求参数封装到实体类
            UpdateUser updateUser = BaseController.parseJSON2Object(request, UpdateUser.class);
            //2.获取业务层对象
            UserService userService = BeansFactory.getInstance("userService");
            //3.调用业务层更新方法
            userService.update(updateUser);
            //4.创建结果对象
            Result result = new Result(true, "更新用户成功");
            //5.响应给前端
            BaseController.printResult(response,result);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //6.创建结果对象
                Result result = new Result(false, "更新用户失败");
                //7.响应给前端
                BaseController.printResult(response,result);
            } catch (Exception ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1.将前端提交的请求参数即当前页码和每页条数封装到实体类QueryPageBean对象中
            QueryPageBean pb = BaseController.parseJSON2Object(request, QueryPageBean.class);
            //2.创建业务层对象
            /*
                TODO:
                    1.问题：我们以前创建对象都是通过newc创建对象，例如创建业务层对象：
                            new UserServiceImpl();
                     这种方式创建对象的弊端是：严重耦合。如果业务层实现类UserServiceImpl被删除了，web报错。或者我们实际开发中
                     向对业务层进行扩展，一般是定义一个新的业务层类UserServiceImpl2，然后将之前的UserServiceImpl替换。就造成
                     web层无法运行，那么太过于耦合。
                   2.解决问题：降低耦合。就是不在web层类中使用new方式创建对象。
                   使用：反射+面向接口编程+读取配置文件+工厂设计模式等方式取代new创建对象
             */
//            UserServiceImpl userService = new UserServiceImpl();
            //实现左边解耦合了，如果扩展实现类只需要修改等号右边
//            UserService userService = new UserServiceImpl();

//            //使用反射+读取配置文件创建对象
//            ResourceBundle bundle = ResourceBundle.getBundle("beans");//参数beans表示要关联的配置文件的名字，不能书写后缀名
//            //根据配置文件的key获取值
//            //userService=com.jensen.case2.service.impl.UserServiceImpl
//            String classNameStr = bundle.getString("userService");//"com.jensen.case2.service.impl.UserServiceImpl"
//            //使用反射创建对象
//            Class<?> clazz = Class.forName(classNameStr);
//            UserService userService = (UserService) clazz.newInstance();//调用UserServiceImpl类的无参构造方法

            //TODO:从SpringIOC的工厂中获取UserServiceImpl类的对象
            UserService userService = BeansFactory.getInstance("userService");
//            UserService userService1 = BeansFactory.getInstance("userService");
//            UserService userService2 = BeansFactory.getInstance("userService");
            //3.使用对象调用方法
            PageResult pageResult = userService.findAll(pb);
            //4.创建Result对象
            Result result = new Result(true, "查询用户成功", pageResult);
            //5.将result转换为json之后响应给前端
            BaseController.printResult(response,result);
        } catch (Exception e) {
            //打印到控制台
            e.printStackTrace();
            try {
                //响应给浏览器
                //6.创建Result对象
                Result result = new Result(false, "查询用户失败");
                //7.将result转换为json之后响应给前端
                BaseController.printResult(response,result);
            } catch (Exception ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
