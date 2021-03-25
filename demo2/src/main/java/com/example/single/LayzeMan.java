package com.example.single;

/**
 * @author YL
 * @date 12:07 2021/3/14
 */
public class LayzeMan {

    private LayzeMan() {
        System.out.println(Thread.currentThread().getName() + "\tok");
    }

    private static volatile LayzeMan layzeMan;

    //双重检测锁模式 懒汉式单例 DCL懒汉式
    public static LayzeMan getInstance() {
        if (null == layzeMan) {
            synchronized (LayzeMan.class) {
                if (null == layzeMan) {
                    layzeMan = new LayzeMan();//不是原子操作，遇到指令重排时可能有问题,通过在该对象上添加volatile关键字可避免指令重排
                    /**
                     * 指令重排
                     * 在一个对象实例化时发生的事情
                     *
                     * 1、分配内存空间
                     * 2、执行构造方法，初始化对象
                     * 3、把这个对象指向这个空间
                     *
                     * 正常顺序是123
                     *
                     * 但是指令重排时可能出现132
                     * 出现这种情况时，那么第一步检测对象是否为null就失去了意义，因为此时该对象已不为null,但是该对象的有一些属性还没有初始化完毕，所以，在并发情况下会出现对象不为null,但属性值为null的情况
                     */
                }
            }
        }
        return layzeMan;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                getInstance();
            }).start();
        }
    }
}
