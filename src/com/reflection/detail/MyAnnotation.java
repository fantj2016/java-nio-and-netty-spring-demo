package com.reflection.detail;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Fant.J.
 * 2018/2/7 16:13
 */
@Retention(RetentionPolicy.RUNTIME)  //意味着注释可以在运行时通过反射来访问。
@Target(ElementType.TYPE)   //意味着注释只能用于类型（通常是类和接口）的顶部。

public @interface MyAnnotation {
    public String name();
    public String value();
}
