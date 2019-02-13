package com.design_patterns.builderPattern;

/**
 * Created by Fant.J.
 * 2018/8/13 9:17
 */
public class Main {
    public static void main(String[] args) {
        Direct direct = new Direct();
        Phone phone = direct.constructMi8(new ConcreteBuilder());
        System.out.println(phone);
    }
}
