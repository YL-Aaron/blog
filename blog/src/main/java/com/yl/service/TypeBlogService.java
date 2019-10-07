package com.yl.service;

import com.yl.bean.TypeBlog;

import java.util.List;
import java.util.Map;

/**
 * @author yi
 * @desciption 类型——博客接口
 * @date 2019/10/2
 */
public interface TypeBlogService extends BaseService<TypeBlog> {
    /**
     * 根据博客编号获取博客类型
     * @author yl
     * @date 2019/10/3 16:31
     * @param blogId id
     * @return java.util.List<com.yl.bean.TypeBlog>
     */
    List<Integer> selectByBlogId(Integer blogId);

    /**
     * 删除
     * @author yl
     * @date 2019/10/3 20:04
     * @param typeBlog
     * @return int
     */
    int delete(TypeBlog typeBlog);
}
