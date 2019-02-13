package com.thread.readWrite;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试  读写锁 的公平锁 实现
 * Created by Fant.J.
 */
public class TestReadWriteRead {
    public static void main(String[] args) {
         ReentrantLock fairLock = new ReentrantLock(true);
        MyReadWriteLock myReadWriteLock = new MyReadWriteLock();
        myReadWriteLock.put("a","fantj_a");
        new Thread(new Runnable() {
            @Override
            public void run() {
                fairLock.lock();
                System.out.println(myReadWriteLock.get("a"));
                System.out.println("fair队列长度"+fairLock.getQueueLength());
                fairLock.unlock();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                fairLock.lock();
                System.out.println(myReadWriteLock.get("a"));
                System.out.println("fair队列长度"+fairLock.getQueueLength());

                fairLock.unlock();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                fairLock.lock();
                System.out.println(myReadWriteLock.get("a"));
                System.out.println("fair队列长度"+fairLock.getQueueLength());
                fairLock.unlock();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                fairLock.lock();
                myReadWriteLock.put("a","fantj_a_update");
                System.out.println("fair队列长度"+fairLock.getQueueLength());
                fairLock.unlock();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                fairLock.lock();
                System.out.println(myReadWriteLock.get("a"));
                System.out.println("fair队列长度"+fairLock.getQueueLength());
                fairLock.unlock();
            }
        }).start();
    }
}
