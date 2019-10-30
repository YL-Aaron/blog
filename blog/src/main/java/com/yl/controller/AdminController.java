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
        return "index";
    }

    @RequestMapping("/welcome")
    public String newArticle(Model model) {
        //获取用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String jdk = System.getProperty("java.version");
        String system = System.getProperty("os.name");
        String vendor = System.getProperty("java.vendor");
        model.addAttribute("userName", user.getUsername());
        model.addAttribute("jdk",jdk);
        model.addAttribute("system", system);
        model.addAttribute("vendor", vendor);
        return "welcome";
    }

    @RequestMapping("/welcome1")
    public String newArticle1() {
        return "welcome1";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(String userName, String password, Model model) {
        try {
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            model.addAttribute("userName", userName);
            return "index";
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return "login";
    }

    @GetMapping("/loginOut")
    public String loginOut() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
