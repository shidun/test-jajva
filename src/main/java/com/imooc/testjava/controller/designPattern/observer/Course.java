package com.imooc.testjava.controller.designPattern.observer;

import lombok.Data;

import java.util.Observable;

/**
 * @author : shidun
 * @date : 2019/12/19
 */
@Data
public class Course extends Observable {
    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void produce(Course course, Question question) {
        System.out.println("发送课程信息");
        setChanged();
        notifyObservers(question);
    }
}
