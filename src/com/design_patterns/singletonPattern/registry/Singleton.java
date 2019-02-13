package com.design_patterns.singletonPattern.registry;

/**
 * Created by Fant.J.
 */
public class Singleton {
    private static Singleton instance;

    private static class SingletonHandler{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHandler.INSTANCE;
    }
}
