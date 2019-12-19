package com.imooc.testjava.controller.designPattern.templatemethod;

/**
 * @author : ShiDun
 * @date : 2019/12/19
 */
public abstract class ACourse {

    protected final void makeCourse() {
        makePPT();
        makeVideo();
        if (isWrite()) {
            writeArticle();
        }
        packAgeCourse();
    }
    final void makePPT() {
        System.out.println("制作ppt");
    }
    final void makeVideo() {
        System.out.println("制作video");
    }
    final void writeArticle() {
        System.out.println("记录笔记");
    }
    public boolean isWrite() {
        return false;
    }

    abstract void packAgeCourse();
}
