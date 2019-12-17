package com.imooc.testjava.controller.designPattern.abstractFactory;

/**
 * @author : jack sd
 * @date : 2019/12/16
 */
public class PhpCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new PhpVideo();
    }

    @Override
    public Article getArticle() {
        return new PhpArticle();
    }
}
