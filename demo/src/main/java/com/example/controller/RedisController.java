package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author YL
 * @date 17:54 2020/6/18
 */
@RestController
public class RedisController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static final String key = "buy";

    @RequestMapping("buy3")
    public String buy3() {
        try {
            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(key, "1");
            if (!result) {
                System.err.println("失败");
                return "error";
            } else {
                Map<String, Object> map = jdbcTemplate.queryForMap("select * from test limit 1");
                int value = Integer.parseInt(map.get("value").toString());
                if (value > 0) {
                    value--;
                    int update = jdbcTemplate.update("update test set value=?", value);
                    if (update > 0) {
                        System.err.println("成功");
                    }
                }
            }
        } finally {
            stringRedisTemplate.delete(key);
        }
        return "end";
    }
}
