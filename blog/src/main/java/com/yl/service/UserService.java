package com.yl.service;

import com.yl.bean.User;

/**
 * @author yi
 * @desciption
 * @date 2019/8/28
 */
public interface UserService extends BaseService<User>{

    User login(String userName);
}
