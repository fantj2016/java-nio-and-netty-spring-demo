package com.design_patterns.singletonPattern;

import com.design_patterns.singletonPattern.enum_pt.Singleton;

/**
 * Created by Fant.J.
 * 2018/8/6 15:04
 */
public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        singleton.myMethod();
    }
}
