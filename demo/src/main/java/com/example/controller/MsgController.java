package com.example.controller;

import com.example.server.AcgistVideoServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class MsgController {

    @RequestMapping("/msg")
    public String msg(String oid, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        log.error(oid);
        String uid = request.getSession().getId();
        model.addAttribute("initiator", "false");
        if (!AcgistVideoServer.canCreate()) {
            response.getWriter().write("不能创建通话房间，超过最大创建数量！");
            return null;
        }

        if (!AcgistVideoServer.canJoin(oid)) {
            response.getWriter().write("对不起对方正在通话中，你不能加入！");
            return null;
        }

        if (AcgistVideoServer.addUser(uid, oid)) {
            model.addAttribute("uid", uid);
        } else {
            model.addAttribute("initiator", "true");

            model.addAttribute("uid", uid);
            model.addAttribute("oid", oid);
        }
        return "c";
    }
}
