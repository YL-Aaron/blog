package com.lintcode.sourcecode;

/**
 * @author YL
 * @date 23:08 2020/8/19
 */
public interface MyList<K> {

    /**
     * 添加
     * @author YL
     * @date 2020/8/19 23:09
     * @param k 需添加的元素
     * @return void
     */
    public void add(K k);

    /**
     * 删除指定位置的元素
     * @author YL
     * @date 2020/8/19 23:10
     * @param index 下标位置
     * @return K
     */
    public K remove(int index);

    /**
     * 在指定位置添加元素
     * @author YL
     * @date 2020/8/19 23:11
     * @param index 下标
     * @param k 需添加的元素
     * @return void
     */
    public void set(int index,K k);
}
