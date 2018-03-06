package com.thread.create;

/**
 * 实现runnable接口，作为线程任务存在
 * Created by Fant.J.
 * 2018/2/24 10:27
 */
public class CreatThreadDemo2 implements Runnable {
    @Override
    public void run() {
        while (true){
            System.out.println("线程执行了...");
        }
    }

    public static void main(String[] args) {
        //将线程任务传给线程对象
        Thread thread = new Thread(new CreatThreadDemo2());
        //启动线程
        thread.start();
    }
}
