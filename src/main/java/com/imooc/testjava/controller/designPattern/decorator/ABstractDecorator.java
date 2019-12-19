package com.imooc.testjava.controller.designPattern.decorator;

/**
 * @author : SHIDUN
 * @date : 2019/12/17
 */
public abstract class ABstractDecorator extends ABattercake {
    private ABattercake aBattercake;

    public ABstractDecorator(ABattercake aBattercake) {
        this.aBattercake = aBattercake;
    }

    @Override
    protected String getDesc() {
        return this.aBattercake.getDesc();
    }

    @Override
    protected int cost() {
        return this.aBattercake.cost();
    }
}
