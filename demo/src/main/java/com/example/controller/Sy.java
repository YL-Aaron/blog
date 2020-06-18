package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 同步代码块
 * @author YL
 * @date 12:35 2020/6/18
 */
@RestController
public class Sy {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("buy")
    public String buy() {
        synchronized (this) {
            Map<String, Object> map = jdbcTemplate.queryForMap("select * from test limit 1");
            int value = Integer.parseInt(map.get("value").toString());
            if (value > 0) {
                value--;
                int update = jdbcTemplate.update("update test set value=?", value);
                if (update>0){
                    System.err.println("成功");
                }
            }
        }
        return "end";
    }

    public synchronized void aa(int value) {
        System.out.println(value);
        if (value > 0) {
            value--;
            jdbcTemplate.update("update test set value=?", value);
        }
    }


}
