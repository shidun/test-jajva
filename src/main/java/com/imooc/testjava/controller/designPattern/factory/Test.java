package com.imooc.testjava.controller.designPattern.factory;

import java.util.Collection;

/**
 * 工厂方法
 * @author : jack sd
 * @date : 2019/12/16
 */
public class Test {
    /**
     * 工厂方法
     * @param args
     */
    public static void main(String[] args) {
        VideoFactory videoFactory = new JavaVideoFactory();
        Video video = videoFactory.getVideo();
        video.produce();
    }
}
