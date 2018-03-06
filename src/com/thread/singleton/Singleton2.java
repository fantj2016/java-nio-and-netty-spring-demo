package com.thread.singleton;

/**
 * 单例模式 -- 懒汉式
 * Created by Fant.J.
 * 2018/2/25 19:30
 */
public class Singleton2 {


    private Singleton2(){}

    private static Singleton2 instance;

    public synchronized static Singleton2 getInstance()  {
        /* 下面这段代码  不是原子性操作  会出现线程安全问题 。
            解决方法：1.给方法加上synchronized（变成单线程，影响性能）
                    2.给代码块加synchronized（双重检查加锁）
                      虽然2方法解决了性能问题，  但是还会有问题 。
                      问题来自  jvm 的优化：指令重排序（有兴趣了解）
                      我们可以在对象中添加volatile 关键字来 不让jvm对该 对象做优化
        **/
        if (instance == null) {
            synchronized (Singleton2.class){
                if (instance == null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
