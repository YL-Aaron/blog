package com.example.single;

/**
 * @author YL
 * @date 12:05 2021/3/14
 */
public class Main {

    private Main() {
    }

    public static class Holder {
        private static final Main holder = new Main();
    }

    public static Main getInstance() {

        return Holder.holder;
    }
}
