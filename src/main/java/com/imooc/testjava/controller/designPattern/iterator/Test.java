package com.imooc.testjava.controller.designPattern.iterator;

import java.util.ArrayList;

/**
 * 迭代器模式
 * @author : ShiDun
 * @date : 2019/12/19
 */
public class Test {
    public static void main(String[] args) {
        Course course1 = new Course("第1门课程");
        Course course2 = new Course("第2门课程");
        Course course3 = new Course("第3门课程");
        Course course4 = new Course("第4门课程");
        Course course5 = new Course("第5门课程");
        CourseAggregate courseAggregate = new CourseAggregateImpl();
        courseAggregate.addCourse(course1);
        courseAggregate.addCourse(course2);
        courseAggregate.addCourse(course3);
        courseAggregate.addCourse(course4);
        courseAggregate.addCourse(course5);
        printCourse(courseAggregate);

        courseAggregate.removeCourse(course2);
        printCourse(courseAggregate);
    }

    private static void printCourse(CourseAggregate courseAggregate) {
        CourseIterator courseIterator = courseAggregate.courseIterator();
        while (!courseIterator.lastCourse()) {
            Course course = courseIterator.nextCourse();
            System.out.println(course.getName());
        }
    }
}
