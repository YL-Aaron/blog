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
        model.addAttribute("blogs", biogs);
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
        return "redirect:list";
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

    /**
     * 编辑文章
     *
     * @param id
     * @param model
     * @return java.lang.String
     * @author YL
     * @date 2019/9/17 16:56
     */
    @RequestMapping("/edit")
    public String edit(Integer id, Model model) {
        Blog blog = blogService.selectByPrimaryKey(id);
        model.addAttribute("blog", blog);
        return "/blog/edit";
    }

    /**
     * 更新博客
     * @author YL
     * @date 2019/9/17 17:41
     * @param id
     * @param title
     * @param content
     * @param isShow
     * @return java.lang.String
     */
    @RequestMapping("/update")
    public String update(Integer id, String title, String content,Integer isShow) {
        Blog blog = new Blog()
                .setId(id)
                .setTitle(title)
                .setContent(content)
                .setIsShow(isShow);
        blogService.updateByPrimaryKeySelective(blog);
        return "redirect:list";
    }
}
