package com.imooc.testjava.controller.designPattern.builder;

/**
 * @author : jack sd
 * @date : 2019/12/16
 */
public class Coach {

    private CourseBuilder courseBuilder;

    public void setCourseBuilder(CourseBuilder courseBuilder) {
        this.courseBuilder = courseBuilder;
    }

    public Course makeCourse(String courseName, String coursePPT, String courseVideo, String courseArticle, String courseQA) {
        this.courseBuilder.buildCourseName(courseName);
        this.courseBuilder.buildCourseArticle(courseArticle);
        this.courseBuilder.buildCoursePPT(coursePPT);
        this.courseBuilder.buildCourseQA(courseQA);
        this.courseBuilder.buildCourseVideo(courseVideo);
        return this.courseBuilder.makeCourse();
    }
}
