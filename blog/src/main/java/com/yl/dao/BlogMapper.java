package com.yl.dao;

import com.yl.bean.Blog;
import com.yl.bean.BlogSearch;

import java.util.List;

/**
 * 文章接口
 * @author YL
 * @date 2019/9/16 11:32
 */
public interface BlogMapper extends BaseMapper<Blog>{

    /**
     * 更新id查询
     * @author YL
     * @date 2019/9/25 11:52
     * @param id
     * @return com.yl.bean.Blog
     */
    Blog selectById(Integer id);

    /**
     * 添加博客并返回主键
     * @author YL
     * @date 2019/12/26 14:40
     * @param blog
     * @return int
     */
    int insertBlog(Blog blog);

    /**
     * 条件查询列表
     * @author YL
     * @date 2019/12/26 14:41
     * @param sreach
     * @return java.util.List<com.yl.bean.Blog>
     */
    List<Blog> selectAll(BlogSearch sreach);
}