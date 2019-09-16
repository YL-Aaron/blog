package com.yl.service.impl;

import com.yl.bean.Blog;
import com.yl.dao.BlogMapper;
import com.yl.service.BlogService;
import org.springframework.stereotype.Service;

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

    @Override
    public List<Blog> selectAll() {
        return blogMapper.selectAll();
    }
}
