package com.thread.readWrite;

/**
 * 测试  写-读模式 互斥
 * Created by Fant.J.
 */
public class TestWriteRead {
    public static void main(String[] args) {

        MyReadWriteLock myReadWriteLock = new MyReadWriteLock();
        //读读不互斥（共享）
        //读写互斥
        new Thread(new Runnable() {
            @Override
            public void run() {
                myReadWriteLock.put("a","fantj_a");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(myReadWriteLock.get("a"));
            }
        }).start();


    }
}
