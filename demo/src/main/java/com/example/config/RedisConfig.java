//package com.example.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
//
//@Configuration
//@EnableCaching
//public class RedisConfig {
//
//    @Value("${spring.redis.host}")
//    private String host;
//
//    @Value("${spring.redis.port}")
//    private int port;
//
//    @Value("${spring.redis.timeout}")
//    private int timeout;
//
//    @Value("${spring.redis.jedis.pool.max-idle}")
//    private int maxIdle;
//
//    @Value("${spring.redis.jedis.pool.max-wait}")
//    private long maxWaitMillis;
//
//    @Value("${spring.redis.block-when-exhausted}")
//    private boolean blockWhenExhausted;
//
//    @Bean
//    public JedisPool redisPoolFactory() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxIdle(maxIdle);
//        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
//        jedisPoolConfig.setMaxTotal(200);
//        //设置最小空闲数
//        jedisPoolConfig.setMinIdle(8);
//        //jedisPoolConfig.setTestOnBorrow(true);
//        //jedisPoolConfig.setTestOnReturn(true);
//        //Idle时进行连接扫描
//        jedisPoolConfig.setTestWhileIdle(true);
//        //表示idle object evitor两次扫描之间要sleep的毫秒数
//        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(30000);
//        //表示idle object evitor每次扫描的最多的对象数
//        jedisPoolConfig.setNumTestsPerEvictionRun(10);
//        //表示一个对象至少停留在idle状态的最短时间，然后才能被idle object evitor扫描并驱逐；这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义
//        jedisPoolConfig.setMinEvictableIdleTimeMillis(60000);
//        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
//        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
//        // 是否启用pool的jmx管理功能, 默认true
//        jedisPoolConfig.setJmxEnabled(true);
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
//        return jedisPool;
//    }
//
//    public String getHost() {
//        return host;
//    }
//
//    public int getPort() {
//        return port;
//    }
//
//    public int getTimeout() {
//        return timeout;
//    }
//
//    public int getMaxIdle() {
//        return maxIdle;
//    }
//
//    public long getMaxWaitMillis() {
//        return maxWaitMillis;
//    }
//
//    public boolean isBlockWhenExhausted() {
//        return blockWhenExhausted;
//    }
//}