package com.thread.priority;

/**
 * Created by Fant.J.
 * 2018/2/25 10:04
 */
public class Task implements Runnable{

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "线程执行了...");
        }
    }
}
