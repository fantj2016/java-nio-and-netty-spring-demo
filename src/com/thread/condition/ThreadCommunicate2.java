package com.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCommunicate2 {
        private int signal = 0;
        public Lock lock = new ReentrantLock();
        Condition teacher = lock.newCondition();
        Condition student1 = lock.newCondition();
        Condition student2 = lock.newCondition();

        public void teacher(){
            lock.lock();
            while (signal != 0){
                try {
                    teacher.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("老师叫上课");
            signal++;
            student1.signal();
            lock.unlock();
        }
        public void student1(){
            lock.lock();
            while (signal != 1){
                try {
                    student1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("学生1醒了,准备叫醒学生2");
            signal++;
            student2.signal();
            lock.unlock();
        }
        public void student2(){
            lock.lock();
            while (signal != 2){
                try {
                    student2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("学生2醒了");
            signal=0;
            teacher.signal();
            lock.unlock();
        }

        public static void main(String[] args) {
            ThreadCommunicate2 ten = new ThreadCommunicate2();
            new Thread(() -> ten.teacher()).start();
            new Thread(() -> ten.student1()).start();
            new Thread(() -> ten.student2()).start();
        }
}