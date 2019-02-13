package com.design_patterns.abstractFactoryPattern;

import java.lang.reflect.InvocationTargetException;

/**
 * 创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂。
 * Created by Fant.J.
 */
public class FactoryProducer {
    public static <T> AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            //这里不举例子了，你可以自己 创建一个 ColorFactory
            return null;
        }
        return null;
    }

    public static AbstractFactory getShapeFactory(){
        return new ShapeFactory();
    }
}
