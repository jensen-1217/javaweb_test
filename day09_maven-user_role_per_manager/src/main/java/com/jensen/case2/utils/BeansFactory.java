package com.jensen.case2.utils;

import java.util.HashMap;
import java.util.ResourceBundle;

/*
    TODO:当前工厂类的作用就是创建对象的
    回顾：
        一个类对象：
            1）单例 单个对象
            2）多例 多个对象
   我们这里实现产生的对象是单例 userService=com.jensen.case2.service.impl.UserServiceImpl
        1.创建一个Map集合： new HashMap<String,Object>();
        2.Map集合的key:例如配置文件等号左边的标识userService roleService
        3.Map集合的value:就是创建的对象UserServiceImpl 类的对象  RoleServiceImpl类的对象
        4.实现步骤：
            1）创建map集合存储创建的对象
            2）定义静态方法创建具体类的对象
            3）在静态方法中判断map集合的key是否有值，如果没有值，说明第一创建对象
            4）直接使用反射+读取配置文件方式创建对象
            5）将创建的对象作为map集合的value和key存入到map中
            6）返回给调用者创建的对象
 */
public class BeansFactory {

    // 1）创建map集合存储创建的对象
    /*
        key            value
        userService    UserServiceImpl0x001
        roleService    RoleServiceImpl0x002
     */
    private static HashMap<String,Object> map = new HashMap<>();
    // 2）定义静态方法创建具体类的对象
    //多线程安全问题：t1 t2
    public static synchronized  <T> T getInstance(String key) throws Exception{//String key=userService roleService
        // 3）在静态方法中判断map集合的key是否有值，如果没有值，说明第一创建对象
        Object obj = map.get(key);
        // 4）直接使用反射+读取配置文件方式创建对象
        if(obj == null){
            //说明当前map集合中没有传递的key对应的值
            //4.1使用反射+读取配置文件创建对象
            ResourceBundle bundle = ResourceBundle.getBundle("beans");//参数beans表示要关联的配置文件的名字，不能书写后缀名
            //4.2根据配置文件的key获取值 t1
            //userService=com.jensen.case2.service.impl.UserServiceImpl
            String classNameStr = bundle.getString(key);//"com.jensen.case2.service.impl.UserServiceImpl"
            //4.3使用反射创建对象
            Class<?> clazz = Class.forName(classNameStr);
            obj = clazz.newInstance();//调用UserServiceImpl类的无参构造方法
            // 5）将创建的对象作为map集合的value和key存入到map中
            map.put(key,obj);//t1线程创建的对象0x001 t2线程创建的对象0x002
        }
        // 6）返回给调用者创建的对象
        return (T)obj;
    }






}
