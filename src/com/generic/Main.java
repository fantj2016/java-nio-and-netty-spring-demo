package com.generic;

/**
 * Created by Fant.J.
 * 2018/2/27 9:43
 */
public class Main {
    public static void main(String[] args) {
//        Plate<Fruit> plate = new Plate<Apple>(new Apple());
        Plate<? extends Fruit> plate = new Plate<Apple>(new Apple());
    }
}
