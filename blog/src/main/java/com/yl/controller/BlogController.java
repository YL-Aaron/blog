package com.yl.controller;

import com.yl.bean.Blog;
import com.yl.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yi
 * @desciption 博客控制器
 * @date 2019/9/3
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;

    @RequestMapping("/list")
    public String list(Model model) {
        List<Blog> biogs = blogService.selectAll();
        model.addAttribute("biogs", biogs);
        return "/blog/list";
    }

    @RequestMapping("/add")
    public String add() {
        return "/blog/add";
    }

    /**
     * 保存文章
     *
     * @param title
     * @param content
     * @return java.lang.String
     * @author YL
     * @date 2019/9/15 11:55
     */
    @RequestMapping("/save")
    public String save(String title, String content) {
        Blog blog = new Blog()
                .setContent(content)
                .setTitle(title);
        blogService.insertSelective(blog);
        return "/blog/list";
    }

    /**
     * 预览
     *
     * @param title
     * @param content
     * @return java.lang.String
     * @author YL
     * @date 2019/9/15 11:57
     */
    @RequestMapping("/preview")
    public String preview(String title, String content, Model model) {
        model.addAttribute("title", title);
        model.addAttribute("content", content);
        return "/blog/preview";
    }
}
