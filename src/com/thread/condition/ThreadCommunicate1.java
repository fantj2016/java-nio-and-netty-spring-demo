package com.thread.condition;

public class ThreadCommunicate1 {
        private int signal = 0;

        public synchronized void teacher(){
            while (signal != 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("老师叫上课");
            signal++;
            notifyAll();
        }
        public synchronized void student1(){
            while (signal != 1){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("学生1醒了,准备叫醒学生2");
            signal++;
            notifyAll();
        }
        public synchronized void student2(){
            while (signal != 2){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("学生2醒了");
            signal=0;
        }

        public static void main(String[] args) {
            ThreadCommunicate1 ten = new ThreadCommunicate1();
            new Thread(() -> ten.teacher()).start();
            new Thread(() -> ten.student1()).start();
            new Thread(() -> ten.student2()).start();
        }
}