package com.jvm.methodInvoke;

/**
 * 动态分派（方法覆盖）
 * Created by Fant.J.
 */
public class Test2 {
    static abstract class Phone{
        abstract void show();
    }
    static class Mi extends Phone{
        @Override
        void show() {
            System.out.println("phone is mi");
        }
    }
    static class Iphone extends Phone{
        @Override
        void show() {
            System.out.println("phone is iphone");
        }
    }

    public static void main(String[] args) {
        Phone mi = new Mi();
        Phone iphone = new Iphone();
        mi.show();
        iphone.show();
        mi = new Iphone();
        mi.show();
    }
}
