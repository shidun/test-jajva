package com.imooc.testjava.controller.designPattern.strategy;

/**
 * @author : shidun
 * @date : 2019/12/19
 */
public class FanXianPromotion implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现活动");
    }
}
