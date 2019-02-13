package com.design_patterns.singletonPattern.LazySecurity;

/**
 * Created by Fant.J.
 * 2018/8/6 14:20
 */
public class Singleton {
    private static Singleton instance;

    public static synchronized Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
