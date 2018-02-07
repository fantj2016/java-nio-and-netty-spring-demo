package com.reflection.detail;

import java.lang.reflect.Method;

/**
 * Created by Fant.J.
 * 2018/2/7 15:20
 */
public class Reflection_GetterSetter {

    public static void printGettersSetters(Class aClass) {
        Method[] methods = aClass.getMethods();

        for (Method method : methods) {
            if (isGetter(method)) {
                System.out.println("getter: " + method);
            }
            if (isSetter(method)) {
                System.out.println("setter: " + method);
            }
        }
    }

    /**
     * 是否是getter
     *
     * @param method method对象
     * @return 布尔值
     */
    public static boolean isGetter(Method method) {
        //get开头
        if (!method.getName().startsWith("get")) {
            return false;
        }
        //参数长度不是0
        if (method.getParameterTypes().length != 0) {
            return false;
        }
        //返回值不为空
        if (void.class.equals(method.getReturnType())) {
            return false;
        }
        return true;
    }

    /**
     * 是否是setter
     *
     * @param method
     * @return
     */

    public static boolean isSetter(Method method) {
        //是否是set开头
        if (!method.getName().startsWith("set")) {
            return false;
        }
        //是否参数长度等于1
        if (method.getParameterTypes().length != 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Class aClass = People.class;
        printGettersSetters(aClass);
    }
}
