package com.imooc.testjava.controller.designPattern.iterator;

import lombok.Data;

/**
 * @author : ShiDun
 * @date : 2019/12/19
 */
@Data
public class Course {
    private String name;

    public Course(String name) {
        this.name = name;
    }
}
