package com.lock;

/**
 * Created by Fant.J.
 * 2018/3/6 20:24
 */
public class MyLockTest2 {

    public int value = 0;

    MyLock myLock = new MyLock();

    public void a(){
        myLock.lock();
        System.out.println("a");
        b();
        myLock.unlock();
    }

    public void b(){
        myLock.lock();
        System.out.println("b");
        myLock.unlock();
    }

    public static void main(String[] args) {

        MyLockTest2 task = new MyLockTest2();
        new Thread(){
            @Override
            public void run() {
                task.a();
                }
        }.start();

        new Thread(){
            @Override
            public void run() {
                task.a();
            }
        }.start();
    }
}
