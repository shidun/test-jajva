package com.imooc.testjava.controller.designPattern.observer;

import javafx.beans.InvalidationListener;

import java.util.Observable;
import java.util.Observer;

/**
 * @author : shidun
 * @date : 2019/12/19
 */
public class Teacher implements Observer {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Course course = (Course) o;
        Question question = (Question) arg;
        System.out.println(this.name + " teacher 接受课程信息");
        System.out.println(course);
        System.out.println(question);
    }
}
