package com.imooc.testjava.controller.designPattern.flyweight;

import lombok.Data;

/**
 * @author : ShiDun
 * @date : 2019/12/18
 */
@Data
public class Manager implements Employee {
    @Override
    public void report() {
        System.out.println(reportContent);
    }

    private String department;
    private String reportContent;

    public Manager(String department) {
        this.department = department;
    }
}
