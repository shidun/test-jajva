package com.imooc.testjava.controller.designPattern.flyweight;

/**
 * 享元模式
 * @author : ShiDun
 * @date : 2019/12/18
 */
public class Test {
    private static final String[] departments = {"AD", "BD", "CA"};
    public static void main(String[] args) {
        ManagerFactory managerFactory = new ManagerFactory();
//        for (int i = 0; i <10; i++) {
//            String department = departments[(int) (Math.random()*departments.length)];
//            Manager manager = (Manager) managerFactory.getManager(department);
//            manager.report();
//        }
        Integer a = -128;
        Integer b = -128;
        Integer c = 10000;
        Integer d = 10000;
        // -128到127 取cache已经放好到值 使用了享元模式
        System.out.println(a==b);
        System.out.println(c==d);
        System.out.println(c.equals(d));
    }

}
