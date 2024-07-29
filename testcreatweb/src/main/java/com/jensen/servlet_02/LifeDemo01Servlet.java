package com.jensen.servlet_02;

import javax.servlet.*;
import java.io.IOException;

/*
1.谁创建Servlet对象？
    tomcat使用反射技术创建对象
2.何时创建Servlet对象？
    第一次访问Servlet类的时候创建Servlet对象，调用无参构造方法创建对象，使用对象立刻调用init方法进行初始化，init方法
    只会执行一次。然后调用service方法处理业务逻辑。
3.创建对象之后每次访问Servlet类的时候只会执行service方法
4.关闭tomcat服务器的时候，关闭之前使用Servlet类的对象调用destroy方法销毁资源

*/

public class LifeDemo01Servlet implements Servlet {
    public LifeDemo01Servlet() {
        System.out.println("无参构造方法执行了");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service...");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
