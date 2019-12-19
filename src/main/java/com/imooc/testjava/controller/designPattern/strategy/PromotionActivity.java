package com.imooc.testjava.controller.designPattern.strategy;

/**
 * @author : shidun
 * @date : 2019/12/19
 */
public class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void executePromotion() {
        promotionStrategy.doPromotion();
    }
}
