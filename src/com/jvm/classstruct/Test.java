package com.jvm.classstruct;

/**
 * Created by Fant.J.
 */
public class Test {
    public static void main(String[] args) {
        Phone phone = new Phone() {
            @Override
            void show() {
                System.out.println("my name is mi");
            }
        };
        phone.show();

        Phone phone1 = new PhoneMi();
        phone1.show();
        phone1.print();
    }
}
