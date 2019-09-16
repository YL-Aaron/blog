package com.yl.service.impl;

import com.yl.bean.User;
import com.yl.dao.UserMapper;
import com.yl.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yi
 * @desciption
 * @date 2019/8/28
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private UserMapper userMapper;

    @Resource
    public void setUserMapper(UserMapper userMapper) {
        this.baseMapper=this.userMapper = userMapper;
    }

    @Override
    public User login(String userName) {
        return userMapper.login(userName);
    }
}
