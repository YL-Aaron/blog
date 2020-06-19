package com.example.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author YL
 * @date 17:54 2020/6/18
 */
@RestController
public class RedisController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private RedissonClient redisson;

    public static final String key = "buy";

    @RequestMapping("buy3")
    public String buy3() {
        RLock lock=redisson.getLock(key);
        try {
            boolean result = lock.tryLock(2, 8, TimeUnit.SECONDS);
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return "end";
    }
}
