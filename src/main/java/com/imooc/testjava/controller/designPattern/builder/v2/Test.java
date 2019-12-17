package com.imooc.testjava.controller.designPattern.builder.v2;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 * @author : jack sd
 * @date : 2019/12/16
 */
public class Test {
    public static void main(String[] args) {
        Course2 course2 =  new Course2.CourseBuilder().buildCourseName("javaName").buildCourseArticle("javaJiacheng").build();
        System.out.println(course2);

        Set<String> set = ImmutableSet.<String>builder().add("a").add("b").build();
        System.out.println(set);
    }

}
