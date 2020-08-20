package com.lintcode.sourcecode.impl;

import com.lintcode.sourcecode.MyList;

/**
 * @author YL
 * @date 22:39 2020/8/19
 */
public class MyArrayList<K> implements MyList<K> {

    Object[] elementData;
    private final int defaultInitialCapacity = 10;
    private int size = 0;

    public MyArrayList() {
        this.elementData = new Object[defaultInitialCapacity];
    }

    public MyArrayList(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }

    @Override
    public boolean add(K k) {
        //TODO 扩容
        this.elementData[size++] = k;
        return true;
    }

    /**
     * 检查数组，判断是否需要扩容
     *
     * @return void
     * @author YL
     * @date 2020/8/20 23:34
     */
    private void checkCapacity() {

    }

    @Override
    public K remove(int index) {
        return null;
    }

    @Override
    public int clear() {
        return 0;
    }

    @Override
    public void set(int index, K k) {

    }
}
