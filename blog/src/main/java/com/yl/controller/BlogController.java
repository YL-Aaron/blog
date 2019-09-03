package com.yl.controller;

import org.springframework.stereotype.Controller;
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
    public String list(){
        return "/blog/list";
    }
}
