package com.design_patterns.builderPattern;

/**
 * ConcreteBuilder:  具体建造者
 * Created by Fant.J.
 */
public class ConcreteBuilder implements PhoneBuilder{
    public Phone phone;
    public ConcreteBuilder() {
        phone = new Phone();
    }

    @Override
    public void buildScreen() {
        phone.setScreen("三星OLED屏幕");
    }

    @Override
    public void buildCpu() {
        phone.setCpu("骁龙845");
    }

    @Override
    public void buildCamera() {
        phone.setCamera("SONY");
    }

    @Override
    public Phone buildPhone() {
        return this.phone;
    }
}
