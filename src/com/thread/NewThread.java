package com.thread;

/**
 * Created by Fant.J.
 * 2018/2/24 9:19
 */
public class NewThread implements Runnable {
    /**
     * 自定义线程
     */
    @Override
    public void run() {
        System.out.println("线程运行了...");
    }

    /**
     * 主线程
     * @param args
     */
    public static void main(String[] args) {
        Thread thread = new Thread(new NewThread()); //创建一个线程，并设置线程任务
        thread.start(); //启动线程
    }
}
