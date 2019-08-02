package com.imooc.testjava.dataobject;

import com.imooc.testjava.enums.OrderStatusEnum;
import com.imooc.testjava.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Transient;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@DynamicUpdate //自动更新update字段
public class OrderMaster {
    @Id
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAdress;
    private String buyerOpenid;
    private BigDecimal orderAmout;
    //订单状态 默认为0新下单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    //支付状态 默认为0未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;
    private Date updateTime;
}
