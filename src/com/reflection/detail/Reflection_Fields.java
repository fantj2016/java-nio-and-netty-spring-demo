package com.reflection.detail;

import java.lang.reflect.Field;

/**
 * Created by Fant.J.
 * 2018/2/7 14:51
 */
public class Reflection_Fields {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        //获取field对象
        Class aClass = People.class;
        Field[] fields = aClass.getFields();

        //如果你知道一些字段的名字，你可以这样获取到它
        Field field = aClass.getField("someField");
        System.out.println(field.getName()+"   "+field.getType());

        //那么，我们能获取到它的字段类型，那如何取出该字段的值呢
        People people = new People();
        Object obj = field.get(people);
        System.out.println(obj.toString());

        //如何给字段设置值呢
        field.set(people,"shuai");
        Object obj2 = field.get(people);
        System.out.println(obj2.toString());
    }
}
