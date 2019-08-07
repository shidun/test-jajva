package com.imooc.testjava.controller;

import com.imooc.testjava.dto.OrderDTO;
import com.imooc.testjava.enums.ResultEnum;
import com.imooc.testjava.exception.SellException;
import com.imooc.testjava.service.impl.OrderServiceImpl;
import com.imooc.testjava.service.impl.PayServiceImpl;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private PayServiceImpl payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl
                               ) {
        //查询订单
        OrderDTO orderDTO = orderService.getOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIT);
        }

        //发起支付
        PayResponse payResponse = payService.create(orderDTO);
        Map<String, Object> map = new HashMap<>();
        map.put("returnUrl", returnUrl);
        map.put("payResponse", payResponse);
        return new ModelAndView("pay/create", map);
    }
}
