package com.lintcode.sourcecode.impl;

import com.lintcode.sourcecode.MyList;

/**
 * @author YL
 * @date 22:39 2020/8/19
 */
public class MyArrayList<K> implements MyList<K> {

    Object[] elementData;
    private final int defaultInitialCapacity = 10;

    public MyArrayList() {

    }

    public MyArrayList(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }

    @Override
    public void add(K k) {

    }

    @Override
    public K remove(int index) {
        return null;
    }

    @Override
    public void set(int index, K k) {

    }
}
