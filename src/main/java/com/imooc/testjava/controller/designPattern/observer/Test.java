package com.imooc.testjava.controller.designPattern.observer;

/**
 * 观察者模式
 * @author : shidun
 * @date : 2019/12/19
 */
public class Test {

    public static void main(String[] args) {
        Course course = new Course("java");
        Teacher teacher = new Teacher("老师1");
        Teacher teacher2 = new Teacher("老师w");
        course.addObserver(teacher);
        course.addObserver(teacher2);
        Question question = new Question();
        question.setUserId("12");
        question.setContent("提问问题");
        course.produce(course, question);
    }
}
