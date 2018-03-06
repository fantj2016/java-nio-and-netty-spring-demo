package com.thread.priority;

/**优先级
 * Created by Fant.J.
 * 2018/2/25 10:04
 */
public class PriorityTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());

        /**
         * 设置优先级
         * MAX_PRIORITY=10
         * MIN_PRIORITY=1
         * NORM_PRIORITY=5
         */

        t1.setPriority(Thread.NORM_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
}
