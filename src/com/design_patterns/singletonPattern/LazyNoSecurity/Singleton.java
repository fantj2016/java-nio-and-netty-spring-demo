package com.design_patterns.singletonPattern.LazyNoSecurity;

/**
 * Created by Fant.J.
 */
public class Singleton {
    private static Singleton instance;

    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
