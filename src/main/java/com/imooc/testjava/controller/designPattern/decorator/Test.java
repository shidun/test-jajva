package com.imooc.testjava.controller.designPattern.decorator;

/**
 * 装饰者模式
 * @author : SHIDUN
 * @date : 2019/12/17
 */
public class Test {
    public static void main(String[] args) {
        ABattercake aBattercake;
        aBattercake = new BatterCake();
        aBattercake = new SausageDecorator(aBattercake);
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new EggDecorator(aBattercake);
        System.out.println(aBattercake.getDesc() + "价格是： " + aBattercake.cost());
    }
}
