package com.thread.threadLocal;

/**
 * Created by Fant.J.
 */
public class Demo {
    private ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public int getNext(){
        Integer integer = threadLocal.get();
        integer++;
        threadLocal.set(integer);
        return integer;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(() -> {
            while (true){
                System.out.println(Thread.currentThread().getName()+"   :"+demo.getNext());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (true){
                System.out.println(Thread.currentThread().getName()+"   :"+demo.getNext());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
