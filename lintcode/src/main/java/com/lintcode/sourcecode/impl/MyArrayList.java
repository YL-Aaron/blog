package com.lintcode.sourcecode.impl;

import com.lintcode.sourcecode.MyList;

import java.util.Arrays;

/**
 * @author YL
 * @date 22:39 2020/8/19
 */
public class MyArrayList<K> implements MyList<K> {

    transient Object[] elementData;
    private static final int DEFAULT_INITIAL_CAPACITY = 5;
    private int size = 0;

    public MyArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public MyArrayList(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }

    @Override
    public boolean add(K k) {
        checkCapacity();
        this.elementData[size++] = k;
        return true;
    }

    @Override
    public boolean add(int index,K k) {
        rangeCheckForAdd(index);
        checkCapacity();
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i-1];
        }
        elementData[index] = k;
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
        if (size >= elementData.length) {
            int newLength = size + 1;
            elementData = Arrays.copyOf(elementData, newLength);
        }
    }

    /**
     * 数组越界检查
     *
     * @param index
     * @return void
     * @author YL
     * @date 2020/9/5 14:43
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || 0 > index) {
            throw new IndexOutOfBoundsException("数组越界了");
        }
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object elementDatum : elementData) {
            sb.append(elementDatum).append(",");
        }
        return sb.toString();
    }
}
