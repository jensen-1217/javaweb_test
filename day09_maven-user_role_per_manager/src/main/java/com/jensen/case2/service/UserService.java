package com.jensen.case2.service;

import com.jensen.case2.pojo.vo.PageResult;
import com.jensen.case2.pojo.vo.QueryPageBean;
import com.jensen.case2.pojo.vo.UpdateUser;

public interface UserService {
    //分页查询
    public PageResult findAll(QueryPageBean pb);
    //更新用户
    void update(UpdateUser updateUser);
}
