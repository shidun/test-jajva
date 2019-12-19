package com.imooc.testjava.controller.designPattern.abstractFactory;

/**
 * 抽象工厂模式
 * @author : jack sd
 * @date : 2019/12/16
 */
public class Test {
    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        Video video = courseFactory.getVideo();
        video.produce();
        Article article = courseFactory.getArticle();
        article.produce();
    }
}
