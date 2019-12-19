package com.imooc.testjava.controller.designPattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ShiDun
 * @date : 2019/12/19
 */
public class CourseIteratorImpl implements CourseIterator {
    private List list;
    private Course course;
    private int position;

    public CourseIteratorImpl(List list) {
        this.list = list;
    }

    @Override
    public Course nextCourse() {
        System.out.println("当前课程的位置："+position);
        course = (Course) list.get(position);
        position++;
        return course;
    }

    @Override
    public boolean lastCourse() {
        if (position < list.size()) {
            return false;
        }
        return true;
    }
}
