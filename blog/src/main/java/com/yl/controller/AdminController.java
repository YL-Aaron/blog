package com.yl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yi
 * @desciption
 * @date 2019/8/13
 */
@Controller
public class AdminController {

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }

    @RequestMapping("/welcome")
    public String newArticle(){
        return "/welcome";
    }
}
