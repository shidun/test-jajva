package com.imooc.testjava.controller.designPattern.strategy;

/**
 * 策略模式
 * @author : shidun
 * @date : 2019/12/19
 */
public class Test {

    public static void main(String[] args) {
        String key = "LIJIAN";
        PromotionActivity promotionActivity = new PromotionActivity(PromotionFactory.getPromotion(key));
        promotionActivity.executePromotion();
    }
}
