package com.thread.readWrite;

/**
 * 测试 写-写 模式  是互斥的
 * Created by Fant.J.
 */
public class TestWriteWrite {
    public static void main(String[] args) {

        MyReadWriteLock myReadWriteLock = new MyReadWriteLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                myReadWriteLock.put("b","fantj_b");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                myReadWriteLock.put("b","fantj_b");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                myReadWriteLock.put("b","fantj_b");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                myReadWriteLock.put("b","fantj_b");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                myReadWriteLock.put("b","fantj_b");
            }
        }).start();
    }
}
