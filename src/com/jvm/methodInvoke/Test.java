package com.jvm.methodInvoke;

/**
 * 静态分派（方法重载）
 * Created by Fant.J.
 * 2018/8/13 17:52
 */
public class Test {
    static class Phone{}
    static class Mi extends Phone{}
    static class Iphone extends Phone{}

    public void show(Mi mi){
        System.out.println("phone is mi");
    }
    public void show(Iphone iphone){
        System.out.println("phone is iphone");
    }
    public void show(Phone phone){
        System.out.println("phone parent class be called");
    }

    public static void main(String[] args) {
        Phone mi = new Mi();
        Phone iphone = new Iphone();

        Test test = new Test();
        test.show(mi);
        test.show(iphone);
        test.show((Mi)mi);
    }
}
