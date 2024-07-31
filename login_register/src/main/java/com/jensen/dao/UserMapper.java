package com.jensen.dao;

import com.jensen.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {


    @Select("select * from user where username=#{username} and password=#{password}")
    User login(User user);

    @Insert("insert into user values (null,#{username},#{password})")
    Integer register(User user);

    @Select("select * from user where username=#{username}")
    User queryUserByUsername(String username);
}
