package com.yl.service.impl;

import com.yl.bean.Blog;
import com.yl.bean.BlogSearch;
import com.yl.bean.TypeBlog;
import com.yl.dao.BlogMapper;
import com.yl.dao.TypeBlogMapper;
import com.yl.service.BlogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * 文章实现类
 *
 * @author YL
 * @date 11:39 2019/9/16
 */
@Service
public class BlogServiceImpl extends BaseServiceImpl<Blog> implements BlogService {

    private BlogMapper blogMapper;

    @Resource
    public void setBlogMapper(BlogMapper blogMapper) {
        this.baseMapper = this.blogMapper = blogMapper;
    }

    @Resource
    private TypeBlogMapper typeBlogMapper;


    @Override
    public List<Blog> selectAll(BlogSearch search) {
        return blogMapper.selectAll(search);
    }

    @Override
    public Blog selectById(Integer id) {
        return blogMapper.selectById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertBlog(Blog blog, Integer[] typeId) {
        int rows = blogMapper.insertBlog(blog);
        if (rows > 0) {
            int blogId = blog.getId();
            for (Integer id : typeId) {
                TypeBlog typeBlog = new TypeBlog().setBlogId(blogId).setTypeId(id);
                typeBlogMapper.insert(typeBlog);
            }
        }
        return rows;
    }

    /**
     * 更新博客，同时更新博客类型
     * @author yl
     * @date 2019/10/3 20:18
     * @param blog
     * @param typeId
     * @return int
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateBlog(Blog blog, Integer[] typeId) {
        int rows = blogMapper.updateByPrimaryKeySelective(blog);
        if (rows > 0) {
            int blogId = blog.getId();
            //先删除原先的中间表
            typeBlogMapper.delete(new TypeBlog().setBlogId(blogId));
            for (Integer id : typeId) {
                TypeBlog typeBlog = new TypeBlog().setBlogId(blogId).setTypeId(id);
                typeBlogMapper.insert(typeBlog);
            }
        }
        return rows;
    }
}
