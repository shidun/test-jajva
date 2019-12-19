package com.imooc.testjava.controller.designPattern.proxy;

/**
 * @author : ShiDun
 * @date : 2019/12/18
 */
public class OrderDaoImpl implements IOrderDao {
    @Override
    public int insert(Order order) {
        System.out.println("dao 层成功插入数据");
        return 1;
    }
}
