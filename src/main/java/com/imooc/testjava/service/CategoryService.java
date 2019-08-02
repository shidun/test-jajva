package com.imooc.testjava.service;

import com.imooc.testjava.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {

    ProductCategory getOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
