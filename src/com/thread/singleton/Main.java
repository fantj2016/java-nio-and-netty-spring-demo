package com.thread.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Fant.J.
 * 2018/2/25 19:37
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0;i<20;i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " :" + Singleton2.getInstance());

                }
            });
        }

        threadPool.shutdown();
    }
}
