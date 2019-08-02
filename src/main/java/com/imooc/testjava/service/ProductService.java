package com.imooc.testjava.service;

import com.imooc.testjava.dataobject.ProductInfo;
import com.imooc.testjava.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo getOne(String productId);

    //分页查询
    Page<ProductInfo> findAll(Pageable pageable);

    //查询在架商品
    List<ProductInfo> findUpAll();

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
