package com.thread.condition;

/**
 * Created by Fant.J.
 * 2018/8/25 16:24
 */
public class QueueTest {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>(5);
        myQueue.add(5);
        myQueue.add(4);
        myQueue.add(3);
//        myQueue.add(2);
//        myQueue.add(1);
        myQueue.remove();
        myQueue.foreach(5);
    }
}
