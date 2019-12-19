package com.imooc.testjava.controller.designPattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ShiDun
 * @date : 2019/12/19
 */
public class CourseAggregateImpl implements CourseAggregate {
    private List list;

    public CourseAggregateImpl() {
        this.list = new ArrayList();
    }

    @Override
    public void addCourse(Course course) {
        list.add(course);
    }

    @Override
    public void removeCourse(Course course) {
        list.remove(course);
    }

    @Override
    public CourseIterator courseIterator() {
        return new CourseIteratorImpl(list);
    }
}
