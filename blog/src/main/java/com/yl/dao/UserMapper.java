package com.yl.dao;


import com.yl.bean.User;

import java.util.List;

/**
 * @author yi
 * @desciption 用户接口
 * @date 2019/8/13
 */
public interface UserMapper extends BaseMapper<User>{

    /**
     * 登录
     * @author YL
     * @date 2019/9/25 11:52
     * @param userName
     * @return com.yl.bean.User
     */
    User login(String userName);
}