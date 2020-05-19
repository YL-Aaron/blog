package com.yl.controller.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yl.bean.ApiReturn;
import com.yl.bean.Blog;
import com.yl.enumerate.ReturnCode;
import com.yl.service.BlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yi
 * @desciption 博客api
 * @date 2019/11/18
 */
@RestController
@RequestMapping("/api/blog")
public class ApiBlogController {

    @Resource
    private BlogService blogService;

    /**
     * 获取列表
     * @author YL
     * @date 2019/12/11 14:20
     * @param pageNum
     * @param pageSize
     * @return com.yl.bean.ApiReturn
     */
    @GetMapping("/list")
    public ApiReturn list(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue =
            "10") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogs = blogService.selectAll();
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        return new ApiReturn(ReturnCode.SUCCESS.getCode(),ReturnCode.SUCCESS.getMsg(),pageInfo);
    }
}
