package com.imooc.testjava.controller.designPattern.proxy;

/**
 * @author : ShiDun
 * @date : 2019/12/18
 */
public class OrderServiceImpl implements IOrderService {
    private IOrderDao orderDao;

    @Override
    public int saveOrder(Order order) {
        orderDao = new OrderDaoImpl();
        System.out.println("service 调用dao ");
        return orderDao.insert(order);
    }
}
