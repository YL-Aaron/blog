package com.yl.dao;


import com.yl.bean.User;

import java.util.List;

/**
 * @author yi
 * @desciption 用户接口
 * @date 2019/8/13
 */
public interface UserMapper extends BaseMapper<User>{
    User login(String userName);
    List<User> selectAll();
}