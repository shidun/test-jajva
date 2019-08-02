package com.imooc.testjava.repository;

import com.imooc.testjava.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JpaRepository<ProductCategory, Integer>  ProductCategory对应的类   Integer是主键类型
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
