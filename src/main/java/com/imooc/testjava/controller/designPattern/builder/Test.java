package com.imooc.testjava.controller.designPattern.builder;

/**
 * @author : jack sd
 * @date : 2019/12/16
 */
public class Test {
    public static void main(String[] args) {
        CourseBuilder courseBuilder = new CourseActualBuilder();
        Coach coach = new Coach();
        coach.setCourseBuilder(courseBuilder);
        Course course = coach.makeCourse("phpName","phpPPT", "PHPVideo", "phpArticle", "phpQA");
        System.out.println(course);
    }

}
