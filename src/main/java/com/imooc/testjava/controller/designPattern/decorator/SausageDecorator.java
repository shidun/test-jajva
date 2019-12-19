package com.imooc.testjava.controller.designPattern.decorator;

/**
 * @author : SHIDUN
 * @date : 2019/12/17
 */
public class SausageDecorator extends ABstractDecorator {
    public SausageDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc() + " 加1个鸡腿";
    }

    @Override
    protected int cost() {
        return super.cost() + 3;
    }
}
