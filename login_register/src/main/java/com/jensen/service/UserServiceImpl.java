package com.jensen.service;

import com.jensen.dao.UserMapper;
import com.jensen.pojo.User;
import com.jensen.util.MyBatisUtil;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl {
    public User login(User user) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u=mapper.login(user);
        sqlSession.close();
        return u;
    }

    public Integer register(User user) {
        SqlSession sqlSession=null;
        try {
            sqlSession = MyBatisUtil.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User u=mapper.queryUserByUsername(user.getUsername());
            if(u==null){
                Integer row= mapper.register(user);

                return row;
            }else {
                MyBatisUtil.closeSqlSession(sqlSession);
                return 0;
            }
        } finally {
            if(sqlSession!=null) {
                MyBatisUtil.closeSqlSession(sqlSession);
            }
        }

    }
}
