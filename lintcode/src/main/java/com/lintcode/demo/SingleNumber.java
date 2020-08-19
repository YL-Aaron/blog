package com.lintcode.demo;

import java.util.Map;

/**
 * 落单的数
 * @author YL
 * @date 16:21 2020/8/7
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] A = {1, 1, 2, 3, 2, 4, 4};
        int i = singleNumber(A);
        System.out.println(i);
    }

    public static int singleNumber(int[] A) {
        // write your code here
        int a=0;
        for (int i : A) {
            a^=i;
        }
        return a;

    }
}
