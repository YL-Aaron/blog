package com.lintcode.main;

import com.lintcode.sourcecode.MyList;
import com.lintcode.sourcecode.impl.MyArrayList;

/**
 * @author YL
 * @date 23:21 2020/8/21
 */
public class Array {
    public static void main(String[] args) {
        MyList<Integer> a = new MyArrayList<>();
        a.add(1);
        a.add(2);
        System.out.println(a);
    }
}
