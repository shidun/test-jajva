package com.imooc.testjava.controller.designPattern.templatemethod;

/**
 * @author : ShiDun
 * @date : 2019/12/19
 */
public class FECourse extends ACourse {
    private boolean isneedWrite = false;

    public FECourse(boolean isneedWrite) {
        this.isneedWrite = isneedWrite;
    }

    @Override
    public boolean isWrite() {
        return isneedWrite;
    }

    @Override
    void packAgeCourse() {
        System.out.println("打包前端代码");
    }
}
