package com.imooc.testjava.controller.designPattern.decorator;

/**
 * @author : SHIDUN
 * @date : 2019/12/17
 */
public class EggDecorator extends ABstractDecorator {
    public EggDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc() + " 加1个鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost() + 1;
    }
}
