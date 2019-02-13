package com.thread.waitNotify_1;

import java.util.Date;
import java.util.Timer;

/** 通过synchronized方法实现 wait notify
 * Created by Fant.J.
 */
public class Demo2 {
    private volatile boolean flag = false;

    private synchronized boolean getFlag() {
        System.out.println(Thread.currentThread().getName()+"开始执行...");
        if (!this.flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"执行结束...");
        return flag;
    }

    public synchronized void setFlag(boolean flag) {
        this.flag = flag;
//        notify();
        notifyAll();
        System.out.println("测试notify触发后会不会等2s"+System.currentTimeMillis());
        try {
            Thread.sleep(2000);
            System.out.println("测试notify触发后会不会等2s"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        Runnable target1 = new Runnable() {
            @Override
            public void run() {
                demo2.getFlag();
            }
        };

        Runnable target2 = new Runnable() {
            @Override
            public void run() {
                demo2.setFlag(true);
            }
        };

        new Thread(target1).start();
        new Thread(target1).start();
        new Thread(target1).start();
        new Thread(target1).start();
        new Thread(target2).start();
    }
}
