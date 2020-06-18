package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author YL
 * @date 16:17 2020/6/18
 */
@Service
public class BuyServiceImpl implements BuyService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void buy1() throws InterruptedException {
        Map<String, Object> map = jdbcTemplate.queryForMap("select * from test limit 1 for update ");
        Thread.sleep(10000);
        int value = Integer.parseInt(map.get("value").toString());
        if (value > 0) {
            value--;
            int update = jdbcTemplate.update("update test set value=?", value);
            if (update>0){
                System.err.println("成功");
            }
        }
    }
}
