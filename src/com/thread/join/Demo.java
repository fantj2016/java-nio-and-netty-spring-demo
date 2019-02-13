package com.thread.join;

import java.net.HttpRetryException;

/**
 * Created by Fant.J.
 */
public class Demo {
    public void a(Thread t1){
        System.out.println("方法a执行了");
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a方法执行完毕");
    }
    public void b(){
        System.out.println("加塞线程执行。。");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("加塞线程执行完毕。。");
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        Thread t1 = new Thread(demo::b);
        new Thread(() -> demo.a(t1)).start();
    }
}
