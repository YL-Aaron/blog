package com.lintcode.sourcecode;

/**
 * @author YL
 * @date 23:08 2020/8/19
 */
public interface MyList<K> {

    /**
     * 添加
     *
     * @param k 需添加的元素
     * @return boolean 成功即为true 否则反之
     * @author YL
     * @date 2020/8/19 23:09
     */
    public boolean add(K k);

    /**
     * 添加元素到指定位置
     *
     * @param k 元素
     * @param index 下下表
     * @return boolean
     * @author YL
     * @date 2020/8/23 21:09
     */
    public boolean add(K k, int index);

    /**
     * 删除指定位置的元素
     *
     * @param index 下标位置
     * @return K
     * @author YL
     * @date 2020/8/19 23:10
     */
    public K remove(int index);

    /**
     * 删除全部元素
     *
     * @param
     * @return int
     * @author YL
     * @date 2020/8/20 23:26
     */
    public int clear();

    /**
     * 在指定位置添加元素
     *
     * @param index 下标
     * @param k     需添加的元素
     * @return void
     * @author YL
     * @date 2020/8/19 23:11
     */
    public void set(int index, K k);
}
