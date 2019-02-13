package com.lock;

import com.thread.security.Task;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁
 * Created by Fant.J.
 * 2018/3/6 20:09
 */
public class ReentrantLockTest {

    public int value = 0;

    //实例化重入锁锁
    Lock lock = new ReentrantLock();

    public   int getValue() {
        //加锁
        lock.lock();
        int a = value++;
        //消除锁
        lock.unlock();
        return a;
    }

    public static void main(String[] args) {

        ReentrantLockTest task = new ReentrantLockTest();
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "  " + task.getValue());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "  " + task.getValue());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
