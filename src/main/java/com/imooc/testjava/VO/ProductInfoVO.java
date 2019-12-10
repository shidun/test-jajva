package com.imooc.testjava.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * 商品详情
 */
@Data
public class ProductInfoVO implements Serializable {
    private static final long serialVersionUID = 33L;
    @JsonProperty("id")
    private String productId;
    @JsonProperty("name")
    private String productName;
    @JsonProperty("price")
    private BigDecimal productPrice;
    @JsonProperty("description")
    private String productDescription;
    @JsonProperty("icon")
    private String productIcon;
}
