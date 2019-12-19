package com.imooc.testjava.controller.designPattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : shidun
 * @date : 2019/12/19
 */
public class PromotionFactory {
    private final static Map<String, PromotionStrategy> map = new HashMap<>();
    private final static PromotionStrategy promotion =  new EmptyPromotion();

    static  {
        map.put(PromotionString.MANJIAN, new ManJianPromotion());
        map.put(PromotionString.LIJIAN, new LiJianPromotion());
        map.put(PromotionString.FANXIAN, new FanXianPromotion());
    }

    private PromotionFactory() {
    }

    public static PromotionStrategy getPromotion(String promotionKey) {
        PromotionStrategy promotionStrategy = map.get(promotionKey);
        return promotionStrategy == null ? promotion : promotionStrategy;
    }

    private interface PromotionString {
        String MANJIAN = "MANJIAN";
        String FANXIAN = "FANXIAN";
        String LIJIAN = "LIJIAN";
    }
}
