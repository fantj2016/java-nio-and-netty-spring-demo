package com.thread.fair;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Fant.J.
 */
public class MyFairLock {
    /**
     *     true 表示 ReentrantLock 的公平锁
     */
    private  ReentrantLock lock = new ReentrantLock(true);

    private void testFail(){
        try {
            lock.lock();
            System.out.println("获得了锁"+Thread.currentThread().getName() +"获得了锁");
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        MyFairLock fairLock = new MyFairLock();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName()+"启动");
            fairLock.testFail();
        };
        Thread[] threadArray = new Thread[100];
        for (int i=0; i<100; i++) {
            threadArray[i] = new Thread(runnable);
            threadArray[i].start();
        }
    }
}
