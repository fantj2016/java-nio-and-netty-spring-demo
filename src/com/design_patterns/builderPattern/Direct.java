package com.design_patterns.builderPattern;

/**
 * Direct:指导者
 * Created by Fant.J.
 */
public class Direct {
    public Phone constructMi8(PhoneBuilder phoneBuilder){
        phoneBuilder.buildCamera();
        phoneBuilder.buildCpu();
        phoneBuilder.buildScreen();
        return phoneBuilder.buildPhone();
    }
}
