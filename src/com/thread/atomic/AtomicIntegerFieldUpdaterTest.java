package com.thread.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 如果我们只需要某个类里的某个字段，那么就需要使用原子更新字段类
 * 原子更新类的字段的必须使用public volatile修饰符。
 * Created by Fant.J.
 * 2018/2/28 18:50
 */
public class AtomicIntegerFieldUpdaterTest {

    //假设我们需要User里的age属性，并给age进行原子更新
    static AtomicIntegerFieldUpdater<User> aif = AtomicIntegerFieldUpdater.newUpdater(User.class,"age");

    public static void main(String[] args) {
        User user = new User("fantj",20);
        //将User对象传给 原子更新字段类对象
        aif.getAndIncrement(user);
        System.out.println(aif.get(user));
    }




    static class User{
        private String name;

        public volatile int age;   //注意这里要加 volatile

        public User(String name, int i) {
            this.name = name;
            this.age=i;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
