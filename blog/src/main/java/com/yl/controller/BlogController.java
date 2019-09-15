package com.yl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yi
 * @desciption 博客控制器
 * @date 2019/9/3
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @RequestMapping("/list")
    public String list() {
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
        model.addAttribute("content",content);
        return "/blog/preview";
    }
}
