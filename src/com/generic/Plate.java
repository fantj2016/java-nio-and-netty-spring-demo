package com.generic;

/**
 * 盘子类
 * Created by Fant.J.
 * 2018/2/27 9:41
 */
public class Plate<T> {

    private T item;

    public Plate(T t){
        item = t;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
