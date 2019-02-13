package com.design_patterns.abstractFactoryPattern;

/**
 * 为 Color 和 Shape 对象创建抽象类来获取工厂。
 * Created by Fant.J.
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract <T> T getShape(Class<T> clazz) ;
}
