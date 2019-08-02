package com.imooc.testjava.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 商品详情表
 */
@Entity
@Data
public class ProductInfo {

    @Id //表的主键
    private String productId;
    //名称
    private String productName;
    //价格
    private BigDecimal productPrice;
    //库存
    private Integer productStock;
    //描述
    private String productDescription;
    //小图
    private String productIcon;
    //状态  0正常 1下架
    private Integer productStatus;
    //类目编号
    private Integer categoryType;
}
