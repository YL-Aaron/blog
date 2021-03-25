package com.example.guancha;

/**
 * @author YL
 * @date 22:30 2021/3/23
 */
public class laowang implements Person {

    private String name = "老王";

    @Override
    public void getMessage(String s) {
        System.err.println(name + "接到了大妹子打来的电话----->" + s);
    }
}
