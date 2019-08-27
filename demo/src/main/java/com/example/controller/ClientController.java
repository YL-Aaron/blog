package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {
    @RequestMapping("/client")
    public String client(String user, Model model) {
        model.addAttribute("username", user);
        return "/client";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }
}
