package com.lintcode.demo;

/**
 * 字符串原地旋转
 *
 * @author YL
 * @date 14:51 2020/8/7
 */
public class RotateString {
    public static void main(String[] args) {
        char[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g','a', 'b', 'c', 'd', 'e', 'f', 'g','a', 'b', 'c', 'd', 'e', 'f', 'g','a', 'b', 'c', 'd', 'e', 'f', 'g','a', 'b', 'c', 'd', 'e', 'f', 'g','a', 'b', 'c', 'd', 'e', 'f', 'g','a', 'b', 'c', 'd', 'e', 'f', 'g'};
        rotateString(str, 20);
    }

    public static void rotateString(char[] str, int offset) {
        long date=System.currentTimeMillis();
        if (str==null||str.length==0||offset==0) {
            return;
        }
        int length = str.length;
        char temp;
        for (int i = 0; i < offset % length; i++) {
            temp = str[length - 1];
            int j = length - 2;
            while (j >= 0) {
                str[j + 1] = str[j];
                j--;
            }
            str[0] = temp;
        }
        System.out.println(date-System.currentTimeMillis());
    }
}
