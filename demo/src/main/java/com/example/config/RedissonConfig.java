package com.example.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * redisson配置
 *
 * @author YL
 * @date 2020/6/19 21:45
 */
@Configuration
public class RedissonConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;


    @Bean
    public RedissonClient getClient() {
        Config config = new Config();

        config.useSingleServer().setAddress("redis://" + host + ":" + port);

        return Redisson.create(config);
    }

}