package com.imooc.testjava.service;

import com.imooc.testjava.dto.OrderDTO;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    //创建订单
    OrderDTO create(OrderDTO orderDTO);

    //查询单个订单
    OrderDTO getOne(String orderId);

    //查询订单列表
    Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);

    Page<OrderDTO> findAllList(Pageable pageable);

    //取消订单
    OrderDTO cancel(OrderDTO orderDTO);

    //完结订单
    OrderDTO finish(OrderDTO orderDTO);

    //支付订单
    OrderDTO paid(OrderDTO orderDTO);
}
