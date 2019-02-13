package com.design_patterns.singletonPattern.dcl;

/**
 *
 * 双重检测
 * Created by Fant.J.
 * 2018/8/6 14:31
 */
public class Singleton {
    private static Singleton instance;

    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
