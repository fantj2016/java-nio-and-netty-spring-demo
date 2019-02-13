package com.jvm.jconsole;

/**
 * 模拟死锁并用jconsole进行检测
 *
 * Created by Fant.J.
 */
public class DeadLock {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1){
                    try {
                        System.out.println("获取到o1的锁");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2){
                        System.out.println("获取到o2的锁");
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o2){
                    try {
                        System.out.println("获取到o2的锁");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o1){
                        System.out.println("获取到o1的锁");
                    }
                }
            }
        }).start();
    }
}
