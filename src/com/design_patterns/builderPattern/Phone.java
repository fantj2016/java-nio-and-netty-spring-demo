package com.design_patterns.builderPattern;

/**
 * 产品类:Product
 * Created by Fant.J.
 */
public class Phone {
    /**
     * 处理器
     */
    private String cpu;
    /**
     * 屏幕
     */
    private String screen;
    /**
     * 相机
     */
    private String camera;


    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                ", camera='" + camera + '\'' +
                '}';
    }
}
