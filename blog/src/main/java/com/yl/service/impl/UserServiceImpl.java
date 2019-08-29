package com.yl.service.impl;

import com.yl.bean.User;
import com.yl.dao.UserMapper;
import com.yl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yi
 * @desciption
 * @date 2019/8/28
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String userName) {
        return userMapper.login(userName);
    }
}
