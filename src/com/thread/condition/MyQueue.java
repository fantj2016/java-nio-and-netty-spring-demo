package com.thread.condition;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Fant.J.
 */
public class MyQueue<E> {

    private Object[] objects;
    private Lock lock = new ReentrantLock();
    private Condition addCDT = lock.newCondition();
    private Condition rmCDT = lock.newCondition();

    private int addIndex;
    private int rmIndex;
    private int queueSize;

    MyQueue(int size){
        objects = new Object[size];
    }
    public void add(E e){
        lock.lock();
        while (queueSize == objects.length){
            try {
                addCDT.await();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        objects[addIndex] = e;
        System.out.println("添加了数据"+"Objects["+addIndex+"] = "+e);
        if (++addIndex == objects.length){
            addIndex = 0;
        }
        queueSize++;
        rmCDT.signal();
        lock.unlock();

    }
    public Object remove(){
        lock.lock();
        while (queueSize == 0){
            try {
                System.out.println("队列为空");
                rmCDT.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object temp = objects[rmIndex];
        objects[rmIndex] = null;
        System.out.println("移除了数据"+"Objects["+rmIndex+"] = null");
        if (++rmIndex == objects.length){
            rmIndex = 0;
        }
        queueSize--;
        addCDT.signal();
        lock.unlock();
        return temp;
    }
    public void foreach(E e){
        if (e instanceof String){
            Arrays.stream(objects).map(obj->{
                if (obj == null){
                    obj = " ";
                }
                return obj;
            }).map(Object::toString).forEach(System.out::println);
        }
        if (e instanceof Integer){
            Arrays.stream(objects).map(obj -> {
                if (obj == null ){
                    obj = 0;
                }
                return obj;
            }).map(object -> Integer.valueOf(object.toString())).forEach(System.out::println);
        }
    }
}
