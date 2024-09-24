package com.jensen.case2.service.impl;

import com.jensen.case2.dao.UserMapper;
import com.jensen.case2.pojo.po.User;
import com.jensen.case2.pojo.vo.PageResult;
import com.jensen.case2.pojo.vo.QueryPageBean;
import com.jensen.case2.pojo.vo.UpdateUser;
import com.jensen.case2.service.UserService;
import com.jensen.case2.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements UserService {
    //1.分页查询用户
    public PageResult findAll(QueryPageBean pb) {
        //2.获取mybatis会话对象
        SqlSession session = SqlSessionUtil.getSession();
        //3.获取接口代理对象
        UserMapper mapper = session.getMapper(UserMapper.class);
        //4.使用接口代理对象调用接口中分页查询的用户方法
        //select * from 表名 limit 起始索引,每页条数;
        //调用方法获取起始索引
        Integer startIndex = pb.getOffset();
        //获取每页条数
        Integer pageSize = pb.getPageSize();
        List<User> list = mapper.findAll(startIndex,pageSize);

        //5.使用接口代理对象调用接口中查询总记录数方法
        Long total = mapper.findCount();
        //6.创建存储查询结果的实体类对象  public PageResult(Long total, List rows)
        PageResult pageResult = new PageResult(total,list);
        //7.关闭会话
        session.close();
        //8.将结果对象返回给web层
        return pageResult;
    }
    //更新用户
    @Override
    public void update(UpdateUser updateUser) {
        //1.获取mybatis会话对象
        SqlSession session = SqlSessionUtil.getSession();
        //2.获取接口代理对象
        UserMapper mapper = session.getMapper(UserMapper.class);
        //3.使用接口代理对象调用接口中更新用户表t_user的数据
        mapper.update(updateUser);
        //4.使用接口代理对象调用接口中根据用户id到中间表t_user_role中删除用户数据
        mapper.deleteFromUserAndRoleTableByUID(updateUser.getId());
        //5.使用接口代理对象调用接口中向中间表t_user_role中插入数据的方法
//        updateUser.getId(); //表示用户的id
//        updateUser.getRoleIds(); //表示当前用户对应的新的角色id
//        List<String> list = updateUser.getRoleIds();//{1,2,3}
        mapper.addUIDAndRIDToUserAndRoleTable(updateUser.getId(),updateUser.getRoleIds());
        //6.释放资源
        session.close();
    }
}
