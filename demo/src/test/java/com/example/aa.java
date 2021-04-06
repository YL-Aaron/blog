package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.math.BigDecimal;

/**
 * @author YL
 * @date 14:33 2020/6/19
 */
@SpringBootTest
public class aa {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void aa(){
        redisTemplate.opsForValue().set("bb", "啊");
        Object bb = redisTemplate.opsForValue().get("bb");
        System.out.println(bb);
        stringRedisTemplate.opsForValue().set("aa", "哈哈哈");
        String aa = stringRedisTemplate.opsForValue().get("aa");
        System.out.println(aa);
    }
}
