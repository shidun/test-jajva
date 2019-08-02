package com.imooc.testjava.dto;

import com.imooc.testjava.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAdress;
    private String buyerOpenid;
    private BigDecimal orderAmout;
    //订单状态 默认为0新下单
    private Integer orderStatus;
    //支付状态 默认为0未支付
    private Integer payStatus;

    private Date createTime;
    private Date updateTime;

    List<OrderDetail> orderDetailList;
}
