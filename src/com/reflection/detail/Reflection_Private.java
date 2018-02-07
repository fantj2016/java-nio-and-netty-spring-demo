package com.reflection.detail;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Fant.J.
 * 2018/2/7 15:28
 */
public class Reflection_Private {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        //获取对象
        Class aClass = People.class;
        Field  privateField = aClass.getDeclaredField("privateString");

        //设置允许jvm编译通过。(jvm 默认不允许访问 私有类型的东西)
        privateField.setAccessible(true);

        //获取私有字段的值
        People people = new People();
        Object privateStringResult = privateField.get(people);
        System.out.println(privateStringResult);

        //获取私有方法
            //获取setPrivateString方法
        Method privateMethod = aClass.getDeclaredMethod("setPrivateString", String.class);
            //获取getPrivateString方法
        Method privateMethod1 = aClass.getDeclaredMethod("getPrivateString", null);
            //jvm编译通过允许
        privateMethod.setAccessible(true);
            //反射对象和参数 给setPrivateString方法
        privateMethod.invoke(people,"Fant.J is so cool");
            //反射对象和参数 给getPrivateString方法
        Object obj = privateMethod1.invoke(people,null);
        System.out.println(obj);






    }
}
