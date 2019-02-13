package com.thread.demotionLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁降级
 * Created by Fant.J.
 */
public class MyDemotionLock {

    private Map<String,Object> map = new HashMap<>();

    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    private Lock r = rwl.readLock();
    private Lock w = rwl.writeLock();

    int value = 100;


    public void readAndWrite(){
        //获取读锁
        r.lock();
        Object object = map.get("a");
        if (object == null){
            System.out.println("获取到了空值");
            //缓存是空，模拟从新从数据库中获取
            //关闭读锁，获取写锁
            r.unlock();
            w.lock();
            map.put("a","Fant.J"+value);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //完成写操作后，应该在写锁释放之前获取到读锁
            r.lock();
            System.out.println("我要施放锁啦");
            w.unlock();
        }
        System.out.println("线程"+Thread.currentThread().getName()+map.get("a"));
        r.unlock();
    }

    public static void main(String[] args) {

        MyDemotionLock lock = new MyDemotionLock();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName()+"启动");
            lock.readAndWrite();
        };
        Thread[] threadArray = new Thread[10];
        for (int i=0; i<10; i++) {
            threadArray[i] = new Thread(runnable);
        }
        for (int i=0; i<10; i++) {
            threadArray[i].start();
        }
    }

}
