package com.lintcode.demo;

/**
 * 数组中的两数之和等于目标数据 输出这两个数字的下标
 * @author YL
 * @date 10:06 2020/7/24
 */
public class TwoNum {
    public static void main(String[] args) {

        int[] a = new int[]{2, 9, 11, 7};
        int target = 9;
        int[] ints = twoSum(a, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 两数之和等于
     * @author YL
     * @date 2020/7/24 9:45
     * @param numbers
     * @param target
     * @return int[]
     */
    public static int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int a = numbers[i];
            for (int j = 0; j < numbers.length; j++) {

                int f = j;
                boolean flag = false;
                int b = 0;
                if (i == f) {
                    f++;
                }
                if (f >= numbers.length) {
                    f = 0;
                    flag = true;
                }
                b = numbers[f];
                if (a + b == target) {
                    if (i > f){
                        result[0] = f;
                        result[1] = i;
                    }else {
                        result[0] = i;
                        result[1] = f;
                    }
                    break;
                }
                if (flag) {
                    break;
                }
            }
        }
        return result;
    }
}
