package com.imooc.testjava.controller.designPattern.proxy;

/**
 * 代理模式
 * @author : ShiDun
 * @date : 2019/12/18
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);
        IOrderService orderServiceDynamicProxy = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();
        orderServiceDynamicProxy.saveOrder(order);
    }
}
