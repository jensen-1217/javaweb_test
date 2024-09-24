package com.jensen.case2.service.impl;

import com.jensen.case2.dao.RoleMapper;
import com.jensen.case2.pojo.po.Role;
import com.jensen.case2.service.RoleService;
import com.jensen.case2.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    //TODO:用户下拉框中查询角色信息的方法
    @Override
    public List<Role> findAllRoses() {
        //1.获取mybatis会话对象
        SqlSession session = SqlSessionUtil.getSession();
        //2.获取接口代理对象
        RoleMapper mapper = session.getMapper(RoleMapper.class);
        //3.调用查询所有角色方法
        List<Role> list = mapper.findAllRoses();
        //4.释放资源
        session.close();
        //5.将list返回给web层
        return list;
    }
}
