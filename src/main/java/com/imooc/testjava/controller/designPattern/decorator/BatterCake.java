package com.imooc.testjava.controller.designPattern.decorator;

/**
 * @author : SHIDUN
 * @date : 2019/12/17
 */
public class BatterCake extends ABattercake {
    @Override
    protected String getDesc() {
        return "鸡蛋饼";
    }

    @Override
    protected int cost() {
        return 10;
    }
}
