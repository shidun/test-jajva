package com.imooc.testjava.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIT(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(20, "库存不正确"),
    ORDER_NOT_EXIT(30, "订单不存在"),
    ORDER_DETAIL_EMPTY(40, "订单详情为空"),
    ORDER_STATUS_ERROR(50, "订单不是未完成状态"),
    ORDER_UPDATE_ERROR(60, "订单更新失败"),
    ORDER_PRODUCT_EMPTY(70, "订单中无商品"),
    ORDER_PAY_ERROR(70, "支付状态不正确"),
    ORDER_PAY_UPDATE(70, "订单更新失败")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
