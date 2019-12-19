package com.imooc.testjava.controller.designPattern.strategy;

/**
 * @author : shidun
 * @date : 2019/12/19
 */
public class ManJianPromotion implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("满减促销活动");
    }
}
