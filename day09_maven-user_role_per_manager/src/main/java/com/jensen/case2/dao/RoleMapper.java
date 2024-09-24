package com.jensen.case2.dao;

import com.jensen.case2.pojo.po.Role;

import java.util.List;

public interface RoleMapper {

    //角色下拉框查询角色信息
    List<Role> findAllRoses();
}
