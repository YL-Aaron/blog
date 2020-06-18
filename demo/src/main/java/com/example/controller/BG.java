package com.example.controller;

import com.example.service.BuyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * for update 数据库锁 仅适用于InnoDB，并且必须开启事务，在begin与commit之间才生效。 会阻塞其他事物
 * 悲观锁 认为数据在被修改的时候一定会存在并发问题，因此在整个数据处理过程中将数据锁定
 * @author YL
 * @date 16:01 2020/6/18
 */
@RestController
public class BG {

    @Resource
    private BuyService buyService;

    @RequestMapping("buy1")
    public String buy() throws InterruptedException {
        buyService.buy1();
        return "end";
    }
}
