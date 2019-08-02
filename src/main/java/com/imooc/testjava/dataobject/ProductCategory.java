package com.imooc.testjava.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

//@Table(name = "product_category")
@Entity
@DynamicUpdate
@Data
/**
 * 类目表
         */
public class ProductCategory {
    //类目Id
    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增类型
    private Integer categoryId;
    //类目名字
    private String categoryName;
    //类目编号
    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    //    private Date createTime;
//
//    private Date updateTime;
}
