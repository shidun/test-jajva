package com.imooc.testjava.controller.designPattern.factory;

/**
 * @author : jack sd
 * @date : 2019/12/16
 */
public class JavaVideoFactory extends VideoFactory {

    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
