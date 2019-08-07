package com.imooc.testjava.service;

import com.imooc.testjava.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;

public interface PayService {

    PayResponse create(OrderDTO orderDTO);
}
