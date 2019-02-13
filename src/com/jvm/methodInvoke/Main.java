package com.jvm.methodInvoke;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fant.J.
 * 2018/8/13 17:24
 */
public class Main {
    public static void main(String[] args) {
        //invokestatic调用
        Test.hello();
        //invokespecial调用
        Test test = new Test();
    }
    static class Test{
        static void hello(){
            System.out.println("hello");
        }
    }
}
