package com.yl.controller;

import com.yl.bean.User;
import com.yl.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author yi
 * @desciption
 * @date 2019/8/13
 */
@Controller
public class AdminController {

    @RequestMapping("/index")
    public String index() {
        return "/index";
    }

    @RequestMapping("/welcome")
    public String newArticle() {
        return "/welcome";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @PostMapping("/loginUser")
    public String loginUser(String username, String password, Model model) {
        try {
            password= DigestUtils.md5DigestAsHex(password.getBytes());
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            model.addAttribute("userName",username);
            return "index";
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return "login";
    }

    @GetMapping("/loginOut")
    public String loginOut(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
