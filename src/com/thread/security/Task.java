package com.thread.security;

/**
 * 线程安全问题及解决
 * Created by Fant.J.
 * 2018/2/25 10:29
 */
public class Task{

        public int value = 0;

/*
        没有处理线程安全
        public  int getValue() {
        return value++;
    }*/

//处理线程安全
    public  synchronized int getValue() {
        return value++;
    }

    public static void main(String[] args) {

        Task task = new Task();
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
