package com.thread.singleton;

/**
 * 单例模式-- 饿汉式
 * Created by Fant.J.
 * 2018/2/25 19:24
 */
public class Singleton1 {
    /** 私有化构造方法,在外部不能实例化对象 */
    private Singleton1(){}

    /** 在这里实例化 静态对象  （优点：不存在线程安全问题。  缺点：每次调用都实例化，占用空间） */
    private static Singleton1 singleton1 = new Singleton1();

    public static Singleton1 getInstance(){
        return singleton1;
    }

}
