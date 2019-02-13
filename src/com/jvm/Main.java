package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 制造堆溢出
 * Created by Fant.J.
 */
public class Main {
    public static void main(String[] args) {
        List<Test> list = new ArrayList<>();
        while (true){
            list.add(new Test());
        }
    }
}
