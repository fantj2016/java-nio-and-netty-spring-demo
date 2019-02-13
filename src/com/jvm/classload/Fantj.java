package com.jvm.classload;

/**
 * Created by Fant.J.
 */
public class Fantj {
    public static  int high = 180;
    static {
        System.out.println("静态初始化类Fantj ");
        high = 185;
    }
    public Fantj(){
        System.out.println("创建Fantj 类的对象");
    }
    public static void boss(){
        System.out.println("boss静态方法初始化");
    }
}
