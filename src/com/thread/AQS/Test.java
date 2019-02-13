package com.thread.AQS;

/**
 * Created by Fant.J.
 */
class TestAQS {

    private int value;

    private MyAQSLock myAQSLock = new MyAQSLock();

    public int next(){
        myAQSLock.lock();
        try {
            Thread.sleep(300);
            return value++;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }finally {
            myAQSLock.unlock();
        }
    }
    public void a() {
        myAQSLock.lock();
        System.out.println("a");
        b();
        myAQSLock.unlock();
    }

    public void b() {
        myAQSLock.lock();
        System.out.println("b");
        myAQSLock.unlock();
    }
    public static void main(String[] args) {
        TestAQS test = new TestAQS();


        new Thread(new Runnable() {
            @Override
            public void run() {
                test.a();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName()+"  "+test.next());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName()+"  "+test.next());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName()+"  "+test.next());
                }
            }
        }).start();
    }
}
