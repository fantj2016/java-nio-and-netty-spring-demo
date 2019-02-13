package com.jvm.jconsole;

import java.util.Scanner;

/**
 * 用jconsole工具查看线程的情况
 * 第一次输入并回车，可以看到多了一个线程while thread，状态是runnable,还有一些内存情况
 * 第二次输入并回车，又会多一个线程，状态是waitting
 * Created by Fant.J.
 */
public class ThreadConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.next();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    //空转
                }
            }
        },"while thread").start();
        scanner.next();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Object object = new Object();
                synchronized (object){
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}




