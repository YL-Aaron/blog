package com.yl.service;

import com.yl.bean.Blog;

import java.util.List;

/**
 * 文章接口
 *
 * @author YL
 * @date 11:38 2019/9/16
 */
public interface BlogService extends BaseService<Blog> {

    List<Blog> selectAll();
    Blog selectById(Integer id);
}
