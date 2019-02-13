package com.jvm.stackFrame;

/**
 * Created by Fant.J.
 * 2018/8/13 13:14
 */
public class Main {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64*1024*1024];
        }
        int a = 0;
        System.gc();
    }
}
