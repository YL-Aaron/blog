package com.yl.config;

import com.github.pagehelper.util.StringUtil;
import com.yl.util.RedisUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisUtils;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author YL
 * @date 17:42 2021/1/2
 */
public class CustomerMatcher extends HashedCredentialsMatcher {

    @Autowired
    RedisUtil redisUtil;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String loginName = (String) token.getPrincipal();
        //初始化错误登录次数
        AtomicInteger errorNum = new AtomicInteger(0);
        //获取错误登录的次数
        String value = redisUtil.get("login:error:" + loginName);
        if (StringUtil.isNotEmpty(value)) {
            errorNum = new AtomicInteger(Integer.parseInt(value));
        }
        if (errorNum.get() >= 10) {
            throw new ExcessiveAttemptsException();
        }

        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {
            //移除缓存中用户的错误登录次数
            redisUtil.delete("login:error:" + loginName);
        } else {
            //存储错误次数到redis中
            redisUtil.setForTimeMIN("login:error:" + loginName, errorNum.incrementAndGet() + "", 30);
        }
        return matches;

    }
}
