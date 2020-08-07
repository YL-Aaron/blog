package com.lintcode.demo;

/**
 * @author YL
 * @date 16:50 2020/8/7
 */
public class StrStr {
    public static void main(String[] args) {

    }

    public static int strStr(String source, String target) {
        // Write your code here
        boolean contains = source.contains(target);
        int result=-1;
        if (contains) {
            result = source.indexOf(target);
        }
        return result;
    }
}
