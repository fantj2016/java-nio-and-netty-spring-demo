package com.thread.create;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器Timer（弊端：不可控），quartz框架实现了控制定时线程问题
 * Created by Fant.J.
 * 2018/2/24 10:59
 */
public class CreatThreadDemo5 {

    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时器线程执行了...");
            }
        },0,1000);   //延迟0，周期1s

    }

}
