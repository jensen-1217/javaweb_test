package com.jensen.json;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class JsonTest {

    @Test
    public void test3(){

        ArrayList<User> list = new ArrayList<>();
        Collections.addAll(list,new User("白岩","123456"),
                new User("张三","123456"),
                new User("李四","123456"));

        HashMap<String, Object> map = new HashMap<>();
        map.put("白岩","123456");
        map.put("我",new User("白岩的爸爸","123456"));
        map.put("白岩2",list);

        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
    }
    /*
    {
    "我":{"password":"123456","username":"白岩的爸爸"},
    "白岩":"123456",
    "白岩2":[{"password":"123456","username":"白岩"},
            {"password":"123456","username":"张三"},
            {"password":"123456","username":"李四"}]
     }


    */

    @Test
    public void test2(){
        ArrayList<User> list = new ArrayList<>();
        Collections.addAll(list,new User("白岩","123456"),
                                new User("张三","123456"),
                                new User("李四","123456"));

        String jsonString = JSON.toJSONString(list);
        System.out.println(jsonString);
        List<User> user= JSON.parseArray(jsonString, User.class);
        System.out.println(user);

    }

    @Test
    public void test1(){
        User user = new User();
        user.setUsername("白岩");
        user.setPassword("123456");
        String jsonStr = JSON.toJSONString(user);
        System.out.println(jsonStr);
        User user1 = JSON.parseObject(jsonStr, User.class);
        System.out.println(user1);
    }
}
