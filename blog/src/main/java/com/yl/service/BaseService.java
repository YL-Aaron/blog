package com.yl.service;

import com.yl.bean.Blog;

/**
 * service层父类
 * @author YL
 * @date 11:47 2019/9/16
 */
public interface BaseService<T>{
    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
