package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author YL
 * @date 18:55 2020/6/18
 */
@RestController
public class aa {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("buy4")
    public String buy4(){
        Map<String, Object> map = jdbcTemplate.queryForMap("select * from test limit 1");
        int value = Integer.parseInt(map.get("value").toString());
        if (value > 0) {
            value--;
            int update = jdbcTemplate.update("update test set value=?", value);
            if (update>0){
                System.err.println("成功");
            }
        }
        return "end";
    }
}
