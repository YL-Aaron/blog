package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author YL
 * @date 22:11 2020/12/22
 */
@Component
public class ThreadPoolConfig {

    @Bean
    public ThreadPoolExecutor getThreadPool() {
        return new ThreadPoolExecutor(100, 200, 60, TimeUnit.SECONDS, new SynchronousQueue<>(), r -> new Thread(r,"哈哈哈"));
    }
}
