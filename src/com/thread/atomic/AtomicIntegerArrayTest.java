package com.thread.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by Fant.J.
 * 2018/2/28 18:28
 */
public class AtomicIntegerArrayTest {
    static int[] value = new int[]{1,2};
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0,3);
        System.out.println(ai.get(0));
    }
}
