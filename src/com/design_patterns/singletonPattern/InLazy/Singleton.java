package com.design_patterns.singletonPattern.InLazy;

/**
 * Created by Fant.J.
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }
}
