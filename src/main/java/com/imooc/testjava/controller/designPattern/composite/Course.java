package com.imooc.testjava.controller.designPattern.composite;

import lombok.Data;

/**
 * @author : ShiDun
 * @date : 2019/12/18
 */
@Data
public class Course extends CatalogComponent {
    private String name;
    private Integer price;

    public Course(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public Integer getPrice(CatalogComponent catalogComponent) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println("name:" + name + " price:" + price);
    }
}
