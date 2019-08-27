package com.yl.dao;


import com.yl.bean.User;

/**
 * @author yi
 * @desciption 用户接口
 * @date 2019/8/13
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}