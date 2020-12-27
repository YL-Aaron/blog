package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author YL
 * @date 1:43 2020/12/12
 */
@RestController
public class bb {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @RequestMapping("/bb")
    public String aa() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();
        threadPoolExecutor.execute(() -> {
            for (Integer i = 0; i < 100000; i++) {
                if (i % 2 == 0) {
                    stringBuilder.append(i).append(",");
                }
                stringBuilder1.append(i).append(",");
            }
            String sql = "insert  into b values(?,?)";
            int update = jdbcTemplate.update(sql, stringBuilder.toString(), stringBuilder1.toString());
            System.out.println(Thread.currentThread().getName()+"\t"+update);
        });

        return "ok";
    }
}
