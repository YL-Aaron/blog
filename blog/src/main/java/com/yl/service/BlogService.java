package com.yl.service;

import com.yl.bean.Blog;
import com.yl.bean.BlogSearch;

import java.util.List;

/**
 * 文章接口
 *
 * @author YL
 * @date 11:38 2019/9/16
 */
public interface BlogService extends BaseService<Blog> {

    /**
     * 根据id查询博客（不查content）
     * @author YL
     * @date 2019/9/29 17:59
     * @param id
     * @return com.yl.bean.Blog
     */
    Blog selectById(Integer id);

    /**
     * 重写 增加条件查询
     * @author YL
     * @date 2019/12/26 14:39
     * @param sreach
     * @return java.util.List<com.yl.bean.Blog>
     */
    List<Blog> selectAll(BlogSearch sreach);
    /**
     * 添加博客，同时添加博客类型
     * @author yl
     * @date 2019/10/3 20:11
     * @param blog
     * @param typeId
     * @return int
     */
    int insertBlog(Blog blog,Integer[] typeId);

    /**
     * 更新博客，同时更新博客类型
     * @author yl
     * @date 2019/10/3 20:18
     * @param blog
     * @param typeId
     * @return int
     */
    int updateBlog(Blog blog,Integer[] typeId);
}
