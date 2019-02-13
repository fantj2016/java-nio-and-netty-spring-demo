package com.lock;

/**
 * Created by Fant.J.
 * 2018/3/6 20:24
 */
public class MyLockTest {

    public int value = 0;

    MyLock myLock = new MyLock();

    public int  getValue(){
        myLock.lock();

        value++;

        myLock.unlock();

        return value;
    }

    public static void main(String[] args) {

        MyLockTest task = new MyLockTest();
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
