package com.yl.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

public class BlogApplicationTests {

    @Test
    public void contextLoads() {
        String a=null;
        a=a.substring(1);
        a=a.substring(a.lastIndexOf(".") + 1).toLowerCase();
        System.out.println(a);
    }

}
