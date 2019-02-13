package com.thread.fair;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Fant.J.
 */
public class MyNonfairLock {
    /**
     *     false 表示 ReentrantLock 的非公平锁
     */
    private  ReentrantLock lock = new ReentrantLock(false);

    public  void testFail(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() +"获得了锁");
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        MyNonfairLock nonfairLock = new MyNonfairLock();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName()+"启动");
            nonfairLock.testFail();
        };
        Thread[] threadArray = new Thread[50];
        for (int i=0; i<50; i++) {
            threadArray[i] = new Thread(runnable);
            threadArray[i].start();
        }
    }
}
