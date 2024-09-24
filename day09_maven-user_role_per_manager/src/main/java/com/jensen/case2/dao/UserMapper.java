package com.jensen.case2.dao;


import com.jensen.case2.pojo.po.User;
import com.jensen.case2.pojo.vo.UpdateUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> findAll(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);


    Long findCount();

    void update(UpdateUser updateUser);

    void deleteFromUserAndRoleTableByUID(Integer id);

    void addUIDAndRIDToUserAndRoleTable(@Param("uid")Integer id, @Param("roleIds")List<String> roleIds);
}
