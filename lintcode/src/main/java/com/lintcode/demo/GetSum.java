package com.lintcode.demo;

/**
 * @author YL
 * @date 16:42 2020/8/7
 */
public class GetSum {
    public static void main(String[] args) {
        int sum = getSum(2, 7);
        System.out.println(sum);
    }

    public static int getSum(int A, int B) {
        // Write your code here
        int a = 0;
        for (int i = A; i <= B; i++) {
            if (i % 3 == 0) {
                a += i;
            }
        }
        return a;
    }
}
