package com.yl.service.impl;

import com.yl.bean.TypeBlog;
import com.yl.dao.TypeBlogMapper;
import com.yl.service.BaseService;
import com.yl.service.TypeBlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yi
 * @desciption 类型-博客接口实现类
 * @date 2019/10/2
 */
@Service
public class TypeBlogServiceImpl extends BaseServiceImpl<TypeBlog> implements TypeBlogService {

    private TypeBlogMapper typeBlogMapper;

    @Resource
    public void setTypeBlogMapper(TypeBlogMapper typeBlogMapper) {
        this.baseMapper=this.typeBlogMapper = typeBlogMapper;
    }

    @Override
    public List<Integer> selectByBlogId(Integer blogId) {
        List<TypeBlog> type = typeBlogMapper.selectByBlogId(blogId);
        List<Integer> data = new ArrayList<>();
        for (TypeBlog typeBlog: type){
            data.add(typeBlog.getTypeId());
        }
        return data;
    }

    @Override
    public int delete(TypeBlog typeBlog) {
        return typeBlogMapper.delete(typeBlog);
    }
}
