package com.imooc.testjava.service;

import com.imooc.testjava.dto.OrderDTO;

public interface PushMessageService {
    /**
     * 订单状态变更消息
     * @param orderId
     */
    void orderStatus(String  orderId);
}
