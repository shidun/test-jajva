package com.imooc.testjava.util;

public class MathUtil {

    private static final Double MONEY_LEFT = 0.01;
    /**
     * 比较2个金额是否相等
     * @param d1
     * @param d2
     * @return
     */
    public static Boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_LEFT) {
            return true;
        } else {
            return false;
        }
    }
}
