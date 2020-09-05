package com.lintcode.main;

import com.lintcode.sourcecode.MyList;
import com.lintcode.sourcecode.impl.MyArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YL
 * @date 23:21 2020/8/21
 */
public class Array {
    public static void main(String[] args) {
        aa();
    }

    public static void my() {
        MyList<Integer> a = new MyArrayList<>();
        a.add(1);
        //a.add(3);
        //a.add(2, 4);
        System.out.println(a.toString());
    }

    public static void aa() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1, 1);
    }
}
