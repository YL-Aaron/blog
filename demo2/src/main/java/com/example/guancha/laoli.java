package com.example.guancha;

/**
 * @author YL
 * @date 22:33 2021/3/23
 */
public class laoli implements Person {

    public String name = "老李";

    @Override
    public void getMessage(String s) {
        System.err.println(name + "接到了大妹子打来的电话---》" + s);
    }
}
