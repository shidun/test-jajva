package com.imooc.testjava.controller.designPattern.strategy;

/**
 * @author : shidun
 * @date : 2019/12/19
 */
public class LiJianPromotion implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("立减活动");
    }
}
