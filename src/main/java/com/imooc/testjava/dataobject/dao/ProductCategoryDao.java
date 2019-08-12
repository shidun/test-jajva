package com.imooc.testjava.dataobject.dao;

import com.imooc.testjava.dataobject.ProductCategory;
import com.imooc.testjava.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

public class ProductCategoryDao {

    @Autowired
    private ProductCategoryMapper mapper;

    public int insertByMap(Map<String , Object> map) {
        return  mapper.insertByMapper(map);
    }
    public int insertByObject(ProductCategory productCategory) {
        return mapper.insertByObject(productCategory);
    }
}
