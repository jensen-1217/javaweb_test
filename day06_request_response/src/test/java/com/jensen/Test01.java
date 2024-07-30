package com.jensen;

import org.junit.Test;

import java.util.HashMap;

public class Test01 {
    @Test
    public void test01(){
        HashMap<String, Integer> map = new HashMap<>();

        map.put("张三",13);
        map.put("李四",14);
        map.put("王五",15);
        map.put("赵六",16);

        map.forEach((name,age)->{
            System.out.println(name+":"+age);
        });
    }

}
