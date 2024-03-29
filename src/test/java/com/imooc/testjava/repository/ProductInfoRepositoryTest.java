package com.imooc.testjava.repository;

import com.imooc.testjava.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1111232");
        productInfo.setProductName("手抓饼");
        productInfo.setProductPrice(new BigDecimal(12));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("这是一个很好吃的手抓饼哦!");
        productInfo.setProductIcon("http://xxxxxxx");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(6);
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatusTest() {
        List<ProductInfo> productInfoList = repository.findByProductStatus(0);
        Assert.assertNotEquals(0, productInfoList.size());
    }
}