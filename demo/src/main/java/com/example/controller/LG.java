package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author YL
 * @date 17:12 2020/6/18
 */
@RestController
public class LG {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("buy2")
    public String buy() {
        Map<String, Object> map = jdbcTemplate.queryForMap("select * from test limit 1");
        int value = Integer.parseInt(map.get("value").toString());
        Long nanoTime = Long.parseLong(map.get("nano_time").toString());
        if (value > 0) {
            value--;
            long newNanoTime = System.nanoTime();
            int update = jdbcTemplate.update("update test set value=?,nano_time=? where nano_time=?", value, newNanoTime, nanoTime);
            if (update > 0) {
                System.err.println("成功");
            }
        }
        return "end";
    }


    @RequestMapping("buy21")
    public String buy1() {
        Map<String, Object> map = jdbcTemplate.queryForMap("select * from test limit 1");
        int value = Integer.parseInt(map.get("value").toString());
        Long version = Long.parseLong(map.get("version").toString());
        if (value > 0) {
            value--;
            long newVersion = version + 1;
            int update = jdbcTemplate.update("update test set value=?,version=? where version=?", value, newVersion, version);
            if (update > 0) {
                System.err.println("成功");
            }
        }
        return "end";
    }
}
