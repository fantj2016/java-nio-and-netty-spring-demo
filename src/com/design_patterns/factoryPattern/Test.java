package com.design_patterns.factoryPattern;

/**
 * Created by Fant.J.
 */
public class Test {
    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();
        //获取  圆形  实例化对象
        Shape circle = shapeFactory.getShape("CIRCLE");
        //调用对象方法
        circle.describe();

        //获取 长方形  实例化对象
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        //调用方法
        rectangle.describe();


       /* Object shape = (Rectangle)shapeFactory.getShape(Rectangle.class);
        ((Rectangle) shape).describe();*/

        Rectangle shape = shapeFactory.getShape(Rectangle.class);
        shape.describe();

    }
}
