package com.reflection.detail;

import java.lang.annotation.Annotation;

/**
 * Created by Fant.J.
 * 2018/2/7 16:13
 */
public class Reflection_Annotations {
    public static void main(String[] args) {

        //获取对象
        Class aClass = People.class;
        Annotation[] annotations = aClass.getAnnotations();

        //获取类注解
        for(Annotation annotation : annotations){
            if(annotation instanceof MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());
            }
        }


    }
}
