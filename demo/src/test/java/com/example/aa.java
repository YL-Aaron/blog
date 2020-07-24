package com.example;

import java.math.BigDecimal;

/**
 * @author YL
 * @date 14:33 2020/6/19
 */
public class aa {
    public static void main(String[] args) {
        BigDecimal gas=new BigDecimal("5000000000");
        System.out.println(gas.divide(new BigDecimal(Math.pow(10, 18))).toPlainString());
    }
}
