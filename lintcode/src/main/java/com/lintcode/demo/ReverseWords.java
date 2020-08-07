package com.lintcode.demo;

/**
 * @author YL
 * @date 16:54 2020/8/7
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s = reverseWords("How are you?");
        System.out.println(s);
    }

    public static String reverseWords(String s) {
        // write your code here
        String[] s1 = s.split("\\s+");
        int len = s1.length;
        if (len == 0) {
            return "";
        }
        if (len < 2) {
            return s1[0];
        }
        for (int i = 0; i < len / 2; i++) {
            String a = s1[i];
            s1[i] = s1[len - i - 1];
            s1[len - i - 1] = a;
        }

        StringBuilder buffer = new StringBuilder();
        for (String s2 : s1) {
            buffer.append(s2).append(" ");
        }
        return buffer.toString().trim();
    }
}
