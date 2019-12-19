package com.imooc.testjava.controller.designPattern.templatemethod;

/**
 * @author : ShiDun
 * @date : 2019/12/19
 */
public class DesignPatternCourse extends ACourse {
    @Override
    public boolean isWrite() {
        return true;
    }

    @Override
    void packAgeCourse() {
        System.out.println("后端java打包");
    }
}
