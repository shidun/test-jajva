package com.imooc.testjava.controller.designPattern.composite;

/**
 * 组合模式
 * @author : ShiDun
 * @date : 2019/12/18
 */
public class Test {
    public static void main(String[] args) {
        CatalogComponent course3 = new Course("java第一套课程", 111);
        CatalogComponent course4 = new Course("java第二套课程", 222);
        CatalogComponent course5 = new Course("java第三套课程", 333);
        CatalogComponent catalog2 = new CourseCatalog("java课程列表", 2);
        catalog2.add(course3);
        catalog2.add(course4);
        catalog2.add(course5);

        CatalogComponent catalog1 = new CourseCatalog("imooc课程列表", 1);
        CatalogComponent course = new Course("linux课程", 111);
        CatalogComponent course2 = new Course("windows课程", 555);
        catalog1.add(course);
        catalog1.add(course2);
        catalog1.add(catalog2);
        catalog1.print();
    }
}
