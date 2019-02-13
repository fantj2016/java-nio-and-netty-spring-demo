package com.lambda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Predicate;

/**
 * Created by Fant.J.
 * 2018/8/15 16:26
 */
public class Second_1 {
    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("匿名内部类的执行");
//            }
//        }).start();
//        new Thread(()->{
//            System.out.println("lambda代替内部类");
//        }).start();
//
//        String  name = "FantJ";
//        Runnable runnable =  ()-> System.out.println("hello " +name);
//        runnable.run();
//        name = "foo";
//
//        Test test = s -> System.out.println("oneParam方法传递参数："+s);
//        test.oneParam("我是传递的值");

//        Test2 test2 = (x,y) -> x+y;
//        int add = test2.add(10, 10);/
//        Test3 test3 = (long x,long y) -> x+y;
//        long add = test3.add(10, 10);
//        System.out.println(add);
//        System.out.println(add);
//        System.out.println(test2);



    }

    interface Test{
        void oneParam(String name);
    }
    interface Test2{
        int add(int a,int b);
    }
    interface Test3{
        long add(long a,long b);
    }
    interface IntPre{
        boolean test(Integer value);
        boolean check(Predicate<Integer> predicate);
        boolean check(IntPre pre);
    }
}
