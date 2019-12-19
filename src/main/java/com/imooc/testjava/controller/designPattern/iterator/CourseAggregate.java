package com.imooc.testjava.controller.designPattern.iterator;

/**
 * @author : ShiDun
 * @date : 2019/12/19
 */
public interface CourseAggregate {
    void addCourse(Course course);

    void removeCourse(Course course);

    CourseIterator courseIterator();
}
