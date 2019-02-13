package com.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by Fant.J.
 * 2018/3/6 20:12
 */
public class MyLock implements Lock {

    //声明一个判断锁的布尔值
    private boolean isLocked = false;

    Thread lockBy = null;

    int lockCount = 0;

    /**
     * 必须声明  synchronized 原自行操作，不然jvm不会识别是哪个线程的wait方法，notify也一样
     */
    @Override
    public synchronized void lock() {

        Thread currentThread = Thread.currentThread();  //获取到当前线程
        while (isLocked && currentThread != lockBy){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockBy = currentThread; //将currentThread线程指向 lockBy线程
        lockCount++;//计数器自增

    }

    @Override
    public synchronized void unlock() {
        if (lockBy == Thread.currentThread()){
            lockCount--;
            if (lockCount ==0 ){
                notify();
                isLocked = false;
            }
        }
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }


    @Override
    public boolean tryLock() {
        return false;
    }


    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }




    @Override
    public Condition newCondition() {
        return null;
    }
}
