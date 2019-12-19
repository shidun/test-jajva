package com.imooc.testjava.controller.designPattern.templatemethod;

/**
 * 模版方法模式
 * @author : ShiDun
 * @date : 2019/12/19
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("后端课程开始");
        ACourse aCourse = new DesignPatternCourse();
        aCourse.makeCourse();
        System.out.println("前端课程开始");
        ACourse course = new FECourse(true);
        course.makeCourse();

    }
}
