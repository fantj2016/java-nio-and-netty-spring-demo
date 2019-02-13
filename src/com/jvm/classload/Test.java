package com.jvm.classload;

/**
 * Created by Fant.J.
 */
public abstract class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Object o = myClassLoader.classLoader.loadClass("com.jvm.classload.Son").newInstance();
        System.out.println("Son类对象："+o.getClass());
        System.out.println("Son父类对象："+o.getClass().getSuperclass());

        Object c = myClassLoader.classLoader.loadClass("com.jvm.classload.MyClassLoader").newInstance();
        System.out.println("c对象的类加载器："+c.getClass().getClassLoader());
        System.out.println("myClassLoader对象的类加载器："+myClassLoader.getClass().getClassLoader());
    }
}
