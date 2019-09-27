package com.yl.dao;


import java.util.List;

/**
 * dao层父类
 * @author YL
 * @date 11:42 2019/9/16
 */
public interface BaseMapper<T> {

    /**
     * 批量删除
     * @author YL
     * @date 2019/9/25 11:48
     * @param id
     * @return int
     */
    int deleteByPrimaryKeys(String[] id);

    /**
     * 新增（全字段）
     * @author YL
     * @date 2019/9/25 11:48
     * @param record
     * @return int
     */
    int insert(T record);

    /**
     * 新增（指定字段）
     * @author YL
     * @date 2019/9/25 11:49
     * @param record
     * @return int
     */
    int insertSelective(T record);

    /**
     * 根据id查询
     * @author YL
     * @date 2019/9/25 11:49
     * @param id
     * @return T
     */
    T selectByPrimaryKey(Integer id);

    /**
     * 更新（指定字段）
     * @author YL
     * @date 2019/9/25 11:49
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 更新（全字段）
     * @author YL
     * @date 2019/9/25 11:49
     * @param record
     * @return int
     */
    int updateByPrimaryKey(T record);

    /**
     * 查询所有
     * @author YL
     * @date 2019/9/25 11:50
     * @param
     * @return java.util.List<T>
     */
    List<T> selectAll();
}
