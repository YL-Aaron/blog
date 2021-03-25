package com.example.single;

/**
 * @author YL
 * @date 12:01 2021/3/14
 */
public class Huger {

    private Huger() {

    }

    private static Huger huger = new Huger();

    public static Huger getInstance() {
        return huger;
    }
}
