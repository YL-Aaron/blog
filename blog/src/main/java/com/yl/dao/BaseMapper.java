package com.yl.dao;


import java.util.List;

/**
 * dao层父类
 * @author YL
 * @date 11:42 2019/9/16
 */
public interface BaseMapper<T> {
    int deleteByPrimaryKeys(String[] id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
