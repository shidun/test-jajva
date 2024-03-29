package com.imooc.testjava.from;

import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

@Data
public class ProductForm {

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

    //类目编号
    private Integer categoryType;
}
