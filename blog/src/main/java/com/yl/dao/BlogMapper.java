package com.yl.dao;

import com.yl.bean.Blog;

import java.util.List;

/**
 * 文章接口
 * @author YL
 * @date 2019/9/16 11:32
 */
public interface BlogMapper extends BaseMapper<Blog>{

    List<Blog> selectAll();
}