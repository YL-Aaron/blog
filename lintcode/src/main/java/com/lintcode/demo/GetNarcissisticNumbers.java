package com.lintcode.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取水仙花数
 *
 * @author YL
 * @date 10:23 2020/7/24
 */
public class GetNarcissisticNumbers {

    public static void main(String[] args) {
        List<Integer> narcissisticNumbers = getNarcissisticNumbers(2);
        System.out.println(narcissisticNumbers);
    }

    public static List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        StringBuffer a = new StringBuffer();
        StringBuffer b = new StringBuffer();
        if (n < 2) {
            a.append(0);
        } else {
            a.append(1);
        }
        b.append(9);
        for (int i = 0; i < n - 1; i++) {
            a.append(0);
            b.append(9);
        }
        int c = Integer.parseInt(a.toString());
        int d = Integer.parseInt(b.toString());

        for (int i = c; i < d + 1; i++) {
            boolean ad = ad(i, c, n);
            if (ad) {
                result.add(i);
            }
        }
        return result;
    }

    private static int pow(int a, int b) {
        int c = a;
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        for (int i = 0; i < b - 1; i++) {
            c = c * a;
        }
        return c;
    }

    private static boolean ad(int i, int c, int n) {
        if (c == 0) {
            c = 1;
        }
        int c1 = i / c;
        int s1 = i % c;
        int a = pow(c1, n);

        for (int j = 0; j < n; j++) {
            c = c / 10;
            if (c == 0) {
                break;
            }
            int c2 = s1 / c;
            s1 = i % c;
            a += pow(c2, n);
        }
        if (a == i) {
            return true;
        }
        return false;
    }
}
