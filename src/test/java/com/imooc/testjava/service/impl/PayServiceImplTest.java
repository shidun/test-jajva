package com.imooc.testjava.service.impl;

import com.imooc.testjava.dto.OrderDTO;
import com.imooc.testjava.service.OrderService;
import com.imooc.testjava.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayServiceImpl payService;

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = orderService.getOne("1564737225230472563");
        orderDTO.getOrderId();
        payService.create(orderDTO);
    }

    @Test
    public void refund() {
        OrderDTO orderDTO = orderService.getOne("1564737225230472563");
        payService.refund(orderDTO);
    }
}