package com.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Fant.J.
 * 2018/2/28 17:21
 */
public class AtomicIntegerTest {
    static AtomicInteger value = new AtomicInteger(0);

    public static int getValue(){
        return value.getAndIncrement();//value++;
    }

    public static void main(String[] args) {

  /*      Runnable r1 = ()->{
            for (;;){
                System.out.println(Thread.currentThread().getName()+" :"+getValue());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        r1.run();*/

        new Thread(()->{
            for (;;){
                System.out.println(Thread.currentThread().getName()+" :"+getValue());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            for (;;){
                System.out.println(Thread.currentThread().getName()+" :"+getValue());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
