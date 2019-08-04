package com.imooc.testjava.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.testjava.dataobject.OrderDetail;
import com.imooc.testjava.util.serializer.Data2Long;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL) //过滤空值
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

    @JsonSerialize(using = Data2Long.class)
    private Date createTime;
    @JsonSerialize(using = Data2Long.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList = new ArrayList<>(); //默认空数组
}
