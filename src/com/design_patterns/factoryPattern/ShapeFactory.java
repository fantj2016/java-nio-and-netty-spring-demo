package com.design_patterns.factoryPattern;

import java.lang.reflect.InvocationTargetException;

/**
 * 形状工厂（你可以通过我获取 相应的实例化对象）
 * Created by Fant.J.
 */
public class ShapeFactory {
    public Shape getShape(String type){
        if (type == null){
            return null;
        }
        if ("CIRCLE".equals(type)){
            return new Circle();
        }else if ("RECTANGLE".equals(type)){
            return new Rectangle();
        }
        return null;
    }
    /**
     * 反射
     */
/*    public Object getShape(Class<? extends  Shape> clazz){
        Object object = null;

        try {
            object = Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }*/
    /**
     * 反射 + 泛型
     */
    public <T> T getShape(Class<? extends T> clazz){
        T object = null;
        try {
            //实例化，并在这里做 类型转换
            object = (T) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 针对多个接口实现一个公共的工厂类
     */
    public <T> Object getObject(Class<T> clazz) {
        if (clazz == null ) {
            return null;
        }
        Object obj  = null;
        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
