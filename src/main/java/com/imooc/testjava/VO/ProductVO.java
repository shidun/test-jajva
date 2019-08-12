package com.imooc.testjava.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品（包含类目）
 */
@Data
public class ProductVO implements Serializable {
    private static final long serialVersionUID = 22L;

    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("food")
    private List<ProductInfoVO> productInfoVOList;
}
