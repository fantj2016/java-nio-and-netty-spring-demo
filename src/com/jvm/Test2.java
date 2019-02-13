package com.jvm;

/**
 * Created by Fant.J.
 */
public class Test2 {
    public static void main(String[] args) {
        int a = 0, b = 2;
        long startTime = System.nanoTime();
        try {

            for (int i = 10; i >= 0; i--) {
                a = b / i;
            }
        } catch (Exception e) {
            a = 1;
        } finally {
            long runTime = System.nanoTime() - startTime;
            System.out.println(runTime);
        }
    }
}
