package com.design_patterns.builderPattern;

/**
 * builder: 抽象建造者
 * Created by Fant.J.
 */
public interface PhoneBuilder {
    void buildScreen();
    void buildCpu();
    void buildCamera();

    Phone buildPhone();
}
