package com.reflection.detail;

import java.lang.reflect.Array;

/**
 * Created by Fant.J.
 * 2018/2/7 16:50
 */
public class Reflection_Arrays {
    public static void main(String[] args) throws ClassNotFoundException {

        //用反射来定义一个int类型，3长度的数组
        int[] intArray = (int[]) Array.newInstance(int.class, 3);

        Array.set(intArray, 0, 123);
        Array.set(intArray, 1, 456);
        Array.set(intArray, 2, 789);

        System.out.println("intArray[0] = " + Array.get(intArray, 0));
        System.out.println("intArray[1] = " + Array.get(intArray, 1));
        System.out.println("intArray[2] = " + Array.get(intArray, 2));

        //获取类对象的类型
        Class aClass = getClass("int");
        //获取类对象的一个数组
        Class stringArrayClass = Array.newInstance(aClass, 0).getClass();
        System.out.println("is array: " + stringArrayClass.isArray());


        //获取数组的组件类型
        String[] strings = new String[3];
        Class stringArrayClass2 = strings.getClass();
        Class stringArrayComponentType = stringArrayClass2.getComponentType();
        System.out.println(stringArrayComponentType);






    }
    static Class getClass(String className) throws ClassNotFoundException {
        if("int" .equals(className)) {return int .class;}
        if("long".equals(className)) {return long.class;}

        return Class.forName(className);
    }
}
