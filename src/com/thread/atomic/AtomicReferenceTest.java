package com.thread.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Fant.J.
 * 2018/2/28 18:40
 */
public class AtomicReferenceTest {
    static AtomicReference<User> ar = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("fantj",20);
        User updateUser = new User("dalao",20);

        ar.set(user);
        ar.compareAndSet(user,updateUser); //public final boolean compareAndSet(User expect, User update)
        System.out.println(ar.get().getName() + " :"+ar.get().getAge());
    }


    static class User{
        private String name;

        private Integer age;

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
