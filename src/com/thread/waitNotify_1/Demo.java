package com.thread.waitNotify_1;

/** 通过synchronized代码块锁定同步 并 调用对象的 wait 和 notify 实例
 * Created by Fant.J.
 */
public class Demo {
    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (demo) {
                    System.out.println("修改flag线程执行");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    demo.setFlag(true);
                    demo.notify();
                    System.out.println("修改flag并释放锁成功");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (demo) {
                    while (demo.isFlag() != true) {
                        try {
                            demo.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("flag为true时线程执行");
                }
            }
        }).start();
    }
}
