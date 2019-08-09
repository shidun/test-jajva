package com.imooc.testjava.service.impl;

import com.imooc.testjava.dataobject.ProductInfo;
import com.imooc.testjava.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void getOne() {
        ProductInfo productInfo = productService.getOne("1111232");
        Assert.assertEquals("1111232", productInfo.getProductId());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0, 2);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
//        Long size = productInfoPage.getTotalElements();
//        System.out.println(size);
        Assert.assertNotEquals(0, productInfoPage.getTotalElements());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    @Transactional //不写入数据库
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("221222");
        productInfo.setProductName("汉堡王");
        productInfo.setProductPrice(new BigDecimal(12));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("这是一个很好吃的手抓饼哦!");
        productInfo.setProductIcon("http://xxxxxxx");
        productInfo.setProductStatus(ProductStatusEnum.Down.getCode());
        productInfo.setCategoryType(6);
        ProductInfo productInfo1 = productService.save(productInfo);
        Assert.assertNotNull(productInfo1);
    }

    @Test
    public void upProduct() {
        ProductInfo productInfo = productService.getOne("123432");
        ProductInfo productInfo1 = productService.upProduct(productInfo);
        Assert.assertNotNull(productInfo1);
    }
    @Test
    public void downProduct() {
        ProductInfo productInfo = productService.getOne("123432");
        ProductInfo productInfo1 = productService.downProduct(productInfo);
        Assert.assertNotNull(productInfo1);
    }
}